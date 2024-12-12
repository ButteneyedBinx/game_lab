
public class key extends item {
	public key( String name, String description) {
		super("key","key");
	}
	@Override 
	public void use() {
	if(game.currentRoom.getExit('n')== null) {
		game.print("Maybe a door...");
	}
	else if (game.currentRoom.getExit('n').getRoomname().equals("BASEMENT")){
		game.print("you used the key to open the BASEMENT");
		game.currentRoom.getExit('n').setlock(false);
	}
	else {
		game.print("try a diffrent door");
	}
	}
}
