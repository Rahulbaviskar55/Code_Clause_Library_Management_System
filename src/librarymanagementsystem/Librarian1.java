package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Librarian1 extends JFrame implements ActionListener {
    JLabel heading,id,name,password,email,contact,city;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton btn1,btn2;
    Font f1;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
    LocalDateTime now = LocalDateTime.now();
    
    Librarian1() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        f1  = new Font("Elephant",Font.BOLD,18);
        
        heading = new JLabel(":: ADD LIBRARIAN ::");
        heading.setFont(new Font("Elephant",Font.BOLD,25));
        heading.setForeground(Color.YELLOW);
        heading.setBounds(180,20,400,100);
        add(heading);
        
        name = new JLabel("Name :: ");
        name.setFont(f1);
        name.setForeground(Color.WHITE);
        name.setBounds(120,105,300,100);
        add(name);
        
        t1 = new JTextField();
        t1.setFont(f1);
        t1.setBounds(250,140,300,30);
        add(t1);
        
        id = new JLabel("ID ::");
        id.setFont(f1);
        id.setForeground(Color.WHITE);
        id.setBounds(145,165,300,100);
        add(id);
        
        t6 = new JTextField();
        t6.setFont(f1);
        t6.setBounds(250,200,300,30);
        add(t6);
        
        password = new JLabel("Password :: ");
        password.setFont(f1);
        password.setBounds(80,220,300,100);
        password.setForeground(Color.WHITE);
        add(password);
        
        t2 = new JPasswordField();
        t2.setFont(f1);
        t2.setBounds(250,255,300,30);
        add(t2);
        
        email = new JLabel("Email :: ");
        email.setFont(f1);
        email.setForeground(Color.WHITE);
        email.setBounds(115,280,300,100);
        add(email);
        
        t3 = new JTextField();
        t3.setFont(f1);
        t3.setBounds(250,310,300,30);
        add(t3);
        
        contact = new JLabel("Contact ::");
        contact.setFont(f1);
        contact.setForeground(Color.WHITE);
        contact.setBounds(100,330,200,100);
        add(contact);
        
        t4 = new JTextField();
        t4.setFont(f1);
        t4.setBounds(250,365,300,30);
        add(t4);
        
        city = new JLabel("City :: ");
        city.setFont(f1);
        city.setForeground(Color.WHITE);
        city.setBounds(135,380,200,100);
        add(city);
        
        t5 = new JTextField();
        t5.setFont(f1);
        t5.setBounds(250,415,300,30);
        add(t5);
        
        btn1 = new JButton("Add Librarian");
        btn1.setFont(f1);
        btn1.setBounds(120,490,200,30);
        add(btn1);
        btn1.addActionListener(this);
        
        btn2 = new JButton("Cancel");
        btn2.setFont(f1);
        btn2.setBounds(360,490,200,30);
        add(btn2);
        btn2.addActionListener(this);
        
        setSize(700,600);
        setLocation(450,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn1) {
            String tname,tid,tpassword,temail,tcontact,tcity,date;
            tname = t1.getText();
            tid = t6.getText();
            tpassword = t2.getText();
            temail = t3.getText();
            tcontact = t4.getText();
            tcity = t5.getText();
            date = dtf.format(now);
            if(tid.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter ID..!!!");
                t6.setText("");
            }
            if(tpassword.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Password..!!!");
                t3.setText("");
            }
            if(tcontact.length()<10 || tcontact.length()>10) {
                JOptionPane.showMessageDialog(null, "Please Enter Valid Contact Number..!!!");
                t4.setText("");
            }
            String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";  
            Pattern pattern = Pattern.compile(regex);  
            Matcher matcher = pattern.matcher(temail);
            if(!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Please Enter Valid Email..!!!");
                t3.setText("");
            }
            try {
                Connection_Class c1 = new Connection_Class();
                String query = "Insert into librarian values('"+tname+"','"+tid+"','"+tpassword+"','"+temail+"',"
                        + "'"+tcontact+"','"+tcity+"','"+date+"')";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Librarian Added Successfully..!!!");
                setVisible(false);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource() == btn2) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Librarian1();
    }
}
