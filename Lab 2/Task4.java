public class RotateMatrix 
{
    public static void main(String[] args) 
    {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}
        };
        
        int[][] rotatedMatrix = rotateMatrix90Clockwise(matrix);

        System.out.println("Matrix, rotated 90 degrees clockwise: ");
        printMatrix(rotatedMatrix);
    }

    public static int[][] rotateMatrix90Clockwise(int[][] matrix) 
    {
        int row = matrix.length; 
        int column = matrix[0].length;
        
        // in rotated matrix rows change place with columns
        int[][] rotatedMatrix = new int[column][row];

        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < column; j++) 
            {
                // e.g. second element in a column becomes a second-to-last in a new row
                rotatedMatrix[j][row - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }
    
    // method for nice matrix output
    public static void printMatrix(int[][] matrix) 
    {
        for (int[] row : matrix) 
        {
            for (int value : row) 
            {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
