package com.nislav.lab07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {
    public static ArrayList<Integer> Reader(String filename){
        Scanner scnr = null;
        ArrayList<Integer> al = new ArrayList<Integer>();
        try {
            scnr = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scnr.hasNext()) {
            String str = scnr.nextLine();
            String[] s = str.split(" ");
            for(String d:s){
                d=d.replaceAll("[^0-9]", "");
                if(!d.equals("")) al.add(Integer.parseInt(d));
            }
        }
        return al;
    }
}
