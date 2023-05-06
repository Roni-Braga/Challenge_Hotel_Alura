package Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

		public static void main(String[] args) throws SQLException {
			
		Connection connection = new ConnectionFactory().RecConexao();
		System.out.println("Fechando conexao");
		
		connection.close();
		
		}
}