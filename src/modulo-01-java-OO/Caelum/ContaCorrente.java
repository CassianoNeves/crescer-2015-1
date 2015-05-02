
/**
 * Write a description of class ContaCorrente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContaCorrente extends Conta implements Comparable<ContaCorrente>{

    private double saldo = 0;
    
    public ContaCorrente( String nomeCliente, int numero ){
        super( nomeCliente, numero );
    }
    
    public void deposita( double valor ){
        this.saldo += valor;
    }
    
    public int compareTo(ContaCorrente outra) {
    if (this.saldo < outra.saldo) {
      return -1;
    }

    if (this.saldo > outra.saldo) {
      return 1;
    }

    return 0;
  }
}
