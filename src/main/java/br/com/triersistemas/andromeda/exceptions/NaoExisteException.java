package br.com.triersistemas.andromeda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NaoExisteException extends RuntimeException {

    public NaoExisteException() {
        super("Registo não encontrado.");
    }
}
