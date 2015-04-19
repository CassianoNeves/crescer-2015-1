import java.util.*;
/**
 * Write a description of class EstrategiaIntercalada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaIntercalada implements EstrategiaDeAtaque {
 
    ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        
        intercalarAtaque( elfos );
        
        for( Elfo elfo : ordemAtaque ){
            for( Orc orc : orcs ){
                elfo.atirarFlecha(orc);
            }
        }
        
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemAtaque;
    }
    
    public void intercalarAtaque( ArrayList<Elfo> elfos ){
        
        if( verificarExercito( elfos ) ){
            
            ordemAtaque.add( elfos.get(0) );
            elfos.remove( ordemAtaque.get(0) );
            Class ultimaClasse = ordemAtaque.get(0).getClass();
            
            //Enquanto tiver elfos dentro de elfos continua.
            while( elfos.size() > 0){
                for( int i = 0; i < elfos.size(); i++ ){
                    Elfo elfoAtual = elfos.get(i);
                    if( elfoAtual.getClass() != ultimaClasse ){
                        ordemAtaque.add( elfoAtual );
                        ultimaClasse = elfoAtual.getClass();
                        elfos.remove( elfoAtual );
                    }
                }
            }
        }
    }
    
    public boolean verificarExercito( ArrayList<Elfo> elfos ){
        
        int elfosVerdes = 0;
        int elfosNoturnos = 0;
        
        for( Elfo elfoAtual : elfos ){
            if( elfoAtual instanceof ElfoVerde ){
                elfosVerdes++;
            }
            
            if( elfoAtual instanceof ElfoNoturno ){
                elfosNoturnos++;
            }
        }
        
        return elfosVerdes == elfosNoturnos;
    }
    
    
}
