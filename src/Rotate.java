/*
Question 3: Rotate a 2D Array

In Rotate.java, complete the method of rotate180. The method receives a 2D array of integers and rotates the given
2D array in 1800 degrees (clockwise). After running the rotate180(a) the matrix should be changed (in-place) such that
it has 180 degrees rotation of elements.
 */

public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        print(matrix);
        System.out.println("\n##############################\n");
        print(rotate180(matrix));
    }

    public static int[][] rotate180(int[][] matrix) {

        // define existing matrix size to provide sizing for the new rotatedArray
        int rows = matrix.length;
        int cols = matrix[0].length;
        // create rotatedArray
        int[][] rotatedArray = new int[rows][cols];
        // use a nested for loop to populate the new array
        // outer for loop is for rows
        for (int i = 0; i < rows; i++){
            // inner for loop is for columns
            for (int j = 0; j < cols; j++){
                // elements in rotatedArray should be placed in reference to their original index
                // formula is: {new coordinate = length - 1 - original coordinate} i.e. [0,0] becomes [4,4]
                rotatedArray[i][j] = matrix[rows-1-i][cols-1-j];
            }
        }
        return rotatedArray;
    }

    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}