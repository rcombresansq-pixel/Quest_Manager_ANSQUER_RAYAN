package com.querymanager.repository;

import com.google.gson.Gson;

import com.questmanager.model.Player;

public class PlayerRepository {

    private Gson gson;
    private String filePath;

}

public PlayerRepository(String filePath) {
    this.gson = new Gson();
    this.filePath = filePath;
}

