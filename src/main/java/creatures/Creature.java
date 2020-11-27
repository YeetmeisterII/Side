package creatures;

public abstract class Creature {
    private final Stats stats;

    public Creature(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }
}
