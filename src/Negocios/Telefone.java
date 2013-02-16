package Negocios;

public class Telefone {

	private String codigo;
	private String descricao;
	private int idFuncionario;
	
	public Telefone(String codigo, String descricao, int idFuncionario) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setIdFuncionario(idFuncionario);
	}
	public Telefone() {
		this.codigo = "";
		this.descricao = "";
		this.idFuncionario = -1;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
	
}
