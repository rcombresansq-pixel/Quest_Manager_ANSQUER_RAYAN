package com.questmanager.view;

import com.questmanager.controller.PlayerController;
import com.questmanager.controller.QuestController;
import com.questmanager.model.Quest;
import com.questmanager.model.OneTimeQuest;
import javax.swing.*;
import java.awt.*;

public class QuestPanel extends JPanel {

    private QuestController questController;
    private PlayerController playerController;
    private PlayerPanel playerPanel;
    private JList<String> questList;
    private DefaultListModel<String> listModel;

    public QuestPanel(QuestController questController, PlayerController playerController, PlayerPanel playerPanel) {
        this.questController = questController;
        this.playerController = playerController;
        this.playerPanel = playerPanel;

        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        questList = new JList<>(listModel);
        add(new JScrollPane(questList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Ajouter une quête");
        JButton completeButton = new JButton("Terminer la quête");

        addButton.addActionListener(e -> addQuest());
        completeButton.addActionListener(e -> completeQuest());

        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        refresh();
    }
}