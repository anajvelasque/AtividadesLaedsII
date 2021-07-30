package arvore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arvore {
	private static ArrayList<Pessoa> pessoas;

	private static String lerTexto() {
		Scanner inputTxt = new Scanner(System.in);
		String txt = inputTxt.nextLine();
		return txt;
	}

	private static Pessoa getPessoaLista(String nome) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).comparaNome(nome))
				return pessoas.get(i);
		}
		return null;
	}

	private static void cadastraPessoasTeste() {
		cadastrarPessoa(new Pessoa("Mae 1"));
		cadastrarPessoa(new Pessoa("Pai 1"));

		cadastrarPessoa(new Pessoa("Watson Holmess", getPessoaLista("Mae 1"), getPessoaLista("Pai 1")));
		cadastrarPessoa(new Pessoa("Sulivan SA", getPessoaLista("Mae 1"), getPessoaLista("Pai 1")));

		cadastrarPessoa(new Pessoa("Pai PV"));
		cadastrarPessoa(new Pessoa("Mae PV"));

		cadastrarPessoa(new Pessoa("Pai AV"));
		cadastrarPessoa(new Pessoa("Mae AV"));

		cadastrarPessoa(new Pessoa("Pedro Vaz", getPessoaLista("Mae PV"), getPessoaLista("Pai PV")));
		cadastrarPessoa(new Pessoa("Ana Velasque", getPessoaLista("Mae AV"), getPessoaLista("Pai AV")));

		cadastrarPessoa(new Pessoa("Pana Vazasque", getPessoaLista("Ana Velasque"), getPessoaLista("Pedro Vaz")));

		cadastrarPessoa(new Pessoa("Kipo Kopi", getPessoaLista("Pana Vazazque"), getPessoaLista("Sulivan SA")));
	}

	private static void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	private static Boolean verificaCadastro(String nome) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).comparaNome(nome))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private static Boolean verIrmandade(Pessoa pessoa, Pessoa possivelIrmao) {
		if (pessoa == null || possivelIrmao == null)
			return false;
		return pessoa.verificaIrmandade(possivelIrmao);
	}

	private static Boolean verAncestralidade(Pessoa pessoa, Pessoa possivelAncestral) {
		if (pessoa == null || possivelAncestral == null)
			return false;
		return pessoa.verificaAncestralidade(possivelAncestral);
	}

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		pessoas = new ArrayList<Pessoa>();

		cadastraPessoasTeste();

		Integer menu;
		do {

			System.out.println("\n*** Menu ***\n"
					+ "1 - Cadastrar pessoa;\n" 
					+ "2 - Atualizar cadastro;\n"
					+ "3 - Verificar cadastro;\n" 
					+ "4 - Verificar irmandade;\n" 
					+ "5 - Verificar ancestralidade;\n"
					+ "0 - Sair.");

			try {
				menu = leitor.nextInt();
			} catch(InputMismatchException  e) {
				System.out.println("Só numeros permitidos");
				leitor.nextLine();
				menu = -1; 
			} 
			
			
			switch (menu) {

			case (1): {
				System.out.println("** 1 - Cadastrar pessoa ** ");
				System.out.printf("\nDigite o nome da pessoa: ");
				cadastrarPessoa(new Pessoa(lerTexto()));
				System.out.println("Cadastrado!");
				break;
			}

			case (2): {
				System.out.println("** 2 - Atualizar cadastro **");
				Pessoa p = null;
				String nome = null;

				while (p == null) {
					System.out.printf("\nDigite 0 para sair ou nome da pessoa para continuar: ");
					nome = lerTexto();

					if (nome.equalsIgnoreCase("0"))
						break;

					p = getPessoaLista(nome);
					if (p == null)
						System.out.println("Nome não encontrado :( \n");
				}

				if (nome.equalsIgnoreCase("0"))
					break;

				do {
					System.out.println("** Atualizar Cadastro **\n"
							+ "1 - Modificar nome;\n" 
							+ "2 - Atribuir pai;\n"
							+ "3 - Atribuir mãe;\n" 
							+ "0 - Voltar.");

					try {
						menu = leitor.nextInt();
					} catch(InputMismatchException  e) {
						System.out.println("Só numeros permitidos");
						leitor.nextLine();
						menu = -1;
					} 
					
					switch (menu) {
					case (1): {
						System.out.printf("\nDigite o novo nome: ");
						p.resetNome(lerTexto());
						System.out.println("Atualizado!");
						break;
					}
					case (2): {
						System.out.printf("\nDigite o nome do pai: ");
						nome = lerTexto();
						cadastrarPessoa(new Pessoa(nome));
						p.setPai(getPessoaLista(nome));
						System.out.println("Atualizado!");
						break;
					}
					case (3): {
						System.out.printf("\nDigite o nome do mãe: ");
						nome = lerTexto();
						cadastrarPessoa(new Pessoa(nome));
						p.setMae(getPessoaLista(nome));
						System.out.println("Atualizado!");
						break;
					}
					case (0):
						menu = -1; 
						break;
					default: {
						System.out.println("Opção inválida, tente novamente!");
						break;
					}
					}
				} while (menu != -1);

				break;
			}

			case (3): {
				System.out.println("** 3 - Verificar cadastro **");
				System.out.printf("\nDigite 0 para sair ou nome da pessoa para continuar: ");
				String nome = lerTexto();

				if (nome.equalsIgnoreCase("0"))
					break;

				if (verificaCadastro(nome))
					System.out.println("\nPessoa já cadastrada!");
				else
					System.out.println("\nCadastro não encontrado!");

				break;
			}

			case (4): {
				Boolean sairDoLoop, sairDeTudo;
				String nome1, nome2;
				do {
					sairDoLoop = Boolean.FALSE;
					sairDeTudo = Boolean.FALSE;

					System.out.printf("\nDigite 0 para sair ou nome da pessoa para continuar: ");
					nome1 = lerTexto();

					if (nome1.equalsIgnoreCase("0")) {
						sairDoLoop = Boolean.TRUE;
						sairDeTudo = Boolean.TRUE;
						break;
					}

					if (verificaCadastro(nome1))
						sairDoLoop = Boolean.TRUE;
					else
						System.out.println("Cadastro não encontrado!\n");

				} while (!sairDoLoop);

				if (sairDeTudo)
					break;

				do {
					sairDoLoop = Boolean.FALSE;

					System.out.printf("\nDigite 0 para sair ou nome do possível irmã(o) para continuar: ");
					nome2 = lerTexto();

					if (nome2.equalsIgnoreCase("0"))
						sairDoLoop = Boolean.TRUE;

					if (verificaCadastro(nome1))
						sairDoLoop = Boolean.TRUE;
					else
						System.out.println("Cadastro não encontrado!\n");

				} while (!sairDoLoop);

				if (verIrmandade(getPessoaLista(nome1), getPessoaLista(nome2)))
					System.out.println("São irmãos!");
				else
					System.out.println("Não são irmãos!");

				break;
			}

			case (5): {
				Boolean sairDoLoop, sairDeTudo;
				String nome1, nome2;
				do {
					sairDoLoop = Boolean.FALSE;
					sairDeTudo = Boolean.FALSE;

					System.out.printf("\nDigite 0 para sair ou nome da pessoa para continuar: ");
					nome1 = lerTexto();

					if (nome1.equalsIgnoreCase("0")) {
						sairDoLoop = Boolean.TRUE;
						sairDeTudo = Boolean.TRUE;
						break;
					}

					if (verificaCadastro(nome1))
						sairDoLoop = Boolean.TRUE;
					else
						System.out.println("Cadastro não encontrado!\n");

				} while (!sairDoLoop);

				if (sairDeTudo)
					break;

				do {
					sairDoLoop = Boolean.FALSE;

					System.out.printf("\nDigite 0 para sair ou nome do possível ancestral para continuar: ");
					nome2 = lerTexto();

					if (nome2.equalsIgnoreCase("0"))
						sairDoLoop = Boolean.TRUE;

					if (verificaCadastro(nome1))
						sairDoLoop = Boolean.TRUE;
					else
						System.out.println("Cadastro não encontrado!\n");

				} while (!sairDoLoop);

				if (verAncestralidade(getPessoaLista(nome1), getPessoaLista(nome2)))
					System.out.printf("\n%s é ancestral de %s!\n", nome1, nome2);
				else
					System.out.println("Acestralidade não encontrada!\n");

				break;
			}

			case (0): {
				System.out.println("Finalizado!\n");
				System.exit(0);
				break;
			}

			default: {
				System.out.println("\nOpção Inválida, tente novamente!\n\n");
				break;
			}
			}

		} while (menu != 0);
		leitor.close();
	}
}