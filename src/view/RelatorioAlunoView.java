package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private JFrame janela;
	private JTable tabela;
	private JButton btnCancelar;
	private JPanel painelDaJanela;
	private JScrollPane painelDeScroll;
	private String[] colunas = new String[] { "Matrícula", "Nome", "Data de Nascimento" };
	private String[][] dados;
//	private Aluno vetorAluno[] = null;

	public void iniciaGui(Aluno vetorAluno[]) {
		for (int i = 0; i < vetorAluno.length; i++) {
			while (vetorAluno[i] != null) {
				dados = new String[][] { { vetorAluno[i].getMatricula(), vetorAluno[i].getNome(),
						vetorAluno[i].getDataNascimento().getDia() + "/" + vetorAluno[i].getDataNascimento().getMes()
								+ "/" + vetorAluno[i].getDataNascimento().getAno() } };
			}
		}

		janela = new JFrame("Relatório de alunos");
		tabela = new JTable();
		btnCancelar = new JButton();
		painelDaJanela = (JPanel) janela.getContentPane();

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		tabela = new JTable(modelo);
		tabela.setEnabled(true);

		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll.setBounds(5, 5, 475, 500);

		painelDaJanela.add(btnCancelar);
		painelDaJanela.add(painelDeScroll);

		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(370, 520, 100, 30);
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

		iniciaGui(ac.listarTodos());
	}

}
