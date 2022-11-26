public class Player extends Essence {
    public int attack;
    public int protect;
    public int healthy;
    public int[] damage;
    public int maxHealthy;
    public int countHeal;

    // Конструктор Игрока наследованный от родительского класса Существа.
    // Дополнительный параметр - значение максимального Здоровья.
    // Дополнительный параметр - количество исцелений Игрока.
    public Player (int attack, int protect, int healthy, int[] damage) {
        super(attack, protect, healthy, damage);
        maxHealthy = healthy;
        countHeal = 0;
    }

    public Player () {
    }

    // Установка значений параметрам Игрока, инициализация параметра максимального Здоровья
    // и параметра количества исцелений Игрока
    public void setValuesToPlayer (Player testPlayer, int N, int M) {
        super.attack = Essence.setAttackOrProtect();
        super.protect = Essence.setAttackOrProtect();
        super.healthy = Essence.setHealthy(N);
        super.damage = Essence.setDamage(M, N);
        maxHealthy = super.healthy;
        countHeal = 0;
    }

    // Метод для исцеления Игрока.
    // Игрок не может исцелить себя, если его здоровье и так максимально.
    // Игрок может исцелить себя только три раза.
    // Исцеление происходит путём добавления к параметру Здоровья 50% параметра максимального Здоровья (приведено к int для избежания несоответсвия типов).
    // Игрок не может исцелить себя больше, чем до параметра максимального Здоровья.
    public void healPlayer(Player player) {
        if (super.healthy == player.maxHealthy)
        return;
        if (super.healthy < player.maxHealthy && player.countHeal < 3) {
            super.healthy += (int) (player.maxHealthy * 0.5); 
            System.out.println("You heal Player with " + (int) (player.maxHealthy * 0.5) + "hp.\n");
            player.countHeal += 1;

            if (super.healthy > player.maxHealthy)
            super.healthy = player.maxHealthy;
        }
    }
}
