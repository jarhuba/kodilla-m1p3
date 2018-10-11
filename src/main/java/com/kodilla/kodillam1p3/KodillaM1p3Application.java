package com.kodilla.kodillam1p3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodillaM1p3Application {

    public static void main(String[] args) {
        SpringApplication.run(KodillaM1p3Application.class, args);

        Knight you = new Knight(new DeadIslandQuest());
        System.out.println(you.title);
        you.processQuest();
        System.out.println(you.sucess);
        you = new Knight(new EliteKnightQuest());
        System.out.println(you.title);
        you.processQuest();
        System.out.println(you.sucess);

    }
}

interface Quest {
    void process();

    String title();

    default String success() {
        return "Zwycięstwo!";
    }
}

class DeadIslandQuest implements Quest {

    public void process() {
        System.out.println("Jesteś na małpiej wyspie i walczysz o banany z małpami.");
    }

    public String title() {
        return "Dead Island Quest:";
    }

    public String success() {
        return "Zwycięstwo, banany są twoje!";
    }
}

class EliteKnightQuest implements Quest {

    public void process() {
        System.out.println("Bronisz bananów na małpiej wyspie przed rycerzami.");
    }

    public String title() {
        return "Elite Knight Quest:";
    }
}

class Knight {
    Quest quest;
    String title;
    String sucess;

    Knight(Quest quest) {
        this.quest = quest;
        this.title = quest.title();
        this.sucess = quest.success();
    }

    void processQuest() {
        this.quest.process();
    }
}

