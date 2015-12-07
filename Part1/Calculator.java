/*Easy Calculator*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    //Declaration
    double result = 0;
    JTextField Num1, Num2;
    JLabel Sign, Equ, Sum;
    JButton Add, Sub, Mul, Div, OK;
    //Draw Calculator
    Calculator() {
        //Set Pane
        Container lo = getContentPane();
        //Set Button-Layout
        lo.setLayout(new GridLayout(2,5,10,10));
        //Set TextField and Label
        Num1 = new JTextField();
        Num1.setHorizontalAlignment(JTextField.CENTER);
        lo.add(Num1);
        Sign = new JLabel();
        Sign.setHorizontalAlignment(JLabel.CENTER);
        lo.add(Sign);
        Num2 = new JTextField();
        Num2.setHorizontalAlignment(JTextField.CENTER);
        lo.add(Num2);
        Equ = new JLabel("=");
        Equ.setHorizontalAlignment(JLabel.CENTER);
        lo.add(Equ);
        Sum = new JLabel();
        Sum.setHorizontalAlignment(JLabel.CENTER);
        lo.add(Sum);
        //Set Button
        Add = new JButton("+");
        lo.add(Add);
        Sub = new JButton("-");
        lo.add(Sub);
        Mul = new JButton("x");
        lo.add(Mul);
        Div = new JButton("÷");
        lo.add(Div);
        OK = new JButton("OK");
        lo.add(OK);
        //Set pane-attribute
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
        //Add Actionlistener
        Add.addActionListener(this);
        Sub.addActionListener(this);
        Mul.addActionListener(this);
        Div.addActionListener(this);
        OK.addActionListener(this);
    }

    //Button-ActionEvent
    public void actionPerformed(ActionEvent e) {
        //Click-Sign-Button-ActionEvent
        if (e.getActionCommand() == "+") {
            Sign.setText("+");
        }
        if (e.getActionCommand() == "-") {
            Sign.setText("-");
        }
        if (e.getActionCommand() == "x") {
            Sign.setText("x");
        }
        if (e.getActionCommand() == "÷") {
            Sign.setText("÷");
        }
        //Click-OK-Button-ActionEvent
        if (e.getActionCommand() == "OK") {
            //Get Sign
            String sign = Sign.getText();
            //Get Num1 and Num2
            double num1 = Double.valueOf(Num1.getText());
            double num2 = Double.valueOf(Num2.getText());
            //Judge Sign and Calculator
            if (sign.equals("+")) {
                result = num1 + num2;
            }
            else if (sign.equals("-")) {
                result = num1 - num2;
            }
            else if (sign.equals("x")) {
                result = num1 * num2;
            }
            else if (sign.equals("÷")) {
                result = num1 / num2;
            }
            Sum.setText(String.valueOf(result));
        }   
     }
     //Call Constructor
     public static void main(String[] args) {
        new Calculator();
     }
}

