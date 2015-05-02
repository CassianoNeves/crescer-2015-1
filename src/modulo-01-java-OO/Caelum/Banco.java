
import java.util.*;
/**
 * Write a description of class Banco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banco{

    private Map<String, Conta> contas = new HashMap<>();
    
    public void adiciona(String nome, Conta c ){
        contas.put( nome, c );
    }
    
    public Conta buscarPorNome( String nome ){
        return contas.get( nome );
    }
    
    public int pegaQuantidadeDeContas(){
        return contas.size();
    }
}
