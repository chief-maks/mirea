package Lab_9;

public class Exception5 {
    public void getDetails(String key){
        try {
            if (key == null)
                throw new NullPointerException("null key in getDetails!");

            key = key + "abc";
            System.out.println(key);
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
