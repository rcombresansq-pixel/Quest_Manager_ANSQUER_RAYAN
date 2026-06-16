package com.questmanager.controller;

import com.questmanager.model.Player;
import com.questmanager.repository.PlayerRepository;

public class PlayerController {

    private Player player;
    private PlayerRepository playerRepository;


public PlayerController(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
}

public void loadPlayer(String name) {
    try {
        this.player = playerRepository.load();
    } catch (Exception e) {
        this.player = new Player(name);
    }
}

public void savePlayer() {
    try {
        playerRepository.save(player);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}