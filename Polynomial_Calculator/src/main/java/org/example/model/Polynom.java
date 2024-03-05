package org.example.model;
import javax.management.StringValueExp;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;


public class Polynom {

   private HashMap<Integer,Double> equation=new HashMap<Integer,Double>();


   public HashMap<Integer, Double> getPolynom() {
      return equation;
   }

   public void setP(HashMap<Integer, Double> equation) {
      this.equation = equation;
   }
   public void addTherm(Integer exponent,Double coeff){
      equation.put(exponent,coeff);
   }

   public Double getCoeff(Integer exponent){return equation.get(exponent);}

   public String toString() {
      StringBuilder aux = new StringBuilder();
      String s = null;
      for (int i : equation.keySet()) {
         Double coeff = equation.get(i);
         if (coeff > 0) {
            if(i==0) {
               aux.append(" + ").append(coeff);
            }else{
               aux.append(" + ").append(coeff).append("x^").append(i);}
         }else if(coeff<0){
            if(i==0) {
               aux.append(" - ").append(-coeff);
            }else{
               aux.append(" - ").append(-coeff).append("x^").append(i);}
         }else if(coeff==0) {
            continue;}
      }
      if (aux.length() == 0) {
         aux.append("0");
      }
      return aux.toString();
   }

   public void fullPolynom(Polynom p){                         //put in the hashmap the monomials with coeff 0
      int maxKey=0;
      for (Integer key : equation.keySet()){
         maxKey=key;
      }
      for(int i=0;i<=maxKey;i++){
         equation.putIfAbsent(i,0.0);
      }
   }

   public Polynom fromString(String text){
      Polynom p=new Polynom();
      text=text.replace(" ","");          //eliminate all spaces
      String sExp,sCoeff;
      int exponent=0;
      Double coeff=0.0;
      String[] terms=text.split("(?=\\+|\\-)");            //split polynomial by + and -
      for(String elem : terms){                                 //take all splited elements
         String[] nr=elem.split("x",2);              //put 2 so that when we have as it will split them as  elements
         if(nr.length>1 && nr[1]!=""){                         // the second therm is the ^exponent
            sExp=nr[1].replace("^","");
            exponent=Integer.valueOf(sExp);}
         else if(nr.length>1 && nr[1]==""){exponent=1;
         }else if(nr.length<=1)exponent=0;
         if(nr[0]=="")coeff=1.0;
         else if(nr[0].charAt(0)>='0'&& nr[0].charAt(0)<='9')coeff=Double.valueOf(nr[0]);      //if the first therm doesn't have a + or - (3x^2)
         else if(nr[0].charAt(0)=='+'){
            sCoeff=nr[0].replace("+","");
            if(sCoeff=="")coeff=1.0;
            else coeff=Double.valueOf(sCoeff);
         }else if(nr[0].charAt(0)=='-'){
            sCoeff=nr[0].replace("-","");
            if(sCoeff=="")coeff=-1.0;
            else coeff=-Double.valueOf(sCoeff);
         }p.addTherm(exponent,coeff);
      }p.fullPolynom(p);
      return p;}

   public void displayPolynom(Polynom p){
      for (Integer key : equation.keySet()){
         System.out.println("power = "+ key + ", coeff = "+ equation.get(key));
      }
   }

   public void copy(Polynom p1,Polynom p2)         //in p1 copy polynom p2
   {
      for (Integer key : p2.getPolynom().keySet()){
         p1.addTherm(key,p2.getPolynom().get(key));
      }
   }
}

