package sh.surge.albertzhong.daniel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) {

        ArrayList<String> daniels = LinesReader.getLines(true);
        ArrayList<String> nonDaniels = LinesReader.getLines(false);

        System.out.println(Arrays.toString(Algorithm.getData(daniels)));
        System.out.println(Arrays.toString(Algorithm.getData(nonDaniels)));

        System.out.println("Input a line:");
        Scanner input = new Scanner(System.in);
        String sample = input.nextLine();

        if ( isCloser(Algorithm.getWeightedMean(sample), Algorithm.getWeightedMean(daniels), Algorithm.getWeightedMean(nonDaniels)) ) {
            System.out.println("It's a daniel");
        } else {
            System.out.println("It's not a daniel");
        }



    }


    public static boolean isCloser (double base, double test1, double test2) {
        if (Math.abs(base-test1) <= Math.abs(base-test2)) { // if difference between base and test1 is less or equal
            return true;
        }
        return false;
    }

}
