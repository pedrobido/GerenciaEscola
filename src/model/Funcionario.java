/**
 * Classe modelo de funcionário
 * @author pbido
 * @since 17/02/2020
 * @version 0.1
 */

package model;

public class Funcionario {
	private int id;
	private String nome;
	private String cpf;
	private double salario;

	public Funcionario() {
		System.out.println("Funcionário Criado");
	}

	public Funcionario(int id, String nome, String cpf, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void exibe() {
		System.out.println("Nome do funcionário: " + nome);
		System.out.println("CPF do funcionário: " + cpf);
		System.out.println("Salário do funcionário: " + salario);
	}
}