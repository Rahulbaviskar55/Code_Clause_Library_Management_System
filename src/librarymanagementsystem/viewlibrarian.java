package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class viewlibrarian extends JFrame implements ActionListener {
    JTable table;
    JButton btn;
    viewlibrarian() {
        super("Librarians Details ::");
        setSize(900,600);
        setLocation(300,100);
        
        table = new JTable();
        try {
            Connection_Class c1 = new Connection_Class();
            ResultSet rs = c1.s.executeQuery("select * from librarian");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        btn = new JButton("OK");
        btn.setFont(new Font("Elephant",Font.BOLD,20));
        add(btn,"South");
        btn.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new viewlibrarian();
    }
}