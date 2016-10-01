package com.nislav.lab07;

import java.util.ArrayList;

//TODO: remove poop from this code
public class Main {

    public static void main(String[] args) {
        About();
        ArrayList<Integer> al = Files.Reader("C:\\Users\\Nikola Slavich\\IdeaProjects\\MPLabs\\lab07\\src\\com\\nislav\\lab07\\data.txt");
        ArrayList<Integer> newal=new ArrayList<Integer>();
        while(al.size()!=1) {
            for(int i=0;i<al.size();i+=2){
                if(i==al.size()-1) newal.add(al.get(i));
                else newal.add(al.get(i)+al.get(i+1));
            }
            al = new ArrayList<Integer>(newal);
            //System.out.println(al);
            newal.clear();
        }
        System.out.println("Result: "+al.get(0));
    }
    public static void About(){
        System.out.println("Выполнить попарное суммирование произвольного конечного ряда чисел следующим образом: на первом этапе суммируются попарно рядом стоящие числа, на втором этапе суммируются результаты первого этапа и т.д. до тех пор, пока не останется одно число\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
