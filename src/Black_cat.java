
public class Black_cat extends NPC{
	int talkCount =0;
	
	public Black_cat (String name, String description) {
		super("Black_Cat", "A small shadow lurks in the corner");
	}
	@Override
	public void talk() {
		talkCount++;
		
		if (talkCount==0) {
			say("what are you doing here?");
			String[] options= {
					"Im cleaning up after my wierd freinds cats",
					"none of your business",
			};
			getResponse(options);
			talkCount++;
		} else if (talkCount == 1) {
			say("do you know how lucky you are to be in my presense");
			String[] options = {
					"your kind of an ass",
					"umm okay?",
			};
			getResponse(options);
			talkCount++;
		} else {
			say("what do you want");
			talkCount++;
		}
		
	}
	@Override
	public void response(int option) {
		if(talkCount == 0) {
			switch(option) {
				case 1:
					say("DONT CALL  MY MOM ANNOYING YOU LAME HUMMINOID!");
					game.print("The black cat rolls its eyes");
					break;
				case 2:
					say("Your in my home humminoid show respect");
					game.print(" The Black cat swats at your face barely missing.");
					break;
			}
		} else if (talkCount == 1) {
			switch (option) {
				case 1:
					say("Thank you ill take that as a compliment");
					game.print("the Black cat smirks, and licks its paw.");
					break;
				case 2:
					say("ummm are you like ummmm dumb");
					game.print("the black cat narrows its eyes at you");
					break;
			}
			
		}
	}
}
