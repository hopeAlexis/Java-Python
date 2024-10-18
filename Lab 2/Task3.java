import java.util.Arrays;

public class maxSumOfSubArray
{
    public static void main (String[] args) 
    {
        int[] array = {1, 2, 3, -1, 2, -10};
        System.out.println("Max sum: " + findMaxSUmOfSubArray(array));
    }

    public static int findMaxSUmOfSubArray(int[] arr) 
    {
        int[] maxSums = new int[arr.length]; // for all max sums from all starting positions
        int maxSum;
        int currentSum;
        
        // check sub arrays for each starting position
       for (int i = 0; i < arr.length; i++)
       {
           maxSum = Integer.MIN_VALUE; // the lowest integer value
           currentSum = 0;
           for (int j = i; j < arr.length; j++)
           {
               currentSum += arr[j];
               if(currentSum > maxSum)
               {
                   maxSum = currentSum;
               }
           }
        maxSums[i] = maxSum; // add max sum for i starting position
       }
       
    return  Arrays.stream(maxSums).max().getAsInt(); // treat array as an integer sequence, find max
    }
}
