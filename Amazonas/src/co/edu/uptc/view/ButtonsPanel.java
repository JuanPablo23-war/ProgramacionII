package co.edu.uptc.view;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
    private ButtonWithIcon calendar, complaints, procedures, contracting, reporting, challenges;
    private ButtonWithIcon offer, pdd, pqrsd, help, feda;


    public ButtonsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponets();
    }

    public void initComponets() {
        createGreenButtons();
        createBlueButtons();
        greenPanel();
        bluePanel();
    }

    
    public void createGreenButtons() {
        Color background = Color.decode("#468214");
        calendar = new ButtonWithIcon("Calendario", "data/icons/calendar.png", background);
        complaints = new ButtonWithIcon("<html><center>Peticiones y quejas</center></html>", "data/icons/text.png", background);
        procedures = new ButtonWithIcon("<html><p>Trámites y <br/>servicios</p></html>", "data/icons/check-mark.png", background);
        contracting = new ButtonWithIcon("Contrataciones", "data/icons/compliant.png", background);
        reporting = new ButtonWithIcon("<html><p>Rendición de <br/>cuentas</p></html>", "data/icons/trending.png", background);
        challenges = new ButtonWithIcon("<html><center>Retos de<br/>participación</center></html>", "data/icons/question.png", background);
    }

    public void createBlueButtons() {
        Color backColor = Color.decode("#004884");
        offer = new ButtonWithIcon("<html><center>Oferta y oportunidades</center></html>", "data/icons/question.png", backColor);
        pdd = new ButtonWithIcon("<html><center>P.D.D 2024 - 2027</center></html>", "data/icons/project-management.png", backColor);
        pqrsd = new ButtonWithIcon("<html><center>informe de PQRSD</center></html>", "data/icons/football-trophy.png", backColor);
        help = new ButtonWithIcon("Mesa de ayuda", "data/icons/box.png", backColor);
        feda = new ButtonWithIcon("<html><p>FEDA</p></html>", "data/icons/box.png", backColor);
    }

    public void greenPanel() {
        JPanel greenPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        greenPanel.add(calendar);
        greenPanel.add(complaints);
        greenPanel.add(procedures);
        greenPanel.add(contracting);
        greenPanel.add(reporting);
        greenPanel.add(challenges);
        add(greenPanel);
    }

    public void bluePanel(){
        JPanel bluePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 42, 40));
        bluePanel.add(offer);
        bluePanel.add(pdd);
        bluePanel.add(pqrsd);
        bluePanel.add(help);
        bluePanel.add(feda);
        add(bluePanel);
    }
}
