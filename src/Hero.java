public abstract class Hero {
    public abstract class Character {
        protected String name;
        protected int health;

        public Character(String name, int health) {
            this.name = name;
            this.health = health;
        }

        public boolean isAlive() {
            return health > 0;
        }

        public void takeDamage(int damage) {
            health -= damage;
            if (health < 0) {
                health = 0;
            }
        }

        public void heal(int amount) {
            health += amount;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        abstract void performAction(Character[] characters, Boss boss);
    }
}