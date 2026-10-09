package co.edu.uptc.view;

public class CheckBox extends JFrame {
    public CheckBox() {
        setTitle("CheckBox Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        JCheckBox checkBox3 = new JCheckBox("Option 3");
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        setVisible(true);
    }
}
