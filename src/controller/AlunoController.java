/**
 * @author pbido
 * @since 18/02/2020
 * 
 */

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

public class AlunoController {// Classe que controla todos os processamentos relacionados a aluno
	// Método que valida os campos do cadastro de alunos
	public boolean validarAluno(String matricula, String nome, String dataNascimento, String sexo, String rg,
			String cpf, String logradouro, String numero, String complemento, String bairro, String cidade,
			String estado, String cep, String telefone, String senha) {

		try {
			StringBuilder strRegistro = new StringBuilder();

			// Contador de caracteres para saber se o campo está nulo
			int contMatricula = matricula.length();
			int contNome = nome.length();
			int contData = dataNascimento.length();
			int contSexo = sexo.length();
			int contRg = rg.length();
			int contCpf = cpf.length();
			int contLogradouro = logradouro.length();
			int contNumero = numero.length();
			int contBairro = bairro.length();
			int contCidade = cidade.length();
			int contEstado = estado.length();
			int contCep = cep.length();
			int contTelefone = telefone.length();
			int contSenha = senha.length();

			if ((contMatricula != 0) && (contNome != 0) && (contData != 0) && (contSexo != 0) && (contRg != 0)
					&& (contCpf != 0) && (contLogradouro != 0) && (contNumero != 0) && (contBairro != 0)
					&& (contCidade != 0) && (contEstado != 0) && (contCep != 0) && (contTelefone != 0)
					&& (contSenha != 0)) {

				if ((sexo.trim().toUpperCase().equals("Masculino"))
						|| (sexo.trim().toUpperCase().contentEquals("Feminino"))
						|| (sexo.trim().toUpperCase().equals("M")) || (sexo.trim().toUpperCase().equals("F"))) {

					strRegistro.append(matricula + ";" + nome + ";" + dataNascimento + ";" + sexo + ";" + rg + ";" + cpf
							+ ";" + logradouro + ";" + numero + ";" + complemento + ";" + bairro + ";" + cidade + ";"
							+ estado + ";" + cep + ";" + telefone + ";" + senha);

					String data[] = dataNascimento.split("/");
					int dia = Integer.parseInt(data[0]);
					int mes = Integer.parseInt(data[1]);
					int ano = Integer.parseInt(data[2]);

					if ((dia < 32) && (mes < 13) && (ano < 2600) && (ano > 1800)) {
						char sexoChar = sexo.charAt(0);
						if (sexoChar == 'M' || sexoChar == 'F') {

							Data txtData = new Data(dia, mes, ano);
							Cidade txtCidade = new Cidade(cidade.toUpperCase());
							Estado txtEstado = new Estado(estado.toUpperCase(), null);
							Endereco txtEndereco = new Endereco(logradouro.toUpperCase(), Integer.parseInt(numero),
									complemento.toUpperCase(), bairro.toUpperCase(), txtCidade, txtEstado, cep);
							Aluno aluno = new Aluno(matricula.trim(), nome.toUpperCase().trim(), txtData, sexoChar, rg,
									cpf, txtEndereco, telefone, senha);
							if (inserirAluno(aluno)) {
								JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Sucesso!",
										JOptionPane.INFORMATION_MESSAGE);
								return true;
							} else {
								return false;
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Data inválida.", "Erro!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sexo inválido.", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException e3) {
			JOptionPane.showMessageDialog(null, "Data inválida", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException e4) {
			JOptionPane.showMessageDialog(null, "Data inválida", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (StringIndexOutOfBoundsException e4) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		} catch (NullPointerException e5) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}

	// Grava todas as informações de aluno num arquivo caso os campos sejam válidos
	public boolean inserirAluno(Aluno aluno) {
		try {
			File arquivoAluno = new File("aluno.txt");
			FileOutputStream arquivoAlunoOutput = new FileOutputStream(arquivoAluno, true);
			PrintStream gravador = new PrintStream(arquivoAlunoOutput);
			gravador.print(aluno.getMatricula());
			gravador.print(";");
			gravador.print(aluno.getNome());
			gravador.print(";");
			gravador.print(aluno.getDataNascimento());
			gravador.print(";");
			gravador.print(aluno.getSexo());
			gravador.print(";");
			gravador.print(aluno.getRg());
			gravador.print(";");
			gravador.print(aluno.getCpf());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getNumero());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCep());
			gravador.print(";");
			gravador.print(aluno.getTelefone());
			gravador.print(";");
			gravador.println(aluno.getSenha());
			gravador.close();

			arquivoAlunoOutput.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Exibe todos os alunos cadastrados
	public ArrayList<Aluno> listarTodos() {
		try {
			InputStream is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			int i = 0;
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();

			while (texto != null) {
				String dados[] = texto.split(";");

				String datas[] = dados[2].split("/");
				int dia = Integer.parseInt(datas[0]);
				int mes = Integer.parseInt(datas[1]);
				int ano = Integer.parseInt(datas[2]);

				Data txtData = new Data(dia, mes, ano);

				Cidade txtCidade = new Cidade(dados[11].toUpperCase());
				Estado txtEstado = new Estado(dados[12].toUpperCase(), null);

				Endereco txtEndereco = new Endereco(dados[6].toUpperCase(), Integer.parseInt(dados[7]),
						dados[8].toUpperCase(), dados[9].toUpperCase(), txtCidade, txtEstado, dados[12]);

				Aluno aluno = new Aluno(dados[0], dados[1], txtData, dados[4].charAt(0), dados[5], dados[6],
						txtEndereco, dados[13], dados[14]);
				texto = leitor.readLine();

				alunos.add(aluno);

			}
			return alunos;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}
		return null;

	}

	public void listarAniversariantes(int mes) {
		try {
			InputStream is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {
				String dados[] = texto.split(";");
				String data = dados[2];
				String[] datas = data.split("/");
				int mesAniversario = Integer.parseInt(datas[1]);
				if (mesAniversario == mes) {
					System.out.println("Matrícula do aluno: " + dados[0]);
					System.out.println("Nome do aluno: " + dados[1]);
					System.out.println("Data de nascimento do aluno: " + dados[2]);
					System.out.println("Sexo: " + dados[3]);
					System.out.print("\n");
				}
				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}
	}

}
