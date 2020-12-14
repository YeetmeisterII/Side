package combat;

import combat.results.AttackResult;
import combat.results.BlockResult;
import creatures.Creature;

public class Executor {
    public static void run(AttackResult playerResult, AttackResult enemyResult) {
        executeAttack(playerResult);
        executeAttack(enemyResult);
    }

    public static void run(AttackResult playerResult, BlockResult enemyResult) {
        executeAttack(playerResult);
    }

    public static void run(BlockResult playerResult, AttackResult enemyResult) {
        executeAttack(enemyResult);
    }

    public static void run(BlockResult playerResult, BlockResult enemyResult) {
    }

    private static void executeAttack(AttackResult result) {
        Creature target = result.getTargetCreature();

        switch (result.getHitType()) {
            case CRITICAL_HIT, HIT:
                target.getStats().subtractCurrentHitPoints(result.getDamage());
                break;
            case BLOCKED, MISS, CRITICAL_MISS:
                break;
        }
    }
}
