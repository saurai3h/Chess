package game;

import game.TwoPlayerGame.Color;

public class Player {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color;

    public Player(String name, Color color)  {
        setName(name);
        setColor(color);
    }
}
