
/**
 * Classe main do projeto Gerencia Escola
 * @author pbido
 * @since 17/02/2020
 * @version 0.1
 */

import javax.swing.UIManager;

import controller.AlunoController;
import view.MenuView;

public class Main {// Inicio do método main

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//Muda o layout de todos os elementos do java swing
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MenuView();
	}

}// Fim do método main
