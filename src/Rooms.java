
public class Rooms {

	private String description;
	private Rooms east;
	private Rooms west;
	private Rooms north;
	private Rooms south;
	private Rooms up;
	private Rooms down;
	
	public Rooms (String d) {
			description = d;		
	}// end of constructor
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
		return description;
	}//special method
	
}// end of class
