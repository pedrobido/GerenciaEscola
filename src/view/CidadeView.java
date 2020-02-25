/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CidadeController;

/**
 * @author pbido
 *
 */
public class CidadeView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JTextField tfdCidade;
	private JLabel lblCidade;
	private JButton btnSalvar;
	private JButton btnCancelar;

	public void iniciaGui() {
		janela = new JFrame("Cadastro de cidade");
		painelDaJanela = (JPanel) janela.getContentPane();
		tfdCidade = new JTextField();
		lblCidade = new JLabel();
		btnSalvar = new JButton();
		btnCancelar = new JButton();

		tfdCidade.setBounds(20, 30, 200, 20);
		tfdCidade.addActionListener(new SalvarListener());

		lblCidade.setText("Digite uma cidade para adicionar:");
		lblCidade.setBounds(20, 10, 200, 20);

		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(175, 70, 100, 30);
		btnSalvar.addActionListener(new SalvarListener());

		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(70, 70, 100, 30);
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
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(tfdCidade);
		painelDaJanela.add(btnSalvar);
		painelDaJanela.add(btnCancelar);

		janela.setLocationRelativeTo(null);
		janela.setLayout(null);
		janela.setSize(300, 150);
		janela.setVisible(true);

	}

	public CidadeView() {
		iniciaGui();
	}

	public class SalvarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int opcao = JOptionPane.showConfirmDialog(null, "Confirmar cadastro?", "Atenção", 0);
			if (opcao == 0) {
				CidadeController cidadeController = new CidadeController();
				try {
					if (cidadeController.validarCidade(tfdCidade.getText())) {
						tfdCidade.setText("");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}
