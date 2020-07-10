package com.uverwolf.banco;
import java.util.Random;
public class BankAccount {
	private String numeroCuenta;
	private double saldoCuentaCorriente;
	private double saldoCuentaAhorro;
	private static int contadorCuentas=0;
	private static int montoTotal;
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}

	public void setSaldoCuentaCorriente(double saldoCuentaCorriente) {
		this.saldoCuentaCorriente = saldoCuentaCorriente;
	}

	public double getSaldoCuentaAhorro() {
		return saldoCuentaAhorro;
	}

	public void setSaldoCuentaAhorro(double saldoCuentaAhorro) {
		this.saldoCuentaAhorro = saldoCuentaAhorro;
	}

	public static void getContadorCuentas() {
		System.out.println("La cantidad de cuentas actuales en el sistem es: "+contadorCuentas);
		
	}

	public static void setContadorCuentas(int contadorCuentas) {
		BankAccount.contadorCuentas = contadorCuentas;
	}

	public static void getMontoTotal() {
		System.out.println("El monto total acumulado entre todas las cuentas es: "+montoTotal);
		
	}

	public static void setMontoTotal(int monto,int tipo ) {
		if(tipo==1) {
			BankAccount.montoTotal += monto;
		}else {
			BankAccount.montoTotal -= monto;
		}
			
	}
	public BankAccount() {
	this.numeroCuenta = ""+generadorNumeroCuenta();
	contadorCuentas++;
	}
	
	public long generadorNumeroCuenta() {
		Random rand = new Random();
		long drand = (long)(rand.nextDouble()*10000000000L);
		return drand ;
	}
	
	public void deposito(int tipo,int monto) {
		switch (tipo) {
		case 1:
			System.out.println("Se depositaron: "+monto+" correctamente en tu cuenta corriente.");
			this.setSaldoCuentaCorriente(this.getSaldoCuentaCorriente()+monto);
			setMontoTotal(monto,1);
			
			break;
		case 2:
			System.out.println("Se depositaron: "+monto+" correctamente en tu cuenta de ahorros.");
			this.setSaldoCuentaAhorro(this.getSaldoCuentaAhorro()+monto);
			setMontoTotal(monto,1);
			break;

		default:
			break;
		}		
	}
	/** @param  */
	public void giro (int tipo, int monto) {
		switch (tipo) {
		case 1:
			if(this.getSaldoCuentaCorriente()<monto) {
				System.out.println("Saldo insuficiente para realizar el giro");
			}else {
				System.out.println("Giraste correctamente: "+monto+" desde tu cuenta corriente");
				this.setSaldoCuentaCorriente(this.getSaldoCuentaCorriente()-monto);
				setMontoTotal(monto, 2);
			}
			break;
		case 2:
			if(this.getSaldoCuentaAhorro()<monto) {
				System.out.println("Saldo insuficiente para realizar el giro");
			}else {
				System.out.println("Giraste correctamente: "+monto+" desde tu cuenta de ahorros");
				this.setSaldoCuentaAhorro(this.getSaldoCuentaAhorro()-monto);
				setMontoTotal(monto, 2);
			}
			break;

		default:
			break;
		}
	}
}
