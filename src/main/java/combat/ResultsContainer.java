package combat;

import combat.results.Result;

public class ResultsContainer {
//  playerResult and enemyResult will bet either AttackResult or BlockResult.
    private final Result playerResult, enemyResult;

    public <T extends Result> ResultsContainer(T playerResult, T enemyResult) {
        this.playerResult = playerResult;
        this.enemyResult = enemyResult;
    }

    public <T extends Result> T getPlayerResult() {
        return (T) playerResult;
    }

    public <T extends Result> T getEnemyResult() {
        return (T) enemyResult;
    }
}
