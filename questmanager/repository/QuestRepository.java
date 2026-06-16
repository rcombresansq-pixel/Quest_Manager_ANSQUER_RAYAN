package com.querymanager.repository;

import com.google.gson.Gson;

import com.questmanager.model.Player;

import java.io.FileWriter;

import java.io.FileReader;

import com.questmanager.model.Quest;

import java.util.List;


public class QuestRepository {
    public class PlayerRepository {

    private Gson gson;
    private String filePath;

}

public QuestRepository(String filePath) {
    this.gson = new Gson();
    this.filePath = filePath;
}

public void save(Quest quest) throws Exception {
    String json = gson.toJson(quest);
    FileWriter writer = new FileWriter(filePath);
    writer.write(json);
    writer.close();
}




}
