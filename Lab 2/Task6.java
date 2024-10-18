public class SumMatrix 
{
    public static void main(String[] args) 
    {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
        };

        System.out.println("Sum of all elements in the matrix: " + findSumMatrix(matrix));
    }

    public static int findSumMatrix (int[][] matrix) 
    {
        int row = matrix.length; 
        int column = matrix[0].length;
        int sum = 0;

        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < column; j++) 
            {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

}
