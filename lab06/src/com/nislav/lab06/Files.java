package com.nislav.lab06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TODO: remove poop from this code
public class Files {
    public static void SetsReader(String filename){
        Scanner scnr = null;
        try {
            scnr = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scnr.hasNext()) {
            String str = scnr.nextLine();
            String[] s = str.split(" ");
            Set<Integer> data = new HashSet<Integer>();
            for(String d:s){
                d=d.replaceAll("[^0-9]", "");
                if(!d.equals("")) data.add(Integer.parseInt(d));
            }
            NumSet.ns.add(new NumSet(data));
        }
    }
}
