
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContaPoupancaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContaPoupancaTest{
    
    @Test
    public void testaOrdenacao(){
        //arrange
        List<ContaPoupanca> contas = new ArrayList<>();
    
        ContaPoupanca c1 = new ContaPoupanca( "Poupanca 1", 1973);
        contas.add(c1);
    
        ContaPoupanca c2 = new ContaPoupanca( "Poupanca 1", 1462);
        contas.add(c2);
    
        ContaPoupanca c3 = new ContaPoupanca( "Poupanca 1", 1854);
        contas.add(c3);
        
        List<ContaPoupanca> esperado = new ArrayList<>();
        esperado.add(c2);
        esperado.add(c3);
        esperado.add(c1);
        //act
        Collections.sort(contas);
        //assert
        assertEquals( esperado, contas );
        
       for (int i = 0; i < contas.size(); i++) {
           System.out.println("numero: " + contas.get(i).getNumero());
        }
        
    }
    
    @Test
    public void testaOrdenacaoComLinkedList(){
        //arrange
        List<ContaPoupanca> contas = new LinkedList<>();
    
        ContaPoupanca c1 = new ContaPoupanca( "Poupanca 1", 1973);
        contas.add(c1);
    
        ContaPoupanca c2 = new ContaPoupanca( "Poupanca 1", 1462);
        contas.add(c2);
    
        ContaPoupanca c3 = new ContaPoupanca( "Poupanca 1", 1854);
        contas.add(c3);
        
        List<ContaPoupanca> esperado = new LinkedList<>();
        esperado.add(c2);
        esperado.add(c3);
        esperado.add(c1);
        //act
        Collections.sort(contas);
        //assert
        assertEquals( esperado, contas );
        
    }
    
    @Test
    public void invertendoAOrderDeUmaLista(){
        //arrange
        List<ContaPoupanca> contas = new ArrayList<>();
    
        ContaPoupanca c1 = new ContaPoupanca( "Poupanca 1", 1973);
        contas.add(c1);
    
        ContaPoupanca c2 = new ContaPoupanca( "Poupanca 1", 1462);
        contas.add(c2);
    
        ContaPoupanca c3 = new ContaPoupanca( "Poupanca 1", 1854);
        contas.add(c3);
        
        List<ContaPoupanca> esperado = new ArrayList<>();
        esperado.add(c3);
        esperado.add(c2);
        esperado.add(c1);
        //act
        Collections.reverse(contas);
        //assert
        assertEquals( esperado, contas );
        
    }
    
     @Test
    public void inserindoSaldoAleatórioEmVariasContas(){
        //arrange
        List<ContaPoupanca> contas = new LinkedList<>();
    
        Random gerador = new Random();
        for( int i =0; i < 10; i++ ){
            contas.add( new ContaPoupanca( "conta", gerador.nextInt(2000) ) );
        }
        
        //act
        //Este metodo enbarralha de forma randomica os objetos.
        Collections.shuffle( contas );
        //assert
        //System.out.println( contas );
        
    }
    
    @Test
    public void rotandoElementosDeUmLista(){
        //arrange
        List<ContaPoupanca> contas = new LinkedList<>();
    
        ContaPoupanca c1 = new ContaPoupanca( "Poupanca 1", 1973);
        contas.add(c1);
    
        ContaPoupanca c2 = new ContaPoupanca( "Poupanca 1", 1462);
        contas.add(c2);
    
        ContaPoupanca c3 = new ContaPoupanca( "Poupanca 1", 1854);
        contas.add(c3);
            
        List<ContaPoupanca> esperado = new ArrayList<>();
        esperado.add(c2);
        esperado.add(c3);
        esperado.add(c1);
        
        //act
        //Este metodo rota os elementos conforme a quantidade recebi no paramentro
        Collections.rotate( contas, 2 );
        //assert
        assertEquals( esperado, contas );
        
    }
}
