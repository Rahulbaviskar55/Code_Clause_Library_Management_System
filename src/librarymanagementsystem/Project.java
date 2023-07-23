package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    JLabel image;
    JMenuBar mb;
    JMenu m1,m2,m3,m4;
    JMenuItem item1,item2,item3,item4;
    
    Project() {
        super(":: ADMIN PAGE :: ");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("librarymanagementsystem/icons/main.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        add(image);
        
        Font f1 = new Font("Elephant",Font.BOLD,20);
        
        mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(50,50));
        setJMenuBar(mb);
        
        m1 = new JMenu("Add Info");
        m1.setFont(f1);
        m1.setForeground(Color.RED);
        m1.add(new JPanel());
        mb.add(m1);
        
        item1 = new JMenuItem("Add Librarian");
        item1.setFont(f1);
        item1.setForeground(Color.BLACK);
        m1.add(item1);
        item1.addActionListener(this);
        
        m2 = new JMenu("View Info");
        m2.setFont(f1);
        m2.setForeground(Color.RED);
        m2.add(new JPanel());
        mb.add(m2);
        
        item2 = new JMenuItem("View Librarians");
        item2.setFont(f1);
        item2.setForeground(Color.BLACK);
        m2.add(item2);
        
        m3 = new JMenu("Delete Info");
        m3.setFont(f1);
        m3.setForeground(Color.RED);
        m3.add(new JPanel());
        mb.add(m3);
        
        item3 = new JMenuItem("Remove Librarian");
        item3.setFont(f1);
        item3.setForeground(Color.BLACK);;
        m3.add(item3);
        
        m4 = new JMenu("Logout");
        m4.setFont(f1);
        m4.setForeground(Color.RED);
        mb.add(Box.createHorizontalGlue());
        mb.add(m4);
        
        item4 = new JMenuItem("Exit");
        item4.setFont(f1);
        item4.setForeground(Color.BLACK);
        m4.add(item4);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == item1) {
            new Librarian1();
        }
        if(ae.getSource() == item2) {
            new viewlibrarian();
        }
        if(ae.getSource() == item3) {
            new removelibrarian();
        }
        if(ae.getSource() == item4) {
            setVisible(false);
            new index();
        }
    }
    public static void main(String[] args) {
        new Project();
    }
}
