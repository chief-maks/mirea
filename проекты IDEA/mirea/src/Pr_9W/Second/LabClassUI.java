package Pr_9W.Second;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class LabClassUI extends JFrame {
    private ArrayList<Student> students;
    private JPanel mainPanel;
    private JTable studentsTable;
    private JButton addStudent, removeStudent, findStudent, sortStudents;

    {
        students = new ArrayList<>();
        {
            students.add(new Student("Пятаков Максим", 100));
            students.add(new Student("Барш Галина", 34));
            students.add(new Student("Модина Елизавета", 64));
            students.add(new Student("Чуйко Максим", 17));
            students.add(new Student("Домбровская Мария", 78));
            students.add(new Student("Доброхвалов Иван", 82));
            students.add(new Student("Анастасиади Дмитрий", 16));
            students.add(new Student("Жаркова Светлана", 47));
            students.add(new Student("Пальянов Максим", 72));
        }

        mainPanel = new JPanel(new FlowLayout());
        addStudent = new JButton("Add Student");
        removeStudent = new JButton("Remove student");
        findStudent = new JButton("Find student");
        sortStudents = new JButton("Sort students");
        mainPanel.add(addStudent);
        mainPanel.add(removeStudent);
        mainPanel.add(findStudent);
        mainPanel.add(sortStudents);
    }

    public LabClassUI() {
        super("Students");
        setSize(500, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        generateAL();
        generateTable();
    }

    private void generateTable() {
        String[] header = new String[]{"ID", "Name", "GPA"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(header, 0);
        for (Student student : students)
            defaultTableModel.addRow(new Object[] {student.getIDNumber(), student.getFIO(), student.getGPA()});

        studentsTable = new JTable(defaultTableModel);
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
        studentsTable.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        studentsTable.getColumnModel().getColumn(0).setMaxWidth(50);
        studentsTable.getColumnModel().getColumn(0).setMinWidth(30);
        studentsTable.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        studentsTable.getColumnModel().getColumn(2).setMaxWidth(100);
        studentsTable.getColumnModel().getColumn(2).setMinWidth(50);

        getContentPane().add(new JScrollPane(studentsTable), BorderLayout.CENTER);
        getContentPane().add(mainPanel, BorderLayout.NORTH);
    }

    private void generateAL() {
        addStudent.addActionListener(actionEvent -> {
            try {
                addStudent();
            } catch (EmptyStringException e1) {
                JOptionPane.showMessageDialog(mainPanel, "Empty string!", "Error!", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(mainPanel, "Input GPA is illegal!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        removeStudent.addActionListener(actionEvent -> {
            try {
                removeStudent();
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(mainPanel, "Please, select the row(s)", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        findStudent.addActionListener(actionEvent -> {
            try {
                findStudent();
            } catch (StudentNotFoundException e1) {
                JOptionPane.showMessageDialog(mainPanel, "We don't have this student.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } catch (EmptyStringException e2) {
                JOptionPane.showMessageDialog(mainPanel, "Empty string!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        sortStudents.addActionListener(actionEvent -> {
            try {
                sortStudents();
            } catch (StudentNotFoundException e) {
                JOptionPane.showMessageDialog(mainPanel, "We don't have the students", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void addStudent() {
        String FIO = JOptionPane.showInputDialog("Input name");
        try {
            if (FIO.equals("")) throw new EmptyStringException();   // если ""
        } catch (NullPointerException e) {   // если null
            return;
        }
        String GPA = JOptionPane.showInputDialog("Input average score");
        int intGPA;
        try {
            intGPA = Integer.parseInt(GPA);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        Student student = new Student(FIO, intGPA);
        students.add(student);
        DefaultTableModel defaultTableModel = (DefaultTableModel) studentsTable.getModel();
        defaultTableModel.addRow(new Object[]{student.getIDNumber(), student.getFIO(), student.getGPA()});
    }

    private void removeStudent() {
        int selectedRowCount = studentsTable.getSelectedRowCount();
        if (selectedRowCount == 0) throw new IllegalArgumentException();
        int[] selectedRows = studentsTable.getSelectedRows();
        int deleteCounter = 0;
        for (int i = 0; i < selectedRowCount; i++) {
            int selectRow = selectedRows[i];
            students.remove(selectRow - deleteCounter);
            DefaultTableModel defaultTableModel = (DefaultTableModel) studentsTable.getModel();
            defaultTableModel.removeRow(selectRow - deleteCounter);
            deleteCounter++;
        }
    }

    private void findStudent() throws StudentNotFoundException {
        String FIO = JOptionPane.showInputDialog("Input name");
        try {
            if (FIO.equals("")) throw new EmptyStringException();
        } catch (NullPointerException e) { return; }
        for (Student foundStudent : students) {
            if (foundStudent.getFIO().equals(FIO)) {
                JOptionPane.showMessageDialog(this,
                        "--Found student--\n" + foundStudent,
                        "Found!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        throw new StudentNotFoundException();
    }

    private void sortStudents() throws StudentNotFoundException {
        if (students.size() <= 1) throw new StudentNotFoundException();
        qSort(students, 0, students.size() - 1);
        DefaultTableModel defaultTableModel = (DefaultTableModel) studentsTable.getModel();
        for (int i = 0; i < students.size(); i++) {
            defaultTableModel.removeRow(i);
            Student foundStudent = students.get(i);
            defaultTableModel.insertRow(i, new Object[]{foundStudent.getIDNumber(),
                    foundStudent.getFIO(), foundStudent.getGPA()});
        }
    }

    private void qSort(ArrayList<Student> arr, int begin, int end) {
        if (begin < end) {
            int partitions = partition(arr, begin, end);

            qSort(arr, begin, partitions - 1);
            qSort(arr, partitions + 1, end);
        }
    }

    private int partition(ArrayList<Student> arr, int begin, int end) {
        Student pivot = arr.get(end);
        int i = (begin - 1);
        SortingStudentsByGPA comp = new SortingStudentsByGPA();
        for (int j = begin; j < end; j++) {
            if (comp.compare(arr.get(j), pivot) < 0) {
                i++;
                Student swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
            }
        }

        Student swapTemp = arr.get(i + 1);
        arr.set(i + 1, arr.get(end));
        arr.set(end, swapTemp);

        return i + 1;
    }
}

