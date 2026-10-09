package co.edu.uptc.view;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
    private JLabel tittle, name, adress, paid, city, state;
    private JTextField txtName, txtAdress, txtCity, txtState;
    private JComboBox<String> cbPaid;
    private JPanel buttons;

    public MainPanel (){
        initComponents();
    }

    public void initComponents(){
        createComboBox();
        createComponentsLabel();
        createComponentsTextField();
        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        setLayout(gbl);
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets=new Insets(0,0,10,0);
        add(tittle, gbc);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0,0,0,0);
        add(name, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtName, gbc);
        gbc.gridwidth = 1;
        add(adress, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtAdress, gbc);
        gbc.gridwidth = 1;
        add(city, gbc);
        add(txtCity, gbc);
        add(state, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtState, gbc);
        gbc.gridwidth = 1;
        gbc.insets=new Insets(5,0,5,0);
        add(paid, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill=GridBagConstraints.NONE;
        add(cbPaid, gbc);
        buttonPanel();
        gbc.anchor=GridBagConstraints.SOUTH;
        gbc.insets=new Insets(15,0,0,0);
        add(buttons, gbc);
    }

    public void createComponentsLabel(){
        tittle = new JLabel("Pague ahora");
        name   = new JLabel("Nombre:");
        adress = new JLabel("Dirección: ");
        paid = new JLabel("Metodo de pago");
        city = new JLabel("Ciudad");
        state = new JLabel("Departamento");
    }

    public void createComponentsTextField(){
        txtName = new JTextField(20);
        txtAdress  = new JTextField();
        txtCity = new JTextField(6);
        txtState = new JTextField();
    }

    public void createComboBox(){
        cbPaid = new JComboBox<>();
        cbPaid.addItem("Visa");
        cbPaid.addItem("MasterCard");
        cbPaid.addItem("AmericanExpress");
    }

    public void buttonPanel(){
        buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        JButton btnPaid = new JButton("Pagar");
        JButton btnCancel = new JButton("Cancelar");
        buttons.add(btnPaid);
        buttons.add(btnCancel); 
    }

}
