package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Anuncio;
import util.ConnectionFactory;

//classe responsável por fazer as operaçôes que envolve interação com o banco de dados
public class AnuncioDAO {
	
	//funcao que adiciona um anuncio ao banco 
	public static void addAnuncio(Anuncio anuncio) {
			
		String sql;
		Connection conexao = null;
		try {
			//cria conexao com o banco
			conexao = ConnectionFactory.getConnection();
		
			//insere na base de dados
			sql = "INSERT INTO anuncio (nome,cliente,datainicio,datafinal,investimento) values (?, ?, ?, ?,? )";
			
			//prepara o sql 
			PreparedStatement  prepareStatement = conexao.prepareStatement(sql);
	    			
	        prepareStatement.setString(1, anuncio.getNome());
	        prepareStatement.setString(2, anuncio.getCliente());
	        prepareStatement.setDate(3, anuncio.getDataInicio());
	        prepareStatement.setDate(4, anuncio.getDataFinal());
	        prepareStatement.setDouble(5, anuncio.getInvestimentoPorDia());
	        
	        //executa o sql 
	        prepareStatement.executeUpdate();
	        //fecha conexao
	        
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//funcão que retorna todos os anuncios cadastrados
	public static ArrayList<Anuncio> pesquisaAnuncios() {
		ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
		ResultSet resultado = null;
		Statement stm = null;
		
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql = "Select * from anuncio";
			stm = con.createStatement();
			resultado = stm.executeQuery(sql);
			
			while (resultado.next()) {
				Anuncio anuncio = new Anuncio();
				popularAnuncio(anuncio,resultado);
				anuncios.add(anuncio);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return anuncios;
	}
	// Popula os campos de anuncio a partir do resultado de uma consulta sql
	private static void popularAnuncio(Anuncio anuncio, ResultSet resultado) throws SQLException {
		anuncio.setCliente(resultado.getString("cliente"));
		anuncio.setDataFinal(resultado.getDate("datafinal"));
		anuncio.setDataInicio(resultado.getDate("datainicio"));
		anuncio.setInvestimentoPorDia(resultado.getInt("investimento"));
		anuncio.setNome(resultado.getString("nome"));
		
	}
}
