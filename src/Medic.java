 public class Medic extends Character {
        private int healAmount;

        public Medic(String name, int health, int healAmount) {
            super(name, health);
            this.healAmount = healAmount;
        }

        @Override
        void performAction(Character[] characters, Boss boss) {
            // Лечим первого члена команды с здоровьем менее 100 единиц, если есть такой
            for (Character character : characters) {
                if (character != this && character.getHealth() < 100 && character.isAlive()) {
                    character.heal(healAmount);
                    System.out.println(name + " лечит " + character.getName() + " на " + healAmount + " единиц здоровья.");
                    break; // Лечим только одного игрока за раунд
                }
            }
        }
    }
}