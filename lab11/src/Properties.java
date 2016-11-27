import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nikola Slavich on 27.11.2016.
 */
public class Properties extends JFrame{
    private JButton cc;
    private JTextField csize;
    private JPanel pnl;
    private JSlider cspeedX;
    private JSlider cspeedY;
    private JButton okay;
    private JPanel example;
    private JPanel bg;

    private int parentFrameHeight;
    private Circle circle;

    public Properties(JFrame f){
        //TODO: force preview image to work correctly
        //setMinimumSize(new Dimension(600, 250));
        setMinimumSize(new Dimension(300, 250));
        setResizable(false);

        circle = new Circle(flyingCircle.circle);

        parentFrameHeight = f.getHeight();
        initListeners(this);

        csize.setText(""+circle.getCSize());
        cspeedX.setValue(circle.getSpeedX());
        cspeedY.setValue(circle.getSpeedY());

//        JPanel contentPane = new JPanel(){
//            Graphics2D g2d;
//
//            @Override
//            public void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g2d = (Graphics2D)g;
//                g2d.setColor(circle.getColor());
//                g2d.fillOval(example.getX()+example.getHeight()/2-circle.getCSize(), example.getY()+example.getWidth()/2-circle.getCSize(), example.getX()+example.getHeight()/2+circle.getCSize(), example.getY()+example.getWidth()/2+circle.getCSize());
//                g2d.setColor(Color.BLACK);
//                g2d.drawOval(example.getHeight()/2-circle.getCSize(), example.getWidth()/2-circle.getCSize(), example.getHeight()/2+circle.getCSize(), example.getWidth()/2+circle.getCSize());
//            }
//        };
//        contentPane.add(bg);
//        repaint();
//        setContentPane(contentPane);
        add(pnl);
    }

    private void initListeners(JFrame f){
        cc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(f, "Color", circle.getColor());
                circle.setColor(color);
                getContentPane().repaint();
            }
        });
        csize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                csize.setText(csize.getText().replaceAll("[^0-9]", ""));
                int size = Integer.parseInt(csize.getText());
                if (size < 1 || size > parentFrameHeight-10) {
                    csize.setText("");
                } else {
                    circle.setCSize(size);
                    getContentPane().repaint();
                }
            }
        });
        cspeedX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                circle.setSpeed('x', cspeedX.getValue());
            }
        });
        cspeedY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                circle.setSpeed('y', cspeedY.getValue());
            }
        });
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flyingCircle.circle = new Circle(circle);
                dispose();
            }
        });
    }
}
