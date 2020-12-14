package combat;

import combat.Constants.HitTypes;
import combat.actions.Attack;
import combat.actions.Block;
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

    private AttackResult simulateAttack(Attack attack, boolean isBlocking) {
        int d20, attackScore, weaponDamage;
        boolean defenceLessThanAttackScore, defenceDoubledLessThanAttackScore;
        Creature attacker, defender;
        Weapon weaponUsed;
        HitTypes hitType;

        d20 = rollD20();
        attacker = attack.getPerformer();
        defender = attack.getTarget();
        weaponUsed = attack.getWeaponUsed();


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

    private ResultsContainer simulateCombatRound(Attack playerAttack, Attack enemyAttack) {
        AttackResult playerResult, enemyResult;

        playerResult = simulateAttack(playerAttack, false);
        enemyResult = simulateAttack(enemyAttack, false);
        Executor.run(playerResult, enemyResult);
        return new ResultsContainer(playerResult, enemyResult);
    }

    private ResultsContainer simulateCombatRound(Attack playerAttack, Block enemyBlock) {
        AttackResult playerResult;
        BlockResult enemyResult;

        playerResult = simulateAttack(playerAttack, true);
        enemyResult = new BlockResult(enemyBlock.getPerformer());
        Executor.run(playerResult, enemyResult);
        return new ResultsContainer(playerResult, enemyResult);
    }

    private ResultsContainer simulateCombatRound(Block playerBlock, Attack enemyAttack) {
        AttackResult enemyResult;
        BlockResult playerResult;

        playerResult = new BlockResult(playerBlock.getPerformer());
        enemyResult = simulateAttack(enemyAttack, true);
        Executor.run(playerResult, enemyResult);
        return new ResultsContainer(playerResult, enemyResult);
    }

    private ResultsContainer simulateCombatRound(Block playerBlock, Block enemyBlock) {
        BlockResult playerResult, enemyResult;

        playerResult = new BlockResult(playerBlock.getPerformer());
        enemyResult = new BlockResult(enemyBlock.getPerformer());
        Executor.run(playerResult, enemyResult);
        return new ResultsContainer(playerResult, enemyResult);
    }
}
