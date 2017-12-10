package ohtu;

import ohtu.komento.Komento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Tapahtumankuuntelija implements ActionListener {
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    private Komentotehdas kt;
    private int val;
    private Stack<Integer> historia;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.kt = new Komentotehdas();
        this.val = 0;
        this.historia = new Stack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        Komento k = kt.hae(((JButton) ae.getSource()).getText());
        this.val = k.suorita(historia, this.val, arvo);

        syotekentta.setText("");
        tuloskentta.setText("" + this.val);
        if (this.val == 0) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);
    }

}
