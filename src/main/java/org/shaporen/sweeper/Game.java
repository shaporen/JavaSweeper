package org.shaporen.sweeper;

public class Game {
    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
    }

    public Box getBox(Coord coord) {
        return Box.values()[(coord.x + coord.y) % Box.values().length];
    }
}
