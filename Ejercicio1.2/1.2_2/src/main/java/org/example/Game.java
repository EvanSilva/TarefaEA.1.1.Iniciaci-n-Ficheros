package org.example;

import java.io.Serializable;

public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    String name = "";
    String description = "";
    String languages = "";

    public Game(String name, String description, String languages) {
        this.name = name;
        this.description = description;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", languages='" + languages + '\'' +
                '}';
    }
}
