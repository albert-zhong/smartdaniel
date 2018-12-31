package sh.surge.albertzhong.daniel;

import java.util.ArrayList;

public class Features {

    public static int getWordCount(String str) {
        char[] charArray = str.toCharArray();
        int wordCount = 0;


        for (int i=1; i<charArray.length; i++) {
            if (Character.isLetterOrDigit(charArray[i]) && charArray[i-1] == ' ') {
                wordCount++;
            }
        }
        return wordCount;
    }

    public static ArrayList<String> split(String str) {
        ArrayList<String> strings = new ArrayList<String>();

        char[] charArray = str.toCharArray();
        String stack = "";

        for (int i=0; i<charArray.length; i++) {
            if (charArray[i] != ' ') { // if non-space
                stack += charArray[i];
                if (i==(charArray.length-1)) {
                    strings.add(stack);
                }
            } else { // if space
                if (stack != "") { // if stack is not empty
                    strings.add(stack);
                    stack = ""; // reset stack
                }
            }
        }
        return strings;

    }

    public static double getMeanWordLength(String str) {
        ArrayList<String> strings = split(str);
        double pile = 0;

        for (int i=0; i<strings.size(); i++) {
            pile += strings.get(i).length();
        }
        return pile/strings.size();
    }

}
