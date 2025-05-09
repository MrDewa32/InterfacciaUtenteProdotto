package org.ext.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import org.ext.persona.Utente;

public class CarrelloFrame extends JFrame {
    public CarrelloFrame(Utente utente) {
        setTitle("Carrello di " + utente.getNome());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea carrelloArea = new JTextArea();
        carrelloArea.setEditable(false);

        JButton visualizzaBtn = new JButton("Visualizza Carrello");

        visualizzaBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            if (utente.getCarrello().isEmpty()) {
                sb.append("Il carrello è vuoto.");
            } else {
                for (Map.Entry<String, Integer> entry : utente.getCarrello().entrySet()) {
                    sb.append(entry.getKey())
                      .append(" x")
                      .append(entry.getValue())
                      .append("\n");
                }
            }
            carrelloArea.setText(sb.toString());
        });

        add(visualizzaBtn, BorderLayout.NORTH);
        add(new JScrollPane(carrelloArea), BorderLayout.CENTER);

        setVisible(true);
    }
}
