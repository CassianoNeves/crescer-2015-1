import java.util.*;
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
    private ArrayList<ItemDoInventario> itens;
   
    //aqui estou 44
    public Orc( String nome ){
        this.nome = nome;
        vida = 110;
        status = status.VIVO;
        itens = new ArrayList<ItemDoInventario>();
    }
    
    public Orc(){
        this.nome = "";
        vida = 110;
        status = status.VIVO;
        itens = new ArrayList<ItemDoInventario>();
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
        
        double numero = gerarNumero();
        
        if( numero < 0 ){
            experiencia = experiencia +2;
        }
        else if(numero > 100){
 
            if( getVida() > 0){
                this.vida -= 10;
                if( getVida() == 0 ){
                    status = status.MORTO;
                }
                else{
                    status = status.MORTO;
                    // this.vida = this.vida - 10;
                }
            }
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
    
    public Status getStatus(){
        return status;
    }
    
    public void setExperiencia( int novaExpi ){
        this.experiencia = novaExpi;
    }
    
    public void setStatus( Status status ){
        this.status = status;
    }
    
    private double gerarNumero(){
        double numero = 0.0;
               numero = (nome.length() > 5 ? numero + 65 : numero - 60);
               numero = (vida > 30 && vida < 60 ? numero * 2 : vida < 20 ? numero * 3 : numero * 1);
               numero = (getStatus() == status.FUGINDO ? numero / 2 : getStatus() == status.CACANDO || getStatus() == status.DORMINDO ? numero +1: numero + 0);
               numero = (experiencia%2 == 0 ? Math.pow(numero, 3) : experiencia > 2 ? Math.pow(numero, 2) : numero );
        return numero;
    }
    
    public void addItemParaOrc( ItemDoInventario item ){
        this.itens.add(item);
    }
    
    public void removeItemDoOrc( ItemDoInventario item ){
        this.itens.remove(item);
    }
    
    public ArrayList<ItemDoInventario> getItens(){
        return itens;
    }
    
    public String imprimirNomesDosSeusObjetos(){
        
        ItemDoInventario item;
        StringBuilder nomes = new StringBuilder();
       
        
        for( int i = 0; i < this.itens.size(); i++ ){
            item = this.itens.get(i);
            nomes.append( i == (this.itens.size()-1) ? item.getDescricao() : item.getDescricao() + ", ");
        }
        
        System.out.println(nomes);
        return nomes.toString();
    }
    
    public void tentarSorte(){
        if( gerarNumero() == 3481 ){
   
            int quantidade = 1000;
            ItemDoInventario item;
        
            for( int i = 0; i < this.itens.size(); i++){
                quantidade = 1000;
                item = itens.get(i);
                quantidade += item.getQuantidade();
                item.setQuantidade(quantidade);
            }
        }
    }
    
    public ItemDoInventario getItemComMaiorQuantidade(){
        
        ItemDoInventario Item = null;
        int QuantidadeMaior = 0;
        int QuantidadeAtual = 0;
        
        for( ItemDoInventario itemAtual : this.itens ){
            
            QuantidadeAtual = itemAtual.getQuantidade();
            
            if( QuantidadeAtual >= QuantidadeMaior ){
                QuantidadeMaior = QuantidadeAtual;
                Item = itemAtual;
            }
        }
        return Item;
    }
}
