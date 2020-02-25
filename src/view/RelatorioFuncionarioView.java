package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FuncionarioController;
import model.Funcionario;

public class RelatorioFuncionarioView {
	FuncionarioController fc = new FuncionarioController();
//Declaração das variáveis da janela
	private JFrame janela;
	private JTable tabelaProf;
	private JTable tabelaFaxi;
	private JTable tabelaSecr;
	private JButton btnCancelar;
	private JPanel painelDaJanela;
	private JScrollPane painelDeScrollProf;
	private JScrollPane painelDeScrollFaxi;
	private JScrollPane painelDeScrollSecr;
	private String[] colunas = new String[] { "Nome", "Data de Nascimento", "Telefone" };
	private String[][] dados;
	private ArrayList<Funcionario> professores;
	private ArrayList<Funcionario> faxineiras;
	private ArrayList<Funcionario> secretarias;
	private JTabbedPane abasFuncionario;

	public void iniciaGui() {
		professores = fc.listarProfessores();
		DefaultTableModel modeloProf = new DefaultTableModel(dados, colunas);
		for (Funcionario funcionario : professores) {

			modeloProf.addRow(new Object[] {
					funcionario.getNome(), funcionario.getDataNascimento().getDia() + "/"
							+ funcionario.getDataNascimento().getMes() + "/" + funcionario.getDataNascimento().getAno(),
					funcionario.getTelefone() });
		}

		faxineiras = fc.listarFaxineiras();
		DefaultTableModel modeloFaxi = new DefaultTableModel(dados, colunas);
		for (Funcionario funcionario : faxineiras) {

			modeloFaxi.addRow(new Object[] {
					funcionario.getNome(), funcionario.getDataNascimento().getDia() + "/"
							+ funcionario.getDataNascimento().getMes() + "/" + funcionario.getDataNascimento().getAno(),
					funcionario.getTelefone() });
		}

		secretarias = fc.listarSecretarias();
		DefaultTableModel modeloSecr = new DefaultTableModel(dados, colunas);
		for (Funcionario funcionario : secretarias) {

			modeloSecr.addRow(new Object[] {
					funcionario.getNome(), funcionario.getDataNascimento().getDia() + "/"
							+ funcionario.getDataNascimento().getMes() + "/" + funcionario.getDataNascimento().getAno(),
					funcionario.getTelefone() });
		}

		janela = new JFrame("Relatório de Funcionários");
		btnCancelar = new JButton();
		painelDaJanela = (JPanel) janela.getContentPane();

		tabelaProf = new JTable(modeloProf);
		tabelaProf.setEnabled(true);

		tabelaFaxi = new JTable(modeloFaxi);
		tabelaFaxi.setEnabled(true);

		tabelaSecr = new JTable(modeloSecr);
		tabelaSecr.setEnabled(true);

		painelDeScrollProf = new JScrollPane(tabelaProf);
		painelDeScrollProf.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScrollProf.setBounds(5, 5, 375, 400);

		painelDeScrollFaxi = new JScrollPane(tabelaFaxi);
		painelDeScrollFaxi.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScrollFaxi.setBounds(5, 5, 375, 400);

		painelDeScrollSecr = new JScrollPane(tabelaSecr);
		painelDeScrollSecr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScrollSecr.setBounds(5, 5, 375, 400);

		abasFuncionario = new JTabbedPane();
		abasFuncionario.setBounds(10, 10, 465, 500);

		painelDaJanela.add(btnCancelar);
		painelDaJanela.add(abasFuncionario);
		abasFuncionario.add("Professores", painelDeScrollProf);
		abasFuncionario.add("Faxineiras", painelDeScrollFaxi);
		abasFuncionario.add("Secretáras", painelDeScrollSecr);

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

	public RelatorioFuncionarioView() {
		iniciaGui();
	}

}
