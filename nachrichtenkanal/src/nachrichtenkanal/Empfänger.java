package nachrichtenkanal;

import cs101.lang.Animate;
import cs101.lang.AnimatorThread;

public class Empf�nger implements Animate {
	
	TextContainer kanal1;					// Variable vom Typ TextContainer mit Namen kanal1 wird erstellt
	TextGUI msgGUI = new TextGUI();			// neues Objekt vom Typ TextGui wird erzeugt
	
	public Empf�nger() {					// 

	}
	
	public Empf�nger(TextContainer kanal1) {
		System.out.println("Empf�nger gestartet");	//
		this.kanal1 = kanal1;				// 
		
	}
		
	public void ausgeben() {
		try {
			String msg = kanal1.remove(); 	// String wird aus Kanal gel�scht und in Variable gespeichert
			msgGUI.write(msg);				// gel�schter String wird �ber GUI ausgegeben
			}
		catch (EmptyException e) { 			// f�ngt alle Fehler die auftreten wenn der Container leer ist.
			//System.out.println("leer");
			}	
		catch (NullPointerException z) {/* warte*/}	// f�ngt eine NullPointerException,
		
	}
		
	public static void main(String[] args) {
		MyContainer kanal1 = new MyContainer(4);
		AnimatorThread aniSender = new AnimatorThread(new Sender(kanal1));
		AnimatorThread aniEmpf�nger = new AnimatorThread(new Empf�nger(kanal1));
		aniSender.startExecution();
		aniEmpf�nger.startExecution();
		aniEmpf�nger.setSleepRange(50000);		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		ausgeben();
	}
	
}
	



