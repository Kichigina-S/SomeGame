public class Monster extends Essence {
    public int attack;
    public int protect;
    public int healthy;
    public int[] damage;

    public Monster (int attack, int protect, int healthy, int[] damage) {
        super(attack, protect, healthy, damage);
    }

    public Monster () {

    }

    public void setValuesToMonster (Monster testMonster, int N, int M) {
        super.attack = Essence.setAttackOrProtect();
        super.protect = Essence.setAttackOrProtect();
        super.healthy = Essence.setHealthy(N);
        super.damage = Essence.setDamage(M, N);
    }
}
