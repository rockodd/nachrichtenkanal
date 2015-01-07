package nachrichtenkanal;

public class MyContainerFIFOarray implements TextContainer {
	
	private String[] list;		// String Array wird erzeugt
	private int size,			// Variablen f�r Gr��e und Z�hler f�r das Array
				next = 0,
				count = 0,
				last = 0;
	
	public MyContainerFIFOarray(){
		this(50);
	}
	/* Konstruktor bekommt Gr��e �bergeben und erzeugt String Array  */
	public MyContainerFIFOarray(int size){
		this.size = size;			
		list = new String[size];	// String-Array mit �bergebener Gr��e wird erzeugt
	}
	/* Methode um Elemente dem Array hinzuzuf�gen */
	public void enter (String s) throws FullException{
		if ( count >= size) throw new FullException();			
		list[next] = s;
		next = (next+1)%size;				//modulo um n�chstes Element zu ermitteln
		count++;
	}
	
	/* Methode um Elemente aus Array zu entfernen */
	public String remove() throws EmptyException {	
		if (count == 0) throw new EmptyException();	//Pr�fung ob Z�hler auf Null also keine Elemente im Array
		String msg = list[last];			// Element an der Stelle "last" im Array in String speichern
		count--;							// Z�hler decrement
		last = (last+1)%size; 				// modulo um zeiger auf letztem Element zu positionieren
		return msg;
	}
	/* Methode um zu pr�fen ob Array leer ist */
	public boolean emtpy() {
		return count == 0;			// true wird zur�ckgegeben wenn leer
		
	}
	
	public static void main (String[] args) {
		MyContainerFIFOarray chn = new MyContainerFIFOarray(4);
		try {	chn.enter("ONE"); 		// top steht auf 1
				chn.enter("TWO");
				chn.enter("THREE");
				chn.enter("FOUR");
				//chn.enter("FIVE");
				System.out.println(chn.remove());
				System.out.println(chn.remove());
				System.out.println(chn.remove());
				System.out.println(chn.remove());
				
		}
		catch (EmptyException e) { 
				System.out.println("leer");
				
		}
	}

}
