import java.util.Scanner;

public class TruckHeight 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount of roads: ");
        int roadAmount = scanner.nextInt();

        int allowedRoad = -1;
        int maxHeight = 0;

        for (int i = 1; i <= roadAmount; i++) 
        {
            System.out.print("Enter the amount of tunnels for the road " + i + ": ");
            int tunnelCount = scanner.nextInt();
            int minHeight = Integer.MAX_VALUE;

            for (int j = 1; j <= tunnelCount; j++) 
            {
                System.out.print("Enter the height of " + j + " tunnel: ");
                int height = scanner.nextInt();

                if (height < minHeight) 
                {
                    minHeight = height;
                }
            }

            if (minHeight > maxHeight) 
            {
                maxHeight = minHeight;
                allowedRoad = i;
            }
        }

        System.out.println("The allowed road is : " + allowedRoad + " for the height: " + maxHeight);
    }
}
