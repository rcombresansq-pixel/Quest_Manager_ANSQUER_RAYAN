package com.questmanager.repository;

import com.google.gson.Gson;
import com.questmanager.model.Quest;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;

public class QuestRepository {

    private Gson gson;
    private String filePath;

    public QuestRepository(String filePath) {
        this.gson = new Gson();
        this.filePath = filePath;
    }

    public void save(List<Quest> quests) throws Exception {
        String json = gson.toJson(quests);
        FileWriter writer = new FileWriter(filePath);
        writer.write(json);
        writer.close();
    }

    public List<Quest> load() throws Exception {
        FileReader reader = new FileReader(filePath);
        List<Quest> quests = gson.fromJson(reader, List.class);
        reader.close();
        return quests;
    }
}