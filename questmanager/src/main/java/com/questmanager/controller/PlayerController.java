package com.questmanager.controller;

import com.questmanager.model.Player;
import com.questmanager.repository.PlayerRepository;

public class PlayerController {

    private Player player;
    private PlayerRepository playerRepository;


public PlayerController(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
}
}