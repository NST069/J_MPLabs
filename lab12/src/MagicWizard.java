
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Nikola Slavich on 11.12.2016.
 */
public class MagicWizard extends JFrame {

    private String ob_type;
    private String ob_name;
    private int ob_X;
    private int ob_Y;
    private int ob_width;
    private int ob_height;
    private int ob_tf_type;
    private int ob_cols;
    private int ob_rows;

    private JButton OKButton;
    private JPanel pnl;
    private JComboBox comboBox1;
    private JPanel content;

    private JPanel jp_prop;

    private JLabel jl_name;
    private JTextField jt_name;
    private JLabel jl_X;
    private JTextField jt_X;
    private JLabel jl_Y;
    private JTextField jt_Y;
    private JLabel jl_width;
    private JTextField jt_width;
    private JLabel jl_height;
    private JTextField jt_height;
    private JLabel jl_tf_type;
    private JComboBox jc_tf_type;
    private JLabel jl_cols;
    private JTextField jt_cols;
    private JLabel jl_rows;
    private JTextField jt_rows;

    private Random randomizer;

    public MagicWizard(JFrame f){
        setMinimumSize(new Dimension(400, 300));
        setResizable(false);

        pnl.setLayout(new BorderLayout());

        initComps();
        content.setLayout(new BorderLayout());
        pnl.add(comboBox1, BorderLayout.NORTH);

        jp_prop = new JPanel(new GridLayout(8, 2));
        jp_prop.add(this.jl_name);
        jp_prop.add(this.jt_name);
        jp_prop.add(this.jl_X);
        jp_prop.add(this.jt_X);
        jp_prop.add(this.jl_Y);
        jp_prop.add(this.jt_Y);
        jp_prop.add(this.jl_height);
        jp_prop.add(this.jt_height);
        jp_prop.add(this.jl_width);
        jp_prop.add(this.jt_width);

        jp_prop.add(jl_tf_type);
        jp_prop.add(jc_tf_type);

        jp_prop.add(jl_cols);
        jp_prop.add(jt_cols);
        jp_prop.add(jl_rows);
        jp_prop.add(jt_rows);

        content.add(jp_prop, BorderLayout.CENTER);

        jl_tf_type.setVisible(false);
        jc_tf_type.setVisible(false);

        jl_cols.setVisible(false);
        jt_cols.setVisible(false);
        jl_rows.setVisible(false);
        jt_rows.setVisible(false);

        pnl.add(content, BorderLayout.CENTER);

        pnl.add(OKButton, BorderLayout.SOUTH);
        add(pnl);
        initListeners(this);
    }

    private void initComps() {
        this.jl_name = new JLabel("Name :");
        this.jl_X = new JLabel("X :");
        this.jl_Y = new JLabel("Y :");
        this.jl_height = new JLabel("Height :");
        this.jl_width = new JLabel("Width :");
        this.jl_tf_type = new JLabel("Type :");
        this.jl_cols = new JLabel("Cols :");
        this.jl_rows = new JLabel("Rows :");

        this.jt_name = new JTextField(50);
        this.jt_X = new JTextField(50);
        this.jt_Y = new JTextField(50);
        this.jt_height = new JTextField(50);
        this.jt_width = new JTextField(50);
        this.jc_tf_type = new JComboBox();
        this.jt_cols = new JTextField(50);
        this.jt_rows = new JTextField(50);

        this.jc_tf_type.addItem("Plain");
        this.jc_tf_type.addItem("Password");
        this.jc_tf_type.addItem("Formatted");

        this.comboBox1.addItem("JButton");
        this.comboBox1.addItem("JRadioButton");
        this.comboBox1.addItem("JCheckbox");
        this.comboBox1.addItem("JLabel");
        this.comboBox1.addItem("JTextField");
        this.comboBox1.addItem("JTextArea");
        this.comboBox1.addItem("JTable");

        this.randomizer = new Random();
    }


