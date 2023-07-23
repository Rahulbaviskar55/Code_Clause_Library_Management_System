package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class viewbook extends JFrame implements ActionListener {
    JTable table;
    JButton b1;
    Font f1;
    viewbook() { 
        super(":: BOOKS :: ");
        setSize(900,700);
        setLocation(300,100);
        getContentPane().setBackground(Color.BLACK);
        f1 = new Font("Elepthant",Font.BOLD,20);
        
        table = new JTable();
        try {
            Connection_Class c1 = new Connection_Class();
            String query = "select * from book";
            ResultSet rs = c1.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        b1 = new JButton("OK");
        b1.setFont(f1);
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
        new viewbook();
    }
}
