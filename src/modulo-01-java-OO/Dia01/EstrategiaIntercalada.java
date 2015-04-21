import java.util.*;
/**
 * Write a description of class EstrategiaIntercalada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaIntercalada implements EstrategiaDeAtaque{

    ArrayList<Elfo> ultimaOrdem = new ArrayList<>();
    
    public void atacarOrcs( ArrayList<Elfo> elfos, ArrayList<Orc> orcs ){
        
        intercalarExercito( elfos );
        
        for( Elfo elfo : ultimaOrdem ){
            for( Orc orc : orcs ){
                elfo.atirarFlecha( orc );
            }
        }
    }
    
    public ArrayList<Elfo> getUltimaOrdemAtaque(){
        return ultimaOrdem;
    }
    
    private boolean validarExercito( ArrayList<Elfo> elfos ){
        
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
    
    public void intercalarExercito( ArrayList<Elfo> elfos ){
        
        if( validarExercito( elfos ) && elfos != null ){
        
            Elfo elfoAtual = elfos.get(0);
            Class ultimaClasse = elfoAtual.getClass();
            ultimaOrdem.add( elfoAtual );
            elfos.remove( elfoAtual );
        
            while( elfos.size() > 0 ){
                for( int i = 0; i < elfos.size(); i++ ){
                
                    elfoAtual = elfos.get(i);
                
                    if( elfoAtual.getClass() != ultimaClasse ){
                        ultimaOrdem.add( elfoAtual );
                        ultimaClasse = elfoAtual.getClass();
                        elfos.remove( elfoAtual );
                    }
                }
            }
        }
    }
}
