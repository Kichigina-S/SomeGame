public class App {
    public static void main(String[] args) throws Exception {

        final int N = 56;
        final int M = 28;

        // Пример создания Игрока и вывод о нём информации для наглядности
        Player testPlayer = new Player();
        testPlayer.setValuesToPlayer(testPlayer, N, M);
       
        testPlayer.printInfo(testPlayer);
        System.out.println("\nmaxhealthy: " + testPlayer.maxHealthy);

        // Пример создания Монстра и вывод о нём информации для наглядности
        Monster testMonster = new Monster();
        testMonster.setValuesToMonster(testMonster, N, M);

        testMonster.printInfo(testMonster);    

        // Пример использования методов Удар, если атакующий - Монстр, и Исцеление
        // Метод исцеления вызван четыре раза, что бы показать, что четвёртое исцеление не будет произведено
        // Если параметр Здоровья Существа не положительное значение, Удар не будет совершён, т.к. Сущесвто считается мёртым

        testMonster.kickEssence(testPlayer, testMonster);
        testPlayer.healPlayer(testPlayer);
        testMonster.kickEssence(testPlayer, testMonster);
        testPlayer.healPlayer(testPlayer);
        testMonster.kickEssence(testPlayer, testMonster);
        testPlayer.healPlayer(testPlayer);
        testMonster.kickEssence(testPlayer, testMonster);
        testPlayer.healPlayer(testPlayer);

        testPlayer.printInfo(testPlayer);
        testMonster.printInfo(testMonster);
        

        // Пример использования метода Удар, если атакующий - Игрок

        testPlayer.kickEssence(testMonster, testPlayer);
        testPlayer.printInfo(testPlayer);
        testMonster.printInfo(testMonster);
    }
}
