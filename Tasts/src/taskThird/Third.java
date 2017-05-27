/*IntelliJ IDEA 2017.1.2*/
package taskThird;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Third {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<HashSet<Integer>> setLineMatrix = new ArrayList<HashSet<Integer>>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\taskThird\\input.txt"));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            String[] srt = s.split("\\s+");
            ArrayList<Integer> bufFirst = new ArrayList<Integer>();
            HashSet<Integer> bufSecond = new HashSet<Integer>();
            for (int i = 0; i < srt.length; i++) {
                bufFirst.add(Integer.parseInt(srt[i]));
                bufSecond.add(Integer.parseInt(srt[i]));
            }
            result.add(bufFirst);
            setLineMatrix.add(bufSecond);
        }

        bufferedReader.close();

        for (int i = 0; i < setLineMatrix.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (setLineMatrix.get(i).equals(setLineMatrix.get(j))){
                    result.remove(j);
                    setLineMatrix.remove(j);
                    j--;
                }
            }
        }

        FileWriter fileWriter = new FileWriter("src\\taskThird\\output.txt");
        for (int i = 0; i < result.size(); i++){
            fileWriter.write(String.valueOf(result.get(i)));
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
