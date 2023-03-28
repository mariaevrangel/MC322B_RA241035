package classes;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nome = entrada.next();
		Cliente cliente1 = new ClientePF("Esther", "385.575.678-38", "22/03/2023", 1, "Unicamp");
		Cliente cliente2 = new ClientePF("Edson", "385.575.678-39", "21/03/2023", 1, "Instituto de Computação");
		Seguradora seguradora1 = new Seguradora("Alfa", "91234-5678", "alfa@gmail.com", "Campinas");
		Sinistro sinistro1 = new Sinistro("01/01/23", "Campinas");
		Sinistro sinistro2 = new Sinistro("02/01/23", "São Paulo");
		Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA");
		boolean verificaCPF = cliente1.validarCPF(cliente1.getCpf());
		boolean verificaCPF2 = cliente1.validarCPF(cliente2.getCpf());
		// Print
		System.out.print(cliente1);
		System.out.print(cliente2);
		System.out.print(seguradora1);
		System.out.print(sinistro1);
		System.out.print(sinistro2);
		System.out.print(veiculo1);
		System.out.print(verificaCPF + "\n");
		System.out.print(verificaCPF2);
		// Remover 1 Cliente pf e 1 Cliente pj
		// chamar validarcpf e validarCNPJ
		// adicionar pelo menos 1 veiculo em cada cliente instanciado
		// instanciar pelo menos 1 objeto na seguradora
		// cadastrar pelo menos 2 clientes em uma seguradora, 1pf e 1pj
		// gerar pelo menos um sinistro
		// chamar tostring de cada classe
		// chamar listarClientes, visualizarSinistro, e listarSinistros da seguradora
		// implementar e chamar um metodo que faca leitura de dados usando a funcao system.in
		// esse imput deve exibir um conteudo na tela (ex: menu textual que liste opcoes para
		// visualizar certos dados da seguradora)
	}
	
}
