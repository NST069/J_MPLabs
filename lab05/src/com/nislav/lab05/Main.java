package com.nislav.lab05;



//TODO: remove poop from this code
public class Main {

    public static void main(String[] args) {
        About();
        ComplexNumber n1 = new ComplexNumber(1, -5);
        ComplexNumber n2 = new ComplexNumber(5, 2);
        System.out.println(n1);
        System.out.println(n2);
        n1.plus(n2);
        System.out.println(n1);
        n1.minus(n2);
        System.out.println(n1);
        n1.multi(n2);
        System.out.println(n1);
        n1.div(n2);
        System.out.println(n1);
        n1.pow(5);
        System.out.println(n1);
        n1.root(5);
    }

    public static void About(){
        System.out.println("Реализовать класс комплексного числа и для него операции умножения, сложения, деления, нахождения модуля, возведения в степень и извлечения корня.\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
