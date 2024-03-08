package peggame;
/**
 * This class represents an exception that can be thrown by the SquarePegGame class in case of invalid moves or errors.
 */
public class PegGameException extends Exception{
    /**
     * Constructor for the PegGameException class.
     *
     * @param message The error message to be associated with the exception.
     */
    public PegGameException(String message){
        super(message);
    }
}
