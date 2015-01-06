package nachrichtenkanal;

import cs101.io.Console;
import cs101.lang.Animate;
import cs101.lang.AnimatorThread;

public class Sender implements Animate{
	
	public static TextContainer kanal1;
	
	public Sender() {

	}
	
	public Sender(TextContainer kanal1) {
		System.out.println("Bitte Nachrichten eingeben:");
		this.kanal1 = kanal1;
		
	}
		
	public static void lesen() {
		System.out.println("NEU:");
		String text = Console.readln();
		kanal1.enter(text);
	
	}
	
	
	public static void main(String[] args) {
		TextContainerPrototype kanal1 = new TextContainerPrototype(4);
		AnimatorThread aniSender = new AnimatorThread(new Sender(kanal1));
		aniSender.startExecution();
		
		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		lesen();
	}
	
}
	



