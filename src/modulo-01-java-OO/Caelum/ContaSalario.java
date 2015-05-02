import java.util.*;
/**
 * Write a description of class ContaSalario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContaSalario extends Conta implements Comparable<ContaSalario>{

    public String nomeCliente;
    
    public ContaSalario( int numero, String nome ){
        super( numero );
        this.nomeCliente = nome;
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
