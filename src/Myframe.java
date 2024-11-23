import GUI.Board;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Myframe extends JFrame {

        public Myframe() throws FileNotFoundException {

            initUI();
        }

        private void initUI() throws FileNotFoundException {
//            JXMapViewer jxMapViewer = new JXMapViewer();
//            jxMapViewer.setTileFactory(new DefaultTileFactory(new OSMTileFactoryInfo()));
//
//            GeoPosition initialPosition = new GeoPosition(37.7749, -122.4194);
//            jxMapViewer.setAddressLocation(initialPosition);
            add(new Board());
            setVisible(true);
            setResizable(false);
            pack();
            setTitle("Emergency");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public static void main(String[] args) throws FileNotFoundException {
            new Myframe();

        }
    }


