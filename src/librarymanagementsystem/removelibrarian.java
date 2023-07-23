package librarymanagementsystem;

import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class removelibrarian extends JFrame implements ActionListener {
    JTable table;
    JLabel l1;
    JButton b1,b2;
    JTextField t1;
    
    removelibrarian() {
        super(":: Remove Librarian ::");
        setSize(900,600);
        setLocation(300,100);
        setLayout(null);
        
        table = new JTable();
        try {
            Connection_Class c1 = new Connection_Class();
            ResultSet rs = c1.s.executeQuery("select * from librarian");                     
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,100,900,600);
        add(sp);
        
        l1 = new JLabel("Enter ID To Remove :: ");
        l1.setFont(new Font("Elephant",Font.BOLD,18));
        l1.setForeground(Color.BLACK);
        l1.setBounds(50,50,300,30);
        add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Elephant",Font.BOLD,18));
        t1.setForeground(Color.BLACK);
        t1.setBounds(300,53,200,30);
        add(t1);
        
        b1 = new JButton("Remove");
        b1.setFont(new Font("Elephant",Font.BOLD,18));
        b1.setForeground(Color.BLACK);
        b1.setBounds(520,53,150,30);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Elephant",Font.BOLD,18));
        b2.setBounds(690,53,150,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String id = t1.getText();
            try {
                Connection_Class c1 = new Connection_Class();
                String query = "delete from librarian where id = '"+id+"'";
                int i = c1.s.executeUpdate(query);
                if(i==1) {
                    JOptionPane.showMessageDialog(null, "Librarian Removed Successfully..!!!");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Please Enter Valid Id..!!!");
                    t1.setText("");
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
        new removelibrarian();
    }
}
