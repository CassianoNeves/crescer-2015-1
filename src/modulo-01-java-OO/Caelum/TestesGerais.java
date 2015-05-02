
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestesGerais.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestesGerais{

    @Test
    public void testeComCollectionsSort(){
        List<String> lista = new ArrayList<>();
        lista.add("Sérgio");
        lista.add("Paulo");
        lista.add("Guilherme");
        
        // repare que o toString de ArrayList foi sobrescrito:
        System.out.println(lista);
        
        Collections.sort(lista);
        
        System.out.println(lista);
    }
    
    public void testandoCollectionsSortComObjetos(){
        ContaCorrente c1 = new ContaCorrente(1);
        c1.deposita(500);
        
        ContaCorrente c2 = new ContaCorrente(12);
        c2.deposita(200);
        
        ContaCorrente c3 = new ContaCorrente(123);
        c3.deposita(150);
        
        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(c1);
        contas.add(c3);
        contas.add(c2);
    }
    
    @Test
    public void testaOMetodoCompareToDaContaCorrente(){
        ContaCorrente c1 = new ContaCorrente(123);
        c1.deposita(500);
        
        ContaCorrente c2 = new ContaCorrente(1234);
        c2.deposita(200);
        
        int valor = c1.compareTo(c2);
        
        assertEquals( 1, valor );
    }
    
    @Test
    public void testeColecoesComSet(){
        Set<String> conjunto = new HashSet<>();

        conjunto.add("java");
        conjunto.add("vraptor");
        conjunto.add("scala");
        
        for (String palavra : conjunto) {
          System.out.println(palavra);
        }
    }
    
    @Test
    public void testeSetComIterator(){
        Set<String> conjunto = new HashSet<>();
        conjunto.add("item 1");
        conjunto.add("item 2");
        conjunto.add("item 3");
        
        // retorna o iterator
        Iterator<String> i = conjunto.iterator();
        while (i.hasNext()) {
            // recebe a palavra
            String palavra = i.next();
            System.out.println(palavra);
        }
    }
    
    @Test
    public void testandoOTempoParaAdicionar30000NumerosEmArrayList(){
        System.out.println("Iniciando...");
        Collection<Integer> teste = new ArrayList<>();
        long inicio = System.currentTimeMillis();
        
        int total = 30000;
        
        for (int i = 0; i < total; i++) {
          teste.add(i);
        }
        
        //Aqui esta consulta consome quase muito tempo
        //a consulta e toda a coleção de arrayList leva em torno de 550 m/s
        //se remoer a consulta o metodo tdo leva e torno de 8 m/s
        for (int i = 0; i < total; i++) {
            teste.contains(i);
        }
        
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo);
    }
    
    @Test
    public void testandoOTempoParaAdicionar30000NumerosEmHashSet(){
        System.out.println("Iniciando...");
        Collection<Integer> teste = new HashSet<>();
        long inicio = System.currentTimeMillis();
        
        int total = 30000;
        
        for (int i = 0; i < total; i++) {
          teste.add(i);
        }
        //Aqui esta consulta consome menos tempo em relação a uma arrayList
        //a consulta e toda a coleção de HasSet leva em torno de 15 m/s
        //se remoer a consulta o metodo tdo leva em torno de 9 m/s
        for (int i = 0; i < total; i++) {
            teste.contains(i);
        }
        
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo gasto: " + tempo);
    }
    
    @Test
    public void testandoOTempoParaObter30000NumerosEmLinkedList(){
        System.out.println("Iniciando...");
        long inicio = System.currentTimeMillis();
    
        // trocar depois por ArrayList        
        List<Integer> teste = new LinkedList<>();
        
        //para adicionar elementos à primeira posição o tempo foi em média 8 m/s
        for (int i = 0; i < 30000; i++) {
          teste.add(0, i);
        }
        
         //adicionando o este for, para obter tdos da coleção, o tempo médio vai para 600 m/s
        for (int i = 0; i < 30000; i++) {
          int nu = teste.get(i);
        }
        
        long fim = System.currentTimeMillis();
        long tempo = (fim - inicio);
        System.out.println("Tempo gasto: " + tempo);
    }
    
    @Test
    public void testandoOTempoParaObter30000NumerosEmArrayList(){
        System.out.println("Iniciando...");
        long inicio = System.currentTimeMillis();
    
        // trocar depois por ArrayList        
        List<Integer> teste = new ArrayList<>();
        
        //para adicionar elementos à primeira posição o tempo foi em média 100 m/s
        for (int i = 0; i < 30000; i++) {
          teste.add(0, i);
        }
        
        //adicionando o este for, para obter tdos da coleção, o tempo médio vai para 120 m/s
        for (int i = 0; i < 30000; i++) {
          int nu = teste.get(i);
        }
        
        long fim = System.currentTimeMillis();
        long tempo = (fim - inicio);
        System.out.println("Tempo gasto: " + tempo);
    }
}
