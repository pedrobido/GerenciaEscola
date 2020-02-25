package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;
import model.Aluno;

public class RelatorioAlunoView {
	AlunoController ac = new AlunoController();
//Declaração das variáveis da janela
	private JFrame janela;
	private JTable tabela;
	private JButton btnCancelar;
	private JPanel painelDaJanela;
	private JScrollPane painelDeScroll;
	private String[] colunas = new String[] { "Matrícula", "Nome", "Data de Nascimento" };
	private String[][] dados;
	private ArrayList<Aluno> alunos;

	public void iniciaGui() {
		alunos = ac.listarTodos();// Recebe o retorno do método listar todos do alunoController
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		for (Aluno aluno : alunos) {

			modelo.addRow(new Object[] { aluno.getMatricula(), aluno.getNome(), aluno.getDataNascimento().getDia() + "/"
					+ aluno.getDataNascimento().getMes() + "/" + aluno.getDataNascimento().getAno() });
		}

		janela = new JFrame("Relatório de alunos");
		tabela = new JTable();
		btnCancelar = new JButton();
		painelDaJanela = (JPanel) janela.getContentPane();

		tabela = new JTable(modelo);
		tabela.setEnabled(true);

		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll.setBounds(5, 5, 475, 500);

		painelDaJanela.add(btnCancelar);
		painelDaJanela.add(painelDeScroll);

		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(375, 520, 100, 30);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Atenção", 0, 2);
				if (opcao == 0) {
					janela.dispose();
				}

			}
		});

		painelDaJanela.setLayout(null);

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(500, 600);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public RelatorioAlunoView() {
		if (ac.listarTodos() != null) {
			iniciaGui();
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado");
		}

	}

}
