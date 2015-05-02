import java.util.*;
/**
 * Write a description of class Conta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Conta{

    protected int numero;
    protected String nomeCliente;
    
    public Conta( String nome, int numero ){
        this.numero = numero;
        this.nomeCliente = nome;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public String getNome(){
        return this.nomeCliente;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        System.out.println(result);
        return result;
    }

    public boolean equals(Object obj) {
		Conta outra = (Conta) obj;
		System.out.println("aqui");
        if (numero == outra.numero)
			return true;

		return false;
	}
    
    
}
