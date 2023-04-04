package classes;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nome = entrada.next();
		// Como declarar a lista aqui?
		Cliente cliente1 = new Cliente("Esther", "Unicamp", "04/04/2023", "Pós-Doutorado", "Feminino", "A", []);
		Cliente cliente2 = new Cliente("Edson", "USP", "03/04/2023", "Mestrado", "Masculino", "B" , []);
		ClientePF clientePF1 = new ClientePF(cliente1, "124.356.743-29", "12/02/1990");
		ClientePF clientePF2 = new ClientePF(cliente2, "385.575.678-39", "17/06/2000");
		//Converter String para Date
		ClientePJ clientePJ1 = new ClientePJ (cliente1, "19012389.0001-89", "23/06/2019");
		ClientePJ clientePJ2 = new ClientePJ (cliente2, "19012389.0001-89", "23/08/2022");
		Seguradora seguradora1 = new Seguradora("Alfa", "91234-5678", "alfa@gmail.com", "Campinas", [], []);
		Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA", 2017);
		Sinistro sinistro1 = new Sinistro("01/01/23", "Campinas", seguradora1, veiculo1, cliente1);
		boolean verificaCPF = clientePF1.validarCPF(clientePF1.getCpf());
		boolean verificaCPF2 = clientePF2.validarCPF(clientePF2.getCpf());
		// Print
		System.out.print(cliente1);
		System.out.print(cliente2);
		System.out.print(clientePF1);
		System.out.print(clientePF2);
		System.out.print(clientePJ1);
		System.out.print(clientePJ2);
		System.out.print(seguradora1);
		System.out.print(veiculo1);
		System.out.print(sinistro1);
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
