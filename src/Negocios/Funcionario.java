package Negocios;

public class Funcionario {

	private int id = 0; // serial
	private String nome;
	private String cpf;
	
	public Funcionario(String nome, String cpf) {
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
		id++;
	}
	public Funcionario() {
		this.setId(id);
		this.setNome("");
		this.setCpf("");
		id++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
