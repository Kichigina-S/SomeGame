import java.util.Arrays;

public class Player extends Essence {
    private int maxHealth; 
    private int countHeal;
    
    public int getCountHeal() {
        return countHeal;
    }
    public int getMaxHealth() {
        return maxHealth;
    }

    public Player () throws Exception {
        this.maxHealth = health;
        this.countHeal = 0;
    }

    public Player (int attack, int defense, int health, int[] damage) {
        super(attack, defense, health, damage);
    }

    // Метод для исцеления Игрока.
    // Игрок не может исцелить себя, если его здоровье и так максимально.
    // Игрок может исцелить себя только 4 раза.
    // Исцеление происходит путём добавления к параметру Здоровья 30% параметра максимального Здоровья (приведено к int для избежания несоответсвия типов).
    // Игрок не может исцелить себя больше, чем до параметра максимального Здоровья.
    public String healPlayer(Player player) {
        String resultHeal = "Your health is maximum!";

        if (super.health == player.maxHealth)
            return resultHeal;

        if (super.health < player.maxHealth && player.countHeal < 4) {
            super.health += (int) (player.maxHealth * 0.3); 
            resultHeal = "You heal Player with " + (int) (player.maxHealth * 0.3) + "hp.\n";
            player.countHeal += 1;

            if (super.health > player.maxHealth)
                super.health = player.maxHealth;
            
            return resultHeal;
        }
        else {
            resultHeal = "<html>You've already healed Payer 4 times.<br>It's enough!</html>";
            return resultHeal;
        }
    }

    @Override
    String printInfo() {
        String infoAbout = "";
        infoAbout = "<html>Some info about your player: " +
                            "<br>Attack: "  + getAttack() + 
                            "<br>Defense: " + getDefense() + 
                            "<br>Health: "  + getHealth() +
                            "<br>Max Health: " + getMaxHealth();

        infoAbout += "<br>Damage: ";
        String intArrayString = Arrays.toString(getDamage());
        infoAbout += intArrayString + "</html>";

        return infoAbout;
    }
}
