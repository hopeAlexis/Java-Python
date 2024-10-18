import java.util.Scanner;

public class AlternatingSignSum 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer n > 0 (number of sum elements): ");
        int total = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= total; i++) 
        {
            System.out.print("Enter the " + i + " number: ");
            int number = scanner.nextInt();

            if (i % 2 == 1) 
            {
                sum += number;
            } 
            else 
            {
                sum -= number;
            }
        }

        System.out.println("The alternating sign sum: " + sum);
    }
}
