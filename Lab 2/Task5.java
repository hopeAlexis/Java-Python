import java.util.HashMap;
import java.util.Arrays;

public class PairEqualSum
{
    public static void main(String[] args) 
    {
        int[] array = {4, 3, 7, 6};
        int target = 10;

        int[] pair = findPairEqualSum(array, target);

        if (pair != null) 
        {
            System.out.println("The pair exists: " + Arrays.toString(pair));
        } 
        else 
        {
            System.out.println("There is no pair that in sum equals " + target);
        }
    }

    public static int[] findPairEqualSum(int[] array, int target) 
    {
        // use hashmap to easily find keys
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int number : array) 
        {
            // find complementary number for a potential pair
            int otherNumber = target - number;

            if (hashMap.containsKey(otherNumber)) 
            {
                // exit function if found pair
                return new int[] {otherNumber, number};
            }
           
            hashMap.put(number, 0); // second integer doesn't matter
        }
        
        // no pair is found
        return null;
    }
}