    private void initListeners(JFrame f) {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(comboBox1.getSelectedIndex());

                if(comboBox1.getSelectedIndex()==4){
                    jl_tf_type.setVisible(true);
                    jc_tf_type.setVisible(true);

                    jl_cols.setVisible(false);
                    jt_cols.setVisible(false);
                    jl_rows.setVisible(false);
                    jt_rows.setVisible(false);
                }
                else if(comboBox1.getSelectedIndex()==6){
                    jl_tf_type.setVisible(false);
                    jc_tf_type.setVisible(false);

                    jl_cols.setVisible(true);
                    jt_cols.setVisible(true);
                    jl_rows.setVisible(true);
                    jt_rows.setVisible(true);
                }
                else{
                    jl_tf_type.setVisible(false);
                    jc_tf_type.setVisible(false);

                    jl_cols.setVisible(false);
                    jt_cols.setVisible(false);
                    jl_rows.setVisible(false);
                    jt_rows.setVisible(false);
                }

            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!(jt_X.getText().replaceAll("[^0-9]", "")).equals(""))
                    ob_X = Integer.parseInt(jt_X.getText().replaceAll("[^0-9]", ""));
                else ob_X=randomizer.nextInt(f.getHeight()-10);
                if(!(jt_X.getText().replaceAll("[^0-9]", "")).equals(""))
                    ob_Y = Integer.parseInt(jt_Y.getText().replaceAll("[^0-9]", ""));
                else ob_Y=randomizer.nextInt(f.getWidth()-10);
                if(!(jt_X.getText().replaceAll("[^0-9]", "")).equals(""))
                    ob_height = Integer.parseInt(jt_height.getText().replaceAll("[^0-9]", ""));
                else ob_height=randomizer.nextInt(50)+20;
                if(!(jt_X.getText().replaceAll("[^0-9]", "")).equals(""))
                    ob_width = Integer.parseInt(jt_width.getText().replaceAll("[^0-9]", ""));
                else ob_width=randomizer.nextInt(50)+20;
                ob_name = (jt_name.getText().equals("")) ? "Sample Text" : jt_name.getText();

                ob_type = comboBox1.getSelectedItem().toString();
                System.out.println(ob_type);

                switch(ob_type){
                    case "JButton": {
                        JButton ob = new JButton(ob_name);
                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                    case "JRadioButton":{
                        JRadioButton ob = new JRadioButton(ob_name);
                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                    case "JCheckbox":{
                        JCheckBox ob = new JCheckBox(ob_name);
                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                    case "JLabel":{
                        JLabel ob = new JLabel(ob_name);
                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                    case "JTextField":{
                        ob_tf_type = jc_tf_type.getSelectedIndex();

                        JTextField ob;
                        if(ob_tf_type==1)ob = new JPasswordField(ob_name);
                        else if(ob_tf_type==2) ob = new JFormattedTextField(ob_name);
                        else ob = new JTextField(ob_name);

                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                    case "JTextArea":{
                        JTextArea ob = new JTextArea(ob_name);
                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                    case "JTable":{
                        if(!(jt_cols.getText().replaceAll("[^0-9]", "")).equals(""))
                            ob_cols = Integer.parseInt(jt_cols.getText().replaceAll("[^0-9]", ""));
                        else ob_cols=randomizer.nextInt(9)+1;
                        if(!(jt_rows.getText().replaceAll("[^0-9]", "")).equals(""))
                            ob_rows = Integer.parseInt(jt_rows.getText().replaceAll("[^0-9]", ""));
                        else ob_rows=randomizer.nextInt(9)+1;

                        JTable ob = new JTable(ob_rows, ob_cols);
                        ob.setName(ob_name);
                        ob.setBounds(ob_X, ob_Y, ob_width, ob_height);
                        MainWindow.jp.add(ob);
                        MainWindow.jp.repaint();
                        break;
                    }
                }


                dispose();
            }
        });
    }
}
