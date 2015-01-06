package nachrichtenkanal;

public class MyContainer implements TextContainer {
	
	private String[] list;		// String Array wird erzeugt
	private int size,			// Variablen für Größe und Zähler für das Array
				next = 0,
				count = 0,
				last = 0;
	
	public MyContainer(){
		this(50);
	}
	/* Konstruktor bekommt Größe übergeben und erzeugt String Array  */
	public MyContainer(int size){
		this.size = size;			
		list = new String[size];	// String-Array mit übergebener Größe wird erzeugt
	}
	/* Methode um Elemente dem Array hinzuzufügen */
	public void enter (String s) throws FullException{
		if ( count >= size) throw new FullException();
		list[next] = s;
		next = (next+1)%size;				//modulo um nächstes Element zu ermitteln
		count++;
	}
	
	/* Methode um Elemente aus Array zu entfernen */
	public String remove() throws EmptyException {	
		if (count == 0) throw new EmptyException();	//Prüfung ob Zähler auf Null also keine Elemente im Array
		String msg = list[last];			// Element an der Stelle "last" im Array in String speichern
		count--;							// Zähler decrement
		last = (last+1)%size; 				// modulo um zeiger auf letztem Element zu positionieren
		return msg;
	}
	/* Methode um zu prüfen ob Array leer ist */
	public boolean emtpy() {
		return count == 0;			// true wird zurückgegeben wenn leer
		
	}

}
