/**
 * Classe modelo de professor que herda funcionário
 * @author pbido
 * @since 17/02/2020
 * @version 0.1
 */

package model;

public class Professor extends Funcionario {
	private String materia = "";

	public Professor() {
		System.out.println("Professor Criado");
	}

	public Professor(String materia) {
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public void exibe() {
		super.exibe();
		System.out.println("Matéria do professor: " + materia);
	}
}
