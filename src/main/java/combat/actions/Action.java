package combat.actions;

import creatures.Creature;

public abstract class Action {
    protected final Creature performer, target;

    public Action(Creature performer, Creature target) {
        this.performer = performer;
        this.target = target;
    }

    public Creature getPerformer() {
        return performer;
    }

    public Creature getTarget() {
        return target;
    }
}
