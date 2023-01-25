package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Conversao {

	public static String ehFavorito(Boolean boo) {
		if(boo == true) {
			return "FAVORITO!";
		}else {
			return "";
		}
	}
	
	public static void formatoContato(ResultSet re) throws SQLException {
		System.out.println("\nNome: " + re.getString("NOME")
		+ "\nNúmero: " + re.getString("NUMERO")
		+ "\nTipo: " + re.getString("TIPO") 
		+ "\nE-mail: " + re.getString("EMAIL")
		+ "\nFavorito: " + ehFavorito(re.getBoolean("FAVORITO")));
	}
	
}
