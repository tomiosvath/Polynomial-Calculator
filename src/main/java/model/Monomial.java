/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The Monomial Class implements basic functionality for a monomial used in mathematics, with the form ax^b, where a is a float
 * and b is an integer.
 */

package model;

public class Monomial implements Comparable{
    private float coef;
    private int pow;

    /**
     * Constructor for the 0 monomial
     */
    public Monomial(){
        coef = 0;
        pow = 0;
    }
    /**
     * Constructor for the monomial
     * @param coef coefficient of the monomial
     * @param pow power of the monomial
     */
    public Monomial(float coef, int pow) {
        this.coef = coef;
        this.pow = pow;
    }

    /**
     * Constructor for creating a copy of a monomial
     * @param mono the copied monomial
     */
    public Monomial(Monomial mono){
        this.coef = mono.coef;
        this.pow = mono.pow;
    }

    public float getCoef() {
        return coef;
    }

    public int getPow() {
        return pow;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    /**
     * Function for comparing two monomials by their power
     * @param m the object that needs to be compared(Monomial in our case)
     * @return 1 if greater, 0 if equal, -1 if smaller
     */
    @Override
    public int compareTo(Object m) {
        float compare = ((Monomial)m).getPow();
        return ((int)compare - (int)this.pow);
    }
}
