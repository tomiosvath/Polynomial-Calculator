/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The Model Class implements the structure of the model from the Model-View-Controller design patter. Basically, it creates
 * polynomials in order the Controller to be able to work with them
 */
package model;

public class Model {
    private Polynomial p1, p2;
    private Polynomial result;

    /**
     * Constructor, creates 2 polynomials for the input and a polynomial for the result
     */
    public Model(){
        p1 = new Polynomial();
        p2 = new Polynomial();
        result = new Polynomial();
    }

    public Polynomial getP1() {
        return p1;
    }

    public void setP1(Polynomial p1) {
        this.p1 = p1;
    }

    public Polynomial getP2() {
        return p2;
    }

    public void setP2(Polynomial p2) {
        this.p2 = p2;
    }

    public Polynomial getResult() {
        return result;
    }

    public void setResult(Polynomial result) {
        this.result = result;
    }

    /**
     * Resets the values of the polynomials
     */
    public void reset(){
        p1 = new Polynomial();
        p2 = new Polynomial();
        result = new Polynomial();
    }
}
