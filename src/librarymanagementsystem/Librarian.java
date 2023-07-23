package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Librarian extends JFrame implements ActionListener {
    JLabel heading1,lblname,lblpwd,imglbl;
    JButton login1,cancel1;
    JTextField t1,pwd;
    
    Font f1,f2;
   
    Librarian() {
        super(":: Librarain Login Page ::");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        f1 = new Font("Elephant",Font.BOLD,45);
        f2 = new Font("Elephant",Font.BOLD,30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("librarymanagementsystem/icons/main.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        imglbl = new JLabel(i3);
        add(imglbl);
        
        heading1 = new JLabel(":: LIBRARIAN LOGIN :: ");
        heading1.setFont(f1);
        heading1.setForeground(Color.RED);
        heading1.setBounds(500,80,1000,100);
        add(heading1);
        
        lblname = new JLabel("LIBRARIAN ID ::");
        lblname.setFont(f2);
        lblname.setForeground(Color.WHITE);
        lblname.setBounds(410,240,500,100);
        add(lblname);
        
        lblpwd = new JLabel("PASSWORD   ::");
        lblpwd.setFont(f2);
        lblpwd.setForeground(Color.WHITE);
        lblpwd.setBounds(440,420,500,100);
        add(lblpwd);
        
        t1 = new JTextField();
        t1.setBounds(730,275,300,30);
        t1.setFont(f2);
        add(t1);
        
        pwd = new JPasswordField();
        pwd.setFont(f1);
        pwd.setBounds(730,455,300,30);
        add(pwd);
        
        login1 = new JButton("LOGIN");
        login1.setBounds(400,655,300,50);
        login1.setFont(f2);
        add(login1);
        
        cancel1 = new JButton("BACK");
        cancel1.setFont(f2);
        cancel1.setBounds(800,655,300,50);
        add(cancel1);
        
        login1.addActionListener(this);
        cancel1.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login1) {
            String tid,tpassword;
            tid = t1.getText();
            tpassword = pwd.getText();
            
            try {
                Connection_Class c1 = new Connection_Class();
                String query = "Select * from librarian where id = '"+tid+"' and password = '"+tpassword+"'";
                ResultSet rs = c1.s.executeQuery(query);
                String id = tid.toString();
                if(rs.next()) {
                    new Project1(id);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login..!!!");
                    t1.setText("");
                    pwd.setText("");
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource() == cancel1) {
            setVisible(false);
            new index();
        }
    }
    public static void main(String[] args) {
        new Librarian();
    }
}
