import java.util.Arrays;

public class MaxInRow 
{
    public static void main(String[] args) 
    {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 8, 7},
        };

        System.out.println("Max element for each row in the matrix: " + Arrays.toString(findMaxInRow(matrix)));
    }

    public static int[] findMaxInRow (int[][] matrix) 
    {
        int row = matrix.length; 
        int column = matrix[0].length;
        int[] newMatrix = new int[row];
        int max;

        for (int i = 0; i < row; i++) 
        {
            // treat row array as an integer sequence, find max
            newMatrix[i] = Arrays.stream(matrix[i]).max().getAsInt();
        }

        return newMatrix;
    }

}
