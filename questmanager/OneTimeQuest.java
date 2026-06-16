package com.questmanager.model;

public class OneTimeQuest extends Quest{
    
    private boolean isCompleted;

    public OneTimeQuest(String title, String description, int xpReward) {
        super(title, description, xpReward);
        this.isCompleted = false;
    }

    @Override

    public void complete() {
        this.isCompleted = true;
        this.status = QuestStatus.DONE;
    }
}

