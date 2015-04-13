

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class ElfosNoturnosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
   @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        ElfoNoturno elfoNoturno = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        elfoNoturno.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 3;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfoNoturno.getExperiencia());
        assertEquals(flechasEsperadas, elfoNoturno.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        ElfoNoturno elfoNoturno = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        elfoNoturno.atirarFlecha(orc);
        elfoNoturno.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 6;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfoNoturno.getExperiencia());
        assertEquals(flechasEsperadas, elfoNoturno.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        ElfoNoturno elfoNoturno = new ElfoNoturno("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfoNoturno.atirarFlecha(orc);
        elfoNoturno.atirarFlecha(orc);
        elfoNoturno.atirarFlecha(orc);
        elfoNoturno.atirarFlecha(orc);
        elfoNoturno.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 15;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfoNoturno.getExperiencia());
        assertEquals(flechasEsperadas, elfoNoturno.getFlechas());
    }
    
    @Test
    public void filtrandoItensQueElfoVerdeRecebe(){
        //arrange
        ElfoNoturno elfoNoturno = new ElfoNoturno("cassiano");
        ItemDoInventario item1 = new ItemDoInventario("Espada de aço valariano", 2);
        ItemDoInventario item2 = new ItemDoInventario("Arco e Flecha de vidro", 2);
        //act
        elfoNoturno.addItem(item1);
        elfoNoturno.addItem(item2);
        //assert
        ArrayList<ItemDoInventario> resultadoEsperado = 
            new ArrayList<>();
        resultadoEsperado.add(item1);
        resultadoEsperado.add(item2);
        
        assertEquals(resultadoEsperado, elfoNoturno.getItens());
    }
    
    
}
