import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        HashMap<Integer,String> currency = new HashMap<Integer,String>();

        currency.put(1,"USD");
        currency.put(2,"INR");
        currency.put(3,"EUR");
        currency.put(4,"HKD");
        currency.put(5,"CAD");

        String fromCode ,toCode;
        double amount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to currency ");
    }
}
