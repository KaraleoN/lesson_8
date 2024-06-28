import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Boss boss = new Boss("Злой Босс", 500, 50);

        Player player1 = new Player("Игрок 1", 100, 30);
        Player player2 = new Player("Игрок 2", 80, 40);
        Player player3 = new Player("Игрок 3", 120, 25);

        Medic medic = new Medic("Медик", 70, 20);

        Character[] characters = { player1, player2, player3, medic };

        // Игровой цикл
        while (boss.isAlive()) {
            // Ход игроков
            for (Character character : characters) {
                if (character.isAlive()) {
                    character.performAction(characters, boss);
                }
            }

            // Ход босса
            boss.performAction(characters, boss);

            // Проверка условия окончания игры
            if (!boss.isAlive() || allPlayersDead(characters)) {
                break;
            }

            // Вывод текущего состояния персонажей
            System.out.println("Текущее состояние:");
            for (Character character : characters) {
                System.out.println(character.getName() + " - здоровье: " + character.getHealth());
            }
            System.out.println();
        }

        // Вывод результатов игры
        if (!boss.isAlive()) {
            System.out.println("Босс побежден! Игроки победили!");
        } else {
            System.out.println("Игроки проиграли. Босс победил!");
        }
    }

    private static boolean allPlayersDead(Character[] characters) {
        for (Character character : characters) {
            if (character instanceof Player && character.isAlive()) {
                return false;
            }
        }
        return true;
    }
}