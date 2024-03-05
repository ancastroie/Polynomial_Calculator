package testing;
import org.example.logic.Operations;
import org.example.model.Polynom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingUnit {
    @Test
    public void testAddition(){

        Polynom p1=new Polynom();
        Polynom p2=new Polynom();
        Operations op=new Operations();
        String text1="x^2+2x^3";
        String text2="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        p2=p2.fromString(text2);
        Polynom res=new Polynom();
        res=op.addition(p1,p2);
        assertEquals(res.toString()," + 1.0 + 3.0x^2 + 3.0x^3 + 1.0x^5");
    }

    @Test
    public void testSubstraction(){

        Polynom p1=new Polynom();
        Polynom p2=new Polynom();
        Operations op=new Operations();
        String text1="x^2+2x^3";
        String text2="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        p2=p2.fromString(text2);
        Polynom res=new Polynom();
        res=op.substraction(p1,p2);
        assertEquals(res.toString()," - 1.0 - 1.0x^2 + 1.0x^3 - 1.0x^5");
    }

    @Test
    public void testMultiplication(){

        Polynom p1=new Polynom();
        Polynom p2=new Polynom();
        Operations op=new Operations();
        String text1="x^2+2x^3";
        String text2="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        p2=p2.fromString(text2);
        Polynom res=new Polynom();
        res=op.multiplication(p1,p2);
        assertEquals(res.toString()," + 1.0x^2 + 2.0x^3 + 2.0x^4 + 5.0x^5 + 2.0x^6 + 1.0x^7 + 2.0x^8");
    }

    @Test
    public void testIntegration(){

        Polynom p1=new Polynom();
        Operations op=new Operations();
        String text1="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        Polynom res=new Polynom();
        res=op.integration(p1);
        assertEquals(res.toString()," + 1.0x^1 + 0.6666666666666666x^3 + 0.25x^4 + 0.16666666666666666x^6");
    }

    @Test
    public void testDerivation(){

        Polynom p1=new Polynom();
        Operations op=new Operations();
        String text1="1+2x^2+x^3+x^5";
        p1=p1.fromString(text1);
        Polynom res=new Polynom();
        res=op.derivation(p1);
        assertEquals(res.toString()," + 4.0x^1 + 3.0x^2 + 5.0x^4");
    }


}