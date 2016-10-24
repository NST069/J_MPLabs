package com.nislav.lab06;

public class Main {

    public static void main(String[] args) {
        About();
        Files.SetsReader("src\\com\\nislav\\lab06\\data.txt");
        System.out.println(NumSet.ns.get(0));
        System.out.println(NumSet.ns.get(1));
        System.out.println(NumSet.ns.get(0).cross(NumSet.ns.get(1)).cross(NumSet.ns.get(2)));
        System.out.println(NumSet.ns.get(0).unite(NumSet.ns.get(1)));
    }

    public static void About(){
        System.out.println("Определить класс Set на основе множества целых чисел, n = размер. Создать методы для определения пересечения и объединения множеств\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
