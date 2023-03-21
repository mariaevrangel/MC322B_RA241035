package classes;

public class MainLabUm {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Esther", "385.575.678-38", "22/03/2023", 1, "unicamp");
		Seguradora seguradora1 = new Seguradora("Alfa", "91234-5678", "alfa@gmail.com", "Campinas");
		Sinistro sinistro1 = new Sinistro("01/01/23", "Campinas");
		Sinistro sinistro2 = new Sinistro("02/01/23", "São Paulo");
		Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA");
		boolean verificaCPF = cliente1.validarCPF(cliente1.getCpf());
		// Print
		System.out.print(cliente1);
		System.out.print(seguradora1);
		System.out.print(sinistro1);
		System.out.print(sinistro2);
		System.out.print(veiculo1);
		System.out.print(verificaCPF);
	}
	
	//tag para lab
	//arrumar verifica cpf
}
