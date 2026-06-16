package com.questmanager.model;

public class DailyQuest extends Quest {

    private boolean isCompletedToday;

    public DailyQuest(String title, String description, int xpReward) {
        super(title, description, xpReward);
        this.isCompletedToday = false;
    }

    @Override

    public void complete() {
        this.isCompletedToday = true;
        this.status = QuestStatus.DONE;
    }

    public void reset() {
        this.isCompletedToday = false;
        this.status = QuestStatus.TODO;
    }
        }
