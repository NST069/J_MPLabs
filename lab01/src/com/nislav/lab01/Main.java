package com.nislav.lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//TODO: remove poop from this code

public class Main {

    public static void main(String[] args) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        int strLength=0;
        ArrayList<String> strings = new ArrayList<>();
        getAbout();
        try {
            while (n <= 0) {
                System.out.print("Number of words: ");
                n = Integer.parseInt(reader.readLine());
                if (n <= 0) System.out.println("Please enter a correct number of words");
            }
            for (int i = 0; i < n; i++) {
                strings.add(reader.readLine());
                strLength += strings.get(i).length();
            }

            int mid = strLength / n;

            for (String s : strings) {
                if (s.length() <= mid)
                    System.out.println(s);
            }
        }catch(NumberFormatException e){
            System.out.println("It is not a number, sorry");
        }catch(IOException e){
            System.out.println("Something wrong with your string");
        }
    }
    public static void getAbout(){
        System.out.println("Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше средней, также их длины.\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
