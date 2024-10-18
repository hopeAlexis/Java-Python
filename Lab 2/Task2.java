import java.util.Arrays;

public class MergeSortedArrays 
{
    public static void main (String[] args) 
    {
        //sorted arrays
        int[] arr1 = {-12, -3, 0, 1, 4, 5};
        int[] arr2 = {-3, -1, 5, 8, 13};

        int[] mergedArray = mergeSortedArrays(arr1, arr2);

        //using Arrays to print out the array nicely
        System.out.println("Merged and sorted array: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) 
    {
        int[] mergedArr = new int[arr1.length + arr2.length];

        int i = 0; // arr1
        int j = 0; // arr2
        int k = 0; // mergedArr

        while (i < arr1.length && j < arr2.length) 
        {
            // add the smaller of elements to new array
            if (arr1[i] <= arr2[j])
            {
                mergedArr[k] = arr1[i];
                i++;
            } 
            else 
            {
                mergedArr[k] = arr2[j];
                j++;
            }
            k++; //move on to the next position of the new array
        }

        // add in last elements of the bigger array
        while (i < arr1.length) 
        {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }
        
        while (j < arr2.length) 
        {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }

        return mergedArr;
    }
}
