package exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class TreeException.
 */
public class TreeException extends Exception{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new tree exception.
	 */
	public TreeException() {
		super("No root has been set yet, please intialized root");
	}
}
