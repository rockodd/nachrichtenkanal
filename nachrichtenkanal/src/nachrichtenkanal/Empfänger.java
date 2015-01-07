package nachrichtenkanal;

import java.util.NoSuchElementException;

import cs101.lang.Animate;
import cs101.lang.AnimatorThread;

public class Empfänger implements Animate {
	
	TextContainer kanal1;					// ObjektVariable vom Typ TextContainer mit Namen kanal1 wird erstellt
	TextGUI msgGUI = new TextGUI();			// neues Objekt vom Typ TextGui wird erzeugt
	
	public Empfänger() {					// std. Konstruktor
		}
	
	/* Konstruktor, wird aufgerufen beim erstellen eines neuen Objektes mit "new Empfänger" */
	public Empfänger(TextContainer kanal1) {
		this.kanal1 = kanal1;						// Objektvariable wird mit übergebenem Kanal beschrieben
		System.out.println("Empfänger gestartet");	// 
		}
		
	public void ausgeben() {
		try {
			String msg = kanal1.remove(); 	// String wird aus Kanal gelöscht und in Variable gespeichert
			msgGUI.write(msg);				// gelöschter String wird über GUI ausgegeben
			}
		catch (EmptyException e) { 			// fängt alle Fehler die auftreten wenn der Container leer ist.
			//System.out.println("leer");
			}	
		catch (NullPointerException z) {/* warte*/}		// fängt eine NullPointerException,
		catch (NoSuchElementException z) {/*warte*/}  	// fängt die EmptyException, die durch Java Collection 
														// Framework erzeugt wird, wenn queue leer ist.
		}
		
	public static void main(String[] args) {
		MyContainerJavaCollection kanal1 = new MyContainerJavaCollection();
		kanal1.enter("ONE"); 		// Array wird gefüllt
		kanal1.enter("TWO");
		kanal1.enter("THREE");
		kanal1.enter("FOUR");
		kanal1.enter("FIVE");
			
		AnimatorThread aniEmpfänger = new AnimatorThread(new Empfänger(kanal1));
		aniEmpfänger.startExecution();
		aniEmpfänger.setSleepRange(2000);		
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		ausgeben();
	}
	
}
	



