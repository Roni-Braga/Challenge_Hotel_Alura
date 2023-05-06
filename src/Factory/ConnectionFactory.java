package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
		
	// uma classe de conexão precisa do DataSource
			
		private DataSource datasource;
		public ConnectionFactory() {
			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel?useTimezone=true&serverTimezone=UTC");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("admin");
			
			this.datasource = comboPooledDataSource;
			
		}
		public Connection RecConexao() {
			try {
				return this.datasource.getConnection();
				
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		
		

	

}
