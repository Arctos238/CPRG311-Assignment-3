package exceptions;

public class TreeException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TreeException() {
		super("No root has been set yet, please intialized root");
	}
}
