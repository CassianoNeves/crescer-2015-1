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
      
        System.out.println("aqui-0");
        
        if( this.nomeCliente.compareTo( outra.nomeCliente ) == -1 ){
            
            return -1;
            
        }
        
        if( this.nomeCliente.compareTo( outra.nomeCliente ) == 1 ){
            System.out.println("aqui+1");
            return 1;
                        
        }
        
        return 0;
    }
    
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    
}
