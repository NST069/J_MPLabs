package com.nislav.lab02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: remove poop from this code
public class Main {

    public static void main(String[] args) {
	    String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit Aenean sit amet odio ligula Nullam tempor ante vitae turpis bibendum eget accumsan magna sollicitudin Integer pulvinar ornare turpis vitae tempor lectus Cras id eros ac lacus rhoncus mattis Donec ante urna volutpat non tempus ac cursus et lectus Sed sit amet molestie sem Aliquam hendrerit maximus vestibulum Quisque rutrum diam et mattis interdum nisi velit dictum sem quis porta nunc nulla at arcu Nulla auctor massa pharetra auctor volutpat Suspendisse non massa nec metus dictum cursus vitae nec urna Aliquam aliquam sed sapien non hendrerit Vestibulum neque lectus dictum sit amet nisl eu blandit tincidunt mauris Quisque eu tortor imperdiet faucibus diam sed dapibus massa In eu lorem volutpat tincidunt neque ac semper lectus";
        String[] words = text.split(" ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k=0;
        char sym = 666;
        About();
        try {
            System.out.print("k = ");
            k = Integer.parseInt(reader.readLine());

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() >= k) {
                    StringBuilder sb = new StringBuilder(words[i]);
                    sb.setCharAt(k - 1, sym);
                    words[i] = sb.toString();
                }
            }

            for (String s : words)
                System.out.print(s + " ");

        }catch(NumberFormatException e){
            System.out.println("It is not a number, sorry");
        }catch(IOException e){
            System.out.println("Something wrong with your input");
        }
    }
    public static void About(){
        System.out.println("В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
