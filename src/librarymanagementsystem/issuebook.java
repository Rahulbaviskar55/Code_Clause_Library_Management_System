package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class issuebook extends JFrame implements ActionListener {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
    LocalDateTime now = LocalDateTime.now();
    JLabel l,l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Font f1;
    String lid;
    
    issuebook(String id) {
        setSize(880,690);
        setLocation(290,80);
        getContentPane().setBackground(Color.BLACK);
        f1 = new Font("Elephant",Font.BOLD,20);
        lid = id;
        setLayout(null);
        //System.out.println(dtf.format(now));
        
        l = new JLabel(":: Issue A Book :: ");
        l.setFont(new Font("Elephant",Font.BOLD,25));
        l.setForeground(Color.YELLOW);
        l.setBounds(300,40,300,30);
        add(l);
        
        l1 = new JLabel("Book Id :: ");
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        l1.setBounds(200,120,300,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setFont(f1);
        t1.setBounds(350,120,300,30);
        add(t1);
        
        l2 = new JLabel("Book Name :: ");
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setBounds(160,190,300,30);
        add(l2);
        
        t2 = new JTextField();
        t2.setFont(f1);
        t2.setBounds(350,190,300,30);
        add(t2);
        
        l3 = new JLabel("Student Id :: ");
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        l3.setBounds(170,260,300,30);
        add(l3);
        
        t3 = new JTextField();
        t3.setFont(f1);
        t3.setBounds(350,260,300,30);
        add(t3);
        
        l4 = new JLabel("Student Name :: ");
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        l4.setBounds(135,330,300,30);
        add(l4);
        
        t4 = new JTextField();
        t4.setFont(f1);
        t4.setBounds(350,330,300,30);
        add(t4);
        
        l5 = new JLabel("Student Contact :: ");
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        l5.setBounds(115,400,300,30);
        add(l5);
        
        t5 = new JTextField();
        t5.setFont(f1);
        t5.setBounds(350,400,300,30);
        add(t5);
        
//        l6 = new JLabel("Book Quantity :: ");
//        l6.setFont(f1);
//        l6.setForeground(Color.WHITE);
//        l6.setBounds(125,460,300,30);
//        add(l6);
        
//        t6 = new JTextField();
//        t6.setFont(f1);
//        t6.setBounds(350,460,300,30);
//        add(t6);
        
        b1 = new JButton("Issue Book");
        b1.setFont(f1);
        b1.setBounds(150,540,250,30);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(f1);
        b2.setBounds(450,540,250,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String bid = t1.getText();
            String bname = t2.getText();
            String sid = t3.getText();
            String sname = t4.getText();
            String scontact = t5.getText();
            //String bquantity = t6.getText();
            String date = dtf.format(now);
            System.out.println(date);
            if(bid.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Book Id..!!!");
            }
            if(bname.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Book Name..!!!");
            }
            if(sid.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Student Id..!!!");
            }
            //int Quantity = Integer.parseInt(bquantity);
            try {
                Connection_Class c1 = new Connection_Class();
                ResultSet rs = c1.s.executeQuery("select quantity from book where id = '"+bid+"'");
                int quantity = 0;
                if(rs.next()){
                    quantity = rs.getInt(1);
                }
                if(quantity == 0) {
                    JOptionPane.showMessageDialog(null,"Book Not Available..!!!");
                    setVisible(false);
                } else {
                    int lid1 = Integer.parseInt(lid);
                    String query3 = "select name from librarian where id = '"+lid1+"'";
                    rs = c1.s.executeQuery(query3);
                    String name="";
                    if(rs.next()) {
                        name = rs.getString("name");
                    }
                    String query1 = "insert into issuedbooks values('"+bid+"','"+bname+"','"+sid+"','"+sname+"',"
                        + "'"+scontact+"','"+date+"','"+name+"')";
                    c1.s.executeUpdate(query1);
                    int newquantity = quantity - 1;
                    String query2 = "update book set quantity = '"+newquantity+"' where id = '"+bid+"'";
                    c1.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Book Issued Successfully..!!!");
                    setVisible(false);
                }
                
                }catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource() == b2) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new issuebook("");
    }
}
