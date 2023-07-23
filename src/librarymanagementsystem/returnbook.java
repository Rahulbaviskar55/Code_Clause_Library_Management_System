package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class returnbook extends JFrame implements ActionListener {
    JLabel l,l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
    LocalDateTime now = LocalDateTime.now();
    Font f1;
    String lid;
    
    returnbook(String id) {
        super(":: Return A Book ::");
        lid = id;
        setSize(880,720);
        setLocation(250,80);
        getContentPane().setBackground(Color.BLACK);
        f1 = new Font("Elephant",Font.BOLD,20);
        setLayout(null);
        
        l = new JLabel(":: Return A Book ::");
        l.setFont(new Font("Elephant",Font.BOLD,25));
        l.setForeground(Color.YELLOW);
        l.setBounds(280,50,300,30);;
        add(l);
        
        l1 = new JLabel("Book Id :: ");
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        l1.setBounds(220,120,300,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setFont(f1);
        t1.setBounds(360,120,300,30);
        add(t1);
        
        l2 = new JLabel("Book Name :: ");
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setBounds(185,200,300,30);
        add(l2);
        
        t2 = new JTextField();
        t2.setFont(f1);
        t2.setBounds(360,200,300,30);
        add(t2);
        
        l3 = new JLabel("Student Id :: ");
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        l3.setBounds(190,290,300,30);
        add(l3);
        
        t3 = new JTextField();
        t3.setFont(f1);
        t3.setBounds(360,290,300,30);
        add(t3);
        
        l4 = new JLabel("Student Name :: ");
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        l4.setBounds(150,380,300,30);
        add(l4);
        
        t4 = new JTextField();
        t4.setFont(f1);
        t4.setBounds(360,380,300,30);
        add(t4);
        
        l5 = new JLabel("Student Contact :: ");
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        l5.setBounds(130,470,300,30);
        add(l5);
        
        t5 = new JTextField();
        t5.setFont(f1);
        t5.setBounds(360,470,300,30);
        add(t5);
        
        b1 = new JButton("Confirm");
        b1.setFont(f1);
        b1.setBounds(150,580,250,40);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(f1);
        b2.setBounds(500,580,250,40);
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
            String date = dtf.format(now);
            try {
                Connection_Class c1 = new Connection_Class();
                if(bid.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please Enter Book Id..!!!");
                }
                else if(bname.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please Enter Book Name..!!!");
                }
                else if(sid.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please Enter Student Id..!!!");
                }
                else if(sname.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please Enter Student Name..!!!");
                }else {
                    int id = Integer.parseInt(lid);
                    ResultSet rs = c1.s.executeQuery("select name from librarian where id = '"+id+"'");
                    String name = "";
                    if(rs.next()) {
                        name = rs.getString("name");
                    }
                    rs = c1.s.executeQuery("select * from issuedbooks where bookid = '"+bid+"' and studid = '"+sid+"'"
                            + "and bookname = '"+bname+"'");
                    if(rs.next()) {
                        System.out.println(name);
                        String query1 = "insert into returnbook values('"+bid+"','"+bname+"','"+sid+"','"+sname+"',"
                              + "'"+scontact+"','"+date+"','"+name+"')";
                        c1.s.executeUpdate(query1);
                        c1.s.executeUpdate("delete from issuedbooks where bookid = '"+bid+"' and studid = '"+sid+"'");
                        String query2 = "select quantity from book where id = '"+bid+"'";
                        rs = c1.s.executeQuery(query2);
                        int quantity = 0;
                        if(rs.next()) {
                            quantity = rs.getInt(1);
                        }
                        quantity = quantity + 1;
                        c1.s.executeUpdate("update book set quantity = '"+quantity+"' where id = '"+bid+"'");
                        JOptionPane.showMessageDialog(null,"Book Returned Successfully..!!!");
                    
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null,"No Record Found..!!!");
                    }
                    
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
        new returnbook("");
    }
}
