package ru.jbeking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Simbirsoft {
    public static final String TEMP_FILE_NAME = "temp.html";
    public static void main(String[] args ){
        Networking netw = new Networking(TEMP_FILE_NAME);
        HashMap<String, Long> stats = new HashMap<String, Long>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите адрес разбираемой страницы:");
        System.out.println("пример: https://www.simbirsoft.com/");
        String strUrl = sc.nextLine();
        try {
            netw.getPage(strUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error");
        }
        Parse prs = new Parse(TEMP_FILE_NAME);
        try {
            stats = prs.go();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Странно, но файл не найден.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String k: stats.keySet()){
            System.out.println(k+" - "+ stats.get(k));
        }
    }
}
