public class Monster extends Essence {
    public int attack;
    public int defense;
    public int health;
    public int[] damage;
    
    // Конструктор Монстра наследованный от родительского класса Существа.
    public Monster (int attack, int defense, int health, int[] damage) {
        super(attack, defense, health, damage);
    }

    public Monster () {

    }

    // Установка значений параметрам Монстра
    public void setValuesToMonster (Monster testMonster, int N, int M) throws Exception {
        super.attack = Essence.setAttackOrDefense();
        super.defense = Essence.setAttackOrDefense();
        super.health = Essence.setHealth(N);
        super.damage = Essence.setDamage(M, N);
    }
}
