package nachrichtenkanal;

import cs101.lang.Animate;
import cs101.lang.AnimatorThread;

public class Empfänger implements Animate {
	
	TextContainer kanal1;					// Variable vom Typ TextContainer mit Namen kanal1 wird erstellt
	TextGUI msgGUI = new TextGUI();			// neues Objekt vom Typ TextGui wird erzeugt
	
	public Empfänger() {					// 

	}
	
	public Empfänger(TextContainer kanal1) {
		System.out.println("Empfänger gestartet");	//
		this.kanal1 = kanal1;				// 
		
	}
		
	public void ausgeben() {
		try {
			String msg = kanal1.remove(); 	// String wird aus Kanal gelöscht und in Variable gespeichert
			msgGUI.write(msg);				// gelöschter String wird über GUI ausgegeben
			}
		catch (EmptyException e) { 			// fängt alle Fehler die auftreten wenn der Container leer ist.
			//System.out.println("leer");
			}	
		catch (NullPointerException z) {/* warte*/}	// fängt eine NullPointerException,
		
	}
		
	public static void main(String[] args) {
		MyContainer kanal1 = new MyContainer(4);
		AnimatorThread aniSender = new AnimatorThread(new Sender(kanal1));
		AnimatorThread aniEmpfänger = new AnimatorThread(new Empfänger(kanal1));
		aniSender.startExecution();
		aniEmpfänger.startExecution();
		aniEmpfänger.setSleepRange(50000);		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		ausgeben();
	}
	
}
	



