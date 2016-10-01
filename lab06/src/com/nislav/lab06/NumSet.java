package com.nislav.lab06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikola Slavich on 30.09.2016.
 */

public class NumSet {
    public static ArrayList<NumSet> ns = new ArrayList<NumSet>();
    private Set<Integer> data;
    private int n;

    public NumSet(){
        this.data=new HashSet<Integer>();
        this.n=0;
    }

    public NumSet(Set<Integer> data){
        this.data=data;
        this.n=this.data.size();
        //ns.add(this);
    }

    public NumSet cross(NumSet ob){
        Set<Integer> res = new HashSet<Integer>();
        for(int i:this.data){
            for(int j:ob.data){
                if(i==j) res.add(i);
            }
        }
        return new NumSet(res);
    }

    public NumSet unite(NumSet ob){
        Set<Integer> res = new HashSet<Integer>();
        res.addAll(this.data);
        for(int i:ob.data){
            if(!res.contains(i)) res.add(i);
        }
        return new NumSet(res);
    }
    @Override
    public String toString(){
        String s="";
        for(int i:this.data){
            s+=i+" ";
        }
        s+="\nSize = "+n;
        return s;
    }
}
