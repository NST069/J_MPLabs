package com.nislav.lab09;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nikola Slavich on 22.10.2016.
 */
public class JPolynom {
    private TreeMap<Integer, Integer> coef;
    private int degree;

    public JPolynom(){
        this.coef = new TreeMap<Integer,Integer>();
        this.degree = 0;
    }
    public JPolynom(int[] coefs){
        this.coef = new TreeMap<Integer,Integer>();
        this.degree = coefs.length;
        for(int i=0;i<coefs.length;i++){
            this.coef.put(coefs.length-i-1,coefs[i]);
        }
    }

    public JPolynom add(JPolynom p){
        int maxDegree = (this.degree>p.degree)?this.degree:p.degree;
        int[] coefs = new int[maxDegree];
        this.redoPolynom(maxDegree);
        p.redoPolynom(maxDegree);
        for (Map.Entry<Integer, Integer> pair : this.coef.entrySet()) {
            coefs[maxDegree - pair.getKey()-1] = pair.getValue() + p.coef.get(pair.getKey());
        }
        return new JPolynom(coefs);
    }

    public void redoPolynom(int degree){
        int d = this.degree;
        while(!(this.coef.size()==degree)){
            this.coef.put(d++,0);
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        String sx="";
        for (Map.Entry<Integer, Integer> current : this.coef.descendingMap().entrySet()) {
            if (current.getKey()==degree-1) {
                sx = (current.getValue() > 0) ? current.getValue().toString() : ("-" + Math.abs(current.getValue()));
                if(Math.abs(current.getValue())!=1)
                    builder.append(sx+"x^"+current.getKey());
                else builder.append(sx.substring(0,sx.length()-1)+"x^"+current.getKey());
            }
            else {
                if (current.getValue() != 0) {
                    sx = (current.getValue() > 0) ? (" + " + current.getValue()) : (" - " + Math.abs(current.getValue()));
                    if(Math.abs(current.getValue())!=1||current.getKey()==0)
                        builder.append(sx);
                    else builder.append(sx.substring(0,sx.length()-1));
                    if (current.getKey() == 1) {
                        builder.append("x");
                    } else if (current.getKey() > 1) {
                        builder.append("x^");
                        builder.append(current.getKey());
                    }
                }
            }
        }
        return builder.toString();
    }

}
