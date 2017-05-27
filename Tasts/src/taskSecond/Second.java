/*IntelliJ IDEA 2017.1.2*/
package taskSecond;

import java.io.*;
import java.nio.charset.Charset;

public class Second {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\taskSecond\\input.txt"));
        StringBuilder sbFirst = new StringBuilder();
        StringBuilder sbSecond = new StringBuilder();
        sbFirst.append(bufferedReader.readLine());
        sbSecond.append(bufferedReader.readLine());

        String[] firstArrayString = sbFirst.toString().split("\\s+");
        String[] secondArrayString = sbSecond.toString().split("\\s+");
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < firstArrayString.length; i++) {
            for (int j = 0; j < secondArrayString.length; j++) {
                if (firstArrayString[i].equals(secondArrayString[j])) {
                    sb.append(secondArrayString[j] + " ");
                }
            }
        }

        if (sb.length() == 0) {
            result.append("Отсутствует");
        } else {
            String[] buf = sb.toString().split("\\s+");
            for (int i = 0; i < buf.length; i++) {
                for (int j = 0; j < buf.length - 1 - i; j++) {
                    if (buf[j].length() < buf[j + 1].length()) {
                        String s = buf[j];
                        buf[j] = buf[j + 1];
                        buf[j + 1] = s;
                    }
                }
            }
            result.append(buf[0] + " ");
            for (int i = 0; i < buf.length; i++) {
                if ((i + 1) == buf.length) {
                    break;
                }
                if (buf[i].length() > buf[i + 1].length()){
                    break;
                }
                if (buf[i].length() == buf[i + 1].length()){
                    result.append(buf[i + 1] + " ");
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\taskSecond\\output.txt"), Charset.forName("UTF-8")));
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
