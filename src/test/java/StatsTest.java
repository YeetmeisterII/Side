import creatures.Stats;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StatsTest {
    Stats stats;

    @Before
    public void initStats() {
        stats = new Stats(10, 10, 10, 10, 10, 10);
    }

    @Test
    public void addStrengthShouldAddToStrength() {
        stats.addStrength(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15), stats.getStrength());
    }

    @Test
    public void addDefenceShouldAddToDefence() {
        stats.addDefence(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15), stats.getDefence());
    }

    @Test
    public void addCharismaShouldAddToCharisma() {
        stats.addCharisma(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15), stats.getCharisma());
    }

    @Test
    public void addHitPointsShouldAddToHitPoints() {
        stats.addHitPoints(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15), stats.getHitPoints());
    }

    // TODO: Make Current tests non-dependent on add[baseVariable] methods.
    @Test
    public void addCurrentStrengthShouldAddToCurrentStrength() {
        stats.addStrength(5);
        stats.addCurrentStrength(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentStrength());
    }

    @Test
    public void addCurrentDefenceShouldAddToCurrentDefence() {
        stats.addDefence(5);
        stats.addCurrentDefence(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentDefence());
    }

    @Test
    public void addCurrentCharismaShouldAddToCurrentCharisma() {
        stats.addCharisma(5);
        stats.addCurrentCharisma(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentCharisma());
    }

    @Test
    public void addCurrentHitPointsShouldAddToCurrentHitPoints() {
        stats.addHitPoints(5);
        stats.addCurrentHitPoints(5);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentHitPoints());
    }

    @Test
    public void addCurrentStrengthShouldCapAtStrength() {
        stats.addCurrentStrength(5);
        assertEquals("Should be 10 as currentStrength cannot be greater than strength", Integer.valueOf(10),
                stats.getCurrentStrength());
    }

    @Test
    public void addCurrentDefenceShouldCapAtDefence() {
        stats.addCurrentDefence(5);
        assertEquals("Should be 10 as currentDefence cannot be greater than defence", Integer.valueOf(10),
                stats.getCurrentDefence());
    }

    @Test
    public void addCurrentCharismaShouldCapAtCharisma() {
        stats.addCurrentCharisma(5);
        assertEquals("Should be 10 as currentCharisma cannot be greater than charisma", Integer.valueOf(10),
                stats.getCurrentCharisma());
    }

    @Test
    public void addCurrentHitPointsShouldCapAtHitPoints() {
        stats.addCurrentHitPoints(5);
        assertEquals("Should be 10 as currentHitPoints cannot be greater than hitPoints", Integer.valueOf(10),
                stats.getCurrentHitPoints());
    }

    // TODO: Make Current tests non-dependent on add[baseVariable] methods.
    @Test
    public void addCurrentStrengthShouldAddToCurrentStrengthAndCap() {
        stats.addStrength(5);
        stats.addCurrentStrength(6);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentStrength());
    }

    @Test
    public void addCurrentDefenceShouldAddToCurrentDefenceAndCap() {
        stats.addDefence(5);
        stats.addCurrentDefence(6);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentDefence());
    }

    @Test
    public void addCurrentCharismaShouldAddToCurrentCharismaAndCap() {
        stats.addCharisma(5);
        stats.addCurrentCharisma(6);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentCharisma());
    }

    @Test
    public void addCurrentHitPointsShouldAddToCurrentHitPointsAndCap() {
        stats.addHitPoints(5);
        stats.addCurrentHitPoints(6);
        assertEquals("Should be 15 as 10 (original) + 5 (added value) = 15", Integer.valueOf(15),
                stats.getCurrentHitPoints());
    }

    @Test
    public void subtractStrengthShouldReduceStrength() {
        stats.subtractStrength(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getStrength());
    }

    @Test
    public void subtractDefenceShouldReduceDefence() {
        stats.subtractDefence(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getDefence());
    }

    @Test
    public void subtractCharismaShouldReduceCharisma() {
        stats.subtractCharisma(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getCharisma());
    }

    @Test
    public void subtractHitPointsShouldReduceHitPoints() {
        stats.subtractHitPoints(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getHitPoints());
    }

    @Test
    public void subtractCurrentStrengthShouldReduceCurrentStrength() {
        stats.subtractCurrentStrength(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getCurrentStrength());
    }

    @Test
    public void subtractCurrentDefenceShouldReduceCurrentDefence() {
        stats.subtractCurrentDefence(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getCurrentDefence());
    }

    @Test
    public void subtractCurrentCharismaShouldReduceCurrentCharisma() {
        stats.subtractCurrentCharisma(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getCurrentCharisma());
    }

    @Test
    public void subtractCurrentHitPointsShouldReduceCurrentHitPoints() {
        stats.subtractCurrentHitPoints(5);
        assertEquals("Should be 5 as 10 (original) - 5 (subtracted value) = 5", Integer.valueOf(5),
                stats.getCurrentHitPoints());
    }
}
