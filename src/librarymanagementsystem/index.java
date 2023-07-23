package librarymanagementsystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class index extends JFrame implements ActionListener {

    JLabel headlabel, adminlabel, librarianlabel, imagelbl;
    JButton login1, login2, close;
    Font f1, f2;

    index() {
        super("LOGIN PAGE ==>> ");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("librarymanagementsystem/icons/main.png"));
//        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        imagelbl = new JLabel(i3);
//        imagelbl.setBounds(0,0,700,600);
//        imagelbl.setLayout(new FlowLayout());
//        add(imagelbl);
        headlabel = new JLabel(":: LIBRARY MANAGEMENT SYSTEM ::");
        adminlabel = new JLabel("LOGIN AS ADMIN    :: ");
        librarianlabel = new JLabel("LOGIN AS LIBRARIAN  :: ");

        login1 = new JButton(" LOGIN ");
        login2 = new JButton(" LOGIN ");
        close = new JButton("CLOSE");

        f1 = new Font("Elephant", Font.BOLD, 30);
        f2 = new Font("Elephant", Font.BOLD, 40);

        headlabel.setFont(f2);
        headlabel.setBounds(350, 80, 1000, 100);
        headlabel.setForeground(Color.YELLOW);
        add(headlabel);

        adminlabel.setFont(f1);
        adminlabel.setBounds(405, 255, 500, 100);
        adminlabel.setForeground(Color.WHITE);
        add(adminlabel);

        librarianlabel.setFont(f1);
        librarianlabel.setBounds(340, 390, 500, 100);
        librarianlabel.setForeground(Color.WHITE);
        add(librarianlabel);

        login1.setFont(f1);
        login1.setBounds(820, 290, 310, 40);
        add(login1);

        login2.setFont(f1);
        login2.setBounds(820, 420, 300, 40);
        add(login2);

        close.setFont(f1);
        close.setBounds(590, 600, 300, 34);
        add(close);

        close.addActionListener(this);
        login1.addActionListener(this);
        login2.addActionListener(this);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login1) {
            setVisible(false);
            new Admin();
        }
        if (ae.getSource() == login2) {
            new Librarian();
            setVisible(false);
        }
        if (ae.getSource() == close) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new index();
    }
}
