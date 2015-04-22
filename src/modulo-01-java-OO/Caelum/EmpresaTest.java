

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EmpresaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EmpresaTest{
    
    @Test
    public void adicionandoUmFuncionarioAUmaEmpresa(){
        //arrange
        Funcionario f = new Funcionario( "Cassiano" );
        
        Empresa empresa = new Empresa();
        
        Funcionario[] esperado = new Funcionario[10];
        esperado[0] = f;
        //act
        empresa.adiciona( f );
        //assert
        assertEquals( esperado, empresa.getEmpregados() );
    }
    
    @Test
    public void adicionandoVariosFuncionariosAUmaEmpresa(){
        //arrange
        Funcionario f1 = new Funcionario( "Cassiano" );
        Funcionario f2 = new Funcionario( "Cassiano" );
        Funcionario f3 = new Funcionario( "Cassiano" );
        Funcionario f4 = new Funcionario( "Cassiano" );
        Funcionario f5 = new Funcionario( "Cassiano" );

        
        Empresa empresa = new Empresa();
        
        Funcionario[] esperado = new Funcionario[10];
        esperado[0] = f1;
        esperado[1] = f2;
        esperado[2] = f3;
        esperado[3] = f4;
        esperado[4] = f5;
        //act
        empresa.adiciona( f1 );
        empresa.adiciona( f2 );
        empresa.adiciona( f3 );
        empresa.adiciona( f4 );
        empresa.adiciona( f5 );
        //assert
        assertEquals( esperado, empresa.getEmpregados() );
    }
    
    @Test
    public void imprimindoInformacoesSobreEmpregados(){
        //arrange
        Empresa empresa = new Empresa();
        
        Funcionario f1 = new Funcionario( "Cassiano" );
        f1.setSalario( 1000 );
        Funcionario f2 = new Funcionario( "Joao" );
        f2.setSalario( 1500 );
        
        empresa.adiciona( f1 );
        empresa.adiciona( f2 );
        
        String esperado = "Numero: 1\nNome: Cassiano\nSalario: 1000\nNumero: 2\nNome: Joao\nSalario: 1500\n";
        //act
        String obtido = empresa.mostraEmpregados();
        //assert
        
        assertEquals( esperado, obtido);
    }

}
