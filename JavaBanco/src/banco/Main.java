package banco;

import java.util.Scanner;

public class Main extends Investimentos {

	public static void main(String[] args) {
		
		Cliente marcio = new Cliente();
		marcio.nome = "Márcio";
		
		Conta cc1 = new ContaCorrente(marcio);
		Conta cc3 = new ContaPoupanca(marcio);
		
		Cliente ana = new Cliente();
		ana.nome = "Ana";
		
		Conta cc2 = new ContaCorrente(ana);
		Conta cc4 = new ContaPoupanca(ana);
		
		Cliente julio = new Cliente();
		julio.nome = "Júlio";
		
		Conta cc5 = new ContaCorrente(julio);
		Conta cc6 = new ContaPoupanca(julio);

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
		
		System.out.println("-------------------");
		
		cc5.depositar(140);
		cc6.depositar(90);
		
		cc5.imprimirExtrato();
		System.out.println("-------------------");
		cc6.imprimirExtrato();
		
		
		System.out.println();
		//simulando a quantidade de clientes do Banco
		System.out.println("Quantidade de clientes: " + Cliente.getQtdClientes());
		System.out.println();
		
		Main menu = new Main();
		menu.simulacao();
	}
	
	public void simulacao() {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha o tipo de investimento: ");
		System.out.println("1 - InvestimentoA");
		System.out.println("2 - InvestimentoB");
		System.out.println("0 - Sair");
		
		int opcao = scanner.nextInt();
		
		
		switch(opcao) {
		case 1:
			
			System.out.println("Digite o valor a ser investido");
			
			double valorA = scanner.nextDouble();
			System.out.print(String.format("Valor investido: R$ %.2f", investimentoA(valorA)));
		
			System.out.println("\n\nDigite o número de meses que deseja simular para o dinheiro ficar investido");
			
			int mesesA = scanner.nextInt();
			
			if(mesesA >= 1 && mesesA <= 6) {
				impostoRenda = valorA * porcentagemRendimentoMensal * mesesA * 0.225;
			} else if (mesesA > 6 && mesesA <= 12) {
				impostoRenda = valorA * porcentagemRendimentoMensal * mesesA * 0.200;
			} else if (mesesA > 12 && mesesA <= 24) {
				impostoRenda = valorA * porcentagemRendimentoMensal * mesesA * 0.175;
			} else if (mesesA > 24) {
				impostoRenda = valorA * porcentagemRendimentoMensal * mesesA * 0.150;
			} else {
				System.out.println("O número de meses investidos deve ser 1 ou mais.");
			}
			
			
			
			double rendimentoMensal = valorA * porcentagemRendimentoMensal * mesesA;
			double valorMensal = rendimentoMensal - impostoRenda;
			double saldoBrutoTotal = valorA + rendimentoMensal;
			double saldoLiquidoTotal = valorA + valorMensal;
			
			System.out.println(String.format("Rendimento bruto ao final de %d mes(es) investido(s): R$ %.2f", mesesA, rendimentoMensal));
			System.out.println(String.format("Rendimento líquido ao final de %d mes(es) investido(s): R$ %.2f", mesesA, valorMensal));
			System.out.println(String.format("Saldo bruto total ao final de %d mes(es) investido(s): R$ %.2f", mesesA, saldoBrutoTotal));
			System.out.println(String.format("Saldo líquido total ao final de %d mes(es) investido(s): R$ %.2f", mesesA, saldoLiquidoTotal));
			break;
			
		case 2:
			
			System.out.println("Digite o valor a ser investido");
			
			double valorB = scanner.nextDouble();
			System.out.println(String.format("Valor investido: R$ %.2f", investimentoB(valorB)));
			
			System.out.println("\n\nDigite o número de meses que deseja simular para o dinheiro ficar investido");
			
			int mesesB = scanner.nextInt();
			
			if(mesesB > 0) {
				impostoRenda = 0;
			} else {
				System.out.println("O número de meses investidos deve ser 1 ou mais");
			}
			
			double rendimentoMensalB = valorB * 0.005 * mesesB + (0.0017 * valorB);
			double valorLiquidoMensalB = valorB + rendimentoMensalB;
			
			System.out.println(String.format("Rendimento mensal ao final de %d mes(es) investido(s): R$ %.2f", mesesB, rendimentoMensalB));
			System.out.println(String.format("Saldo líquido total ao final de %d mes(es) investido(s): R$ %.2f", mesesB, valorLiquidoMensalB));
			break;
			
		case 0:
			System.out.println("Saindo");	
		}
		scanner.close();
	}
}


	

	
