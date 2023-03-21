package classes;

public class MainLabUm {
	public static void mainLabUm(String[] args) {
		Cliente cliente1 = new Cliente("Esther", "123.987.456-00", "22/03/23", 1, "unicamp");
		Seguradora seguradora1 = new Seguradora("Edson", "1234-56789", "edson.borin@gmail.com", "ic");
		Sinistro sinistro1 = new Sinistro(sinistro1.idGenerator(), "01/01/23", "campinas");
		Veiculo veiculo1 = new Veiculo("ABC1023", "mercedes", "gla");
		// Print
		System.out.print(cliente1.toString());
		System.out.print(seguradora1.toString());
		System.out.print(sinistro1.toString());
		System.out.print(veiculo1.toString());
	}
	
	//tag para lab
	
	//instalacao de objetos
}
