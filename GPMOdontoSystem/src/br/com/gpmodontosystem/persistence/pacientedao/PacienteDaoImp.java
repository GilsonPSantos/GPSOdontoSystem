package br.com.gpmodontosystem.persistence.pacientedao;

import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import br.com.gpmodontosystem.model.Paciente;
import br.com.gpmodontosystem.persistence.dao.Dao;

public class PacienteDaoImp extends Dao implements IPacienteDao {
//ver melhor esse m�todo, pois paciente � uma pessoa e no final nem precisa dos atributos dele, basta uma classe sem
	//ID pq o ID � da classe pessoa
	@Override
	public void inserir(Paciente p) throws Exception {
		opne();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PACIENTE (PAC_ATIVO, PAC_CADASTRO, PAC_ATUALIZACAO, PESSOA_PES_CODIGO) ");
		sql.append("VALUES (?, ?, ?, ?)");
		stmt = con.prepareStatement(sql.toString() , Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, p.getFlagAtivo());
		java.sql.Date data = new java.sql.Date(p.getDataCadastro().getTime().getTime());
		stmt.setDate(2, data);
		data = new java.sql.Date(p.getDataAtualizacao().getTime().getTime());
		stmt.setDate(3, data);
		stmt.setInt(4, p.getIdPessoa());
		rs = stmt.executeQuery();
		
	
	close();
	}

	@Override
	public void consultarPeloId(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Paciente p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paciente> listarPacientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

public static void main(String[] args) {
	Calendar c = Calendar.getInstance();
	java.sql.Date data = new java.sql.Date(c.getTime().getTime());
	System.out.println(data);
}

}