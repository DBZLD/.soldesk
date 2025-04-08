package rpg;

public class Main {
public static void main(String[] args) {
	Character character = new Character("플레이어", 100, 10);
	character.Info();
	character.nGold += 10;
	character.Info();
}
}
