
/**
 * Classe main para o m�todo main
 * @author pbido
 * @since 17/02/2020
 * @version 0.1
 */

import javax.swing.UIManager;

import controller.AlunoController;
import view.MenuView;

public class Main {// Inicio do m�todo main

	public static void main(String[] args) {
//		ProfessorController professorController = new ProfessorController();
//		professorController.testeProfessor();
		AlunoController alunoController = new AlunoController();
//		alunoController.inserirAluno();
		
//		alunoController.listarAniversariantes(02);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MenuView();
	}

}// Fim do m�todo main
