package sh.surge.albertzhong.daniel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LinesReader {

    public static ArrayList<String> getLines(boolean isDaniel) {

        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader br = null;

        if (isDaniel) {
            try {
                br = new BufferedReader(new FileReader("Daniels.txt"));
                String currentLine;

                while ((currentLine = br.readLine()) != null) {
                    lines.add(currentLine);
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
        } else {
            try {
                br = new BufferedReader(new FileReader("NonDaniels.txt"));
                String currentLine;

                while ((currentLine = br.readLine()) != null) {
                    lines.add(currentLine);
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
        }
        return lines;
    }

    public static void printStringArrayList(ArrayList<String> arrayList) {
        for (int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }


}
