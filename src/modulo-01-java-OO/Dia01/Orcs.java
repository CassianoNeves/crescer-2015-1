
/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orcs
{
    // instance variables - replace the example below with your own
    private int vida;
    private String nome;

    /**
     * Constructor for objects of class Orcs
     */
    public Orcs( String nome)
    {
        vida = 110;
        this.nome = nome;
    }
    
    public void perdeVida(){
        vida = vida - 10;
    }
    
    public int getVida(){
        return this.vida;
    }
}
