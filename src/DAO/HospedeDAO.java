package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Hospede;

public class HospedeDAO {

	private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
		
	}
	
	public void CadastraHospede(Hospede hospede) {
		
		String sql = "INSERT INTO hospede (NOME,SOBRENOME,DATA_NASCIMENTO,NACIONALIDADE,TELEFONE,ID_RESERVA) VALUES (?,?,?,?,?,?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1,hospede.getNome());
			pstm.setString(2, hospede.getSobrenome());
			pstm.setDate(3,Date.valueOf(hospede.getData_nascimento().toLocalDate()));
			pstm.setString(4, hospede.getNacionalidade());
			pstm.setString(5, hospede.getTelefone());
			pstm.setInt(6, hospede.getId_reserva());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				if(rst.next()) {
					hospede.setId(rst.getInt(1));
				}
			}
		}
	catch(SQLException e) {
		System.out.println("Não foi possível inserir o hospede:" +e.getMessage());
	}
	}
	

		public Hospede buscaPorNome(String nome) {
			Hospede hospede = null;
			String sql = "SELECT * FROM hospede WHERE NOME LIKE ?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setString(1,"%" + nome +"%");
				try(ResultSet rs = pstm.executeQuery()){
					while(rs.next()) {
						hospede = new Hospede();
						hospede.setId(rs.getInt("id"));
						hospede.setNome(rs.getString("nome"));
						hospede.setSobrenome(rs.getString("sobrenome"));
						hospede.setData_nascimento(rs.getDate("data_nascimento"));
						hospede.setNacionalidade(rs.getString("nacionalidade"));
						hospede.setTelefone(rs.getString("telefone"));
						hospede.setId_reserva(rs.getInt("Id_reserva"));
						
					}
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			return hospede;
			}
		public void deletar(Integer id) {
			try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM hospede WHERE ID = ?")){
				pstm.setInt(1, id);
				pstm.execute();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
				
	
		public void alterar(String nome, String sobrenome, Date data_nascimento,String nacionalidade, String tell, Integer id) {
			try(PreparedStatement pstm = connection.prepareStatement("UPDATE hospede h SET h.nome = ?, h.sobrenome = ?, h.data_nascimento = ?, h.nacionalidade = ?, h.telefone = ? WHERE ID = ? ")){
				pstm.setString(1, nome);
				pstm.setString(2,sobrenome);
				pstm.setDate(3, data_nascimento);
				pstm.setString(4, nacionalidade);
				pstm.setString(5, tell);
				pstm.setInt(6, id);
				pstm.execute();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
				
			}
			
		


