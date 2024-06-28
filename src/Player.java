public class Player {
    // Player.java
    public class Player extends Character {
        private int damage;

        public Player(String name, int health, int damage) {
            super(name, health);
            this.damage = damage;
        }

        @Override
        void performAction(Character[] characters, Boss boss) {
            if (boss.isAlive()) {
                boss.takeDamage(damage);
                System.out.println(name + " атакует Босса на " + damage + " урона.");
            }
        }
    }
}
