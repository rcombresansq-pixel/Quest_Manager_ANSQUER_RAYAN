package com.questmanager.controller;

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



}
