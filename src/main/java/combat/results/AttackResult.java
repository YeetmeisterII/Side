package combat.results;

import combat.Constants.HitTypes;
import creatures.Creature;

public class AttackResult extends Result {
    private final Creature targetCreature;
    private final HitTypes hitType;
    private final Integer damage;
    private final String textResult;

    public AttackResult(Creature performingCreature, Creature targetCreature, HitTypes hitType, int damage) {
        super(performingCreature);
        this.targetCreature = targetCreature;
        this.hitType = hitType;
        this.damage = damage;
        textResult = produceTextResult();
    }


    public Creature getTargetCreature() {
        return targetCreature;
    }

    public HitTypes getHitType() {
        return hitType;
    }

    public Integer getDamage() {
        return damage;
    }

    public String getTextResult() {
        return textResult;
    }

    private String produceTextResult() {
        String performingCreatureName = String.valueOf(performingCreature);
        String targetCreatureName = String.valueOf(targetCreature);
        String lineOne = performingCreatureName + " attacks " + targetCreatureName + ".";
        String lineTwo = switch (hitType) {
            case CRITICAL_HIT -> String.format("%s critically hits %s for %d.",
                    performingCreatureName, targetCreatureName, damage);
            case HIT -> String.format("%s lands a hit on %s for %d.",
                    performingCreatureName, targetCreatureName, damage);
            case BLOCKED -> String.format("%s makes contact with %s but is blocked.",
                    performingCreatureName, targetCreatureName);
            case MISS -> String.format(
                    "%s misses their attack on %s.",
                    performingCreatureName, targetCreatureName);
            case CRITICAL_MISS -> String.format("%s critically misses %s, making a fool out of themselves in the " +
                    "process", performingCreatureName, targetCreatureName);
        };
        return lineOne + "\n" + lineTwo + "\n";
    }
}