package weapons;

class WeaponStats {
    private final Integer diceQuantity, diceValue, constantDamage;

    public WeaponStats(Integer diceQuantity, Integer diceValue, Integer constantDamage) {
        this.diceQuantity = diceQuantity;
        this.diceValue = diceValue;
        this.constantDamage = constantDamage;
    }

    public Integer getDiceQuantity() {
        return diceQuantity;
    }

    public Integer getDiceValue() {
        return diceValue;
    }

    public Integer getConstantDamage() {
        return constantDamage;
    }
}
