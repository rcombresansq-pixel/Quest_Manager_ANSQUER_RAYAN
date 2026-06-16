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
        JButton addButton = new JButton("Add quest");
        JButton completeButton = new JButton("Finish quest");

        addButton.addActionListener(e -> addQuest());
        completeButton.addActionListener(e -> completeQuest());

        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        refresh();
    }
    private void addQuest() {
        String title = JOptionPane.showInputDialog("Quest title :");
        String description = JOptionPane.showInputDialog("Description :");
        String xpStr = JOptionPane.showInputDialog("XP award :");
        int xp = Integer.parseInt(xpStr);
        Quest quest = new OneTimeQuest(title, description, xp);
        questController.addQuest(quest);
        refresh();
    }

    private void completeQuest() {
        int index = questList.getSelectedIndex();
        if (index >= 0) {
            Quest quest = questController.getQuests().get(index);
            questController.completeQuest(quest, playerController);
            playerPanel.refresh();
            refresh();
        }
    }

    public void refresh() {
        listModel.clear();
        for (Quest quest : questController.getQuests()) {
            listModel.addElement(quest.getTitle() + " — " + quest.getStatus() + " (+" + quest.getXpReward() + " XP)");
        }
    }
}