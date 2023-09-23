public abstract class Essence {
    protected int attack;
    protected int defense;
    protected int health;
    protected int[] damage;

    public static final int N = 46;
    public static final int M = 28;

    public int getAttack()   { return attack;  }
    public int getDefense()  { return defense; }
    public int getHealth()   { return health;  }
    public int[] getDamage() { return damage;  }

    public Essence () throws Exception {
        this(setAttackOrDefense(), setAttackOrDefense(), setHealth(N), setDamage(M, N));
    }

    public Essence (int attack, int defense, int health, int[] damage) {
        this.attack  = attack;
        this.defense = defense;
        this.health  = health;
        this.damage  = damage;
    }

    // Установка рандомного значения Атаки или Защиты Существа
    public static int setAttackOrDefense() throws Exception {
        int parameterAttackOrDefense = 1 + (int) ( Math.random() * 30 );
        if (parameterAttackOrDefense > 30 || parameterAttackOrDefense < 1) throw new Exception("The parameter of Attack or Defense should be from 1...30.");
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

    // Абстрактный метод для вывода инофрмации о Существе на экран
    abstract String printInfo();

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
    public boolean isEssenceDead(Essence essence) {
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
    String kickEssence(Essence essenceDefensive, Essence essenceAttacking) throws Exception {
        String resultFight = "";
        if (isEssenceDead(essenceAttacking) || isEssenceDead(essenceDefensive) ) {
            resultFight = "You'r fight is over!";
            return resultFight;
        }

        int attackModificator = Math.abs(essenceAttacking.attack - essenceDefensive.defense) + 1;
        
        for (int i = 0; i <= attackModificator; i++) {
            if (throwCube()) {
                int chooseDamage = 1 + (int) ( Math.random() * (essenceAttacking.damage.length) + 1 );
                essenceDefensive.health = essenceDefensive.health - essenceAttacking.damage[chooseDamage];
                i = attackModificator;
                resultFight = "<html>Oh, no! Essence attacked you!<br>You loose " + essenceAttacking.damage[chooseDamage] + " hp.</html>";
                return resultFight;
            }
        }

        return resultFight;
    }
}
