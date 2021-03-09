package ru.jbeking;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Parse {
    private String fileName;

    public Parse(String fileName) {
        this.fileName = fileName;
    }

    public HashMap<String, Long> go() throws IOException {
        int c;
        Character[] delim = {' ', '\r', '\n', '\t', '(', ')', ',', '.', '!', '?', '"', ';', ':', '[', ']'};
        HashMap<String, Long> stats = new HashMap<String, Long>();
        FileReader fr = new FileReader(fileName);
        StringBuffer sb = new StringBuffer();
        while ((c = fr.read()) != -1) {
            //char ch = (char) c;
            if (!Arrays.asList(delim).contains((char) c)) {
                sb.append((char) c);
            } else {
                if (sb.length() > 0) {
                    //System.out.println("writed");
                    if (!stats.containsKey(sb.toString())) stats.put(sb.toString(), 0L);
                    stats.put(sb.toString(), stats.get(sb.toString()) + 1);
                    sb = new StringBuffer();

                }
            }
            //System.out.println(sb.length());

        }
        return stats;
    }
}
