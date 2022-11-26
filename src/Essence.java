import java.util.Arrays;

public class Essence {
    protected int attack;
    protected int protect;
    protected int healthy;
    protected int[] damage;

    public int getAttack() { return attack; }
    public int getProtect() { return protect; }
    public int getHealthy() { return healthy; }
    public int[] getDamage() { return damage; }

    public Essence (int attack, int protect, int healthy, int[] damage) {
        this.attack = attack;
        this.protect = protect;
        this.healthy = healthy;
        this.damage = damage;
    }

    public Essence () {

    }

    public static int setAttackOrProtect() {
        int parameterAttackOrProtect = 1 + (int) ( Math.random() * 20 );
        return parameterAttackOrProtect;
    }

    public static int setHealthy (int N) {
        int parameterHealthy = (int) ( Math.random() * (N + 1) );
        return parameterHealthy;
    }

    public static int[] setDamage (int M, int N) {
        int[] arrayDamage = new int[N - M + 1];
        int value = M;
        for (int i = 0; i < N - M + 1; i++) {

            arrayDamage[i] = value;
            value++;
        }
        return arrayDamage;
    }

    public void printInfo(Essence essence) {
        System.out.println( "Some info about your essence: " +
                            "\nAttack: " + essence.getAttack() + 
                            "\nProtect: " + essence.getProtect() + 
                            "\nHealthy: " + essence.getHealthy());

        System.out.println("\nDamage: ");
        String intArrayString = Arrays.toString(essence.getDamage());
        System.out.print(intArrayString);
        System.out.println("\n");
    }

    private boolean throwCube() {
        int throwCube = 1 + (int) ( Math.random() * (6) );
            if (throwCube == 6 || throwCube == 5)
                return true;
            
            return false;
    }

    public boolean checkHealthyEssence(Essence essence) {
        if (essence.healthy <= 0)
        return true;

        return false;
    }

    public void kickEssence(Essence essenceDefensive, Essence essenceAttacking) {
        if (checkHealthyEssence(essenceAttacking) == true || checkHealthyEssence(essenceDefensive) == true  ) {
            System.out.println("You'r fight is over! There is no one to kick.");
            return;
        }

        int attackModificator = essenceAttacking.attack - essenceDefensive.protect + 1;
        boolean success = true;
        
        for (int i = 0; i <= attackModificator; i++) {
            if (success == throwCube()) {
                int chooseDamage = 1 + (int) ( Math.random() * (essenceAttacking.damage.length) + 1 );
                essenceDefensive.healthy = essenceDefensive.healthy - essenceAttacking.damage[chooseDamage];
                i = attackModificator;
                System.out.println("\nOh, no! Essence attacked you! You loose " + essenceAttacking.damage[chooseDamage] + " hp.\n");
            }
        }
    }
}
