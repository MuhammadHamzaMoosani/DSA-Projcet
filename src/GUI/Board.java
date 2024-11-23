package GUI;

import Backend.User;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class Board extends JPanel implements ActionListener, MouseInputListener {
    LoginPage loginPage;
    User user;
    Map map;
    private final int DELAY = 5;
    private Timer timer;
    public Board() throws FileNotFoundException {

        initBoard();
    }
    public void initBoard() throws FileNotFoundException {
        setLayout(null);
        addMouseListener( this );
        addMouseMotionListener( this );
        setBackground(Color.white);
        int b_HEIGHT = 600;
        int b_WIDTH = 900;
        setPreferredSize(new Dimension(b_WIDTH, b_HEIGHT));
        setFocusable(true);

        loginPage = new LoginPage(this);
        loginPage.setBounds(150, 0, 600, b_HEIGHT);
        add(loginPage);

        map = new Map(this);
        map.setBounds(0, 0, b_WIDTH, b_HEIGHT);
        map.setVisible(false);
        add(map);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        if(loginPage.isVisible()) {
            if (loginPage.actionPerformed(e)) {
                user=new User(loginPage.textFields[0].getText(),(String) loginPage.comboBox.getSelectedItem());
                map.name = loginPage.textFields[0].getText();
                map.location = (String) loginPage.comboBox.getSelectedItem();
                System.out.println(map.location);
                System.out.println(loginPage.getUserName());
                loginPage.setVisible(false);
                map.setVisible(true);
            }
        }
        else {
            try {
                map.actionPerformed(e,user);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
