import java.util.HashMap;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos{
 
    HashMap<String, Elfo> alistados = new HashMap<>();
    
    public HashMap<String, Elfo> getAlistados(){
        return alistados;
    }
    
    public void alistarElfo( Elfo elfo ){
        if( elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno ){
            alistados.put(elfo.getNome(), elfo );
        }
        
        
    }
    
    public Elfo getElfo( String nome ){
        return alistados.get( nome );
    }
    
    public HashMap<String, Elfo> getElfosPorStatus( Status status ){
        HashMap<String, Elfo> grupoPorStatus = new HashMap<>();
        
        for( String chave : alistados.keySet() ){
            Elfo elfo = alistados.get(chave);
            
            if( elfo.getStatus().equals( status ) ){
                grupoPorStatus.put( chave, elfo );
            }
        }
        
        return grupoPorStatus;
    }
}
