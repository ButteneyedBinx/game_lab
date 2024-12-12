import java.io.Serializable;
public class item implements Serializable{
	private String name;
	private String description;
	public item(String name, String description) {
		super();
		this.name=name;
		this.description= description;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getname() {
		return name;
	}
	public String getdescription() {
	return description;
	}
	public String toString() {
		return name;
	}
	public void open() {
		game.print("you can't open that.");
	}
	public void use() {
		game.print("you cant use that");
	}
}
