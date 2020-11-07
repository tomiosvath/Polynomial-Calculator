/**
 * @author Osvath Tamas
 * @version 1.0
 * @since 2020-03-05
 *
 * The View Class implements the View element from the Model-View-Controller design pattern.
 * It presents the model's data to the user, but has no knowing what the data represents or how it can be manipulated since it
 * has no access to the Controller.
 */
package gui;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private Model model;

    private JTextField input1 = new JTextField(20);
    private JTextField input2 = new JTextField(20);
    private JTextField result = new JTextField(20);
    private JButton addBtn = new JButton("Add");
    private JButton subBtn = new JButton("Subtract");
    private JButton mulBtn = new JButton("Multiply");
    private JButton divBtn = new JButton("Divide");
    private JButton derBtn = new JButton("Derivative");
    private JButton intBtn = new JButton("Integrate");

    /**
     * The constructor initializes the model and creates the Graphical User Interface to be displayed
     * @param model-the model object
     */
    public View(Model model){
        this.model = model;
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(300, 150));
        FlowLayout flow = new FlowLayout();
        content.setLayout(flow);
        content.add(new JLabel("Input1"));
        content.add(input1);
        content.add(new JLabel("Input2"));
        content.add(input2);
        content.add(new JLabel("Result"));
        result.setEditable(false);
        content.add(result);

        content.add(addBtn);
        content.add(subBtn);
        content.add(mulBtn);
        content.add(divBtn);
        content.add(derBtn);
        content.add(intBtn);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getUserInput1() {
        return input1.getText();
    }

    public String getUserInput2() {
        return input2.getText();
    }

    public void setResult(String text){
        result.setText(text);
    }


    /**
     * Adds listener to the addition button
     * @param mal-listener
     */
    void addAdditionListener(ActionListener mal) {
        addBtn.addActionListener(mal);
    }

    /**
     * Adds listener to the subtraction button
     * @param mal-listener
     */
    void addSubtractionListener(ActionListener mal) {
        subBtn.addActionListener(mal);
    }

    /**
     * Adds listener to the multiplication button
     * @param mal-listener
     */
    void addMultiplicationListener(ActionListener mal) {
        mulBtn.addActionListener(mal);
    }

    /**
     * Adds listener to the division button
     * @param mal-listener
     */
    void addDivisionListener(ActionListener mal) {
        divBtn.addActionListener(mal);
    }

    /**
     * Adds listener to the derivative button
     * @param mal-listener
     */
    void addDerivativeListener(ActionListener mal) {
        derBtn.addActionListener(mal);
    }

    /**
     * Adds listener to the integral button
     * @param mal-listener
     */
    void addIntegralListener(ActionListener mal) {
        intBtn.addActionListener(mal);
    }

}
