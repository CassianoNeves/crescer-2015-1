import java.util.*;
/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem
{
    // instance variables - replace the example below with your own
    protected Status status = Status.VIVO;
    protected int vida;
    protected String nome;
    protected int experiencia = 0;
    protected ArrayList<ItemDoInventario> itens;
    
    public Personagem( int vida, String nome ){
        this.vida = vida;
        this.nome = nome;
        itens = new ArrayList<>();
    }
    
    protected Status getStatus(){
        return this.status;
    }
    
        protected int getVida(){
        return this.vida;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public void setExperiencia( int novaExpi ){
        this.experiencia = novaExpi;
    }
    
    public void setStatus( Status status ){
        this.status = status;
    }
    
    public void addItem( ItemDoInventario item ){
        this.itens.add(item);
    }
    
    public void removeItem( ItemDoInventario item ){
        this.itens.remove(item);
    }
    
    public ArrayList<ItemDoInventario> getItens(){
        return itens;
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
    
    public ItemDoInventario getItemComMenorQuantidade(){
        
        ItemDoInventario Item = null;
        
        int QuantidadeAtual = 0;
        
        boolean temItens = !this.itens.isEmpty();
        if(temItens){
            int QuantidadeMenor = itens.get(0).getQuantidade();
            for( ItemDoInventario itemAtual : this.itens ){
                
                QuantidadeAtual = itemAtual.getQuantidade();
                
                if( QuantidadeAtual <= QuantidadeMenor ){
                    QuantidadeMenor = QuantidadeAtual;
                    Item = itemAtual;
                }
            }
        }
        return Item;
    }
    
    public void ordernarItem(){
        
        /* ESTA É A PRIMEIRA SOLUÇÃO SEM ARRAYLIST AUXILIAR
         * ItemDoInventario itemEleito;
        int i, j;
           
        for(i = 1; i < itens.size(); i++){
            itemEleito = itens.get(i);
            j = i-1;
            while((j >= 0) && (itemEleito.getQuantidade() < itens.get(j).getQuantidade())){
                itens.set(j+1, itens.get(j));
                j--;
            }
            itens.set(j+1, itemEleito);
            }
            
        
        //ESSA É A SOLUÇÃO USANDO ARRAYLIST AUXILIAR
        ArrayList<ItemDoInventario> itensOrdenados = new ArrayList<>();
        ItemDoInventario menorItem;
        int quantidadeDeItens = itens.size();
        
        for( int i = 0; i < quantidadeDeItens; i++ ){
            menorItem = getItemComMenorQuantidade();
            itensOrdenados.add(menorItem);
            itens.remove(menorItem);
        }
        
        itens = itensOrdenados;
        */
       
       for( int i = 0; i < itens.size(); i++ ){
           for( int j = 0; j < itens.size() - 1; j++ ){
               
               ItemDoInventario itemAtual = itens.get( j );
               ItemDoInventario itemProximo = itens.get( j + 1 );
               
               boolean podeTrocar  = 
                    itemProximo.getQuantidade() < itemAtual.getQuantidade();
                    
               if( podeTrocar ){
                   itens.set( j, itemProximo );
                   itens.set( j + 1, itemAtual );
               }
           }
       }
    }
    
}
