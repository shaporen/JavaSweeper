package org.shaporen.sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    public Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixMaxBombs();
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    private void fixMaxBombs() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
    }

    private void placeBomb() {
        while(true){
            Coord coord = Ranges.getRandomCoord();
            if (Box.BOMB == bombMap.get(coord)) {
                continue;
            }
            bombMap.set(coord, Box.BOMB);
            incNumbersAroundBomb(coord);
            break;
        }
    }

    private void incNumbersAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordsAround(coord)) {
            if (bombMap.get(around) != Box.BOMB) {
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
            }
        }
    }

    int getTotalBombs() {
        return totalBombs;
    }
}
