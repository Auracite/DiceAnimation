package eeu8ed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Dice Simulator
 *
 * @author KazukoAura
 * @since 31/10/2017
 */


public class DiceSimulator extends JPanel {

    private int die1 = 4;  // The values shown on the dice.
    private int die2 = 3;

    private Timer timer;   // Used to animate rolling of the dice.

    public DiceSimulator() {

        setLayout(new BorderLayout(2, 2));
        setBackground(Color.BLUE);  // Will show through the gap in the BorderLayout.
        setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        JPanel dicePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);  // fill with background color.
                drawDie(g, die1, 100, 50); // Just draw the dice.
                drawDie(g, die2, 350, 50);
            }
        };
        dicePanel.setPreferredSize(new Dimension(100, 100));
        dicePanel.setBackground(new Color(200, 200, 255));  // light blue
        add(dicePanel, BorderLayout.CENTER);

        /*---------------------------------------------------------------------------*/
        JButton rollButton = new JButton("Throw Dice");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                roll();
            }
        });
        add(rollButton, BorderLayout.SOUTH);
    }

    void drawDie(Graphics g, int val, int x, int y) {
        g.setColor(Color.white);
        g.fillRect(x, y, 120, 120);
        g.setColor(Color.black);
        g.drawRect(x, y, 120, 120);
        if (val > 1) // upper left dot
        {
            g.fillOval(x + 25, y + 20, 20, 20);
        }
        if (val > 3) // upper right dot
        {
            g.fillOval(x + 80, y + 20, 20, 20);
        }
        if (val == 6) // middle left dot
        {
            g.fillOval(x + 25, y + 50, 20, 20);
        }
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
        {
            g.fillOval(x + 50, y + 50, 20, 20);
        }
        if (val == 6) // middle right dot
        {
            g.fillOval(x + 80, y + 50, 20, 20);
        }
        if (val > 3) // bottom left dot
        {
            g.fillOval(x + 25, y + 80, 20, 20);
        }
        if (val > 1) // bottom right dot
        {
            g.fillOval(x + 80, y + 80, 20, 20);
        }
    }

    /**
     * Run an animation that randomly changes the values shown on the dice 10
     * times, every 100 milliseconds.
     */
    private void roll() {
        if (timer != null) {
            return;
        }
        timer = new Timer(100, new ActionListener() {
            int frames = 1;

            public void actionPerformed(ActionEvent evt) {
                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                repaint();
                frames++;
                if (frames == 15) {
                    timer.stop();
                    timer = null;
                }
            }
        });
        timer.start();
    }

}
