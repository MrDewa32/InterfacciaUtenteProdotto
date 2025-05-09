package org.ext.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import org.ext.persona.Utente;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login Utente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // centra la finestra

        // Componenti
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JButton loginBtn = new JButton("Login");

        // Layout
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(loginBtn);
        add(panel);

        // Azione login
        loginBtn.addActionListener((ActionEvent e) -> {
            String email = emailField.getText();
            ArrayList<Utente> utenti = Utente.creaUtentiDefault();

            for (Utente u : utenti) {
                if (u.verificaLogin(email)) {
                    JOptionPane.showMessageDialog(this, "Benvenuto " + u.getNome());
                    dispose(); // chiude questa finestra
                    new CarrelloFrame(u); // apre carrello
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Email non trovata.");
        });

        setVisible(true);
    }
}
