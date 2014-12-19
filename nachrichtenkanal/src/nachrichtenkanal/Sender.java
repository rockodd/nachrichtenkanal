package nachrichtenkanal;
import cs101.io.Console;


public class Sender implements TextContainer {
	static String eingabe = Console.readln();
	
	

	@Override
	public void enter(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public String remove() throws EmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean emtpy() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static void main(String[] args) {
		Sender chn = new Sender(1);
		chn.enter(eingabe);
		

		
		// TODO Auto-generated method stub

	}

}
