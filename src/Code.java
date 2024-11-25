
public class Code extends item{
	public Code(String name, String description){
		super("code","its a code I wonder what too...");
	}
	@Override
	public void use() {
		game.print("Maybe a door or a safe?");
	}
}
