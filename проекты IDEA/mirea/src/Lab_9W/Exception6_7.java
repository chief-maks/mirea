package Lab_9W;

import java.util.Scanner;

public class Exception6_7 {
    public void getKey() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        printDetails(key);
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
