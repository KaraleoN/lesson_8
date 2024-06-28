import java.util.Random;

public class Boss extends Character {
    private int damage;

    public Boss(String name, int health, int damage) {
        super(name, health);
        this.damage = damage;
    }

    @Override
    void performAction(Character[] characters, Boss boss) {
        if (!isAlive()) {
            return;
        }
        Random random = new Random();
        Character target = characters[random.nextInt(characters.length)];
        target.takeDamage(damage);
        System.out.println(name + " атакует " + target.getName() + " на " + damage + " урона.");
    }
}