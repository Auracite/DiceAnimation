package eeu8ed;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Dice Frame Viewer
 *
 * @author KazukoAura
 * @since 31/10/2017
 */
public class DiceFrame {

    public static JFrame frame = new JFrame();

    public static void main(String[] args) {

        DiceSimulator content = new DiceSimulator();
        frame.setContentPane(content);
        frame.pack();
        frame.setLocation(500, 100);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        //window.setResizable(false);  // User can't change the window's size.

    }

}
