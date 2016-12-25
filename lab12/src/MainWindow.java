import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Nikola Slavich on 11.12.2016.
 */
public class MainWindow extends JFrame{

    private JButton aboutButton;
    private JButton addButton;
    private JToolBar toolbar;

    private MagicWizard mw;

    public static JPanel jp;

    public MainWindow(){
        super("A MAGIC WIZARD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        setLayout(new BorderLayout());

        jp = new JPanel();
        jp.setLayout(null);
        //jp.setBackground(Color.BLACK);



        add(toolbar, BorderLayout.NORTH);
        add(jp);

        initListeners(this);
    }

    private void initListeners(JFrame f) {
        aboutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Program was done by NiSlav", "About", JOptionPane.PLAIN_MESSAGE);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mw = new MagicWizard(f);
                mw.setVisible(true);
            }
        });
    }

    public static void main(String args[]){
        MainWindow app = new MainWindow();
        app.setVisible(true);
        app.pack();

    }
}
