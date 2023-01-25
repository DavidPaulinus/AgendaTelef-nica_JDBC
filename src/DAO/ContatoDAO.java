package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Contato;
import util.Conversao;

public class ContatoDAO {

	private Connection conn;

	public ContatoDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Contato contato) throws SQLException {
		try (PreparedStatement ps = conn
				.prepareStatement("INSERT INTO contatos(NOME, NUMERO, TIPO, EMAIL, FAVORITO) VALUES(?,?,?,?,?)")) {
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getNumero());
			ps.setString(3, contato.getTipo());
			ps.setString(4, contato.getEmail());
			ps.setBoolean(5, contato.getFavorito());

			ps.execute();

			System.out.println("Contato " + contato.getNome() + " salvo com sucesso!");
		}
	}

	public void listar() throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos")) {
			ps.execute();

			ResultSet result = ps.getResultSet();
			while (result.next()) {
				Conversao.formatoContato(result);
			}
		}
	}

	public void listarFav() throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos")) {
			ps.execute();

			ResultSet result = ps.getResultSet();
			while (result.next()) {
				if (result.getBoolean("FAVORITO") == true) {
					Conversao.formatoContato(result);
				}
			}
		}
	}

	public void mostrar(String nome) throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos WHERE NOME = ?")) {
			ps.setString(1, nome);
			
			ps.execute();
			
			ResultSet re = ps.getResultSet();
			while (re.next()) {
				Conversao.formatoContato(re);
			}
		}
	}

	public void alterar(String nome, Integer n, String dado) throws SQLException {
		switch (n) {
		case 1:
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET NOME = ? WHERE NOME = ?")) {
				ps.setString(1, dado);
				ps.setString(2, nome);

				ps.execute();
			}
			break;
		case 2:
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET NUMERO = ? WHERE NOME = ?")) {
				ps.setString(1, dado);
				ps.setString(2, nome);

				ps.execute();
			}
			break;
		case 3:
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET TIPO = ? WHERE NOME = ?")) {
				ps.setString(1, dado);
				ps.setString(2, nome);

				ps.execute();
			}
			break;
		case 4:
			try (PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET EMAIL = ? WHERE NOME = ?")) {
				ps.setString(1, dado);
				ps.setString(2, nome);

				ps.execute();
			}
			break;
		case 5:
			try (PreparedStatement ps = conn.prepareStatement("SELECT favorito FROM contatos WHERE NOME = ?")) {
				ps.setString(1, nome);
				ps.execute();
				ResultSet rs = ps.getResultSet();

				try (PreparedStatement ps2 = conn.prepareStatement("UPDATE contatos SET FAVORITO = ? WHERE NOME = ?")) {
					ps2.setString(2, nome);
					if (rs.getBoolean("FAVORITO") == true) {
						ps2.setBoolean(1, true);
					} else {
						ps2.setBoolean(1, false);
					}

					ps2.execute();
				}
			}
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}

		System.out.println("Contato " + nome + " alterado com sucesso!");

	}

	public void deletar(String nome) throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement("DELETE FROM contatos WHERE NOME = ?")) {
			ps.setString(1, nome);

			ps.execute();
			System.out.println("Contato " + nome + " excluído");
		}
	}

}
