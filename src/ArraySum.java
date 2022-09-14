/*
Question 1: ArraySum

1a) Method to transform a number of an array

In ArraySum class, write a method called transform that receives an integer number and transforms it to
an integer array such that the array elements are digits of input integer number.
For example:
int [] transform(1234) should return the integer array [1, 2, 3, 4]

1b) Method to compute the sum of two arrays that represent a very big number.

In ArraySum class, write a method called sum that receives two integer arrays of equal size (each of these
arrays is created by transform method) and returns an array of integer digits that corresponds to the sum.

Example:
transform(1234) -> a which is [1, 2, 3, 4] transform(1211) -> b which is [1, 2, 1, 1]
sum(a, b) -> [2,4,4,5]
transform(9295) -> x which is [9, 2, 9, 5]
sum(a, x) -> [1,0,5,2,9]
 */

public class ArraySum {
    public static void main(String[] args) {

        int first = Integer.parseInt(args[0]);
        int[] firstArray = transform(first);
        int second = Integer.parseInt(args[1]);
        int[] secondArray = transform(second);
        int[] result = sum(firstArray, secondArray);
        print(result);
    }

    public static int[] transform(int num){

        // convert num to string
        String s = String.valueOf(num);
        // convert s to a string array
        String[] splitS = s.split("");
        // create a new int array, sized on the length of s
        int[] numbers = new int[s.length()];

        // use a for loop to convert each string array element into an equivalent int array element
        for (int i = 0; i < s.length(); i++){
            numbers[i] = Integer.parseInt(splitS[i]);
        }
        return numbers;
    }

    public static int[] sum(int[] a, int[] b){

        int sumA = 0;
        int sumB = 0;
        int multOfTen = 1;

        // first, find the sum of the digits within each array

        // the for loop starts with the final element of each integer array (which will always represent multiples of 1)
        // and will add it to sumA/sumB. as it continues through each element of the array, it takes into account the
        // increasing value (*10) of each subsequent element

        for (int j = a.length-1; j >= 0; j--){

            sumA += a[j]*multOfTen;
            sumB += b[j]*multOfTen;
            multOfTen = multOfTen*10;
        }

        // add the array sums together
        int totalSum = sumA + sumB;

        // return an integer array as required by calling the transform method
        return transform(totalSum);
    }

    public static void print(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            if(i != array.length - 1) {
                System.out.print(array[i] + ", ");
            }else{
                System.out.print(array[i] + "]");
            }
        }
    }

}