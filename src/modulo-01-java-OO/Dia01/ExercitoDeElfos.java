import java.util.*;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos{
    
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    
    
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
    
    public void agruparExercito(){
        
        exercitoAgrupado.clear();
        
        //Pega par a par os valores de exercito e faz os testes 
        for( Map.Entry<String, Elfo> chaveValor : exercito.entrySet() ){
            Elfo elfoAtual = chaveValor.getValue();
            
            //Se ja existe o grupo na questao apenas adicionar elfo
            if( exercitoAgrupado.containsKey( elfoAtual.getStatus() ) ){
                exercitoAgrupado.get( elfoAtual.getStatus() ).add( elfoAtual );
            }
            //Senao criar grupo de tal status adicioando o elfo na questao
            else{
                exercitoAgrupado.put( elfoAtual.getStatus(), new ArrayList<Elfo>(
                Arrays.asList( elfoAtual ) ) );
            }
        }
    }
    
    public ArrayList<Elfo> obterGrupo( Status status ){
        agruparExercito();
        return exercitoAgrupado.get( status );
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupado(){
        agruparExercito();
        return exercitoAgrupado;
    }
}
