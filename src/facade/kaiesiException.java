package facade;


//todas as classe com exe��es devem extender a 'exception'
public class KaiesiException extends Exception {
    public KaiesiException(String message) {
        super(message);
    }

    public KaiesiException(String message, Throwable e) {
        super(message, e);
    }

    
}
