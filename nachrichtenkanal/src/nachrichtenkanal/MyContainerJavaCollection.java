package nachrichtenkanal;

import java.util.LinkedList;
import java.util.Queue;

public class MyContainerJavaCollection implements TextContainer {
	
	private Queue<String> queue = new LinkedList();		// String Array wird erzeugt
					
	public MyContainerJavaCollection(){
	}
	
		/* Methode um Elemente dem queue hinzuzufügen */
	public void enter (String s) throws FullException{
		queue.add(s);
	}
	
	/* Methode um Elemente aus queue zu entfernen */
	public String remove() throws EmptyException {
		//if (queue.isEmpty() == true) throw new EmptyException();
		String msg;			
		msg = queue.remove();
		return msg;
	}
	/* Methode um zu prüfen ob Array leer ist */
	public boolean emtpy() {
		return queue.isEmpty();			// true wird zurückgegeben wenn leer
		
	}
	
	
	public static void main (String[] args) {
		MyContainerJavaCollection chn = new MyContainerJavaCollection();
		try {	chn.enter("ONE"); 		// top steht auf 1
				chn.enter("TWO");
				chn.enter("THREE");
				chn.enter("FOUR");
				chn.enter("FIVE");
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
