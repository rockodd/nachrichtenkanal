package nachrichtenkanal;

import cs101.io.Console;
import cs101.lang.Animate;
import cs101.lang.AnimatorThread;

public class Sender implements Animate{
	
	TextContainer kanal1;
	
	public Sender() {								//std. Konstruktur
	}
	
	/* Konstruktor, wird aufgerufen beim erstellen eines neuen Objektes mit "new Sender" */
	public Sender(TextContainer kanal1) {			
		System.out.println("Sender gestartet, bitte Nachrichten eingeben:");	// Eingabeaufforderung aus dem Konstruktur
		this.kanal1 = kanal1;													// Variable kanal1 wird erzeugt  
	}
		
	public void lesen() {														// Methode zum lesen der Konsoleneingabe
		try {
			String text = Console.readln();		// EIngabe wird aus Konsole gelesen und in Variable gespeichert
			kanal1.enter(text);					// eingelesener Text wird in Array gespeichert
			}
		catch (FullException e) { 				// f�ngt alle Fehler die auftreten wenn der Container Voll ist.
			System.out.println("Nachrichtenkanal �berf�llt, Nachricht wird verworfen!");
			}	
		
	}
		
												
	
	
	public static void main(String[] args) {
		TextContainerPrototype kanal1 = new TextContainerPrototype(4);			// Objekt vom Typ TextContainerPrototype erzeugt Array mit 4 Feldern
		AnimatorThread aniSender = new AnimatorThread(new Sender(kanal1));		// Animator Thread wird erzeugt und mit Objekt Sender �bergeben
		aniSender.startExecution();												// Animator Thread wird gestartet
	}


	@Override
	public void act() {															// act Methode ruft immer lesen-Methode auf
		// TODO Auto-generated method stub
		lesen();
	}
	
}
	



