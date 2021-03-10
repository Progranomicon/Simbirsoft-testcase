package ru.jbeking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final String TEMP_FILE_NAME = "temp.html";
    public static void main(String[] args ){
        Networking netw = new Networking(TEMP_FILE_NAME);
        HashMap<String, Long> stats ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите адрес разбираемой страницы");
        System.out.println("пример: https://www.simbirsoft.com/");
        String strUrl = sc.nextLine();
        try {
            netw.getPage(strUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Wrong URL");
            return;
        }catch (Exception e){
            System.out.println("ERROR");
            return;
        }
        Parse prs = new Parse(TEMP_FILE_NAME);
        try {
            stats = prs.go();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Странно, но файл не найден.");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for(String k: stats.keySet()){
            System.out.println( k + " - " + stats.get(k));
        }
        /*File f = new File(TEMP_FILE_NAME);
        System.out.println("Filesize: " + f.length());
        f.delete();*/

    }
}
