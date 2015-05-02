
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AlgunsExercicios.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AlgunsExercicios{

    @Test
    public void ordenandoDeOrdemDescrescenteUmTreeSet(){
        //arrange
        
        TreeSet<Integer> teste = new TreeSet<>();
        TreeSet<Integer> esperado = new TreeSet<>();
        
        for (int i = 0; i < 1000; i++) {
          teste.add(i);
        }
        
        for ( int i = 999; i >= 0; i-- ) {
          esperado.add(i);
        }
        
        Iterator<Integer> iterator;
        //acr
        iterator = teste.descendingIterator();
        while( iterator.hasNext() ){
            int proximo = iterator.next();
            
            teste.add( proximo );
        }
        //assert
        assertEquals( esperado, teste );
    }
    
    @Test
    public void ordenandoDeOrdemDescrescenteUmArrayList(){
        //arrange
        
        ArrayList<Integer> teste = new ArrayList<>();
        ArrayList<Integer> esperado = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
          teste.add(i);
        }
        
        for ( int i = 4; i >= 0; i-- ) {
          esperado.add(i);
        }
        
        
        //acr
        for( int i = 0; i < teste.size(); i++ ){
            for( int j = 1; j < teste.size(); j++ ){
                
                int atual = teste.get( j );
                int anterior = teste.get( j - 1 );
                
                boolean trocar = atual > anterior;
                
                if( trocar ){
                    teste.set( j - 1, atual );
                    teste.set( j, anterior );
                }
            }
        }

        //assert
        assertEquals( esperado, teste );
    }
}
