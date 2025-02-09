package banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	//Contador para obter a quantidade de clientes do Banco
	public static int quantidadeClientes = 0;
	
	public Cliente() {
		quantidadeClientes++;
	}
	
	public static int getQtdClientes() {
		return quantidadeClientes;
	}

	String nome;

	
}
