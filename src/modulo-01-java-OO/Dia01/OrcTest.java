import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);

    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("cassiano");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void adicionadoItemAoOrc(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        //act
        orc.addItemParaOrc(machado);
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<ItemDoInventario>();
        resultadoEsperado.add(machado);
        
        assertEquals(resultadoEsperado, orc.getItens());
    }
    
    @Test
    public void adicionadoItesAoOrc(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        ItemDoInventario espada = new ItemDoInventario("espada", 2);
        ItemDoInventario escudo = new ItemDoInventario("escudo", 3);
        //act
        orc.addItemParaOrc(machado);
        orc.addItemParaOrc(espada);
        orc.addItemParaOrc(escudo);
        //assert
      ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<ItemDoInventario>();
            
        resultadoEsperado.add(machado);
        resultadoEsperado.add(espada);
        resultadoEsperado.add(escudo);
            
        assertEquals(resultadoEsperado, orc.getItens());
    }
    
    @Test
    public void umOrcPerdeItem(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<ItemDoInventario>();
        //act
        orc.addItemParaOrc(machado);
        orc.removeItemDoOrc(machado);
        //assert
      
        assertEquals(resultadoEsperado, orc.getItens());
    }
    
    @Test
    public void obterNomeDosItemDoOrc(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        ItemDoInventario espada = new ItemDoInventario("espada", 1);
        ItemDoInventario escudo = new ItemDoInventario("escudo", 1);
        
        
        //act
        orc.addItemParaOrc(machado);
        orc.addItemParaOrc(espada);
        orc.addItemParaOrc(escudo);
        //assert
        String resultadoEsperado = "machado, espada, escudo";
        
        assertEquals(resultadoEsperado, orc.imprimirNomesDosSeusObjetos());
    }
    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.setStatus(Status.DORMINDO);
        urukhai.setExperiencia(3);
        urukhai.addItemParaOrc(new ItemDoInventario("Poção de mana", 3));
        urukhai.addItemParaOrc(new ItemDoInventario("Poção Lança", 1));
        // Act
        urukhai.tentarSorte();
        // Assert
        
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(1003, pocao.getQuantidade());
        assertEquals(1001, lanca.getQuantidade());
    }
    
    @Test
    public void orcTentarSorteNaoFazNada() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.addItemParaOrc(new ItemDoInventario( "Poção de mana", 3 ));
        urukhai.addItemParaOrc(new ItemDoInventario( "Poção Lança",1 ));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(3, pocao.getQuantidade());
        assertEquals(1, lanca.getQuantidade());
    }
    
    @Test
    public void orcPegarOMaiorObjetoSemTerItens(){
        //arrange
        Orc orc = new Orc("cassiano");
        //act
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        //assert
        assertEquals(null, resutladoObtido);
    }
    
    @Test
    public void pegarOMaiorObjetoDeUmOrcCom1Item(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 2);
        //act
        orc.addItemParaOrc(machado);
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        //assert
        assertEquals(machado, resutladoObtido);
    }
    
    @Test
    public void pegarOMaiorObjetoDeUmOrc(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 2);
        ItemDoInventario escudo = new ItemDoInventario("escudo", 5);
        ItemDoInventario espada = new ItemDoInventario("espada", 20);
        ItemDoInventario tijolo = new ItemDoInventario("tijolo", 3);
        ItemDoInventario faca = new ItemDoInventario("faca", 7);
        //act
        orc.addItemParaOrc(machado);
        orc.addItemParaOrc(escudo);
        orc.addItemParaOrc(espada);
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        //assert
        assertEquals(espada, resutladoObtido);
    }
    
    @Test
    public void orcPegarOMaiorObjetoComQuantidadesIguais(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 3);
        ItemDoInventario escudo = new ItemDoInventario("escudo", 3);
        ItemDoInventario espada = new ItemDoInventario("espada", 3);
        //act
        orc.addItemParaOrc(machado);
        orc.addItemParaOrc(escudo);
        orc.addItemParaOrc(espada);
        
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        
        //assert
        assertEquals(espada, resutladoObtido);
    }
    
    
}




