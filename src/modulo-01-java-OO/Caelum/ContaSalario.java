import java.util.*;
/**
 * Write a description of class ContaSalario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContaSalario extends Conta implements Comparable<ContaSalario>{
    
    public ContaSalario( String nomeCliente, int numero ){
        super( nomeCliente, numero );
        
    }
    
    public int compareTo( ContaSalario outra ){
        
        if( this.nomeCliente.compareTo( outra.nomeCliente ) < 0 ){
            
            return -1;
            
        }
        
        if( this.nomeCliente.compareTo( outra.nomeCliente ) > 0 ){
            
            return 1;
                        
        }
        
        return 0;
    }
    
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    
}
