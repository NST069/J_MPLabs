package com.nislav.lab08;

//TODO: remove poop from this code

public class Main {

    public static void main(String[] args) {
        About();
        int[] a={6, -2, 5, 1};
        int[] b={4, 1, -7, 8, 0};
        JPolynom jp1 = new JPolynom(3,a);
        JPolynom jp2 = new JPolynom(4,b);

        System.out.println(jp1+"\n * \n"+jp2+"\n = ");
        System.out.println(jp1.multiply(jp2));
    }

    public static void About(){
        System.out.println("Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в списках\nАвтор: NiSlav\t(Ломкин Н. 3ИНТ-003)\n");
    }
}
