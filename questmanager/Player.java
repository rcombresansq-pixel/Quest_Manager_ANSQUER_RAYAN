package com.questmanager.model;

public class Player {

    private String name;
    private int level;
    private int currentXP;
    private int totalXP;
    private String title;

}

public Player(String name) {
    this.name = name;
    this.level = 1;
    this.currentXP = 0;
    this.totalXP = 0;
    this.title = "Novice";
}

public void addXP(int xp) {
    this.currentXP += xp;
    this.totalXP += xp;
    while (this.currentXP >= this.level * 100) {
        this.level++;
        this.currentXP -= (this.level - 1) * 100;
    }
}

public String getName() { return this.name; }
public int getLevel() { return this.level; }
public int getCurrentXP() { return this.currentXP; }
public int getTotalXP() { return this.totalXP; }
public String getTitle() { return this.title; }