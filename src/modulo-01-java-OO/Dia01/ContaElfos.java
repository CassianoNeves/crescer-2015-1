
/**
 * Write a description of class ContaElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContaElfos {

    private static int quantidadeDeElfos = 0;
    
    public static void contarElfos() {
        quantidadeDeElfos++;
    }
    
    public static int getQuantidadeElfos(){
        return quantidadeDeElfos;
    }
    
    public static void serQuantidadeElfos( int qtd ){
        quantidadeDeElfos = qtd;
    }
}
