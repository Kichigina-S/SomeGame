public class Player extends Essence {
    public int attack;
    public int defense;
    public int health;
    public int[] damage;
    public int maxHealth;
    public int countHeal;

    // Конструктор Игрока наследованный от родительского класса Существа.
    // Дополнительный параметр - значение максимального Здоровья.
    // Дополнительный параметр - количество исцелений Игрока.
    public Player (int attack, int defense, int health, int[] damage) {
        super(attack, defense, health, damage);
        maxHealth = health;
        countHeal = 0;
    }

    public Player () {
    }

    // Установка значений параметрам Игрока, инициализация параметра максимального Здоровья
    // и параметра количества исцелений Игрока
    public void setValuesToPlayer (Player testPlayer, int N, int M) {
        super.attack = Essence.setAttackOrDefense();
        super.defense = Essence.setAttackOrDefense();
        super.health = Essence.setHealth(N);
        super.damage = Essence.setDamage(M, N);
        maxHealth = super.health;
        countHeal = 0;
    }

    // Метод для исцеления Игрока.
    // Игрок не может исцелить себя, если его здоровье и так максимально.
    // Игрок может исцелить себя только три раза.
    // Исцеление происходит путём добавления к параметру Здоровья 50% параметра максимального Здоровья (приведено к int для избежания несоответсвия типов).
    // Игрок не может исцелить себя больше, чем до параметра максимального Здоровья.
    public void healPlayer(Player player) {
        if (super.health == player.maxHealth)
        return;
        if (super.health < player.maxHealth && player.countHeal < 3) {
            super.health += (int) (player.maxHealth * 0.5); 
            System.out.println("You heal Player with " + (int) (player.maxHealth * 0.5) + "hp.\n");
            player.countHeal += 1;

            if (super.health > player.maxHealth)
            super.health = player.maxHealth;
        }
    }
}
