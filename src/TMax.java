/*
Question 2: TMax (40 points) 2a) Generate a random array

In TMax.java, complete the getRandomArray() method that is responsible to generate a one dimensional random array with
the size of a random number between 2 and 10. Then populate the Array with some random real values from [0, 1].
Note: you can set the seed by using the args in the main method.

Output examples:

The output results might be varied depends on the seed that you are using.
getRandomArray() -> [0.123, 0.235, 0.3573, 0.657] getRandomArray() -> [0.067, 0.235, 0.657]

2b) Find the third-biggest number in the array. Then, complete thirdBiggest(int[] array). This method should accept an
array that we generated above and return the third-biggest number in this array. When array has only two numbers then
the function should return bigger of these two.
*/

import java.util.*;

public class TMax {

    public static void main(String[] args) {
        int seed =  Integer.parseInt(args[0]);
        System.out.print("\nArray: ");
        double[] array = getRandomArray(seed);
        System.out.println(thirdBiggest(array));
    }

    public static double[] getRandomArray(long seed){

        int lowerBound = 2;
        int upperBound = 10;

        // create a new random number generator using seed
        Random random = new Random(seed);
        // create a new array, randomly sized, within the given bounds
        double[] randomArray = new double[random.nextInt(lowerBound, upperBound)];

        // use for loop to populate each array element with a random double
        for (int i = 0; i < randomArray.length; i++){

            // generate a random double that respects the given bounds
            double d = random.nextDouble(1);
            // round double to 3 decimal places, as per assignment example
            d = (Math.round(d*1000))/1000.0;
            // assign double to its place in the array
            randomArray[i] = d;
            System.out.print(randomArray[i] + " ");
        }
        return randomArray;
    }

    public static double thirdBiggest(double[] array){

        // sort the array
        Arrays.sort(array);
        // if array has only two numbers then return bigger of these two
        if (array.length == 2) {
            System.out.print("\nBigger number: ");
            return array[1];
        }
        // else return the third-biggest number, located in the 3rd-last position
        else {
            System.out.print("\n3rd Biggest Number: ");
            return array[array.length-3];
        }
    }
}
