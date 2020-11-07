/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The Polynomial Class implements the structure of a polynomial containing monomials
 */

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Polynomial {
    private ArrayList<Monomial> mons = new ArrayList<Monomial>();

    /**
     * Constructor for polynomial
     * @param mons list of the monomials to be added
     */
    public Polynomial(ArrayList<Monomial> mons) {
        this.mons = mons;
        sort();
    }

    /**
     * Constructor for empty polynomial
     */
    public Polynomial(){
    }

    /**
     * Function for copying a polynomial
     * @param p1 polynomial to be copied
     */
    public void copyPolynomial(Polynomial p1){
        for (Monomial m: p1.getMonomials()){
            Monomial copyM = new Monomial(m);
            addMonomial(copyM);
        }
    }

    /**
     * @return list of the monomials
     */
    public ArrayList<Monomial> getMonomials(){
        return mons;
    }

    /**
     * Adds a monomial to the polynomial
     * @param m monomial to be added
     */
    public void addMonomial(Monomial m){
        mons.add(m);
        sort();
    }

    /**
     * Function for sorting the monomials, in order to have the powers in descending order
     */
    public void sort(){
        for (Iterator<Monomial> it = mons.iterator(); it.hasNext();){
            float coef = it.next().getCoef();
            if (coef == 0)
                it.remove();
        }

        Collections.sort(mons);
    }

    /**
     * Function for printing the monomial
     */
    public void list() {
        if (mons.size() == 0) System.out.print("0");
        else {
            int size = mons.size();
            for (int i = 0; i < size - 1; i++) {
                if (i > 0 && mons.get(i).getCoef() > 0) System.out.print("+");
                if (mons.get(i).getCoef() == -1) System.out.print("-");
                if (mons.get(i).getCoef() != 1 && mons.get(i).getCoef() != -1) {
                    if ((int) mons.get(i).getCoef() == mons.get(i).getCoef())
                        System.out.print((int) mons.get(i).getCoef());
                    else
                        System.out.print(String.format("%.2f", mons.get(i).getCoef()));
                }
                System.out.print("x^" + mons.get(i).getPow());
            }
            if (mons.get(size - 1).getCoef() > 0) System.out.print("+");
            if (mons.get(size - 1).getCoef() == -1) System.out.print("-");
            if (mons.get(size - 1).getCoef() != 1 && mons.get(size - 1).getCoef() != -1) {
                if ((int) mons.get(size - 1).getCoef() == mons.get(size - 1).getCoef())
                    System.out.print((int) mons.get(size - 1).getCoef());
                else
                    System.out.print(String.format("%.2f", mons.get(size - 1).getCoef()));
            }
            System.out.println("x^" + mons.get(size - 1).getPow());
        }
    }

    /**
     * Function to transform the polynomial to a string
     * @return the string
     */
    public String toString(){
        String str = "";
        if (mons.size() == 0) str = "0";
        else {
            int size = mons.size();
            for (int i = 0; i < size - 1; i++) {
                if (i > 0 && mons.get(i).getCoef() > 0) str += "+";
                if (mons.get(i).getCoef() == -1) str += "-";
                if (mons.get(i).getCoef() != 1 && mons.get(i).getCoef() != -1) {
                    if ((int) mons.get(i).getCoef() == mons.get(i).getCoef())
                        str += String.format("%.0f", mons.get(i).getCoef());
                    else
                        str += String.format("%.2f", mons.get(i).getCoef());
                }
                str += "x^" + Integer.toString(mons.get(i).getPow());
            }
            if (mons.get(size - 1).getCoef() > 0) str += "+";
            if (mons.get(size - 1).getCoef() == -1) str += "-";
            if (mons.get(size - 1).getCoef() != 1 && mons.get(size - 1).getCoef() != -1) {
                if ((int) mons.get(size - 1).getCoef() == mons.get(size - 1).getCoef())
                    str += String.format("%.0f", mons.get(size - 1).getCoef());
                else
                    str += String.format("%.2f", mons.get(size - 1).getCoef());
            }
            str += "x^" + Integer.toString(mons.get(size - 1).getPow());
        }
        return str;
    }

    /**
     * Function for returning the degree of the polynomial
     * @return degree
     */
    public int getDegree(){
        return mons.get(0).getPow();
    }

    /**
     * Function for checking if the polynomial is equal to 0
     * @return true if 0, false otherwise
     */
    public boolean isZero(){
        if (mons.size() == 0 || (getDegree() == 0 && mons.get(0).getCoef() == 0)) return true;
        return false;
    }
}
