package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class addbook extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Font f1;
    
    addbook() {
        super(":: Add A BOOk :: ");
        getContentPane().setBackground(Color.BLACK);
        setSize(700,700);
        setLocation(350,100);
        setLayout(null);
        f1 = new Font("Elephant",Font.BOLD,20);
        
        l1 = new JLabel(":: ADD A BOOK :: ");
        l1.setFont(new Font("Elephant",Font.BOLD,25));
        l1.setForeground(Color.YELLOW);
        l1.setBounds(210,30,300,100);
        add(l1);
        
        l2 = new JLabel("Book Id :: ");
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setBounds(125,110,300,100);
        add(l2);
        
        l3 = new JLabel("Book Name :: ");
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        l3.setBounds(90, 190,300,100);
        add(l3);
        
        l4 = new JLabel("Author :: ");
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        l4.setBounds(130,270,300,100);
        add(l4);
        
        l5 = new JLabel("Publisher :: ");
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        l5.setBounds(100,350,300,100);
        add(l5);
        
        l6 = new JLabel("Quantity :: ");
        l6.setFont(f1);
        l6.setForeground(Color.WHITE);
        l6.setBounds(110,430,300,100);
        add(l6);
        
        t1 = new JTextField();
        t1.setFont(f1);
        t1.setBounds(250,145,300,30);
        add(t1);
        
        t2 = new JTextField();
        t2.setFont(f1);
        t2.setBounds(250,225,300,30);
        add(t2);
        
        t3 = new JTextField();
        t3.setFont(f1);;
        t3.setBounds(250,305,300,30);
        add(t3);
        
        t4 = new JTextField();
        t4.setFont(f1);
        t4.setBounds(250,385,300,30);
        add(t4);
        
        t5 = new JTextField();
        t5.setFont(f1);
        t5.setBounds(250,465,300,30);
        add(t5);
        
        b1 = new JButton("Add Book");
        b1.setFont(f1);
        b1.setBounds(70,570,250,30);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(f1);;
        b2.setBounds(350,570,250,30);
        add(b2);
        b1.addActionListener(this);        
        b2.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String tid = t1.getText();
            String tname = t2.getText();
            String tauthor = t3.getText();
            String tpublisher = t4.getText();
            String tquantity = t5.getText();
            
            if(tid.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Id..!!");
            }
            else {
                try {
                    Connection_Class c1 = new Connection_Class();
                    String query = "insert into book values('"+tid+"','"+tname+"','"+tauthor+"','"+tpublisher+"'"
                          + ",'"+tquantity+"')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Book Added Successfully..!!!");
                    setVisible(false);
                }catch(Exception e) {
                e.printStackTrace();
                }
            }
        }
        if(ae.getSource() == b2) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new addbook();
    }
}
