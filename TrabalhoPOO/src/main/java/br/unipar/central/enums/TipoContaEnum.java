package br.unipar.central.enums;

/**
 *
 * @author Laly
 */
public enum TipoContaEnum {
    
    SALARIO(1), 
    CORRENTE(2), 
    POUPANCA(3), 
    INVESTIMENTO(4);
    
    private final int numero;

    private TipoContaEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    public static TipoContaEnum tipoContaEnum(int codigo) {
        for (TipoContaEnum tipo : TipoContaEnum.values()) {
            if (tipo.getNumero() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido!");
    } 
}
