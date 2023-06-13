package classes;

public enum SubMenu {
	CADASTRAR_CLIENTE ("Novo Cliente"),
	CADASTRAR_CONDUTOR("Novo Condutor"),
	CADASTRAR_VEICULO ("Novo Veículo"),
	CADASTRAR_FROTA ("Nova Frota"),
	CADASTRAR_SEGURADORA ("Nova Seguradora"),
	LISTAR_CLIENTE ("Listar Cliente por Seguradora"),
	LISTAR_CONDUTOR ("Listar Condutor por Seguro"),
	LISTAR_SEGURO_SEG ("Listar Sinistros por Seguradora"),
	LISTAR_SINISTRO_CONDUTOR ("Listar Sinistros por Cliente"),
	LISTAR_VEICULO_CLIENTEPF ("Listar Veículos por Cliente"),
	LISTAR_FROTA_CLIENTEPJ ("Listar Frotas por Cliente"),
	LISTAR_VEICULO_SEG ("Listar Veículos por Seguradora"),
	EXCLUIR_CLIENTE ("Excluir Cliente"),
	EXCLUIR_CONDUTOR ("Excluir Condutor de Seguro"),
	EXCLUIR_VEICULO ("Excluir Veiculo"),
	EXCLUIR_VEICULO_FROTA ("Excluir Veículo de Frota"),
	EXCLUIR_FROTA ("Excluir Frota"),
	EXCLUIR_SINISTRO ("Excluir Sinistro"),
	VOLTAR ("Voltar");
	
	private final String operacao;
	
	SubMenu (String operacao) {
		this.operacao = operacao;
	}
	
	public String getOperacao () {
		return this.operacao;
	}
}