package com.questmanager.view;

import com.questmanager.controller.PlayerController;
import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private PlayerController playerController;
    private JLabel nameLabel;
    private JLabel levelLabel;
    private JLabel xpLabel;

    public PlayerPanel(PlayerController playerController) {
        this.playerController = playerController;
        setLayout(new FlowLayout());

        nameLabel = new JLabel("Joueur : " + playerController.getPlayer().getName());
        levelLabel = new JLabel("Niveau : " + playerController.getPlayer().getLevel());
        xpLabel = new JLabel("XP : " + playerController.getPlayer().getCurrentXP());

        add(nameLabel);
        add(levelLabel);
        add(xpLabel);
    }

    public void refresh() {
        nameLabel.setText("Joueur : " + playerController.getPlayer().getName());
        levelLabel.setText("Niveau : " + playerController.getPlayer().getLevel());
        xpLabel.setText("XP : " + playerController.getPlayer().getCurrentXP());
        revalidate();
        repaint();
    }
}