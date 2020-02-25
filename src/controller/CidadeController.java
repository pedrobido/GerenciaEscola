package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Cidade;

public class CidadeController {

	public String[] leCidade() {
		ArrayList<String> arr = new ArrayList<>();
		try {
			FileInputStream fstream = new FileInputStream("cidade.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				arr.add(strLine);
			}
		} catch (Exception e) {
		}
		return arr.toArray(new String[arr.size()]);

	}

	public boolean validarCidade(String cidade) throws IOException {

		int contCidade = cidade.length();
		boolean existe = false;
		if (contCidade != 0) {

			InputStream is = new FileInputStream("cidade.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {
				if (texto.contains(cidade.toUpperCase())) {
					existe = true;

				}
				texto = leitor.readLine();
			}
			if (!existe) {
				Cidade txtCidade = new Cidade(cidade.toUpperCase());
				if (inserirCidade(txtCidade)) {
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso!",
							JOptionPane.INFORMATION_MESSAGE);
					return true;
				} else {
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Essa cidade já existe!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		}
		return false;

	}

	public boolean inserirCidade(Cidade cidade) {
		try {
			File arquivo = new File("cidade.txt");
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			gravador.println(cidade.getNome());
			gravador.close();
			arquivoOutput.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de saída não encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
