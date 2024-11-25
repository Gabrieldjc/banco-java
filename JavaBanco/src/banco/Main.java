package banco;

public class Main {

	public static void main(String[] args) {
		
		Cliente marcio = new Cliente();
		marcio.nome = "Márcio";
		
		Conta cc1 = new ContaCorrente(marcio);
		Conta cc3 = new ContaPoupanca(marcio);
		
		Cliente ana = new Cliente();
		ana.nome = "Ana";
		
		Conta cc2 = new ContaCorrente(ana);
		Conta cc4 = new ContaPoupanca(ana);
		

		cc1.depositar(100);
		cc2.depositar(250);
		
		cc1.imprimirExtrato();
		System.out.println("-------------------");
		cc2.imprimirExtrato();
		
		cc1.transferir(10, cc2);
		
		System.out.println("-------------------");
		
		cc1.imprimirExtrato();
		System.out.println("-------------------");
		cc2.imprimirExtrato();
		System.out.println("-------------------");
		
		cc3.depositar(400);
		cc4.depositar(360);
		
		cc4.transferir(70, cc3);
		
		cc3.imprimirExtrato();
		System.out.println("-------------------");
		cc4.imprimirExtrato();
		

	}

}
