import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class game {
	public static void main (String[]args) {
		textFile();
		gui = new GUI();
		game.print(currentRoom);
	}
	private static GUI gui = new GUI();
	static ArrayList<item> inventory = new ArrayList<item>();
	static HashMap<String, String> Rooms = new HashMap<String, String>();
	static HashMap<String, Rooms> roomObjects = new HashMap<String, Rooms>();
	public static Scanner scanner = new Scanner(System.in);
		public static void print (Object obj) {
			gui.textArea.append((obj.toString())+"\n");
	}
	static Rooms currentRoom = World.buildWorld();
	public static Rooms getCurrentRoom() {
		return currentRoom;
	}


	public static Rooms getcurrentroom() {
		return currentRoom;
	}

	public static item getiteminventory(String name) {
		for (item i : inventory) {
			if (i.getname().equals(name)) {
				return i;
			}
		}
		return null;
	}

	public static void textFile() {
		try {
			Scanner input = new Scanner(new File("description"));
			while (input.hasNextLine()) {
				String name = input.nextLine();
				String desc = input.nextLine();

				if (!name.equals("#") && !desc.equals("#")) {
					Rooms.put(name, desc);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	public static void saveList(String fileName) {
		File f = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(roomObjects);
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File" + fileName + "not found.");
		} catch (IOException ex) {
			System.out.println("Nothing here");
		}
	}

	public static void loadList(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			currentRoom = (Rooms) stream.readObject();
			inventory = (ArrayList) stream.readObject();
			roomObjects = (HashMap) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File" + fileName + "not found");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Rats");
		} catch (ClassNotFoundException ex) {
			System.out.println("Not an object.");
		}
	}
	public static void processCommand(String command) {
			String[] words = command.split("");
			switch (words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Rooms nextRoom = currentRoom.getExit(command.charAt(0));
				if (nextRoom == null) {
					game.print("you can't go that way.");
				} else if (nextRoom.getlock() == true) {
					System.out.println("The door is locked.");
				} else {
					currentRoom = nextRoom;
					break;
				}
			case "x":
				System.out.println("Thanks for playing, Goodbye");
				break;
			case "take":
				if (currentRoom.getitem(words[1]) == null) {
					System.out.println("There is no item here.");
				} else {
					inventory.add(currentRoom.getitem(words[1]));
					currentRoom.additem(words[1], null);
				}
			case "i":
				if (inventory.size() == 0) {
					System.out.println("Inventory is empty");
				} else {
					for (item i : inventory) {
						System.out.println(i);
					}
				}
			case "look":
				if (currentRoom.getitem(words[1]) != null) {
					System.out.println(currentRoom.getitem(words[1]).getdescription() + "\n");
				} else {
					boolean found = false;

					for (item c : inventory) {
						if (c.getname().equals(words[1])) {
							System.out.println(c.getdescription() + "\n");
							found = true;
						}
					}
					if (found == false) {
						System.out.println("There is no such item. \n");
					}
				}
			case "use":
				System.out.println("you are trying to use the" + words[1] + ".");

				if (currentRoom.getitem(words[1]) != null) {
					currentRoom.getitem(words[1]).use();
				} else {
					if (getiteminventory(words[1]) == null) {
						System.out.println("there is no item with that name");
					} else {
						getiteminventory(words[1]).use();
						System.out.println();

					}
				}
			case "open":
				System.out.println("you are trying to open the" + words[1] + ".");
				if (currentRoom.getitem(words[1]) != null) {
					currentRoom.getitem(words[1]).open();
				} else {
					if (getiteminventory(words[1]) == null) {
						System.out.println("there is no such item");
					} else {
						getiteminventory(words[1]).open();
						System.out.println();
					}
				}
			case "talk":
				game.print("you are trying to talk to the"+words[1]+".");
				 	if (currentRoom.getNPC(words[1])!= null) {
				 		currentRoom.getNPC(words[1]).talk();
				 		game.print("\n");
				 	}
				 	else{
				 		game.print("there is no such thing\n");
				 	}		
			break;
			case "save":
				saveList(words[1]);
				break;

			case "load":
				loadList(words[1]);
				break;

			default:
				System.out.println("Invaid. Please try agian.");

			}

	}
}
