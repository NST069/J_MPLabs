package com.nislav.lab09;

//TODO: remove poop from this code

public class Main {

    public static void main(String[] args) {
        About();
        int[] a={-1, 3, 5, 6};
        int[] b ={-8 ,-3, 0, 3, 1};

        JPolynom jp1=new JPolynom(a);
        JPolynom jp2=new JPolynom(b);

        System.out.println(jp1+"\n + \n"+jp2+"\n =");
        System.out.println(jp1.add(jp2));
    }
    public static void About(){
        System.out.println("Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap\nАвтор: NiSlav\t(Ломкин Н. 3ИНТ-003)");
    }
}
