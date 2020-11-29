package weapons;


public class WeaponFactory {
    public Weapon createWeapon(Weapons weapon) {
        return switch (weapon) {
            case SWORD -> createWeapon(weapon, 1, 6, 0);
            case DAGGER -> createWeapon(weapon, 1, 3, 0);
            case ROCK_FIST -> createWeapon(weapon, 1, 8, 3);
            case HARSH_LANGUAGE -> createWeapon(weapon, 1, 4, 0);
            case FIRE_BREATH -> createWeapon(weapon, 2, 12, 0);
        };
    }

    public Weapon createWeapon(Weapons weapon, Integer diceQuantity, Integer diceValue, Integer constantDamage) {
        WeaponStats weaponStats = new WeaponStats(diceQuantity, diceValue, constantDamage);
        return switch (weapon) {
            case SWORD -> new Sword(weaponStats);
            case DAGGER -> new Dagger(weaponStats);
            case ROCK_FIST -> new RockFist(weaponStats);
            case HARSH_LANGUAGE -> new HarshLanguage(weaponStats);
            case FIRE_BREATH -> new FireBreath(weaponStats);
        };
    }
}
