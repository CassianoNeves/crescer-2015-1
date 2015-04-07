/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida;
    private Status status;
    private String nome;
    private int experiencia = 0;
    
    public Orc( String nome ){
        this.nome = nome;
        vida = 110;
        status = status.VIVO;
    }
    
    public Orc(){
        this.nome = "";
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
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
}
