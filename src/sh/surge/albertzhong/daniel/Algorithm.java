package sh.surge.albertzhong.daniel;

import java.util.ArrayList;

public class Algorithm {

    public static boolean isCloser (double base, double test1, double test2) {
        if (Math.abs(base-test1) <= Math.abs(base-test2)) { // if difference between base and test1 is less or equal
            return true;
        }
        return false;
    }


}
