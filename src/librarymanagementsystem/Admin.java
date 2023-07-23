package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener {
    
    JLabel name, password,heading;
    JTextField t1,t2;
    JButton login,cancel;
    Font f1,f2;
    
    Admin() {
        super(":: ADMIN LOGIN PAGE::");
        getContentPane().setBackground(Color.BLACK);
        f1 = new Font("Elephant",Font.BOLD,30);
        f2 = new Font("Elephant",Font.BOLD,60);
        setLayout(null);
        
        heading = new JLabel(":: ADMIN LOGIN ::");
        heading.setBounds(470,60,1000,100);
        heading.setForeground(Color.YELLOW);
        heading.setFont(f2);
        add(heading);
        
        name = new JLabel("ADMIN ID ::");
        name.setBounds(500,255,400,100);
        name.setForeground(Color.WHITE);
        name.setFont(f1);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(740,290,300,32);
        t1.setFont(f1);
        add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(740,435,300,32);
        t2.setFont(f1);
        add(t2);
        
        password = new JLabel("PASSWORD :: ");
        password.setBounds(460,400,500,100);
        password.setForeground(Color.WHITE);
        password.setFont(f1);
        add(password);
        
        login = new JButton("LOGIN");
        login.setFont(f1);
        login.setBounds(470,610,200,50);
        add(login);
        login.addActionListener(this);
        
        cancel = new JButton("BACK");
        cancel.setBounds(820,610,200,50);
        cancel.setFont(f1);
        add(cancel);
        cancel.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String id = t1.getText();
            String pass = t2.getText();
            
            try {
                Connection_Class c1 = new Connection_Class();
                String query = "select * from admin where id = '"+id+"' and pass = '"+pass+"'";
                ResultSet rs = c1.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login..!!!");
                    t1.setText("");
                    t2.setText("");
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource() == cancel) {
           setVisible(false);
           new index();
        }
    }
    
    public static void main(String[] args) {
        new Admin();
    }   
}
