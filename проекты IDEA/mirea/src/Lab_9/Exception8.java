package Lab_9;

import java.util.Scanner;

public class Exception8 {
    public void getKey() {
        int x = 0;
        while (x < 2){
            try {
                Scanner scanner = new Scanner(System.in);
                String key = scanner.nextLine();
                printDetails(key);
                x = 2;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            x++;
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if(key == ""){
            throw new Exception("Key is empty");
        }
        return "data for " + key;
    }
}
