package com.questmanager.view;

import com.questmanager.controller.PlayerController;
import com.questmanager.controller.QuestController;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private PlayerController playerController;
    private QuestController questController;
    private PlayerPanel playerPanel;
    private QuestPanel questPanel;

    public MainWindow(PlayerController playerController, QuestController questController) {
        this.playerController = playerController;
        this.questController = questController;

        setTitle("QuestManager ⚔️");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        playerPanel = new PlayerPanel(playerController);
        questPanel = new QuestPanel(questController, playerController, playerPanel);

        add(playerPanel, BorderLayout.NORTH);
        add(questPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
