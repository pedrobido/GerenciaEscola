/**
 * View dos menus
 * @author pbido
 * @since 20/02/2020
 * @version 0.1
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView {// INICIO DA CLASSE EXEMPLOMENU

	// DECLARAÇÃO DE VARIÁVEIS
	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menu01;
	private JMenu menu02;
	private JMenuItem itemMenu01;
	private JMenuItem itemMenu02;
	private JMenuItem itemMenu03;
	private JMenuItem itemMenu04;
	private JMenuItem itemMenu05;
	private JMenuItem itemMenu06;
	private JPanel painelDaJanela;

	public void iniciaGui() {// INICIO DO METODO INICIAGUI

		// INSTANCIA DAS VARIÁVEIS
		janela = new JFrame("Gerenciador Escola - Menu - by Pedro Bido");
		barraMenu = new JMenuBar();
		menu01 = new JMenu("Cadastro");
		menu02 = new JMenu("Relatório");
		itemMenu01 = new JMenuItem("Aluno");
		itemMenu02 = new JMenuItem("Funcionário");
		itemMenu03 = new JMenuItem("Cidade");
		itemMenu04 = new JMenuItem("Estado");
		itemMenu05 = new JMenuItem("Aluno");
		itemMenu06 = new JMenuItem("Funcionário");
		painelDaJanela = (JPanel) janela.getContentPane();

		// ACRESCENTAR MENUS NA BARRA DE MENUS
		barraMenu.add(menu01);
		barraMenu.add(menu02);

		// ACRESCENTAR ITENS DE MENU NOS MENUS
		menu01.add(itemMenu01);
		menu01.add(itemMenu02);
		menu01.add(itemMenu03);
		menu01.add(itemMenu04);

		menu02.add(itemMenu05);
		menu02.add(itemMenu06);

		itemMenu01.addActionListener(new ActionListener() {// Configurando a ação do item de menu 01
			@Override
			public void actionPerformed(ActionEvent e) {
				new AlunoView();
				// TODO Função DISPOSE
			}
		});

		itemMenu02.addActionListener(new ActionListener() {// Configurando a ação do item de menu 02
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		// CONFIGURAR O PAINEL DE TELA
		painelDaJanela.setLayout(null);

		// CONFIGURAÇÕES DA TELA
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setJMenuBar(barraMenu);
		janela.setSize(700, 700);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}// FIM DO METODO INICIAGUI

	public MenuView() {
		iniciaGui();
	}

}// FIM DA CLASSE EXEMPLOMENU
