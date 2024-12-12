
public class safe extends item{
	public safe(String name, String description) {
		super("safe","A large reusty metal safe? kind of wierd");
	}

	@Override
	public void open() {
		if (game.getiteminventory("code") == null) {
			game.print("The safe is locked idiot");
		}
		else { 
			game.print("THE CODE WORKED!!! looks like a key and a pickle...");
			key key = new key ("A key ", "hmmm I wonder what this unlocks...");
			item pickletoy= new item ("A pickle Toy"," a small  stuffed pickle filled with catnip");
			game.inventory.add(key);
			game.inventory.add(pickletoy);
		}
	}
}
