package sh.surge.albertzhong.daniel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {

    private int sentenceCount = 0; // number of sentences in txt file

    private double meanWordCountPerSentence = 0;
    private double meanLengthPerSentence = 0;
    private Map<String, Integer> wordFrequencyMap = new HashMap<>();


    public void applyDataSet(String location) {

        double sumWordCount = 0;
        double sumLength = 0;

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(location));
            String currentLine;

            while ((currentLine = br.readLine()) != null) { // per line
                sentenceCount++;

                ArrayList<String> currentWordsArray = split(currentLine);

                sumWordCount += currentWordsArray.size();
                sumLength += getLength(currentLine);

                for (String currentWord : currentWordsArray) { // get word frequency
                    wordFrequencyMap.compute(currentWord, (k, v) -> v == null ? 1 : v +1);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        meanWordCountPerSentence = sumWordCount / sentenceCount;
        meanLengthPerSentence = sumLength / sentenceCount;


    }

    // Finds length of sentence minus spaces
    private double getLength (String str) {
        int length = 0;
        char[] charArray = str.toCharArray();
        for (int i=0; i<charArray.length; i++) {
            if (charArray[i] != ' ') {
                length++;
            }
        }
        return length;
    }

    // Splits a string (words and spaces) into a string ArrayList of multiple strings
    private ArrayList<String> split(String str) {

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
                if (!stack.equals("")) { // if stack is not empty
                    strings.add(stack);
                    stack = ""; // reset stack
                }
            }
        }
        return strings;
    }

    public double getMeanWordCount() {
        return meanWordCountPerSentence;
    }

    public double getMeanSentenceLength() {
        return meanLengthPerSentence;
    }

    public Map<String, Integer> getWordFrequencyMap() {
        return wordFrequencyMap;
    }

}
