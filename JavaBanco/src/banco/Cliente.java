package banco;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
