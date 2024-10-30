
public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Rooms buildWorld() {
	Rooms livingRoom = new Rooms("You are in the living room.");
	Rooms kitchen = new Rooms("You are in the kitchen.");
	Rooms Basement= new Rooms("You are in the BASEMENT.");
	Rooms Bedroom= new Rooms("You are in the bedroom.");
	Rooms Balcony= new Rooms("You are on the balcony");
	Rooms Bathroom= new Rooms("You are in the bathroom");
	livingRoom.addExit(kitchen, 'e');
	kitchen.addExit(livingRoom, 'w');
	Basement.addExit(livingRoom, 'u');
	Bedroom.addExit(livingRoom,'e');
	livingRoom.addExit(Basement,'d');
	livingRoom.addExit(Bedroom,'w');
	Balcony.addExit(livingRoom,'s');
	livingRoom.addExit(Balcony,'n');
	Bathroom.addExit(livingRoom,'s');
	livingRoom.addExit(Bathroom,'n');
	return livingRoom;
	}
}
