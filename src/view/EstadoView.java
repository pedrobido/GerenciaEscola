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

import controller.EstadoController;

/**
 * @author pbido
 *
 */
public class EstadoView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JTextField tfdestado;
	private JLabel lblEstado;
	private JTextField tfdUf;
	private JLabel lblUf;
	private JButton btnSalvar;
	private JButton btnCancelar;

	public void iniciaGui() {
		janela = new JFrame("Cadastro de estado");
		painelDaJanela = (JPanel) janela.getContentPane();
		tfdestado = new JTextField();
		lblEstado = new JLabel();
		tfdUf = new JTextField();
		lblUf = new JLabel();
		btnSalvar = new JButton();
		btnCancelar = new JButton();

		tfdestado.setBounds(20, 30, 200, 20);

		lblEstado.setText("Digite um estado para adicionar:");
		lblEstado.setBounds(20, 10, 200, 20);

		lblUf.setText("UF:");
		lblUf.setBounds(20, 60, 200, 20);

		tfdUf.setBounds(20, 80, 40, 20);
		tfdUf.addActionListener(new SalvarListener());

		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(175, 120, 100, 30);
		btnSalvar.addActionListener(new SalvarListener());

		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(70, 120, 100, 30);
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
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(tfdestado);
		painelDaJanela.add(lblUf);
		painelDaJanela.add(tfdUf);
		painelDaJanela.add(btnSalvar);
		painelDaJanela.add(btnCancelar);

		janela.setLocationRelativeTo(null);
		janela.setLayout(null);
		janela.setSize(300, 200);
		janela.setVisible(true);

	}

	public EstadoView() {
		iniciaGui();
	}

	public class SalvarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int opcao = JOptionPane.showConfirmDialog(null, "Confirmar cadastro?", "Atenção", 0);
			if (opcao == 0) {
				EstadoController estadoController = new EstadoController();
				try {
					if (estadoController.validarEstado(tfdestado.getText(), tfdUf.getText())) {
						tfdestado.setText("");
						tfdUf.setText("");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}
