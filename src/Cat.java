
public class Cat extends NPC {
	int talkCount=0;
	
	public Cat(String name, String description) {
		super("Cat","A big orange cat rolls over");
	}
	@Override
	public void talk() {
		talkCount++;
		
		if(talkCount==0) {
			
			say("Hi! do you haave any food?");
			String[] options= { 
					"No, Im sorry",
					"No, but I can try to find some"
			};
			getResponse(options);
			talkCount++;
		} else if(talkCount==1) {
			
			say("you should rub my belly!! please I love belly rubs!");
			String[] options= {
					"Of course! Id love to!!!",
					"No i dont have time, Im sorry",
			};
			getResponse(options);
			talkCount++;
		} else  {
			
			say(" SLAY!!! *purrs*");
			talkCount++;
	}
	}		
	@Override
	public void response(int option) {
		if (talkCount == 0) {
			
			switch(option) {
			case 1:
				say("Well that sucks");
				break;
			case 2:
				say("YOU WILL!! Were best friends now!!");
				game.print("The cat nuzzels aginst you!");
				break;
			}
		}else if (talkCount == 1) {
			switch(option) {
			case 1:
				say ("Thank you <3*purrs*");
				game.print("you lean down and rub the cats belly. After you rub the cats belly you see a crystal, he was laying on.");
				item crystal = new item("crystal","a bright shiny clear crystal");
				game.inventory.add(crystal);
				break;
			case 2:
				say("Thats dumb!");
				game.print("the cat waddles away but not before pissing on your shoe");
				break;
			}
		}
	}
	
}
