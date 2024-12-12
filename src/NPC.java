import javax.swing.JOptionPane;

public class NPC {
	private String name;
	private String desc;
	public NPC(String name, String desc) {
		this.name =name;
		this.desc= desc;
	}
	public String getName(){
		return name;
	}
	public void setDesc(String desc) {
		this.desc =desc;
	}
	public void talk () {
		game.print("you cant talk to"+name+".");
	}
	public void say(String dialog) {
		game.print(name+":"+ dialog);
	}
	public void response (int option) {
		
	}
	public void getResponse(String[] options) {
		String s="";
		for (int i =0; i< options.length; i++) {
			s +="Option"+(i+1)+":"+ options[i]+"\n";
		}
		s += "Enter an Option(1-"+options.length +"):";
		int option = Integer.parseInt(JOptionPane.showInputDialog(s));
		response(option);
	}
}
