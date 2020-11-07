/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The Controller Class implements the Controller element from the Model-View-Controller design pattern.
 * It listens to events triggered by the view (user input in our case), and executes the corresponding operation.
 */
package gui;

import model.*;

import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private View view;
    private Model model;

    /**
     * Constructor
     * @param model-a model type object
     * @param view-a view type object
     */
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.addAdditionListener(new AdditionListener());
        view.addSubtractionListener(new SubtractionListener());
        view.addMultiplicationListener(new MultiplicationListener());
        view.addDivisionListener(new DivisionListener());
        view.addDerivativeListener(new DerivativeListener());
        view.addIntegralListener(new IntegralListener());
    }

    /**
     * Function to transform a polynomial given in string format into an object of Polynomial type
     * @param str-the given string
     * @return the Polynomial object
     */
    public static Polynomial strToPolynomial(String str){
        String input = str;
        Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = p.matcher(input);
        Polynomial p1 = new Polynomial();
        while (m.find()) {
            Monomial m1 = new Monomial((float)Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
            if ((int) m1.getCoef() == m1.getCoef())
                p1.addMonomial(m1);
            else
                System.out.println("NOT INTEGER COEFFICIENT");
        }
        return p1;
    }

    /**
     * Listener for the Addition button
     */
    class AdditionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                userInput2 = view.getUserInput2();
                model.setResult(Operations.Add(strToPolynomial(userInput1), strToPolynomial(userInput2)));
                view.setResult(model.getResult().toString());

            } catch (NumberFormatException nfex) {
                view.setResult("Bad input: '");
            }
        }
    }

    /**
     * Listener for the Subtraction button
     */
    class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                userInput2 = view.getUserInput2();
                model.setResult(Operations.Subtract(strToPolynomial(userInput1), strToPolynomial(userInput2)));
                view.setResult(model.getResult().toString());

            } catch (NumberFormatException nfex) {
                view.setResult("Bad input: '");
            }
        }
    }

    /**
     * Listener for the Multiplication button
     */
    class MultiplicationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                userInput2 = view.getUserInput2();
                model.setResult(Operations.Multiply(strToPolynomial(userInput1), strToPolynomial(userInput2)));
                view.setResult(model.getResult().toString());

            } catch (NumberFormatException nfex) {
                view.setResult("Bad input: '");
            }
        }
    }

    /**
     * Listener for the Division button
     */
    class DivisionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                userInput2 = view.getUserInput2();
                if (userInput2.equals("0")) view.setResult("Division by 0 not possible");
                else if (strToPolynomial(userInput1).getDegree() < strToPolynomial(userInput2).getDegree()) view.setResult("Division not possible");
                else {
                    Polynomial res[] = Operations.Division(strToPolynomial(userInput1), strToPolynomial(userInput2));
                    view.setResult(res[0].toString() + " ,rest: " + res[1].toString());
                }
            } catch (NumberFormatException nfex) {
                view.setResult("Bad input: '");
            }
        }
    }

    /**
     * Listener for the Derivative button
     */
    class DerivativeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                model.setResult(Operations.Derivative(strToPolynomial(userInput1)));
                view.setResult(model.getResult().toString());
            } catch (NumberFormatException nfex) {
                view.setResult("Bad input: '");
            }
        }
    }

    /**
     * Listener for the Integral button
     */
    class IntegralListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                model.setResult(Operations.Integral(strToPolynomial(userInput1)));
                view.setResult(model.getResult().toString());
            } catch (NumberFormatException nfex) {
                view.setResult("Bad input: '");
            }
        }
    }
}
