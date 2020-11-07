/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The Tests Class implements JUnit test cases for all the operations in order to ensure their correctness.
 */
package polynomial;
import model.*;
import gui.*;

import static org.junit.Assert.*;
import org.junit.Test;
public class Tests {
    @Test
    public void test(){
        Polynomial p = new Polynomial();
        Polynomial q = new Polynomial();
        p = Controller.strToPolynomial("2x^2+3x^1+2x^0");
        q = Controller.strToPolynomial("-1x^5-2x^2");

        //Test for addition
        Polynomial res = Operations.Add(p, q);
        assertEquals("-x^5+3x^1+2x^0", res.toString());

        //Test for subtraction
        res = Operations.Subtract(p, q);
        assertEquals("x^5+4x^2+3x^1+2x^0", res.toString());

        //Test for multiplication
        p = Controller.strToPolynomial("2x^2+3x^0");
        q = Controller.strToPolynomial("1x^1+2x^0");
        res = Operations.Multiply(p, q);
        assertEquals("2x^3+4x^2+3x^1+6x^0", res.toString());

        //Test for division
        Polynomial div[];
        div = Operations.Division(p, q);
        assertEquals("2x^1-4x^0 ,rest: +11x^0", div[0].toString() + " ,rest: " + div[1].toString());

        //Test for derivative
        p = Controller.strToPolynomial("2x^4+6x^0");
        res = Operations.Derivative(p);
        assertEquals("+8x^3", res.toString());

        //Test for integral
        p = Controller.strToPolynomial("2x^4+6x^0");
        res = Operations.Integral(p);
        assertEquals("0.40x^5+6x^1", res.toString());

    }

}
