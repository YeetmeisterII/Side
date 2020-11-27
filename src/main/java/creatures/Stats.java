package creatures;

public class Stats {
    protected Integer strength, defence, charisma, hitPoints;
    protected Integer currentStrength, currentDefence, currentCharisma, currentHitPoints;
    protected Integer goldValue, expValue;


    public Stats(Integer strength,
                 Integer defence,
                 Integer charisma, Integer hitPoints,
                 Integer goldValue,
                 Integer expValue) {
        this.strength = this.currentStrength = strength;
        this.defence = this.currentDefence = defence;
        this.charisma = this.currentCharisma = charisma;
        this.hitPoints = this.currentHitPoints = hitPoints;
        this.goldValue = goldValue;
        this.expValue = expValue;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDefence() {
        return defence;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public Integer getCurrentStrength() {
        return currentStrength;
    }

    public Integer getCurrentDefence() {
        return currentDefence;
    }

    public Integer getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void addStrength(Integer value) {
        strength += value;
    }

    public void addDefence(Integer value) {
        defence += value;
    }

    public void addHitPoints(Integer value) {
        hitPoints += value;
    }

    public void addCurrentStrength(Integer value) {
        currentStrength += value;
    }

    public void addCurrentDefence(Integer value) {
        currentDefence += value;
    }

    public void addCurrentHitPoints(Integer value) {
        currentHitPoints += value;
    }

    public void reduceStrength(Integer value) {
        strength += value;
    }

    public void reduceDefence(Integer value) {
        defence += value;
    }

    public void reduceHitPoints(Integer value) {
        hitPoints += value;
    }

    public void reduceCurrentStrength(Integer value) {
        currentStrength += value;
    }

    public void reduceCurrentDefence(Integer value) {
        currentDefence += value;
    }

    public void reduceCurrentHitPoints(Integer value) {
        currentHitPoints += value;
    }
}