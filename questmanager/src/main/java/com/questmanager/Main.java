package com.questmanager;

import com.questmanager.controller.PlayerController;
import com.questmanager.controller.QuestController;
import com.questmanager.repository.PlayerRepository;
import com.questmanager.repository.QuestRepository;
import com.questmanager.view.MainWindow;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository("player.json");
        QuestRepository questRepository = new QuestRepository("quests.json");

        PlayerController playerController = new PlayerController(playerRepository);
        QuestController questController = new QuestController(questRepository);

        playerController.loadPlayer("Heroes");
        questController.loadQuests();

        new MainWindow(playerController, questController);
    }
}