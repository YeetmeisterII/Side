package combat;

import combat.results.AttackResult;
import combat.results.BlockResult;
import creatures.Creature;
import creatures.CreatureFactory;
import creatures.Creatures;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class ResultsContainerTest {
    Creature playerCreature, enemyCreature;
    AttackResult playerResult;
    BlockResult enemyResult;
    ResultsContainer resultsContainer;

    @Before
    public void initResultContainer() {
        playerCreature = CreatureFactory.createCreature(Creatures.GOBLIN);
        enemyCreature = CreatureFactory.createCreature(Creatures.GOBLIN);
        playerResult = new AttackResult(playerCreature, enemyCreature, Constants.HitTypes.HIT, 0);
        enemyResult = new BlockResult(enemyCreature);
        resultsContainer = new ResultsContainer(playerResult, enemyResult);
    }

    @Test
    public void getPlayerResultShouldBeCorrectType() {
        assertEquals("Should return object with type AttackResult", AttackResult.class,
                resultsContainer.getPlayerResult().getClass());
    }

    @Test
    public void getEnemyResultShouldBeCorrectType() {
        assertEquals("Should return object with type AttackResult", BlockResult.class,
                resultsContainer.getEnemyResult().getClass());
    }
}
