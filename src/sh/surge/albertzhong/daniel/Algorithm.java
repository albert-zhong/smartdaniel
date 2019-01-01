package sh.surge.albertzhong.daniel;

import java.util.ArrayList;

public class Algorithm {

    public static double[] getData(ArrayList<String> lines) {

        double meanSentenceLength = 0;
        double meanWordCount = 0;
        double meanWordLength = 0;

        for (int i=0; i<lines.size(); i++) {
            meanSentenceLength += lines.get(i).length();
            meanWordCount += Features.getWordCount(lines.get(i));
            meanWordLength += Features.getMeanWordLength(lines.get(i));
        }

        meanSentenceLength /= lines.size();
        meanWordCount /= lines.size();
        meanWordLength /= lines.size(); // Finding means

        return new double[]{meanSentenceLength, meanWordCount, meanWordLength};
    }

    public static double[] getData(String str){
        return new double[]{str.length(), Features.getWordCount(str), Features.getMeanWordLength(str)};
    }

    public static double getWeightedMean(ArrayList<String> base) {
        // base[0] is total length
        // base[1] is word count
        // base[2] is mean word length
        return calculateWeightedMean(getData(base));
    }

    public static double getWeightedMean(String sample) {
        return calculateWeightedMean(getData(sample));
    }

    private static double calculateWeightedMean(double[] features) {
        double weightedMean = 0;
        weightedMean += features[0] * 0.35; // total length
        weightedMean += features [1] * 0.45; // word count
        weightedMean += features [2] * 0.20; // mean word length
        return weightedMean;
    }

}
