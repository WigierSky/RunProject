import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static java.awt.MouseInfo.getPointerInfo;


public class Frame extends JFrame implements KeyListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }



    public Frame() {
        super("FRAME");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        Random random = new Random();

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 800);
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);

        panel.addKeyListener(this);

        JButton button = new JButton("X");
        button.setBounds(100, 0, 80, 80);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setLocation(random.nextInt(900), random.nextInt(700));
            }
        });
        panel.add(button);



        JButton reset = new JButton("Reset");
        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                button.setLocation(100, 0);
            }
        });
        reset.setBounds(0, 0, 100, 80);
        panel.add(reset);

        panel.setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        reset.setFocusable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar())
        {
            case 'o':
                Point point = MouseInfo.getPointerInfo().getLocation();
                int x = (int) point.getX();
                int y = (int) point.getY();
                getGraphics().fillOval( x-270,  y-100, 100, 100);
                break;
            case 's':
                Point pointx = MouseInfo.getPointerInfo().getLocation();
                int c = (int) pointx.getX();
                int z = (int) pointx.getY();
                getGraphics().fillRect(c-270 , z-100,100,100);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
