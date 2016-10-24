package com.nislav.lab08;

import java.util.ArrayList;

/**
 * Created by Nikola Slavich on 22.10.2016.
 */
public class JPolynom {
    private ArrayList<Integer> coef;
    private int degree;
    //coef.size()==degree+1

    public JPolynom(){
        this.coef= new ArrayList<Integer>();
        this.degree = 0;
    }
    public JPolynom(int degree, int[] coefs){
        this.coef= new ArrayList<Integer>();
        this.degree = degree;
        for(int i:coefs) this.coef.add(i);
    }

    public JPolynom multiply(JPolynom p){
        int deg = this.degree + p.degree;
        int[] coefs = new int[deg+1];
        int d;
        int c;
        for(int i=0;i<coefs.length;i++) coefs[i]=0;
        for(int a:this.coef){
            for(int b:p.coef){
                d=this.coef.indexOf(a)+p.coef.indexOf(b);
                c=a*b;
                coefs[d] += c;
            }
        }

        return new JPolynom(deg, coefs);
    }

    @Override
    public String toString(){
        String s="";
        String sx;
//        for(int x:this.coef){
//            if(x!=0) {
//                sx=(x>0)?(" + "+x):(" - "+Math.abs(x));
//                if (this.coef.indexOf(x)==this.coef.size()-1)
//                    s += sx;
//                else if (degree - this.coef.indexOf(x) == 1)
//                    s += sx + "x";
//                else s += sx + "x^" + (degree - this.coef.indexOf(x));
//            }
//        }
        for(int i=0;i<this.coef.size();i++) {
            if (this.coef.get(i) != 0) {
                if (i == 0) s += this.coef.get(i) + "x^" + (degree - this.coef.indexOf(this.coef.get(i)));
                else {
                    sx = (this.coef.get(i) > 0) ? (" + " + this.coef.get(i)) : (" - " + Math.abs(this.coef.get(i)));
                    if (this.coef.indexOf(this.coef.get(i)) == this.coef.size() - 1)
                        s += sx;
                    else if (degree - this.coef.indexOf(this.coef.get(i)) == 1)
                        s += sx + "x";
                    else s += sx + "x^" + (degree - this.coef.indexOf(this.coef.get(i)));
                }
            }
        }
        return s;
    }
}
