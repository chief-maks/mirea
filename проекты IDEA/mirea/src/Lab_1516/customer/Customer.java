package Lab_1516.customer;

public class Customer {                     //класс заказчика
    private String firstName, secondName;   //поля имени и фамилии
    private int age;                        //поле возраста
    private Address address;                //поле адреса

    /* константы совершеннолетних и несовершеннолетних заказчиков */
    private static Customer MATURE_UNKNOWN_CUSTOMER = new Customer();
    private static Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer();

    /* конструкторы */
    public Customer() {
        this("default", "default", 0, Address.EMPTY_ADDRESS);
    }
    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() { return firstName; }      //методы получения значений полей
    public String getSecondName() { return secondName; }
    public int getAge() { return age; }
    public Address getAddress() { return address; }
}