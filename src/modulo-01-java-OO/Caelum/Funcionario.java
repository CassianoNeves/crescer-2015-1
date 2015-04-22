
/**
 * Write a description of class Funcionario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Funcionario{

    private String nome;
    private int salario;
    
    public Funcionario( String nome ){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getSalario(){
        return this.salario;
    }
    
    public void setNome( String nome ){
        this.nome = nome;
    }
    
    public void setSalario( int salario ){
        this.salario = salario;
    }
}
