package weapons;

import creatures.Creature;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Weapon {
    protected final WeaponStats stats;
    protected Creature user;

    public Weapon(WeaponStats stats) {
        this.stats = stats;
    }

    public WeaponStats getStats() {
        return stats;
    }

    public Creature getUser() {
        return user;
    }

    public void setUser(Creature user) {
        this.user = user;
    }

    public void removeUser() {
        user = null;
    }

    public Integer attack() {
        int sumOfDiceRolls = 0;
        ArrayList<Integer> diceRolls = new ArrayList<>(stats.getDiceQuantity());

        for (int i = 0; i < stats.getDiceQuantity(); i++) {
            diceRolls.add(ThreadLocalRandom.current().nextInt(1, stats.getDiceValue() + 1));
        }

        for (Integer roll : diceRolls) {
            sumOfDiceRolls += roll;
        }
        return sumOfDiceRolls + stats.getConstantDamage();
    }
}
