import java.util.*;
/**
 * Write a description of class EstrategiaNoturna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaNoturna implements EstrategiaDeAtaque{
    

    ArrayList<Elfo> ultimaOrdem = new ArrayList<>();
    
    public void atacarOrcs( ArrayList<Elfo> elfos, ArrayList<Orc> orcs ){
        
        int totalAtaques = elfos.size() * orcs.size();
        int totalNoturnos = (int) ( totalAtaques * 0.3);
        int qtdNoturnoAtacado = 0;
        
        for( Elfo elfoAtual : elfos ){
            ultimaOrdem.add( elfoAtual );
            if( elfoAtual instanceof ElfoNoturno){
                if(totalNoturnos > qtdNoturnoAtacado){
                    qtdNoturnoAtacado++;
                }
                else{
                    continue;
                }
            }
            
            for( Orc orc : orcs ){
                elfoAtual.atirarFlecha( orc );
            }
        }
    }
    
    public ArrayList<Elfo> getUltimaOrdemAtaque(){
        return ultimaOrdem;
    }
}
