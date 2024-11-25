import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class game {
	static Rooms currentRoom = World.buildWorld();
	static ArrayList<item> inventory = new ArrayList<item>();
	static HashMap<String, String> Rooms = new HashMap<String, String>();
	static HashMap<String, Rooms> roomObjects = new HashMap<String, Rooms>();

	public static void main(String[] args) {
		textFile();
		runGame();
	}

	public static void print(Object obj) {
		System.out.println(obj.toString());
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

	public static void runGame() {
		Scanner scanner = new Scanner(System.in);
		String command;
		do {
			System.out.println(currentRoom);
			System.out.print("where do you want to go?:");
			command = scanner.nextLine();
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
					System.out.println("you can't go that way.");
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
			case "save":
				saveList(words[1]);

			case "load":
				loadList(words[1]);

			default:
				System.out.println("Invaid. Please try agian.");

			}

		} while (!command.equals("x"));
		scanner.close();
	}
}
