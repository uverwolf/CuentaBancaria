package com.uverwolf.banco;

public class Test {
 public static void main(String[] args) {
	BankAccount n1 = new BankAccount();
	BankAccount n2 = new BankAccount();
	BankAccount n3 = new BankAccount();
	
	n1.deposito(2, 100);
	n2.deposito(1, 500);
	n3.deposito(1, 200);
	
	n1.giro(2, 50);
	n3.giro(1, 500000000);
	System.out.println(n1.getSaldoCuentaAhorro());
	System.out.println("La cuenta corriente numero: "+n2.getNumeroCuenta()+" tiene actualmente: "+n2.getSaldoCuentaCorriente());
	BankAccount.getMontoTotal();
	BankAccount.getContadorCuentas();
}
}
