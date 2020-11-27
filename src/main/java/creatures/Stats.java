package creatures;

public class Stats {
    protected Integer strength, defence, charisma, hitPoints;
    protected Integer currentStrength, currentDefence, currentCharisma, currentHitPoints;
    protected Integer goldValue, expValue;


    public Stats(Integer strength, Integer defence, Integer charisma, Integer hitPoints, Integer goldValue,
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

    public Integer getCharisma() {
        return charisma;
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

    public Integer getCurrentCharisma() {
        return currentCharisma;
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

    public void addCharisma(Integer value) {
        charisma += value;
    }

    public void addHitPoints(Integer value) {
        hitPoints += value;
    }

    public void addCurrentStrength(Integer value) {
        if (strength < (currentStrength + value)) {
            currentStrength = strength;
        } else {
            currentStrength += value;
        }
    }

    public void addCurrentDefence(Integer value) {
        if (defence < (currentDefence + value)) {
            currentDefence = defence;
        } else {
            currentDefence += value;
        }
    }

    public void addCurrentCharisma(Integer value) {
        if (charisma < (currentCharisma + value)) {
            currentCharisma = charisma;
        } else {
            currentCharisma += value;
        }
    }

    public void addCurrentHitPoints(Integer value) {
        if (hitPoints < (currentHitPoints + value)) {
            currentHitPoints = hitPoints;
        } else {
            currentHitPoints += value;
        }
    }

    public void subtractStrength(Integer value) {
        strength -= value;
    }

    public void subtractDefence(Integer value) {
        defence -= value;
    }

    public void subtractCharisma(Integer value) {
        charisma -= value;
    }

    public void subtractHitPoints(Integer value) {
        hitPoints -= value;
    }

    public void subtractCurrentStrength(Integer value) {
        currentStrength -= value;
    }

    public void subtractCurrentDefence(Integer value) {
        currentDefence -= value;
    }

    public void subtractCurrentCharisma(Integer value) {
        currentCharisma -= value;
    }

    public void subtractCurrentHitPoints(Integer value) {
        currentHitPoints -= value;
    }
}