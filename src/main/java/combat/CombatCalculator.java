package combat;

import combat.Constants.HitTypes;
import combat.actions.*;
import combat.results.AttackResult;
import combat.results.BlockResult;
import creatures.Creature;
import weapons.Weapon;

import java.util.concurrent.ThreadLocalRandom;

import static combat.Constants.CRITICAL_MODIFIER;

public class CombatCalculator {
    private Integer rollD20() {
        return ThreadLocalRandom.current().nextInt(1, 21);
    }

    private AttackResult simulateAttack(Attack attack, Action opponentAction) {
        int d20, attackScore, weaponDamage;
        boolean defenceLessThanAttackScore, defenceDoubledLessThanAttackScore, isBlocking;
        Creature attacker, defender;
        Weapon weaponUsed;
        HitTypes hitType;

        d20 = rollD20();
        attacker = attack.getPerformer();
        defender = attack.getTarget();
        weaponUsed = attack.getWeaponUsed();
        isBlocking = (opponentAction.getClass() == Block.class);


        attackScore = d20 + attacker.getStats().getCurrentStrength();
        defenceLessThanAttackScore = (defender.getStats().getCurrentDefence() < attackScore);
        defenceDoubledLessThanAttackScore = (defender.getStats().getCurrentDefence() * 2 < attackScore);

        // Order of execution in this branch is very important.
        // In 'if (a)' branch, !b must be true and is therefore not evaluated.
        if (d20 == 20) {
            hitType = Constants.HitTypes.CRITICAL_HIT;
        } else if (d20 == 1) {
            hitType = HitTypes.CRITICAL_MISS;
        } else if (defenceDoubledLessThanAttackScore || (!isBlocking && defenceLessThanAttackScore)) {
            hitType = HitTypes.HIT;
        } else if (defenceLessThanAttackScore) {
            hitType = HitTypes.BLOCKED;
        } else {
            hitType = HitTypes.MISS;
        }

        if (hitType == HitTypes.CRITICAL_HIT) {
            weaponDamage = (int) (weaponUsed.attack() * CRITICAL_MODIFIER);
        } else {
            weaponDamage = weaponUsed.attack();
        }
        return new AttackResult(attacker, defender, hitType, weaponDamage);
    }

    private <T extends Action> AttackResult simulateCombatRound(Attack performedAction, T opponentAction) {
        return simulateAttack(performedAction, opponentAction);
    }

    private BlockResult simulateCombatRound(Block performedAction, Block opponentAction) {
        return new BlockResult(performedAction.getPerformer());
    }
}
