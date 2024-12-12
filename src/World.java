public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Rooms buildWorld() {
	Rooms livingRoom = new Rooms("living room");
	Rooms kitchen = new Rooms("kitchen.");
	Rooms Basement= new Rooms("BASEMENT");
	Rooms Bedroom= new Rooms("bedroom");
	Rooms Balcony= new Rooms("balcony");
	Rooms Bathroom= new Rooms("bathroom");
	
	item litterbox = new item ("litterbox","It stinks!");
	item stringtoy = new item ("stringtoy","Maybe this can be used to distract one of the cats");
	item mousetoy= new item ("mouse toy","this toy is falling apart, one of the cats must love it");
	item ball= new item ("ball","You found a ball with a tiny bell inside");
	item cattreats= new item("Cat treats", "these cat treats look nasty");
	item Cible = new item ("Cible", " I wonder what a cible is ");
	Code Code = new Code("code","you found a code!");
	safe safe= new safe("safe","A large rusty metal safe? kind of wierd");
	
	Cat Cat = new Cat("Cat","A big orange cat rolls over");
	Black_cat Black_cat =new Black_cat("Black_Cat","A small shadow lurks in the corner");
	
	livingRoom.addExit(kitchen, 'e');
	livingRoom.addExit(Basement,'d');
	livingRoom.addExit(Bedroom,'w');
	livingRoom.addExit(Balcony,'n'); 
	livingRoom.addExit(Bathroom,'s');
	livingRoom.addNPC("Cat", Cat); 
	
	kitchen.addExit(livingRoom, 'w');
	kitchen.additem("Cat treats", cattreats);
	
	Basement.addExit(livingRoom, 'u');
	Basement.setlock(true);
	Basement.additem("Cible", Cible);
	Basement.addNPC("Black_cat", Black_cat);
	
	Bedroom.addExit(livingRoom,'e');
	Bedroom.additem("mouse toy", mousetoy);
	Bedroom.additem("safe",safe);
	Bedroom.setlock(true);
	
	Balcony.addExit(livingRoom,'s');
	Balcony.additem("string toy", stringtoy);
	
	
	Bathroom.addExit(livingRoom,'s');
	Bathroom.additem("litterbox", litterbox);
	Bathroom.additem("code", Code);
	Bathroom.additem("ball",ball);
	
	return livingRoom;
	}
}
