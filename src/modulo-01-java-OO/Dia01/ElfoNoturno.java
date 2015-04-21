
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo{

    public ElfoNoturno( String nome ){
        super( nome );
    }
    
    public ElfoNoturno( String nome, int flechas ){
        super( nome, flechas );
    }
    /**
     *  Atira flecha em um orc e ganha o triplo de experiencia e perde 5% da vida ate ficar MORTO.
     */
    public void atirarFlecha( Orc orc ){
        if( vida >= 1){
            super.atirarFlecha( orc );
            experiencia += 2;
            vida -= (vida * 0.05);
            if( vida < 1 ){
                status = Status.MORTO;
            }
        }
    }
}
