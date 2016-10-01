package com.nislav.lab05;

/**
 * Created by Nikola Slavich on 29.09.2016.
        */

//TODO: remake multi() & div() & pow() & root()     (!)
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
        //r1*r2*(cos(phi1+phi2)+isin(phi1+phi2))
        double phi1 = Math.atan(this.imag/this.real);
        double phi2 = Math.atan(ob.imag/ob.real);
        double real = abs(this)*abs(ob)*Math.cos(phi1+phi2);
        double imag = abs(this)*abs(ob)*Math.sin(phi1+phi2);
        this.real=real;
        this.imag=imag;
    }
    //частное
    public void div(ComplexNumber ob){
        if(ob.real!=0||ob.imag!=0){
            this.real=(this.real*ob.real-this.imag*ob.imag)/(Math.pow(ob.real, 2)+Math.pow(ob.imag, 2));
            this.imag=(this.imag*ob.real+this.real*ob.imag)/(Math.pow(ob.real, 2)+Math.pow(ob.imag, 2));
        }
    }

    public static double abs(ComplexNumber ob){
        return Math.sqrt(Math.pow(ob.real,2)+Math.pow(ob.imag, 2));
    }

    public void pow(int n){
        //формула Муавра
        // z^n = |z|^n(cos(nф)+isin(nф))
        // ф=arctg(imag/real)

        double phi = Math.atan(this.imag/this.real);
        double real = Math.pow(abs(this), n)*Math.cos(n*phi);
        double imag = Math.pow(abs(this), n)*Math.sin(n*phi);
        this.real=real;
        this.imag=imag;
    }

    public void root(int n){
        //root_n(z) = root_n(|z|)(cos((phi+2kп)/n)+ isin((phi+2kп)/n))

        double phi = Math.atan(this.imag/this.real);
        double real=Math.pow(abs(this), 1/n)*Math.cos((phi/*+2*Math.PI*/)/n);
        double imag=Math.pow(abs(this), 1/n)*Math.sin((phi/*+2*Math.PI*/)/n);
        this.real=real;
        this.imag=imag;
    }
}
