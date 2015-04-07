package datastruct;

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {

	public EmptyStackException(){
		super("We have an empty Stack here");
	}
}
