package modelo;

import java.sql.Date;
import java.util.Objects;

public class Hospede {
	private int id;
	private String nome;
	private String sobrenome;
	private Date data_nascimento;
	private String nacionalidade;
	private String telefone;
	private int id_reserva;
	
	public Hospede() {
		
	}
	
	public Hospede(String nome, String sobrenome, Date data_nascimento, String nacionalidade, String telefone,
			int id_reserva) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_nascimento = data_nascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.id_reserva = id_reserva;
	}
	
	
	
//	public Hospede(int id, String nome, String sobrenome, Date data_nascimento, String nacionalidade, String telefone,
//			int id_reserva) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.sobrenome = sobrenome;
//		this.data_nascimento = data_nascimento;
//		this.nacionalidade = nacionalidade;
//		this.telefone = telefone;
//		this.id_reserva = id_reserva;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	@Override
	public String toString() {
		return "Hospede {" +
				"id=" +id+
				",nome='"+nome+'\'' +
				",sobrenome='"+sobrenome+'\''+
				",data_nascimento="+data_nascimento+
				",nacionalidade='"+nacionalidade+'\''+
				",telefone='"+telefone+'\''+
				'}';
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return id == hospede.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



	
	
	
}
