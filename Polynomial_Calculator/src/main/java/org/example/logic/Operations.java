package org.example.logic;

import org.example.model.Polynom;

public class Operations {

        public Polynom addition(Polynom p1, Polynom p2){
            Polynom sum = new Polynom();
            Double value=0.0;
            sum.copy(sum,p1);
            //sum.displayPolynom(sum);
            for (Integer key : p2.getPolynom().keySet()){
                value=0.0;
                if(p1.getPolynom().containsKey(key)){
                    value=sum.getPolynom().get(key)+p2.getPolynom().get(key);
                    sum.addTherm(key,value);

                }else{
                    sum.addTherm(key,p2.getPolynom().get(key));
                }
            }
            return sum;
        }

        public Polynom substraction(Polynom p1,Polynom p2){
            Polynom sub=new Polynom();
            sub.copy(sub,p1);
            Double value=0.0;
            //sum.displayPolynom(sum);
            for (Integer key : p2.getPolynom().keySet()){
                value=0.0;
                if(p1.getPolynom().containsKey(key)){
                    value=sub.getPolynom().get(key)-p2.getPolynom().get(key);
                    sub.addTherm(key,value);

                }else{
                    sub.addTherm(key,-p2.getPolynom().get(key));
                }
            }
            return sub;
        }

        public Polynom multiplication(Polynom p1,Polynom p2){
            Polynom mult=new Polynom();
            Double coeff;
            for(Integer i:p1.getPolynom().keySet()){
                for(Integer j:p2.getPolynom().keySet()){
                    if(mult.getPolynom().containsKey(i+j)){
                        coeff=mult.getCoeff(i+j)+p1.getCoeff(i)*p2.getCoeff(j);
                        mult.addTherm(i+j,coeff);
                    }
                    else mult.addTherm(i+j,p1.getCoeff(i)*p2.getCoeff(j));
                }
            }
            return mult;
        }

        public Polynom derivation(Polynom p){
            Polynom der=new Polynom();
            Double coeff=0.0;
            for(Integer key:p.getPolynom().keySet()){
                coeff=p.getCoeff(key)*key;
                if(key!=0){
                    der.addTherm(key-1,coeff);
                }
            }
            return der;
        }

        public Polynom integration(Polynom p){
            Polynom integrated=new Polynom();

            Double coeff=0.0;
            for(Integer key:p.getPolynom().keySet()){
                coeff=p.getCoeff(key)/(key+1);
                    integrated.addTherm(key+1,coeff);
            }

            return integrated;
        }

        public Polynom division(Polynom p1,Polynom p2){
           Polynom div=new Polynom();

           return div;
        }
}
