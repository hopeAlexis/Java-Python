import java.util.Scanner;

public class TreasureHunt 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter treasure coordinate x: ");
        int treasureX = scan.nextInt();
        System.out.print("Enter treasure coordinate y: ");
        int treasureY = scan.nextInt();

        int x = 0;
        int y = 0;
        int iterations = 0;

        while (true) 
        {
            System.out.print("Enter direction: ");
            String direction = scan.next();
            
            if (direction == "stop") 
            {
                break;
            }
            System.out.print("Enter amount of steps: ");
            int movement = scan.nextInt();
            iterations++;

            switch (direction) 
            {
                case "north":
                    y += movement;
                    break;
                case "south":
                    y -= movement;
                    break;
                case "east":
                    x += movement;
                    break;
                case "west":
                    x -= movement;
                    break;
                default:
                    System.out.println("No such instruction: ");
                    break;
            }

            if (x == treasureX && y == treasureY) 
            {
                break;
            }
        }

        System.out.println("Yay! You've found treasure in " + iterations + " instructions!");
    }
}
