import java.util.*;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos{
    
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    public void alistar( Elfo elfo ){
        if( elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno ){
            exercito.put( elfo.getNome(), elfo );
        }
    }
    
    public Elfo buscar( String nome ){
        return exercito.get( nome );
    }
    
    public HashMap<String, Elfo> getExercito(){
        return exercito;
    }
}
