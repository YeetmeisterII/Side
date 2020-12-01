package combat;

import creatures.Creature;

public abstract class CombatAction {
    final Creature performer, target;

    public CombatAction(Creature performer, Creature target) {
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
