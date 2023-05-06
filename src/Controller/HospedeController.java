package Controller;

import java.sql.Connection;
import java.sql.Date;

import DAO.HospedeDAO;
import Factory.ConnectionFactory;
import modelo.Hospede;

public class HospedeController {
	private HospedeDAO hospedeDAO;
	
	
	public HospedeController() {
		Connection connection = new ConnectionFactory().RecConexao();
		this.hospedeDAO = new HospedeDAO(connection);
	}
	
	public void CadastraHospede(Hospede hospede) {
		this.hospedeDAO.CadastraHospede(hospede);
	}
	public Hospede BuscaHospedePorNome(String nome) {
		return hospedeDAO.buscaPorNome(nome);
	}
	public void deletarHospede(int id) {
		this.hospedeDAO.deletar(id);
	}
	public void alterarDadosHospede(String nome, String sobrenome,Date data_nascimento,String nacionalidade, String tell, Integer id ) {
		this.hospedeDAO.alterar(nome, sobrenome, data_nascimento, nacionalidade, tell, id);
	}
}
