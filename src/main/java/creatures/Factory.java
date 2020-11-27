package creatures;

public class Factory {
    public Creature createCreature(Creatures creature) {
        return createCreature(creature, getDefaultStats(creature));
    }

    public Creature createCreature(Creatures creature, Stats stats) {
        return switch (creature) {
            case GOBLIN -> new Goblin(stats);
            case ORC -> new Orc(stats);
            case EARTH_ELEMENTAL -> new EarthElemental(stats);
            case DJINN -> new Djinn(stats);
            case DRAGON -> new Dragon(stats);
        };
    }

    public Stats createStats(Integer strength, Integer defence, Integer charisma, Integer hitPoints, Integer goldValue,
                             Integer expValue) {
        return new Stats(strength, defence, charisma, hitPoints, goldValue, expValue);
    }

    private Stats getDefaultStats(Creatures creature) {
        return switch (creature) {
            case GOBLIN -> new Stats(5, 10, 0, 10, 5, 10);
            case ORC -> new Stats(13, 13, 0, 15, 10, 15);
            case EARTH_ELEMENTAL -> new Stats(16, 16, 0, 5, 0, 30);
            case DJINN -> new Stats(5, 16, 17, 10, 30, 15);
            case DRAGON -> new Stats(18, 18, 0, 30, 100000000, 500);
        };
    }
}
