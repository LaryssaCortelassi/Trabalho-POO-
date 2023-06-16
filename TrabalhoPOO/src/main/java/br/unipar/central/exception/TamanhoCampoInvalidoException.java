
package br.unipar.central.exception;

/**
 *
 * @author Beatr
 */
public class TamanhoCampoInvalidoException extends Exception{
    public TamanhoCampoInvalidoException(String campo, int tamanho){
        super("O campo " + campo + " foi informado com tamanho(" + tamanho + " caracteres) inválido. Verifique!");
    }
}
