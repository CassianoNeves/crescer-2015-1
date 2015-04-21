import java.util.*;
/**
 * Write a description of class ElfoVerde here.
 * 
 * @author Cassiano das Neves
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo{

    private final String[] ITENS_PERMITIDOS = new String[] {
        "Espada de aço valiriano", 
        "Arco e Flecha de vidro"};
    
    public ElfoVerde( String nome ){
        super( nome );
    }
    
    public ElfoVerde( String nome, int flechas ){
        super( nome, flechas );
    }
    
    public void atirarFlecha( Orc orc ){
        super.atirarFlecha( orc );
        experiencia++;
    }
    
    public void addItem( ItemDoInventario item ){
        if( itens != null && Arrays.asList( ITENS_PERMITIDOS ).contains( item.getDescricao() )){
            super.addItem( item );
        }
    }
    
    
}
