package com.questmanager.controller;

import com.questmanager.controller.PlayerController;
import com.questmanager.model.Quest;
import com.questmanager.repository.QuestRepository;
import java.util.List;
import java.util.ArrayList;


public class QuestController {

    private List<Quest> quests;
    private QuestRepository questRepository;


public QuestController(QuestRepository questRepository) {
    this.questRepository = questRepository;
    this.quests = new ArrayList<>();
}

public void loadQuests() {
    try {
        this.quests = questRepository.load();
    } catch (Exception e) {
        this.quests = new ArrayList<>();
    }
}

public void saveQuests() {
    try {
        questRepository.save(quests);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void addQuest(Quest quest) {
    this.quests.add(quest);
    saveQuests();
}
public void completeQuest(Quest quest, PlayerController playerController) {
    quest.complete();
    playerController.addXP(quest.getXpReward());
    saveQuests();
}
public List<Quest> getQuests() {
    return this.quests;
}

}
