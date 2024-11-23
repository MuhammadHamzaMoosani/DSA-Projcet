package GUI;

import Backend.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    JTextField[] textFields = new JTextField[2];
    JLabel[] labels = new JLabel[2];
    JButton button = new JButton("LOGIN");
    JComboBox comboBox;

    Image icon = new ImageIcon("src/GUI/Emergency.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    public LoginPage(ActionListener actionListener){
        setLayout(null);
        setBackground(Color.white);
        setFocusable(true);

        int x = 200, y= 280;
        String[] location={"Clifton",
                "Saddar",
                "Gulshan-e-Iqbal",
                "Korangi",
                "Defence",
                "PECHS",
                "Nazimabad",
                "Karachi Airport",
                "Gulberg",
                "New Karachi Town",
                "Karsaz"
        };
        comboBox=new JComboBox<>(location);
        labels[0] = new JLabel("Username:");
        labels[0].setBounds(x, y, 100, 30);
        x+=70;

        textFields[0] = new JTextField(10);
        textFields[0].setBounds(x, y, 100, 25);
        textFields[0].setBorder(BorderFactory.createLineBorder(Color.darkGray));
        textFields[0].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

        add(labels[0]);
        add(textFields[0]);
        add(comboBox);
        x-=70; y+=30;

        labels[1] = new JLabel("Location:");
        labels[1].setBounds(x, y, 100, 30);

        x+=70;
        comboBox.setBounds(x, y, 100, 25);
//        textFields[1] = new JTextField(10);
//        textFields[1].setBounds(x, y, 100, 25);
//        textFields[1].setBorder(BorderFactory.createLineBorder(Color.darkGray));
//        textFields[1].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));


        add(labels[1]);
//        add(textFields[1]);

        x -=25; y+=30;
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        button.setFocusable(false);
        button.setBackground(new Color(68, 195, 219));
        button.setBounds(x, y, 80, 30);
        button.addActionListener(actionListener);
        add(button);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(icon, 240, 150, this);
        g.setColor(new Color(65,64,66,255));
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString("ONE CLICK AWAY", 150, 270);

    }
    public boolean actionPerformed(ActionEvent e){
        if(e.getSource()==button)
        {
            button.setBackground(Color.lightGray);
            System.out.println();
            return true;
        }
        return false;
    }
    public String getUserName()
    {
        return textFields[0].getText();
    }

}
