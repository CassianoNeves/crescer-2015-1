
/**
 * Write a description of class temDoInventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemDoInventario{
    // instance variables - replace the example below with your own
    private String descricao;
    private int quantidade;

    /**
     * Constructor for objects of class temDoInventario
     */
    public ItemDoInventario( String descricao, int qtd)
    {
        this.quantidade = qtd;
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade( int qtd ){
        this.quantidade = qtd;
    }
}
