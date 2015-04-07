/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private Status status;
    {
        vida = 110;
        status = status.VIVO;
    }
    //Adicionei aqui
    //Adicionei aqui
    
    /**
     * Construtor para objetos da classe Orc
    public Orc()
    {
        //vida = 110;
    }
    **/
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        if( getVida() > 0 ){
            this.vida -= 10;
            if( getVida() == 0 ){
                status = status.MORTO;
            }
            
        }else{
        status = status.MORTO;
        // this.vida = this.vida - 10;
    }
    }
    
    public int getVida() {
        return this.vida;
    }
    
    
}
