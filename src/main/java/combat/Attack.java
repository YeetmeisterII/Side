package combat;

import creatures.Creature;
import weapons.Weapon;

public class Attack extends CombatAction {
    final Weapon weaponUsed;

    public Attack(Creature performer, Creature target, Weapon weaponUsed) {
        super(performer, target);
        this.weaponUsed = weaponUsed;
    }

    public Weapon getWeaponUsed() {
        return weaponUsed;
    }
}
