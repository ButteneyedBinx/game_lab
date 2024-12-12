import java.util.HashMap;
import java.io.Serializable;

public class Rooms implements Serializable {

	private String name;
	private Rooms east;
	private Rooms west;
	private Rooms north;
	private Rooms south;
	private Rooms up;
	private Rooms down;
	private HashMap<String, item> items= new HashMap<String,item>();
	private HashMap<String,NPC> NPC = new HashMap<String,NPC>();
	
	private boolean lock;
	
	public Rooms (String name) {
		 this.name= name;
		 game.roomObjects.put(name,this);
	}
	public Rooms getExit(char direction){
		if(direction== 'e'){
			return east;
		}//east
		else if(direction== 'w'){
			return west;
		}// west
		else if(direction== 'n'){
			return north;
		}//north
		else if(direction== 's'){
			return south;
		}// south
		else if(direction== 'u'){
			return up;
		}//up
		else if(direction== 'd'){
			return down;
		}//down
		else {
			return null;
		}//null
	}//get method
	public void addExit(Rooms object, char direction){
		if(direction== 'e'){
			east=object;
		}//
		else if(direction== 'w'){
			west=object;
		}// 
		else if(direction== 'n'){
			north=object;
		}//
		else if(direction== 's'){
			south=object;
		}// 
		else if(direction== 'u'){
			up=object;
		}//
		else{
			down=object;
		}//down
	}//set method
	public String toString() {
		String k = this.getDescription(name);
		return k;
	}//special method
	
	public void additem(String name, item i) {
		items.put(name, i);
	}
	public item getitem(String name) {
		return items.get(name);
	}
	public void  removeItem(String name) {
		items.remove(name);
	}
	public boolean getlock() {
		return lock;	
	}
	public void setlock(boolean bool){
		lock=bool;
	}
	public void addNPC(String name,NPC x){
		NPC.put(name,x);
	}
	public NPC getNPC(String name){
		return NPC.get(name);
	}
	public void removeNPC(String name){
		NPC.remove(name);
	}	
public String getRoomname(){
	return name;
}
	public void setRoomname(String name) {
		this.name=name;
	}
	public String getDescription(String n) {
		for(String s: game.Rooms.keySet()) {
			if(s.equals(n)) {
				return game.Rooms.get(s);
			}
		}
		return null;
	}
}// end of class


