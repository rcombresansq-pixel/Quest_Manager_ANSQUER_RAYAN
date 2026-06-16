package com.questmanager.repository;

import com.google.gson.Gson;

import com.questmanager.model.Player;

import java.io.FileWriter;

import java.io.FileReader;


public class PlayerRepository {

    private Gson gson;
    private String filePath;

}

public PlayerRepository(String filePath) {
    this.gson = new Gson();
    this.filePath = filePath;
}

public void save(Player player) throws Exception {
    String json = gson.toJson(player);
    FileWriter writer = new FileWriter(filePath);
    writer.write(json);
    writer.close();
}

public Player load() throws Exception {
    FileReader reader = new FileReader(filePath);
    Player player = gson.fromJson(reader, Player.class);
    reader.close();
    return player;
}
