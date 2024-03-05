package org.example.view;

import jdk.dynalink.Operation;
import org.example.logic.Operations;
import org.example.model.Polynom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JTextField p1, p2;
    JLabel resultValueLabel,result2;
    JComboBox operationcb;
    JPanel panelResult;
    JButton compute;

    public GUI() {

        getContentPane().setBackground(Color.WHITE);
        this.setTitle("Polynomial Equation Calculator");
        this.setLayout(null);
        this.setBounds(300, 100, 800, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Polynom1");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        p1 = new JTextField();
        p1.setBounds(150, 20, 180, 30);
        add(p1);

        JLabel l2 = new JLabel("Polynom2");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        p2 = new JTextField();
        p2.setBounds(150, 70, 180, 30);
        add(p2);

        JLabel op = new JLabel("Operation");
        op.setBounds(40, 120, 150, 30);
        add(op);

        String[] Options = {"Addition", "Substraction", "Multiplication", "Division", "Derivation","Integration"};
        operationcb = new JComboBox(Options);
        operationcb.setBounds(150, 120, 180, 30);
        operationcb.addActionListener(this);
        add(operationcb);

        compute = new JButton("Compute");
        compute.setBackground(Color.BLACK);
        compute.setForeground(Color.WHITE);
        compute.setBounds(70, 170, 150, 50);
        compute.addActionListener(this);
        add(compute);

        JLabel l3 = new JLabel("Result:");
        l3.setBounds(40, 250, 150, 30);
        add(l3);

        resultValueLabel = new JLabel("");
        resultValueLabel.setBounds(80, 250, 640, 30);
        add(resultValueLabel);

        panelResult=new JPanel();
        panelResult.setBounds(350,20,400,200);
        add(panelResult);

        JLabel text=new JLabel("For the derivation and integration please enter the first polynomial",SwingConstants.CENTER);
        panelResult.add(text);

        setVisible(true);
    }

    public JTextField getFirstPolynom() {
        return p1;
    }

    public JTextField getSecPolynom() {
        return p2;
    }

    public JComboBox getOperationsComboBox() {
        return operationcb;
    }

    public JLabel getResultValueLabel() {
        return resultValueLabel;
    }
    public JLabel getResultValueLabel2() {
        return result2;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Operations operations=new Operations();
        if (e.getActionCommand().equals("Compute")) {
            String firstPolynom = p1.getText();
            String secPolynom = p2.getText();
            String operation = (String) operationcb.getSelectedItem();
            Polynom result = new Polynom();
            Polynom p1 = new Polynom();
            Polynom p2 = new Polynom();
            p1 = p1.fromString(firstPolynom);

            switch (operation) {
                case "Addition":
                    p2 = p2.fromString(secPolynom);
                    result = operations.addition(p1, p2);
                    break;
                case "Substraction":
                    p2 = p2.fromString(secPolynom);
                    result = operations.substraction(p1, p2);
                     break;
                case "Multiplication":
                    p2 = p2.fromString(secPolynom);
                    result = operations.multiplication(p1, p2);
                    break;
                case "Derivation": result=operations.derivation(p1);
                    break;
                case "Integration": result=operations.integration(p1);
                    break;
            }
            this.getResultValueLabel().setText(String.valueOf(result.toString()));
        }
    }

}
