package classes;
import java.util.Scanner;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		//consertar
		private static SimpleDataFormat formatadata = new SimpleDataFormat("dd/mm/yyyy");
		Scanner entrada = new Scanner(System.in);
		System.out.print("Qual o seu nome?");
		String nome = entrada.nextLine();
		System.out.print("Qual a data de licença do seu documento?");
		String dataLicenca = entrada.nextLine();
		//Converter String para Date
		Date data = formataData.parse(dataLicenca);
		entrada.close();
		Cliente cliente1 = new Cliente(nome, "Unicamp", data, "Pós-Doutorado", "Feminino", "A");
		Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA", 2017);
		ClientePF clientePF1 = new ClientePF(nome, "Unicamp", data, "Pós-Doutorado", "Feminino", "A", "124.356.743-29", data);
		ClientePJ clientePJ1 = new ClientePJ (nome, "Unicamp", data, "Pós-Doutorado", "Feminino", "A", "19012389.0001-89", data);
		Seguradora seguradora1 = new Seguradora("Alfa", "91234-5678", "alfa@gmail.com", "Campinas");
		Sinistro sinistro1 = new Sinistro("01/01/23", "Campinas", seguradora1, veiculo1, cliente1);
		cliente1.addVeiculo(veiculo1);
		Cliente cliente2 = new Cliente("Edson", "USP", data, "Mestrado", "Masculino", "B");
		ClientePF clientePF2 = new ClientePF("Edson", "USP", data, "Mestrado", "Masculino", "B", "385.575.678-39", data);
		ClientePJ clientePJ2 = new ClientePJ ("Edson", "USP", data, "Mestrado", "Masculino", "B", "19012389.0001-89", data);
		boolean verificaCPF = clientePF1.validarCPF(clientePF1.getCpf());
		boolean verificaCPF2 = clientePF2.validarCPF(clientePF2.getCpf());
		// Print
		System.out.println(cliente1);
		System.out.println(cliente2);
		System.out.println(clientePF1);
		System.out.println(clientePF2);
		System.out.println(clientePJ1);
		System.out.println(clientePJ2);
		System.out.println(seguradora1);
		System.out.println(veiculo1);
		System.out.println(sinistro1);
		System.out.println(verificaCPF + "\n");
		System.out.println(verificaCPF2);
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
