/*IntelliJ IDEA 2017.1.2*/
package taskFirst;

import java.io.*;
import java.nio.charset.Charset;

public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\taskFirst\\input.txt"));
        int N = 0;
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            N = Integer.parseInt(s);
        }
        bufferedReader.close();
        int[] numbers = new int[N - 15];
        int firstElement = 16;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = firstElement;
            firstElement++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\taskFirst\\output.txt"), Charset.forName("UTF-8")));
        for (int i = 0; i < numbers.length; i++) {
            String element = Integer.toHexString(numbers[i]);
            int counter = 0;
            for (int k = 0; k < element.length(); k++) {
                if ((k + 1) == element.length()) {
                    break;
                }

                if (element.charAt(k) > element.charAt(k + 1)) {
                    counter++;
                }
            }

            if ((counter + 1) == element.length()) {
                bw.write(element);
                bw.write("\n");
                continue;
            }

            int secondCounter = 0;
            for (int j = 0; j < element.length(); j++) {
                if ((j + 1) == element.length()) {
                    break;
                }
                if (element.charAt(j) < element.charAt(j + 1)) {
                    secondCounter++;
                }
            }
            if ((secondCounter + 1) == element.length()) {
                bw.write(element);
                bw.write("\n");
            }
        }
        bw.close();
    }
}
