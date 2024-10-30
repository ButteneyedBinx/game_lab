
public class game {
	public static void main(String[] args) {
		Rooms currentRooms = World.buildWorld();
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move east!");
		currentRooms = currentRooms.getExit('e');
		System.out.println("\nNow we'll move west!");
		currentRooms = currentRooms.getExit('w');
		System.out.println(currentRooms);
	}
}
