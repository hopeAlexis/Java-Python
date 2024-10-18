import java.util.Scanner;

public class SyracuseSequence
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scan.nextInt();
        System.out.println("Number of steps to reach 1 in Syracuse sequence: " + findSyracuseSequence(number));
    }
    
    public static int findSyracuseSequence (Integer number)
    {
        int iterations = 0;
        while (number != 1)
        {
            if (number%2 == 0)
            {
                number = number/2;
            }
            else
            {
                number = 3*number + 1;
            }
            iterations++;
        }
        return iterations;
    }
}