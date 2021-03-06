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
    private final double DELTA = 0.005;
    
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("cassiano");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);
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
        double resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido, DELTA);

    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110.0";
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
        String esperado = "Vida atual: 100.0";
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
        String esperado = "Vida atual: 0.0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void adicionadoItemAoOrc(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        //act
        orc.addItem(machado);
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
        orc.addItem(machado);
        orc.addItem(espada);
        orc.addItem(escudo);
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
        orc.addItem(machado);
        orc.removeItem(machado);
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
        orc.addItem(machado);
        orc.addItem(espada);
        orc.addItem(escudo);
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
        urukhai.addItem(new ItemDoInventario("Poção de mana", 3));
        urukhai.addItem(new ItemDoInventario("Poção Lança", 1));
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
        urukhai.addItem(new ItemDoInventario( "Poção de mana", 3 ));
        urukhai.addItem(new ItemDoInventario( "Poção Lança",1 ));
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
        orc.addItem(machado);
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
        orc.addItem(machado);
        orc.addItem(escudo);
        orc.addItem(espada);
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
        orc.addItem(machado);
        orc.addItem(escudo);
        orc.addItem(espada);
        
        ItemDoInventario resutladoObtido = orc.getItemComMaiorQuantidade();
        
        //assert
        assertEquals(espada, resutladoObtido);
    }
    
    @Test
    public void orcOrdenandoInventarioSemItens(){
        //arrange
        Orc orc = new Orc("cassiano");
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<>();
        //act 
        orc.ordernarItem();
        //assert
        assertEquals(resultadoEsperado, orc.getItens() );
        
    }
    
    @Test
    public void orcOrdenandoInventarioComUmItem(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        //act 
        orc.addItem(machado);
        orc.ordernarItem();
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(machado);
        assertEquals(resultadoEsperado, orc.getItens() );
        
    }
    
    @Test
    public void orcOrdenandoSeusItensPorQuantidadeAscendente(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        ItemDoInventario escudo = new ItemDoInventario("escudo", 2);
        ItemDoInventario pedra = new ItemDoInventario("pedra", 3);
        ItemDoInventario espada = new ItemDoInventario("espada", 4);
        ItemDoInventario nada = new ItemDoInventario("nada", 5);
        //act
        orc.addItem(nada);
        orc.addItem(espada);
        orc.addItem(pedra);
        orc.addItem(escudo);
        orc.addItem(machado);
        orc.ordernarItem();
        //assert
        Orc orctest = new Orc("jaoao");
        
        orctest.addItem(machado);
        orctest.addItem(escudo);
        orctest.addItem(pedra);
        orctest.addItem(espada);
        orctest.addItem(nada);

        
        
        assertEquals(orctest.getItens(), orc.getItens() );
        
    }
    
    @Test
    public void orcOrdenandoSeusItensPorQuantidadeAscendenteComItensNegativos(){
        //arrange
        Orc orc = new Orc("cassiano");
        ItemDoInventario machado = new ItemDoInventario("machado", 1);
        ItemDoInventario escudo = new ItemDoInventario("escudo", 2);
        ItemDoInventario pedra = new ItemDoInventario("pedra", -1);
        ItemDoInventario espada = new ItemDoInventario("espada", 4);
        ItemDoInventario nada = new ItemDoInventario("nada", 5);
        //act
        orc.addItem(nada);
        orc.addItem(espada);
        orc.addItem(pedra);
        orc.addItem(escudo);
        orc.addItem(machado);
        orc.ordernarItem();
        //assert
        Orc orctest = new Orc("jaoao");
        
        orctest.addItem(pedra);
        orctest.addItem(machado);
        orctest.addItem(escudo);
        orctest.addItem(espada);
        orctest.addItem(nada);

        
        
        assertEquals(orctest.getItens(), orc.getItens() );
        
    }
    
    
    
    
    
}