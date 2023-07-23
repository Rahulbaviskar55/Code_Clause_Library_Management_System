package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class issuedbooks extends JFrame implements ActionListener {
    JTable table;
    JButton b1;
    issuedbooks() {
        super(":: ISSUED BOOKS ::");
        setSize(950,700);
        setLocation(280,100);
        getContentPane().setBackground(Color.WHITE);
        
        table = new JTable();
        try {
            Connection_Class c1 = new Connection_Class();
            ResultSet rs = c1.s.executeQuery("select * from issuedbooks");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        b1 = new JButton("OK");
        b1.setFont(new Font("Elephant",Font.BOLD,18));
        add(b1,"South");
        b1.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new issuedbooks();
    }
}
