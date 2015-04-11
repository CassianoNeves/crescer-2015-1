
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        Orc orc = new Orc();
        // Act
        elfoVerde.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfoVerde.getExperiencia());
        assertEquals(flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        Orc orc = new Orc();
        // Act
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 4;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfoVerde.getExperiencia());
        assertEquals(flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        ElfoVerde elfoVerde = new ElfoVerde("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 10;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfoVerde.getExperiencia());
        assertEquals(flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test
    public void filtrandoItensQueElfoVerdeRecebe(){
        //arrange
        ElfoVerde elfoVerde = new ElfoVerde("cassiano");
        ItemDoInventario item1 = new ItemDoInventario("Espada de aço valariano", 2);
        ItemDoInventario item2 = new ItemDoInventario("Arco e Flecha de vidro", 2);
        //act
        elfoVerde.addItem(item1);
        elfoVerde.addItem(item2);
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<>();
        resultadoEsperado.add(item1);
        resultadoEsperado.add(item2);
        
        assertEquals(resultadoEsperado, elfoVerde.getItens());
    }
    
    @Test
    public void filtrandoItensQueElfoVerdeRecebeComItemInvalido(){
        //arrange
        ElfoVerde elfoVerde = new ElfoVerde("cassiano");
        ItemDoInventario item1 = new ItemDoInventario("Espada de aço valariano", 2);
        ItemDoInventario item2 = new ItemDoInventario("", 2);
        //act
        elfoVerde.addItem(item1);
        elfoVerde.addItem(item2);
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<>();
        resultadoEsperado.add(item1);
        
        assertEquals(resultadoEsperado, elfoVerde.getItens());
    }
    
    @Test
    public void filtrandoItensQueElfoVerdeRecebeComItemInvalido2(){
        //arrange
        ElfoVerde elfoVerde = new ElfoVerde("cassiano");
        ItemDoInventario item1 = new ItemDoInventario("", 2);
        ItemDoInventario item2 = new ItemDoInventario("Arco e Flecha de vidro", 2);
        //act
        elfoVerde.addItem(item1);
        elfoVerde.addItem(item2);
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<>();
        resultadoEsperado.add(item2);
        
        assertEquals(resultadoEsperado, elfoVerde.getItens());
    }
}
