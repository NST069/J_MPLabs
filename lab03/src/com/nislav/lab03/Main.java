package com.nislav.lab03;

public class Main {

    public static void main(String[] args) {
        About();
	    String text = "qwertyu@%%%%%sdfghj";
        text = text.replaceAll("[^A-Za-z ]", " ");
        text.trim();
        System.out.println(text);
    }
    public static void About(){
        System.out.println("Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами. Между последовательностями подряд идущих букв оставить хотя бы один пробел\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
