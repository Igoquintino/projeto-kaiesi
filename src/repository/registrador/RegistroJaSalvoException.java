package repository.registrador;

import repository.RepositoryException;

public class RegistroJaSalvoException extends RepositoryException{

    RegistroJaSalvoException() {
        super("Registro j� existe");
    }
    
}
