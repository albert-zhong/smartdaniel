package sh.surge.albertzhong.daniel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LinesReader {

    public static ArrayList<String> linesReader() {

        ArrayList<String> daniels = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Daniels.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                daniels.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return daniels;
    }

    public static void printStringArrayList(ArrayList<String> arrayList) {
        for (int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }


}
