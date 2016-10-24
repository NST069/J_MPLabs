package com.nislav.lab05;

/**
 * Created by Nikola Slavich on 29.09.2016.
        */

public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(){
        this.real=0;
        this.imag=0;
    }
    public ComplexNumber(double real){
        this.real=real;
        this.imag=0;
    }
    public ComplexNumber(double real, double imag){
        this.real=real;
        this.imag=imag;
    }

    public ComplexNumber(ComplexNumber ob){
        this.real=ob.real;
        this.imag=ob.imag;
    }

    @Override
    public String toString(){
        return real+" + "+imag+"i";
    }

    //сумма
    public void plus(ComplexNumber ob){
        this.real+=ob.real;
        this.imag+=ob.imag;
    }

    //разность
    public void minus(ComplexNumber ob){
        this.real-=ob.real;
        this.imag-=ob.imag;
    }

    //произведение
    public void multi(ComplexNumber ob){
        double real = this.real*ob.real - this.imag*ob.imag;
        double imag = this.real*ob.imag + this.imag*ob.real;
        this.real=real;
        this.imag=imag;
    }
    //частное
    public void div(ComplexNumber ob){
        double real;
        double imag;
        if(ob.real!=0||ob.imag!=0){
            real=(this.real*ob.real+this.imag*ob.imag)/(Math.pow(ob.real, 2)+Math.pow(ob.imag, 2));
            imag=(this.imag*ob.real-this.real*ob.imag)/(Math.pow(ob.real, 2)+Math.pow(ob.imag, 2));
            this.real=real;
            this.imag=imag;
        }
    }

    public static double abs(ComplexNumber ob){
        return Math.sqrt(Math.pow(ob.real,2)+Math.pow(ob.imag, 2));
    }
    public static double angle(ComplexNumber ob) {
        if(ob.real>0)
            return Math.atan(ob.imag/ob.real);
        else if(ob.real<0&&ob.imag>=0)
            return Math.PI + Math.atan(ob.imag/ob.real);
        else if(ob.real<0&&ob.imag<0)
            return -Math.PI + Math.atan(ob.imag/ob.real);
        else if(ob.real==0&&ob.imag>0)
            return Math.PI / 2;
        else if(ob.real==0&&ob.imag<0)
            return -Math.PI / 2;
        return 0;
    }

    public void pow(double n){
        //формула Муавра
        // z^n = |z|^n(cos(nф)+isin(nф))
        // ф=arctg(imag/real)

        double phi = angle(this);
        double real = Math.pow(abs(this), n)*Math.cos(n*phi);
        double imag = Math.pow(abs(this), n)*Math.sin(n*phi);
        this.real=real;
        this.imag=imag;
    }

    public void root(double n){
        //root_n(z) = root_n(|z|)(cos((phi+2kп)/n)+ isin((phi+2kп)/n))

        System.out.println("Roots:");
        double phi = angle(this);
        for(int x = 0;x<n;x++) {
            double real = Math.pow(abs(this), 1 / n) * Math.cos((phi+2*Math.PI*x) / n);
            double imag = Math.pow(abs(this), 1 / n) * Math.sin((phi+2*Math.PI*x) / n);
            System.out.println(new ComplexNumber(real,imag));
        }
        System.out.println("===");
    }
}
