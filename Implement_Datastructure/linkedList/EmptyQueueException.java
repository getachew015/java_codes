package datastruct;

@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {

	public EmptyQueueException(){
		super("We have an empty Queue");
	}
}
