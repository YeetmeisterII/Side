package combat;

import java.util.concurrent.ThreadLocalRandom;

public class CombatManager {
    private Integer rollD20() {
        return ThreadLocalRandom.current().nextInt(1, 21);
    }

    private void simulateCombatRound(Attack playerAttack, Attack enemyAttack) {
        Integer playerDamage, enemyDamage;
        Integer playerD20 = rollD20();
        Integer enemyD20 = rollD20();
        boolean playerCritical = (playerD20 == 20);
        boolean enemyCritical = (enemyD20 == 20);

        Integer playerDamageDealt = playerAttack.getWeaponUsed().attack();
        Integer enemyDamageDealt = enemyAttack.getWeaponUsed().attack();
    }

    private void simulateCombatRound(Attack playerAttack, Block enemyBlock) {
        Integer playerDamageDealt = playerAttack.getWeaponUsed().attack();

    }

    private void simulateCombatRound(Block playerBlock, Attack enemyAttack) {
    }

    private void simulateCombatRound(Block playerBlock, Block creatureBlock) {
    }
}
