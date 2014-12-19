package nachrichtenkanal;

public interface TextContainer {
	public void enter(String s);
	public String remove() throws EmptyException;
	public boolean emtpy();
	

}
