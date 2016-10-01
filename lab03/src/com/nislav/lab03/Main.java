package com.nislav.lab03;

public class Main {

    public static void main(String[] args) {
        About();
	    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet odio ligula. Nullam tempor ante vitae turpis bibendum, eget accumsan magna sollicitudin. Integer pulvinar ornare turpis, vitae tempor lectus. Cras id eros ac lacus rhoncus mattis. Donec ante urna, volutpat non tempus ac, cursus et lectus. Sed sit amet molestie sem. Aliquam hendrerit maximus vestibulum. Quisque rutrum, diam et mattis interdum, nisi velit dictum sem, quis porta nunc nulla at arcu. Nulla auctor massa pharetra auctor volutpat. Suspendisse non massa nec metus dictum cursus vitae nec urna. Aliquam aliquam sed sapien non hendrerit. Vestibulum neque lectus, dictum sit amet nisl eu, blandit tincidunt mauris. Quisque eu tortor imperdiet, faucibus diam sed, dapibus massa. In eu lorem volutpat, tincidunt neque ac, semper lectus.";
        text = text.replaceAll("[^A-Za-z ]", "");
        text.trim();
        System.out.println(text);
    }
    public static void About(){
        System.out.println("Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами. Между последовательностями подряд идущих букв оставить хотя бы один пробел\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
