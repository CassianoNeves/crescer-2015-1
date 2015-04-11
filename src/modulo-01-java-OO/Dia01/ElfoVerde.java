
/**
 * Write a description of class ElfosVerdes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo{
   
    public ElfoVerde( String nome, int flechas ){
        super( nome, flechas );
    }
    
    public ElfoVerde( String nome ){
        super( nome );
    }
    
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia += 2;
        umOrc.recebeAtaque();
    }
    
    public void addItem( ItemDoInventario item ){
        if( item.getDescricao() == "Espada de aço valariano" || item.getDescricao() == "Arco e Flecha de vidro"){
            itens.add( item );
        }
    }
}
