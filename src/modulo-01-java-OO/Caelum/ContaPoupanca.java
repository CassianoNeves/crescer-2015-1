
/**
 * Write a description of class ContaPoupanca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>{
    
    public ContaPoupanca( String nomeCliente, int numero ){
        super( nomeCliente, numero );
    }

    public int compareTo( ContaPoupanca o ){
        
        if( this.getNumero() < o.getNumero()){
             return -1;
        }
        
        if( this.getNumero() > o.getNumero()){
             return 1;
        }
        
        return 0;
    }
}
