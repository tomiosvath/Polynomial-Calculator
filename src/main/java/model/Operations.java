/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The Operation class implements the following operations for polynomials: Addition, Subtraction, Multiplication, Division,
 * Integration and Derivation.
 *
 */

package model;

import java.util.ArrayList;

public class Operations {

    /**
     * Constructor
     */
    public Operations() {
    }

    /**
     * Function for the Addition operation
     * @param p1 first polynomial
     * @param p2 second polynomial
     * @return the result
     */
    public static Polynomial Add(Polynomial p1, Polynomial p2){
        Polynomial p = new Polynomial();
        for (Monomial m: p1.getMonomials()) {
            Monomial newM = new Monomial(m);
            p.addMonomial(newM);
        }
        for (Monomial m2: p2.getMonomials()){
            boolean found = false;
            for (Monomial m: p.getMonomials()){
                if (m2.getPow() == m.getPow()){
                    m.setCoef(m.getCoef() + m2.getCoef());
                    found = true;
                }
            }
            if (!found) {
                Monomial newM = new Monomial(m2);
                p.addMonomial(newM);
            }
        }
        p.sort();
        return p;
    }

    /**
     * Function for the Subtraction operation
     * @param p1 first polynomial
     * @param p2 second polynomial
     * @return the result
     */
    public static Polynomial Subtract(Polynomial p1, Polynomial p2){
        Polynomial p = new Polynomial();

        for (Monomial m: p1.getMonomials()) {
            Monomial newM = new Monomial(m);
            p.addMonomial(newM);
        }

        for (Monomial m: p2.getMonomials())
            m.setCoef(-m.getCoef());

        return Add(p1, p2);
    }

    /**
     * Function for the Multiplication operation
     * @param p1 first polynomial
     * @param p2 second polynomial
     * @return the result
     */
    public static Polynomial Multiply(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        for (Monomial m1 : p1.getMonomials()){
            for (Monomial m2 : p2.getMonomials()) {
                float coef = m1.getCoef() * m2.getCoef();
                int pow = m1.getPow() + m2.getPow();
                Monomial newM = new Monomial(coef, pow);
                boolean found = false;
                for (Monomial m : p.getMonomials())
                    if (m.getPow() == newM.getPow()) {
                        m.setCoef(m.getCoef() + newM.getCoef());
                        found = true;
                    }
                if (!found)
                    p.addMonomial(newM);
            }
        }
        p.sort();
        return p;
    }

    /**
     * Function for the Derivative operation
     * @param p1 first polynomial
     * @return the result
     */
    public static Polynomial Derivative(Polynomial p1){
        Polynomial p = new Polynomial();
        for (Monomial m: p1.getMonomials()){
            Monomial newM = new Monomial(m.getCoef() * m.getPow(), m.getPow() - 1);
            if (m.getPow() != 0) p.addMonomial(newM);
        }
        return p;
    }

    /**
     * Function for the Integration operation
     * @param p1 first polynomial
     * @return the result
     */
    public static Polynomial Integral(Polynomial p1){
        Polynomial p = new Polynomial();
        for (Monomial m: p1.getMonomials()){
            Monomial newM = new Monomial(m.getCoef() / (m.getPow() + 1), m.getPow() + 1);
            p.addMonomial(newM);
        }
        return p;
    }

    /**
     * Function for the Division operation
     * @param p1 dividend
     * @param p2 divisor
     * @return the result
     */
    public static Polynomial[] Division(Polynomial p1, Polynomial p2){
        Polynomial[] res = new Polynomial[2];//on the 0th position is the quotient, on the 1st the remainder
        res[1] = new Polynomial();
        res[0] = new Polynomial();
        if (p2.getDegree() == 0 || p1.getDegree() < p2.getDegree()) return null;
        res[1].copyPolynomial(p1);
        while (!res[1].isZero() && res[1].getDegree() >= p2.getDegree()){
            Polynomial t = new Polynomial();

            float coef = res[1].getMonomials().get(0).getCoef() / p2.getMonomials().get(0).getCoef();
            int pow = res[1].getMonomials().get(0).getPow() - p2.getMonomials().get(0).getPow();
            Monomial m = new Monomial(coef, pow);
            t.addMonomial(m);
            res[0] = Add(res[0], t);
            res[1] = Subtract(res[1], Multiply(t, p2));
        }
        return res;
    }

}
