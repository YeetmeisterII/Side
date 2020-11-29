package weapons;

public class HarshLanguage extends Weapon {
    public HarshLanguage(WeaponStats stats) {
        super(stats);
    }

    @Override
    public Integer attack() {
        return super.attack() + user.getStats().getCurrentCharisma();
    }
}
