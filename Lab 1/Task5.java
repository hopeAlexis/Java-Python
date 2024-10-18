import java.util.Scanner;

public class DoubleEven 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 3-digit number: ");
        
        int number = scanner.nextInt();
        
        // convert integer into string to get length and first symbol
        String digitStr = Integer.toString(number);
        
        // number has 3 digits and doesn't start with 0
        if (digitStr.length() != 3 || digitStr.charAt(0) == 30)
        {
            System.out.print("That is not a 3-digit number.");
        }
        else
        {
            System.out.print(checkDoubleEven(number));
        }
    }
    
    public static String checkDoubleEven (Integer number)
    {
        int sum = 0;
        int product = 1;
        
        for (int i = 0; i < 3; i++)
        {
            sum += number%10;
            product *= number%10;
            number = number / 10;
        }
        
        if (sum%2 == 0 && product%2 == 0)
        {
            return "The number is double even.";
        }
        
        return "The number is not double even.";
    }
}
