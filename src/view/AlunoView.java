/**
 * @author pbido
 * @since 18/02/2020
 * @version 0.1
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.AlunoController;

public class AlunoView {
	AlunoController alunoController = new AlunoController();

	private JFrame janela;
	private JLabel lblMatricula;
	private JLabel lblNome;
	private JLabel lblDataNascimento;
	private JLabel lblSexo;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblTelefone;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblRg;
	private JLabel lblCpf;
	private JLabel lblSenha;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JPasswordField jpwSenha;
	private JRadioButton rbtSexoM;
	private JRadioButton rbtSexoF;
	private JComboBox cbCidade;
	private String[] cidade = { "", "OSASCO", "BARUERI", "CARAPICUÍBA" };
	private JComboBox cbEstado;
	private String[] estado = { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
			"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
	private ButtonGroup grpSexo;
	private JButton bSalvar;
	private JButton bCancelar;
	private JPanel painelDaJanela;
	private JPanel painelDados;
	private JPanel painelEndereco;
	private JPanel painelDocumentos;
	private JPanel painelSenha;

	public AlunoView() {
		iniciaAlunoView();
	}

	public void iniciaAlunoView() {
		janela = new JFrame("Cadastro Aluno");
		painelDaJanela = (JPanel) janela.getContentPane();

		lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setBounds(10, 20, 75, 20);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(120, 20, 100, 20);

		lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(200, 80, 100, 20);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 80, 150, 20);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 80, 100, 20);

		lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 20, 100, 20);

		lblNumero = new JLabel("Nº:");
		lblNumero.setBounds(227, 20, 30, 20);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(290, 20, 100, 20);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 140, 100, 20);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(315, 80, 100, 20);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(130, 80, 100, 20);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(300, 80, 100, 20);

		lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 20, 50, 20);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(110, 20, 50, 20);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 1, 100, 20);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 40, 100, 20);

		txtNome = new JTextField();
		txtNome.setBounds(120, 40, 295, 20);

		txtDataNascimento = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataNascimento = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtDataNascimento.setBounds(200, 100, 100, 20);

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
		txtTelefone.setBounds(315, 100, 100, 20);

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

		jpwSenha = new JPasswordField();
		jpwSenha.setBounds(10, 20, 180, 20);
		jpwSenha.addActionListener(new SalvarListener());

		rbtSexoM = new JRadioButton("Masculino");
		rbtSexoM.setBounds(10, 100, 90, 20);

		rbtSexoF = new JRadioButton("Feminino");
		rbtSexoF.setBounds(110, 100, 90, 20);

		grpSexo = new ButtonGroup();
		grpSexo.add(rbtSexoM);
		grpSexo.add(rbtSexoF);

		cbCidade = new JComboBox(cidade);
		cbCidade.setSelectedIndex(0);
		cbCidade.setBounds(130, 100, 150, 20);

		cbEstado = new JComboBox(estado);
		cbEstado.setSelectedIndex(0);
		cbEstado.setBounds(300, 100, 69, 20);

		bSalvar = new JButton("Salvar");
		bSalvar.setBounds(339, 495, 100, 30);
		bSalvar.addActionListener(new SalvarListener());

		bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(230, 495, 100, 30);
		bCancelar.addActionListener(new CancelarListener());

		painelDados = new JPanel();
		painelDados.setBounds(5, 5, 435, 150);
		painelDados.setLayout(null);
		painelDados.setBorder(new TitledBorder("Dados Aluno"));

		painelEndereco = new JPanel();
		painelEndereco.setBounds(5, 160, 435, 200);
		painelEndereco.setLayout(null);
		painelEndereco.setBorder(new TitledBorder("Endereço"));

		painelDocumentos = new JPanel();
		painelDocumentos.setBounds(5, 365, 435, 100);
		painelDocumentos.setLayout(null);
		painelDocumentos.setBorder(new TitledBorder("Documentos"));

		painelSenha = new JPanel();
		painelSenha.setBounds(7, 475, 200, 50);
		painelSenha.setLayout(null);
		painelSenha.setBorder(new TitledBorder(""));

		painelDaJanela.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelDaJanela.setBorder(BorderFactory.createEtchedBorder());
		painelDados.add(lblMatricula);
		painelDados.add(lblNome);
		painelDados.add(lblDataNascimento);
		painelDados.add(lblSexo);
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
		painelSenha.add(lblSenha);
		painelDados.add(txtMatricula);
		painelDados.add(txtNome);
		painelDados.add(txtDataNascimento);
		painelEndereco.add(txtLogradouro);
		painelEndereco.add(txtNumero);
		painelEndereco.add(txtComplemento);
		painelEndereco.add(txtBairro);
		painelEndereco.add(txtCep);
		painelDados.add(txtTelefone);
		painelDocumentos.add(txtRg);
		painelDocumentos.add(txtCpf);
		painelSenha.add(jpwSenha);
		painelDados.add(rbtSexoM);
		painelDados.add(rbtSexoF);
		painelEndereco.add(cbCidade);
		painelEndereco.add(cbEstado);
		painelDaJanela.add(bSalvar);
		painelDaJanela.add(bCancelar);
		painelDaJanela.add(painelDados);
		painelDaJanela.add(painelEndereco);
		painelDaJanela.add(painelDocumentos);
		painelDaJanela.add(painelSenha);

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		janela.setSize(460, 580);
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
				String sexo;
				if (rbtSexoM.isSelected()) {
					sexo = "M";
				} else {
					sexo = "F";
				}
				AlunoController alunocontroller = new AlunoController();
				if (alunocontroller.validarAluno(txtMatricula.getText(), txtNome.getText(), txtDataNascimento.getText(),
						sexo, txtRg.getText(), txtCpf.getText(), txtLogradouro.getText(), txtNumero.getText(),
						txtComplemento.getText(), txtBairro.getText(), cbCidade.getSelectedItem().toString(),
						cbEstado.getSelectedItem().toString(), txtCep.getText(), txtTelefone.getText(),
						jpwSenha.getText())) {
					txtMatricula.setText("");
					txtNome.setText("");
					txtDataNascimento.setText("");
					rbtSexoM.isSelected();
					rbtSexoF.isSelected();
					txtRg.setText("");
					txtCpf.setText("");
					txtLogradouro.setText("");
					txtNumero.setText("");
					txtComplemento.setText("");
					txtBairro.setText("");
					cbCidade.setSelectedIndex(-1);
					cbEstado.setSelectedIndex(-1);
					txtCep.setText("");
					txtTelefone.setText("");
					jpwSenha.setText("");
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
}