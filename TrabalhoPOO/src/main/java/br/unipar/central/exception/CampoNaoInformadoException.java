package br.unipar.central.exception;

/**
 *
 * @author Beatr
 */
public class CampoNaoInformadoException extends Exception{
    public CampoNaoInformadoException(String campo){
        super("O campo " + campo + " não foi informado. Verifique!");
    }
}
