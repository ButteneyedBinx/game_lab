
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
			game.print("THE CODE WORKED!!! looks like another key...");
			item blackkey = new item ("A black key ", "hmmm I wonder what this goes to");
			game.inventory.add(blackkey);
		}
	}
}
