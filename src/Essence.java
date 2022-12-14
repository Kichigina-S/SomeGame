import java.util.Arrays;

public class Essence {
    protected int attack;
    protected int defense;
    protected int health;
    protected int[] damage;

    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getHealth() { return health; }
    public int[] getDamage() { return damage; }

    // Конструктор Существа
    public Essence (int attack, int defense, int health, int[] damage) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.damage = damage;
    }

    // Дефолтный конструктор
    public Essence () {

    }

    // Установка рандомного значения Атаки или Защиты Существа
    public static int setAttackOrDefense() throws Exception {
        int parameterAttackOrDefense = 1 + (int) ( Math.random() * 20 );
        if (parameterAttackOrDefense > 20 || parameterAttackOrDefense < 1) throw new Exception("The parameter of Attack or Defense should be from 1...20.");
        return parameterAttackOrDefense;
    }

    // Установка рандомного значения Здоровья Существа
    public static int setHealth (int N) throws Exception {
        int parameterHealth = (int) ( Math.random() * (N + 1) );
        if (parameterHealth > N || parameterHealth < 0) throw new Exception("The parameter of Health should be from 0..." + N + ".");
        return parameterHealth;
    }

    // Установка значений Урона Существа
    public static int[] setDamage (int M, int N) {
        int[] arrayDamage = new int[N - M + 1];
        int value = M;
        for (int i = 0; i < N - M + 1; i++) {
            arrayDamage[i] = value;
            value++;
        }
        return arrayDamage;
    }

    // Метод выполняет вывод инофрмации о Существе на экран
    public void printInfo(Essence essence) {
        System.out.println( "Some info about your essence: " +
                            "\nAttack: " + essence.getAttack() + 
                            "\nDefense: " + essence.getDefense() + 
                            "\nHealth: " + essence.getHealth());

        System.out.println("\nDamage: ");
        String intArrayString = Arrays.toString(essence.getDamage());
        System.out.print(intArrayString);
        System.out.println("\n");
    }

    // Метод выполняет бросок кубика, в случае если выпадает 6 или 5, возвращается true 
    // т.е. удар считается успешным
    private boolean throwCube() throws Exception {
        int throwCube = 1 + (int) ( Math.random() * (6) );
        if (throwCube > 6 || throwCube < 1) throw new Exception("The value of Cube should be from 1...6.");
            if (throwCube == 6 || throwCube == 5)
                return true;
            
            return false;
    }

    // Метод выполняет проверку на положительное значение параметра Здоровья Существа
    public boolean checkHealthEssence(Essence essence) {
        if (essence.health <= 0)
        return true;

        return false;
    }

    // Метод выполняет удар одним Существом другого. 
    // essenceDefensive - защищающееся Существо, essenceAttacking - атакующее Существо.
    // Удар можно выполнить только в случае, если здоровье Существа имеет положительное значение.
    // Удар считается успешным, если хотя бы на одном из кубиков выпало 5 или 6.
    // Кубик бросается N-раз, где N - это Модификатор атаки, который расчитывается в методе.
    // Если Удар успешен, кубик больше не бросается, цикл for () завершается.
    // Если Удар успешен, здоровье защищавшегося Существа уменьшается на одно из значений параметра Урон атакующего Существа.
    // Выводится информация о совершении Удара и количестве нанесённого Урона.
    public void kickEssence(Essence essenceDefensive, Essence essenceAttacking) throws Exception {
        if (checkHealthEssence(essenceAttacking) == true || checkHealthEssence(essenceDefensive) == true  ) {
            System.out.println("You'r fight is over! There is no one to kick.");
            return;
        }

        int attackModificator = essenceAttacking.attack - essenceDefensive.defense + 1;
        boolean success = true;
        
        for (int i = 0; i <= attackModificator; i++) {
            if (success == throwCube()) {
                int chooseDamage = 1 + (int) ( Math.random() * (essenceAttacking.damage.length) + 1 );
                essenceDefensive.health = essenceDefensive.health - essenceAttacking.damage[chooseDamage];
                i = attackModificator;
                System.out.println("\nOh, no! Essence attacked you! You loose " + essenceAttacking.damage[chooseDamage] + " hp.\n");
            }
        }
    }
}
