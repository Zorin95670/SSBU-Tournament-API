package com.ssbu.utils;

import com.ssbu.model.Battle;

public class TournamentCalculator {

    private static final double LOG2 = Math.log(2);
    private final int number;

    public TournamentCalculator(final int competitors) {
        this.number = competitors;
    }

    public Battle getBattleTree() {
        final Battle root = new Battle();
        final int number = this.getTotalBattle() - 1;
        if (number != 0) {
            root.children[0] = this.get().id;
            root.children[1] = this.get().id;
        }
        return root;
    }

    public Battle get() {
        return null;
    }

    public int getTotalBattle() {
        return this.number - 1;
    }

    public int getBiggestLineOfBattle() {
        return (int) Math.floor((Math.log(this.number) / LOG2));
    }
}
