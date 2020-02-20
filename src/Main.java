
/**
 * Classe main para o método main
 * @author pbido
 * @since 17/02/2020
 * @version 0.1
 */

import javax.swing.UIManager;

import view.AlunoView;
import view.MenuView;

public class Main {// Inicio do método main

	public static void main(String[] args) {
//		ProfessorController professorController = new ProfessorController();
//		professorController.testeProfessor();
//		AlunoController alunoController = new AlunoController();
//		alunoController.inserirAluno();
//		alunoController.listarTodos();
//		alunoController.listarAniversariantes(02);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		new MenuView();
	}

}// Fim do método main
