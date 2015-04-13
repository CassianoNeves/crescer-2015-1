import java.lang.*;
/**
 * Write a description of class ElfosNoturnos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo{
   
    public ElfoNoturno( String nome, int flechas ){
        super( nome, flechas );
    }
    
    
    public ElfoNoturno( String nome ){
         super( nome );
    }
    
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        super.atirarFlecha( umOrc );
        experiencia += 2;
        
        this.vida = (int) (vida - (vida * 0.05));
    }
}
