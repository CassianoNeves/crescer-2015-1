import java.util.*;
/**
 * Write a description of class EstrategiaComPrioridadeDeElfosVerdes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaComPrioridadeDeElfosVerdes implements EstrategiaDeAtaque{
    
    
    private ArrayList<Elfo> ultimaOrdem = new ArrayList<>();
    
    public void atacarOrcs( ArrayList<Elfo> elfos, ArrayList<Orc> orcs ){
        
        organizarExercito( elfos );
        
        for( Elfo elfoAtual : elfos ){
            ultimaOrdem.add( elfoAtual );
            for( Orc orc : orcs ){
                elfoAtual.atirarFlecha( orc );
            }
        }
    }
    
    public void organizarExercito( ArrayList<Elfo> elfos ){
        
        for( int i = 0; i < elfos.size();i++ ){
            
            for( int j = 0; j < elfos.size() - 1; j++ ){
                Elfo elfoAtual = elfos.get(j);
                Elfo elfoProximo = elfos.get(j + 1);
                
                if( elfoAtual instanceof ElfoNoturno && elfoProximo instanceof ElfoVerde ){
                    elfos.set( j, elfoProximo );
                    elfos.set( j + 1, elfoAtual );
                }
            }
        }
    }
    
    public ArrayList<Elfo> getUltimaOrdemAtaque(){
        return ultimaOrdem;
    }
}
