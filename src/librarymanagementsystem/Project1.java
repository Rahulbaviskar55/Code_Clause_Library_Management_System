package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class Project1 extends JFrame implements ActionListener {
    
    JLabel imglbl;
    JMenuBar mb;
    JMenu m1,m2,m3,m4,m5;
    JMenuItem item1,item2,item3,item4,item5,item6,item7;
    Font f1;
    String sid;
    
    Project1(String id) {
        super("LIBRARIAN PAGE :: ");
        sid = id;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("librarymanagementsystem/icons/main.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        imglbl = new JLabel(i3);
        add(imglbl);
        f1 = new Font("Elephant",Font.BOLD,20);
        
        mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(50,50));
        setJMenuBar(mb);
        
        m1 = new JMenu("Add Info");
        m1.setFont(f1);
        m1.setForeground(Color.RED);
        mb.add(m1);
        
        item1 = new JMenuItem("Add Book");
        item1.setFont(f1);
        item1.setForeground(Color.BLACK);
        m1.add(item1);
        
        
        m2 = new JMenu("View Info");
        m2.setFont(f1);
        m2.setForeground(Color.RED);
        mb.add(m2);
        
        item2 = new JMenuItem("View Books");
        item2.setFont(f1);
        item2.setForeground(Color.BLACK);
        m2.add(item2);
        
        item3 = new JMenuItem("View Issued Books");
        item3.setFont(f1);
        item3.setForeground(Color.BLACK);
        m2.add(item3);
        
        m3 = new JMenu("Issue Book");
        m3.setFont(f1);
        m3.setForeground(Color.RED);
        mb.add(m3);
        
        item4 = new JMenuItem("Issue A Book");
        item4.setFont(f1);
        item4.setForeground(Color.BLACK);
        m3.add(item4);
        
        m4 = new JMenu("Return");
        m4.setFont(f1);
        m4.setForeground(Color.RED);
        mb.add(m4);
        
        item5 = new JMenuItem("Return A Book");
        item5.setFont(f1);
        item5.setForeground(Color.BLACK);
        m4.add(item5);
        
        item7 = new JMenuItem("Return History");
        item7.setFont(f1);
        item7.setForeground(Color.BLACK);
        m4.add(item7);
        
        m5 = new JMenu("Logout");
        m5.setFont(f1);
        m5.setForeground(Color.red);
        mb.add(Box.createHorizontalGlue());
        mb.add(m5);
        
        item6 = new JMenuItem("Exit");
        item6.setFont(f1);
        item6.setForeground(Color.BLACK);
        m5.add(item6);
        
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);
        item7.addActionListener(this);
 
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == item1) {
            new addbook();
        }
        if(ae.getSource() == item2) {
            new viewbook();
        }
        if(ae.getSource() == item3) {
            new issuedbooks();
        }
        if(ae.getSource() == item4) {
            new issuebook(sid);
        }
        if(ae.getSource() == item5) {
            new returnbook(sid);
        }
        if(ae.getSource() == item6) {
            setVisible(false);
            new Librarian();
        }
        if(ae.getSource() == item7) {
            new returninfo();
        }
    }
    public static void main(String[] args) {
        new Project1("");
    }
}
