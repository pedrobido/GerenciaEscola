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

import model.Estado;

public class EstadoController {

	public String[] leEstado() {

		ArrayList<String> arr = new ArrayList<>();
		try {
			FileInputStream fstream = new FileInputStream("estado.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				String[] dados = strLine.split(";");
				arr.add(dados[0]);
			}
		} catch (Exception e) {
		}
		return arr.toArray(new String[arr.size()]);
	}

	public boolean validarEstado(String estado, String uf) throws IOException {

		int contEstado = estado.length();
		int contUf = uf.length();
		boolean existe = false;
		if (contEstado != 0 || contUf != 0 || contUf > 2) {

			InputStream is = new FileInputStream("estado.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {
				if ((texto.contains(estado.toUpperCase()) || (texto.contains(uf.toUpperCase())))) {
					existe = true;

				}
				texto = leitor.readLine();
			}
			if (!existe) {
				Estado txtEstado = new Estado(estado.toUpperCase(), uf.toUpperCase());
				if (inserirEstado(txtEstado)) {
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso!",
							JOptionPane.INFORMATION_MESSAGE);
					return true;
				} else {
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esse estado já existe!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		}
		return false;

	}

	public boolean inserirEstado(Estado estado) {
		try {
			File arquivo = new File("estado.txt");
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			gravador.print(estado.getUf());
			gravador.print(";");
			gravador.println(estado.getNome());
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
