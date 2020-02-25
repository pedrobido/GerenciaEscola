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

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;
import model.Funcionario;

public class FuncionarioController {

	public boolean validarFuncionario(String id, String nome, String cpf, String rg, String dataNascimento,
			String telefone, String logradouro, String numero, String complemento, String bairro, String cidade,
			String estado, String cep, String salario) {

		try {
			StringBuilder strRegistro = new StringBuilder();

			int contId = id.length();
			int contNome = nome.length();
			int contData = dataNascimento.length();
			int contRg = rg.length();
			int contCpf = cpf.length();
			int contLogradouro = logradouro.length();
			int contNumero = numero.length();
			int contBairro = bairro.length();
			int contCidade = cidade.length();
			int contEstado = estado.length();
			int contCep = cep.length();
			int contTelefone = telefone.length();

			if ((contId != 0) && (contNome != 0) && (contData != 0) && (contRg != 0) && (contCpf != 0)
					&& (contLogradouro != 0) && (contNumero != 0) && (contBairro != 0) && (contCidade != 0)
					&& (contEstado != 0) && (contCep != 0) && (contTelefone != 0)) {

				strRegistro.append(nome + ";" + dataNascimento + ";" + rg + ";" + cpf + ";" + logradouro + ";" + numero
						+ ";" + complemento + ";" + bairro + ";" + cidade + ";" + estado + ";" + cep + ";" + telefone);

				String data[] = dataNascimento.split("/");
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				if ((dia < 32) && (mes < 13) && (ano < 2600) && (ano > 1800)) {
					int numeroId = 0;
					if (id.equals("PROFESSOR")) {
						numeroId = 1;
					} else if (id.equals("FAXINEIRA")) {
						numeroId = 2;
					} else if (id.equals("SECRETÁRIA")) {
						numeroId = 3;
					}
					salario = salario.replace(",", "");
					salario = salario.replace(". ", "");
					System.out.println(salario);
					Data txtData = new Data(dia, mes, ano);
					Cidade txtCidade = new Cidade(cidade.toUpperCase());
					Estado txtEstado = new Estado(estado.toUpperCase(), null);
					Endereco txtEndereco = new Endereco(logradouro.toUpperCase(), Integer.parseInt(numero),
							complemento.toUpperCase(), bairro.toUpperCase(), txtCidade, txtEstado, cep);
					Funcionario funcionario = new Funcionario(numeroId, nome.toUpperCase().trim(), cpf, rg, txtData,
							telefone, txtEndereco, Double.parseDouble(salario));
					if (inserirFuncionario(funcionario)) {
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso!",
								JOptionPane.INFORMATION_MESSAGE);
						return true;
					} else {
						return false;
					}

				} else {
					JOptionPane.showMessageDialog(null, "Data inválida.", "Erro!", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (StringIndexOutOfBoundsException e4) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		} catch (NullPointerException e5) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}

	public boolean inserirFuncionario(Funcionario funcionario) {
		try {
			File arquivo = new File("funcionario.txt");
			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(funcionario.getId());
			gravador.print(";");
			gravador.print(funcionario.getNome());
			gravador.print(";");
			gravador.print(funcionario.getCpf());
			gravador.print(";");
			gravador.print(funcionario.getRg());
			gravador.print(";");
			gravador.print(funcionario.getDataNascimento());
			gravador.print(";");
			gravador.print(funcionario.getTelefone());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getNumero());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.print(funcionario.getEndereco().getCep());
			gravador.print(";");
			gravador.println(funcionario.getSalario());
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

	public ArrayList<Funcionario> listarFaxineiras() {
		try {
			InputStream is = new FileInputStream("funcionario.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			int i = 0;
			ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

			while (texto != null) {
				String dados[] = texto.split(";");
				if (Integer.parseInt(dados[0]) == 2) {

					String datas[] = dados[4].split("/");
					int dia = Integer.parseInt(datas[0]);
					int mes = Integer.parseInt(datas[1]);
					int ano = Integer.parseInt(datas[2]);

					Data txtData = new Data(dia, mes, ano);

					Cidade txtCidade = new Cidade(dados[10].toUpperCase());
					Estado txtEstado = new Estado(dados[11].toUpperCase(), null);

					Endereco txtEndereco = new Endereco(dados[6].toUpperCase(), Integer.parseInt(dados[7]),
							dados[8].toUpperCase(), dados[9].toUpperCase(), txtCidade, txtEstado, dados[12]);

					Funcionario funcionario = new Funcionario(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3],
							txtData, dados[5], txtEndereco, Double.parseDouble(dados[13]));

					funcionarios.add(funcionario);
				}
				texto = leitor.readLine();
			}
			return funcionarios;
		} catch (FileNotFoundException e) {
			System.out.println("Erro!\nArquivo de entrada não encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Funcionario> listarProfessores() {
		try {
			InputStream is = new FileInputStream("funcionario.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			int i = 0;
			ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

			while (texto != null) {
				String dados[] = texto.split(";");
				if (Integer.parseInt(dados[0]) == 1) {

					String datas[] = dados[4].split("/");
					int dia = Integer.parseInt(datas[0]);
					int mes = Integer.parseInt(datas[1]);
					int ano = Integer.parseInt(datas[2]);

					Data txtData = new Data(dia, mes, ano);

					Cidade txtCidade = new Cidade(dados[10].toUpperCase());
					Estado txtEstado = new Estado(dados[11].toUpperCase(), null);

					Endereco txtEndereco = new Endereco(dados[6].toUpperCase(), Integer.parseInt(dados[7]),
							dados[8].toUpperCase(), dados[9].toUpperCase(), txtCidade, txtEstado, dados[12]);

					Funcionario funcionario = new Funcionario(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3],
							txtData, dados[5], txtEndereco, Double.parseDouble(dados[13]));

					funcionarios.add(funcionario);
				}
				texto = leitor.readLine();
			}
			return funcionarios;
		} catch (FileNotFoundException e) {
			System.out.println("Erro!\nArquivo de entrada não encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Funcionario> listarSecretarias() {
		try {
			InputStream is = new FileInputStream("funcionario.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			int i = 0;
			ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

			while (texto != null) {
				String dados[] = texto.split(";");
				if (Integer.parseInt(dados[0]) == 3) {

					String datas[] = dados[4].split("/");
					int dia = Integer.parseInt(datas[0]);
					int mes = Integer.parseInt(datas[1]);
					int ano = Integer.parseInt(datas[2]);

					Data txtData = new Data(dia, mes, ano);

					Cidade txtCidade = new Cidade(dados[10].toUpperCase());
					Estado txtEstado = new Estado(dados[11].toUpperCase(), null);

					Endereco txtEndereco = new Endereco(dados[6].toUpperCase(), Integer.parseInt(dados[7]),
							dados[8].toUpperCase(), dados[9].toUpperCase(), txtCidade, txtEstado, dados[12]);

					Funcionario funcionario = new Funcionario(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3],
							txtData, dados[5], txtEndereco, Double.parseDouble(dados[13]));

					funcionarios.add(funcionario);
				}
				texto = leitor.readLine();
			}
			return funcionarios;
		} catch (FileNotFoundException e) {
			System.out.println("Erro!\nArquivo de entrada não encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}
		return null;

	}

}
