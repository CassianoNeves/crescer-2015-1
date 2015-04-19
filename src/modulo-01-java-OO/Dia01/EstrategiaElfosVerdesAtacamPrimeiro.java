import java.util.*;
/**
 * Write a description of class EstrategiaElfosVerdesAtacamPrimeiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaElfosVerdesAtacamPrimeiro implements EstrategiaDeAtaque{

    private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        
        ordernarElfos( elfos );
        
        for( Elfo elfo : elfos ){
            ordemAtaque.add(elfo);
            for( Orc orc : orcs ){
                elfo.atirarFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        
        return ordemAtaque;
    }
    
    public void ordernarElfos( ArrayList<Elfo> elfos ){
   
        for( int i = 0; i < elfos.size(); i++ ){
            
            for( int j = 0; j < elfos.size() -1; j++ ){
                
                Elfo elfoAtual = elfos.get(j);
                Elfo elfoProximo = elfos.get(j+1);
                
                boolean trocar = elfoAtual instanceof ElfoNoturno && elfoProximo instanceof ElfoVerde;
                
                if( trocar ){
                    elfos.set( j+1, elfoAtual );
                    elfos.set( j, elfoProximo );
                }
            }
        }
    }
}
