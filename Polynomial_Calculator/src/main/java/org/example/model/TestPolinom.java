package org.example.model;

import org.example.logic.Operations;
import org.example.view.GUI;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestPolinom {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       /*  Polynom p1=new Polynom();
       p1.addTherm(1,1.0);
        p1.addTherm(4,-3.0);
        p1.addTherm(5,0.0);
       // p1.addTherm(0,4.0);
        p1.addTherm(2,-8.3);
        p1.addTherm(6,-0.0);
        p1.addTherm(0,8.0);

        */

       /*String result= p1.toString();
        System.out.println("the coefficient of x^1 is "+p1.getCoeff(1));
        System.out.println("the coeff of x^5 is "+p1.getCoeff(5));

        System.out.println(result);

        */
        /*
        Polynom p2=new Polynom();
        String text=" + 5x- 4x^4-x^2 + 8-2.0x^3 - 9 x ^ 5+10x^7+0x^10";
        p2=p2.fromString(text);
       // p2.displayPolynom(p2);
       text= p2.toString();
      System.out.println(text);
       p2=p2.fromString(text);
       Polynom p=new Polynom();
       p2.copy(p,p2);
      p.displayPolynom(p);

         */
        /*
        Polynom p1=new Polynom();
        Polynom p2=new Polynom();
        Polynom sum=new Polynom();
        String text1="1+2x+4x^3+5x^4";
        String text2="2+3x+x^2+3x^4+2x^5";
        p1=p1.fromString(text1);
        //p1.displayPolynom(p1);

        p2=p2.fromString(text2);
       // p2.displayPolynom(p2);

        Operations op=new Operations();
        sum=op.addition(p1,p2);
        sum.displayPolynom(sum);
        String s;
        s=sum.toString();
        System.out.println(s);

         */


        Polynom p1=new Polynom();
        Polynom p2=new Polynom();
        Operations op=new Operations();
        String text1="x^2+2x^3";
        String text2="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        p2=p2.fromString(text2);
        Polynom res=new Polynom();
        res=op.addition(p1,p2);

        res.displayPolynom(res);
        String result;
        result=res.toString();
        System.out.println(result);


    }
}
