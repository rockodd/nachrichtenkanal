package nachrichtenkanal;

import java.util.NoSuchElementException;

import cs101.lang.Animate;
import cs101.lang.AnimatorThread;

public class Empf�nger implements Animate {
	
	TextContainer kanal1;					// ObjektVariable vom Typ TextContainer mit Namen kanal1 wird erstellt
	TextGUI msgGUI = new TextGUI();			// neues Objekt vom Typ TextGui wird erzeugt
	
	public Empf�nger() {					// std. Konstruktor
		}
	
	/* Konstruktor, wird aufgerufen beim erstellen eines neuen Objektes mit "new Empf�nger" */
	public Empf�nger(TextContainer kanal1) {
		this.kanal1 = kanal1;						// Objektvariable wird mit �bergebenem Kanal beschrieben
		System.out.println("Empf�nger gestartet");	// 
		}
		
	public void ausgeben() {
		try {
			String msg = kanal1.remove(); 	// String wird aus Kanal gel�scht und in Variable gespeichert
			msgGUI.write(msg);				// gel�schter String wird �ber GUI ausgegeben
			}
		catch (EmptyException e) { 			// f�ngt alle Fehler die auftreten wenn der Container leer ist.
			//System.out.println("leer");
			}	
		catch (NullPointerException z) {/* warte*/}		// f�ngt eine NullPointerException,
		catch (NoSuchElementException z) {/*warte*/}  	// f�ngt die EmptyException, die durch Java Collection 
														// Framework erzeugt wird, wenn queue leer ist.
		}
		
	public static void main(String[] args) {
		MyContainerJavaCollection kanal1 = new MyContainerJavaCollection();
		kanal1.enter("ONE"); 		// Array wird gef�llt
		kanal1.enter("TWO");
		kanal1.enter("THREE");
		kanal1.enter("FOUR");
		kanal1.enter("FIVE");
			
		AnimatorThread aniEmpf�nger = new AnimatorThread(new Empf�nger(kanal1));
		aniEmpf�nger.startExecution();
		aniEmpf�nger.setSleepRange(2000);		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		ausgeben();
	}
	
}
	



