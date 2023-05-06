package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.ReservaDAO;
import Factory.ConnectionFactory;
import modelo.Reserva;


public class ReservaController {
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
		Connection connection = new ConnectionFactory().RecConexao();
		this.reservaDAO = new ReservaDAO(connection);
		
	}
	public void CadastraReserva(Reserva reserva) {
		this.reservaDAO.CadastraReserva(reserva);
	}
	public List<Reserva> Buscar() {
		return this.reservaDAO.buscar();
	}
	public Reserva BuscarReservaPorID(int id) {
		return reservaDAO.BuscarReservaPorID(id);
	}
	public void deletarReserva(int id) {
		this.reservaDAO.deletar(id);
	}
	public void alterarReserva(Date dataentrada, Date dataSaida, String valor, String forma_pagamento,Integer id) {
		this.reservaDAO.alterar(dataentrada, dataSaida, valor, forma_pagamento, id);
	}
}
