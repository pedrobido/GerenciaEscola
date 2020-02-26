/**
 * @author pbido
 * @since 24/02/2020
 * @version 0.1
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.CidadeController;
import controller.EstadoController;
import controller.FuncionarioController;

public class FuncionarioView {
	FuncionarioController funcionarioController = new FuncionarioController();
	CidadeController cidadeController = new CidadeController();
	EstadoController estadoController = new EstadoController();

	private JFrame janela;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblDataNascimento;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblTelefone;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblSalario;
	private JLabel lblFuncao;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtDataNascimento;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtSalario;
	private JComboBox cbFuncao;
	private String[] funcoes = { "", "PROFESSOR", "FAXINEIRA", "SECRETÁRIA" };
	private JComboBox cbCidade;
	private String[] cidades = cidadeController.leCidade();
	private JComboBox cbEstado;
	private String[] estado = estadoController.leEstado();
	private JButton bSalvar;
	private JButton bCancelar;
	private JPanel painelDaJanela;
	private JPanel painelDados;
	private JPanel painelEndereco;
	private JPanel painelDocumentos;
	private JPanel painelMaterias;
	private JPanel painelRamal;
	private JPanel painelTurno;
	private JTable tabelaMaterias;
	private JScrollPane painelDeScroll;
	private JLabel lblAddMateria;
	private JButton btnAddMateria;
	private JTextField txtAddMateria;
	private String[] colunas = { "Matérias" };
	private String[][] dados;
	private JTextField txtRamal;
	private JRadioButton rbtDiurno;
	private JRadioButton rbtNoturno;
	private ButtonGroup turno;

	public FuncionarioView() {
		iniciaFuncionarioView();
	}

	public void iniciaFuncionarioView() {
		janela = new JFrame("Cadastro Funcionário");
		painelDaJanela = (JPanel) janela.getContentPane();

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 20, 75, 20);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(110, 20, 50, 20);

		lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 20, 50, 20);

		lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(275, 20, 100, 20);

		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 20, 100, 20);

		lblNumero = new JLabel("Nº:");
		lblNumero.setBounds(227, 20, 30, 20);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(290, 20, 100, 20);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 80, 150, 20);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 140, 100, 20);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 80, 100, 20);

		lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(125, 80, 100, 20);

		lblFuncao = new JLabel("Função:");
		lblFuncao.setBounds(240, 80, 100, 20);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(130, 80, 100, 20);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(300, 80, 100, 20);

		txtNome = new JTextField();
		txtNome.setBounds(10, 40, 250, 20);

		txtDataNascimento = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataNascimento = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtDataNascimento.setBounds(275, 40, 100, 20);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(10, 40, 200, 20);

		txtNumero = new JTextField();
		txtNumero.setBounds(225, 40, 50, 20);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(290, 40, 125, 20);

		txtBairro = new JTextField();
		txtBairro.setBounds(10, 100, 100, 20);

		txtCep = new JTextField();
		try {
			javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
			txtCep = new javax.swing.JFormattedTextField(cep);
		} catch (Exception e) {
		}
		txtCep.setBounds(10, 160, 70, 20);

		txtTelefone = new JTextField();
		try {
			javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
			txtTelefone = new javax.swing.JFormattedTextField(telefone);
		} catch (Exception e) {
		}
		txtTelefone.setBounds(10, 100, 100, 20);

		txtSalario = new JTextField();
		try {
			MaskFormatter salario = new javax.swing.text.MaskFormatter("####");
			txtSalario = new javax.swing.JFormattedTextField(salario);
		} catch (Exception e) {
		}
		txtSalario.setBounds(125, 100, 100, 20);

		txtRg = new JTextField();
		try {
			javax.swing.text.MaskFormatter rg = new javax.swing.text.MaskFormatter("##.###.###-#");
			txtRg = new javax.swing.JFormattedTextField(rg);
		} catch (Exception e) {
		}
		txtRg.setBounds(10, 40, 80, 20);

		txtCpf = new JTextField();
		try {
			javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(cpf);
		} catch (Exception e) {
		}
		txtCpf.setBounds(110, 40, 95, 20);

		cbFuncao = new JComboBox(funcoes);
		cbFuncao.setSelectedIndex(-1);
		cbFuncao.setBounds(240, 100, 120, 20);
		cbFuncao.addActionListener(new ConfirmaFuncaoListener());

		cbCidade = new JComboBox(cidades);
		cbCidade.setSelectedIndex(-1);
		cbCidade.setBounds(130, 100, 150, 20);

		cbEstado = new JComboBox(estado);
		cbEstado.setSelectedIndex(-1);
		cbEstado.setBounds(300, 100, 69, 20);

		bSalvar = new JButton("Salvar");
		bSalvar.setBounds(339, 625, 100, 30);
		bSalvar.addActionListener(new SalvarListener());

		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(230, 625, 100, 30);
		bCancelar.addActionListener(new CancelarListener());

		painelDados = new JPanel();
		painelDados.setBounds(5, 5, 435, 150);
		painelDados.setLayout(null);
		painelDados.setBorder(new TitledBorder("Dados Funcionário"));

		painelEndereco = new JPanel();
		painelEndereco.setBounds(5, 160, 435, 200);
		painelEndereco.setLayout(null);
		painelEndereco.setBorder(new TitledBorder("Endereço"));

		painelDocumentos = new JPanel();
		painelDocumentos.setBounds(5, 365, 435, 100);
		painelDocumentos.setLayout(null);
		painelDocumentos.setBorder(new TitledBorder("Documentos"));

		painelMaterias = new JPanel();
		painelMaterias.setBounds(5, 470, 435, 150);
		painelMaterias.setLayout(null);
		painelMaterias.setVisible(false);
		painelMaterias.setBorder(new TitledBorder("Matérias"));

		lblAddMateria = new JLabel("Inserir matéria:");
		lblAddMateria.setBounds(270, 20, 100, 20);

		txtAddMateria = new JTextField();
		txtAddMateria.setBounds(270, 40, 100, 20);

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		btnAddMateria = new JButton("OK");
		btnAddMateria.setBounds(375, 39, 50, 22);

		btnAddMateria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				modelo.addRow(new Object[] { txtAddMateria.getText().toUpperCase() });
				txtAddMateria.setText("");

			}
		});

		tabelaMaterias = new JTable(modelo);
		tabelaMaterias.setEnabled(true);

		painelDeScroll = new JScrollPane(tabelaMaterias);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll.setBounds(10, 20, 250, 120);

		painelRamal = new JPanel();
		painelRamal.setBounds(5, 470, 435, 100);
		painelRamal.setLayout(null);
		painelRamal.setVisible(false);
		painelRamal.setBorder(new TitledBorder("Ramal"));

		txtRamal = new JTextField();
		txtRamal.setBounds(10, 20, 100, 20);

		painelTurno = new JPanel();
		painelTurno.setBounds(5, 470, 435, 100);
		painelTurno.setLayout(null);
		painelTurno.setVisible(false);
		painelTurno.setBorder(new TitledBorder("Turno"));

		turno = new ButtonGroup();
		turno.add(rbtDiurno);
		turno.add(rbtNoturno);

		rbtDiurno = new JRadioButton("Diurno");
		rbtDiurno.setBounds(10, 20, 70, 20);
		rbtNoturno = new JRadioButton("Noturno");
		rbtNoturno.setBounds(100, 20, 70, 20);

		painelDaJanela.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelDaJanela.setBorder(BorderFactory.createEtchedBorder());
		painelDados.add(lblNome);
		painelDados.add(lblDataNascimento);
		painelDados.add(lblSalario);
		painelEndereco.add(lblLogradouro);
		painelEndereco.add(lblNumero);
		painelEndereco.add(lblComplemento);
		painelEndereco.add(lblBairro);
		painelEndereco.add(lblCep);
		painelDados.add(lblTelefone);
		painelEndereco.add(lblCidade);
		painelEndereco.add(lblEstado);
		painelDocumentos.add(lblRg);
		painelDocumentos.add(lblCpf);
		painelDados.add(txtNome);
		painelDados.add(txtDataNascimento);
		painelEndereco.add(txtLogradouro);
		painelEndereco.add(txtNumero);
		painelEndereco.add(txtComplemento);
		painelEndereco.add(txtBairro);
		painelEndereco.add(txtCep);
		painelDados.add(txtTelefone);
		painelDados.add(txtSalario);
		painelDados.add(lblFuncao);
//		painelDados.add(bFuncao);
		painelDados.add(cbFuncao);
		painelDocumentos.add(txtRg);
		painelDocumentos.add(txtCpf);
		painelEndereco.add(cbCidade);
		painelEndereco.add(cbEstado);
		painelDaJanela.add(bSalvar);
		painelDaJanela.add(bCancelar);
		painelDaJanela.add(painelDados);
		painelDaJanela.add(painelEndereco);
		painelDaJanela.add(painelDocumentos);
		painelDaJanela.add(painelMaterias);
		painelDaJanela.add(painelRamal);
		painelDaJanela.add(painelTurno);
		painelMaterias.add(painelDeScroll);
		painelMaterias.add(btnAddMateria);
		painelMaterias.add(lblAddMateria);
		painelMaterias.add(txtAddMateria);
		painelRamal.add(txtRamal);
		painelTurno.add(rbtNoturno);
		painelTurno.add(rbtDiurno);

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		janela.setSize(460, 700);
		janela.setLocationRelativeTo(null);
		janela.getContentPane().add(bSalvar);
		janela.getContentPane().add(bCancelar);

		janela.setVisible(true);

	}

	public class SalvarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int opcao = JOptionPane.showConfirmDialog(null, "Confirmar cadastro?", "Atenção", 0);
			if (opcao == 0) {
				FuncionarioController funcionarioController = new FuncionarioController();
				if (funcionarioController.validarFuncionario(cbFuncao.getSelectedItem().toString(), txtNome.getText(),
						txtCpf.getText(), txtRg.getText(), txtDataNascimento.getText(), txtTelefone.getText(),
						txtLogradouro.getText(), txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(),
						cbCidade.getSelectedItem().toString(), cbEstado.getSelectedItem().toString(), txtCep.getText(),
						txtSalario.getText())) {
					txtNome.setText("");
					txtDataNascimento.setText("");
					txtRg.setText("");
					txtCpf.setText("");
					txtLogradouro.setText("");
					txtNumero.setText("");
					txtComplemento.setText("");
					txtBairro.setText("");
					cbCidade.setSelectedIndex(-1);
					cbEstado.setSelectedIndex(-1);
					cbFuncao.setSelectedIndex(-1);
					txtCep.setText("");
					txtTelefone.setText("");
					txtSalario.setText("");
				}
			}
		}
	}

	public class CancelarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Atenção", 0, 2);
			if (opcao == 0) {
				janela.dispose();
			}
		}
	}

	public class ConfirmaFuncaoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int funcao = cbFuncao.getSelectedIndex();

			if (funcao == 1) {
				painelMaterias.setVisible(true);
			} else {
				painelMaterias.setVisible(false);
			}
			if (funcao == 2) {
				painelTurno.setVisible(true);
			} else {
				painelTurno.setVisible(false);
			}
			if (funcao == 3) {
				painelRamal.setVisible(true);
			} else {
				painelRamal.setVisible(false);
			}
		}
	}
}
