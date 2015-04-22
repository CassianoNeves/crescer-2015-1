import java.util.*;
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa{

    int qtdEmpregados = 0;
    String nome;
    String cnpj;
    Funcionario[] empregados = new Funcionario[10];
    
    public void adiciona( Funcionario f ){
        
        empregados[qtdEmpregados] = f;
        qtdEmpregados++;
    }
    
    public Funcionario[] getEmpregados(){
        return this.empregados;
    }
    
    public String mostraEmpregados(){
        
        StringBuilder string = new StringBuilder();
        
        for( int i = 0; i < qtdEmpregados; i++ ){
            string.append( "Numero: " + (i + 1) + 
                "\nNome: " + empregados[i].getNome() + "\nSalario: " + empregados[i].getSalario() + "\n" );
        }
        
        return string.toString();
    }
}
