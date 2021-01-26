import java.util.ArrayList;


/**
 * 7shifts
 * Technical Interview
 * String Calculator
 *
 * Mohamed Bensaleh
 * January 25th, 2021
 *
 */

public class StringCalculator {

    public static int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        }

        // Simple returns the number if numbers length is only 1 number
        else if(numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }

        // If there are no negative integers, the sum of the numbers will be returned.
        // Otherwise Exception will be thrown, along with a list of the ints causing the error
        String [] numberArr = splitString(numbers);
        boolean noNegNumber = true;
        ArrayList<Integer> negatives = new ArrayList<Integer>();

        // Loop through all numbers in the string to see if
        // there are any neg values.
        for (String s : numberArr) {
            if (Integer.parseInt(s) < 0) {


                // If there are any neg numbers add them to the error string
                // wich will be printed when exception is thrown.
                negatives.add(Integer.parseInt(s));

                noNegNumber = false;

            }
        }
        if(noNegNumber) {

            return getSum(numbers);
        }
        else {
            throw new IllegalArgumentException("Negatives not allowed. " +
                    "Negative numbers found: "+negatives);
        }
    }

    // Calculates the sum of all numbers less than 1001
    private static int getSum(String numbers) {
        int sum = 0;
        String[] numberArr = splitString(numbers);

        if (numberArr.length > 1) {
            for (String s : numberArr) {
                if (Integer.parseInt(s) < 1001) {
                    sum += Integer.parseInt(s);
                }
            }
        }
        return sum;
    }



    private static String [] splitString(String numbers) {
        String delimiter = "";

        // If string starts with //, the delimiter will become whatever symbol
        // is in position right after the slashes but before \n, and the number string will be
        // whatever comes after the first \n symbol.
        if(numbers.startsWith("//")) {

            for (int offset = 2; numbers.charAt(offset) != '\n'; offset++) {
                delimiter += Character.toString(numbers.charAt(offset));
            }
            numbers = numbers.substring(numbers.indexOf("\n") + 1, numbers.length());
        }
        else {
            // The delimeter by default.
            delimiter = ("(\n)|(,)");

        }
        return numbers.split(delimiter);
    }

}
