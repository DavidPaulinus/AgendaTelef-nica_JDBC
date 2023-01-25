package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.ContatoDAO;
import infra.ConnectionFactory;
import modelo.Contato;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		ConnectionFactory coF= new ConnectionFactory();
//		Connection conn = coF.getConection();

		try (Connection conn = new ConnectionFactory().getConection();) {
			ContatoDAO contt = new ContatoDAO(conn);

			while (true) {
				System.out.print("O que fazer? " 
						+ "\nSalvar novo contato - 1" 
						+ "\nListar contatos     - 2"
						+ "\nListar favoritos    - 3" 
						+ "\nMostrar contato     - 4" 
						+ "\nAlterar contato     - 5"
						+ "\nDeletar contato     - 6" 
						+ "\nR: ");
				int opcao = sc.nextInt();
				sc.nextLine();
				
				switch (opcao) {
				case 1:
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Número: ");
					String numero = sc.nextLine();
					System.out.print("Tipo: ");
					String tipo = sc.nextLine();
					System.out.print("E-mail: ");
					String email = sc.nextLine();
					System.out.print("Favorito? [s]/[n] ");
					String favorito = sc.nextLine();
					if (favorito.equalsIgnoreCase("s")) {
						contt.salvar(new Contato(nome, numero, tipo, email, true));

					} else {
						contt.salvar(new Contato(nome, numero, tipo, email, false));

					}
					break;
					
				case 2:
					contt.listar();
					break;
					
				case 3:
					contt.listarFav();
					break;
					
				case 4:
					System.out.print("\nNome: ");
					contt.mostrar(sc.nextLine());
					break;
					
				case 5:
					contt.listar();
					System.out.print("\nNome do contato: ");
					nome = sc.nextLine();
					System.out.print("O que alterar: " 
							+ "\nNome     - 1" 
							+ "\nNúmero   - 2" 
							+ "\nTipo     - 3"
							+ "\nE-mail   - 4" 
							+ "\nFavorito - 5"
							+ "\nR: ");
					Integer n = sc.nextInt();
					if (n == 5) {
						contt.alterar(nome, n, null);
					} else {
						sc.nextLine();
						System.out.print("\nNovo dado: ");
						String dado = sc.nextLine();
						contt.alterar(nome, n, dado);

					}
					break;
					
				case 6:
					contt.listar();
					System.out.print("\nNome: ");
					contt.deletar(sc.nextLine());
					break;
					
				default:
					System.out.println("\nOpção inválida\n");
					continue;
				}

				System.out.print("\nMais alguma coisa? [s]/[n] ");
				String resp = sc.nextLine();
				if (resp.equalsIgnoreCase("n")) {
					break;
				}
			}

		} catch (SQLException e) {
			
		}

		sc.close();

	}

}
