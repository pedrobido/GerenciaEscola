/**
 * Controller para a classe professor
 * @author pbido
 * @since 17/02/2020
 * @version 0.1
 */

package controller;

import model.Professor;

public class ProfessorController {
	public void testeProfessor() {
		Professor professor = new Professor();
		professor.setNome("João");
		professor.setCpf("123.456.789-01");
		professor.setSalario(9.675);
		professor.setMateria("Física Clássica");
		professor.exibe();
	}
}
