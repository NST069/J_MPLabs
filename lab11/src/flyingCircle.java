import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.DoubleBuffer;

/**
 * Created by Nikola Slavich on 21.11.2016.
 */

//TODO: Remove poop from this code

public class flyingCircle extends JFrame{
    public static Circle circle;
    private JLabel figInfo;
    private JButton About;
    private JButton prop;
    private JToolBar menu;
    private JButton stopButton;
    private Timer timer;

    public flyingCircle(){
        super("THIS CIRCLE IS FLYING!! OMG!!1");
        setMinimumSize(new Dimension(100, 100));
        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(menu);
        figInfo.setHorizontalAlignment(SwingConstants.RIGHT);

        initListeners(this);
    }

    private void initListeners(JFrame f){
        About.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Program was done by NiSlav", "About", JOptionPane.PLAIN_MESSAGE);
            }
        });
        prop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties prop = new Properties(f);
                prop.setVisible(true);
            }
        });
        stopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                    stopButton.setText("Run");
                }
                else{
                    timer.start();
                    stopButton.setText("Stop");
                }
            }
        });
    }

    public static void main(String[] args) {
        flyingCircle app = new flyingCircle();
        app.setVisible(true);
        app.pack();

        circle = new Circle(100, 100, 50, Color.DARK_GRAY);

        JPanel contentPane = new JPanel(){
            Graphics2D g2d;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g2d = (Graphics2D)g;
                g2d.setColor(Color.BLACK);
                g2d.setPaintMode();
                g2d.drawRect(0, 0, getWidth()-1, getHeight()-1);
                g2d.setColor(circle.getColor());
                g2d.fillOval(circle.getX(), circle.getY(), circle.getCSize(), circle.getCSize());
                g2d.setColor(Color.BLACK);
                g2d.drawOval(circle.getX(), circle.getY(), circle.getCSize(), circle.getCSize());

                app.figInfo.setText("["+(circle.getX()+circle.getCSize()/2)+", "+(circle.getY()+circle.getCSize()/2)+"] \nspeed = "+circle.getSpeed());

                }
        };
        contentPane.add(app.menu);
        app.setContentPane(contentPane);

        app.timer = new Timer(18, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(circle);
                circle.move();
                boolean isCollidedX=false, isCollidedY=false;
                if (circle.getX() <= 0) {
                    circle.setX(0);
                    isCollidedX = true;
                }
                if(circle.getX() + circle.getCSize() >= contentPane.getWidth()-1){
                    circle.setX(contentPane.getWidth()-1-circle.getCSize());
                    isCollidedX = true;
                }
                if (circle.getY() <= 0) {
                    circle.setY(0);
                    isCollidedY=true;
                }
                if(circle.getY() + circle.getCSize() >= contentPane.getHeight()-1){
                    circle.setY(contentPane.getHeight()-1-circle.getCSize());
                    isCollidedY = true;
                }
                circle.Collision(isCollidedX, isCollidedY);

                app.repaint();
            }
        });

        app.timer.start();
    }
}
