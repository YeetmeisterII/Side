package combat.results;

import creatures.Creature;

public abstract class Result {
    protected final Creature performingCreature;


    public Result(Creature performingCreature) {
        this.performingCreature = performingCreature;
    }

    public Creature getPerformingCreature() {
        return performingCreature;
    }
}