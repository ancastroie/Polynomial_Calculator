package org.example.logic;

import org.example.model.Polynom;

public class TestOperations {
    public static void main(String[] args) {

        Polynom p1=new Polynom();
        Polynom p2=new Polynom();
        Operations op=new Operations();
        String text1="x+ 2x^2+4x^4";
        String text2="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        p1.displayPolynom(p1);
        Polynom res=new Polynom();
        res=op.derivation(p1);
        String result;
        result=res.toString();
        System.out.println(result);
    }



}
