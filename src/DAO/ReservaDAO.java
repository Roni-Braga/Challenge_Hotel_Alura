package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;

public class ReservaDAO {

	
		private Connection connection;
		
		public ReservaDAO(Connection connection) {
			this.connection = connection;
		}
		public void CadastraReserva(Reserva reserva) {
			try{
				String sql = "INSERT INTO reserva (DATA_ENTRADA,DATA_SAIDA,VALOR,FORMA_PAGAMENTO) VALUES (?,?,?,?)";
			
			
			try(PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
				pstm.setDate(1, reserva.getData_entrada());		
				pstm.setDate(2, reserva.getData_saida());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getForma_pagamento());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
			}catch(SQLException e) {
					throw new RuntimeException(e);
			}
		}
		public Reserva BuscarReservaPorID(int id) {
			String sql = "SELECT * FROM reserva WHERE id = ?";
			Reserva reserva = null;
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setInt(1, id);
				try(ResultSet rs = pstm.executeQuery()){
					if(rs.next()) {
						reserva = new Reserva(null, null, sql, sql);
						reserva.setId(rs.getInt("id"));
						reserva.setData_entrada(rs.getDate("data_entrada"));
						reserva.setData_saida(rs.getDate("data_saida"));
						reserva.setValor(rs.getString("valor"));
						reserva.setForma_pagamento(rs.getString("forma_pagamento"));
						
					}
				}
			}catch(SQLException e) {
				System.out.println("Erro ao buscar reserva por ID: " + e.getMessage());
				
			}
			return reserva;
			
		}
		public List<Reserva> buscar(){
			List<Reserva> reservas = new ArrayList<Reserva>();
			
			try {
				String sql = "SELECT * FROM reserva";
				try(PreparedStatement pstm = connection.prepareStatement(sql)){
					pstm.execute();
					
					transformarResultSetEmReserva(reservas,pstm);
				}
				return reservas;
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		private void transformarResultSetEmReserva(List<Reserva> reservas,PreparedStatement pstm) {
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Reserva reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));
				reservas.add(reserva);
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		public void deletar(Integer id) {
			try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM reserva WHERE ID = ?")){
				pstm.setInt(1, id);
				pstm.execute();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		 public void alterar(Date dataEntrada, Date dataSaida, String valor, String forma_pagamento, Integer id) {
		        try (PreparedStatement pstm = connection.prepareStatement("UPDATE reserva r SET r.data_entrada = ?, r.data_saida = ?, valor = ?, forma_pagamento = ? WHERE ID = ?")) {
		            pstm.setDate(1, dataEntrada);
		            pstm.setDate(2, dataSaida);
		            pstm.setString(3, valor);
		            pstm.setString(4, forma_pagamento);
		            pstm.setInt(5, id);
		            pstm.execute();
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		    }
}
			
			
			
			
		

	


