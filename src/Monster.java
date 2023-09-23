import java.util.Arrays;

public class Monster extends Essence {

    public Monster () throws Exception {
    }

    public Monster (int attack, int defense, int health, int[] damage) {
        super(attack, defense, health, damage);
    }

    @Override
    String printInfo() {
        String infoAbout = "";
        infoAbout = "<html>Some info about your monster: " +
                            "<br>Attack: "  + getAttack() + 
                            "<br>Defense: " + getDefense() + 
                            "<br>Health: "  + getHealth();

        infoAbout += "<br>Damage: ";
        String intArrayString = Arrays.toString(getDamage());
        infoAbout += intArrayString + "</html>";

        return infoAbout;
    }
}
