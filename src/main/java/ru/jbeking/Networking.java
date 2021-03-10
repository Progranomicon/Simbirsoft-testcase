package ru.jbeking;

import java.io.*;
import java.net.*;

public class Networking {
    private String tempFile;
    private HttpURLConnection conn;
    private URL url;
    public Networking(String tempFileName){
        this.tempFile = tempFileName;
    }
    public void getPage(String strUrl) throws MalformedURLException {

            url = new URL(strUrl);
        try {
            conn = (HttpURLConnection) url.openConnection();

            try {
                conn.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            conn.setRequestProperty("Content-Length", "0");
            conn.setRequestProperty("Content-Language", "ru-RU");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:86.0) Gecko/20100101 Firefox/86.0");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.close();
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            FileWriter fw = new FileWriter(tempFile, false);
            String line;
            while ((line = rd.readLine()) != null) {
                fw.write(line);
                fw.write('\n');
            }
            fw.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
