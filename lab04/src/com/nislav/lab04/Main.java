package com.nislav.lab04;

public class Main {

    public static void main(String[] args) {
        About();
        System.out.println("12th Fib = "+fib(12));
        System.out.println("12! = "+factorial(12));
    }

    public static long fib(int n){
        long x=1;
        long y=0;
        long ans=0;
        for(int i=1;i<=n;i++){
            ans=x+y;
            x=y;
            y=ans;
        }
        return ans;
    }

    public static long factorial(int n){
        long x=1;
        for(int i=1;i<=n;i++)
            x*=i;
        return x;
    }

    public static void About(){
        System.out.println("Создайте программу, вычисляющую числа Фибоначчи и факториал числа\nАвтор: NiSlav\t(Николай Ломкин 3ИНТ-003)");
    }
}
