package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import negocio.Bolao;

public class BolaoDAO {

	public void inserir(Bolao a) {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into bolao (nome, pais1, placar1, pais2, placar2, pais3, placar3, pais4, placar4, pais5, placar5, pais6, placar6, pais7, placar7, pais8, placar8, pais9, placar9, pais10, placar10, pais11, placar11, pais12, placar12, pais13, placar13, pais14, placar14, pais15) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			inserir.setString(1, a.getNome());
			inserir.setString(2, a.getPaises().get(0));
			inserir.setInt(3, a.getPlacares().get(0));
			inserir.setString(4, a.getPaises().get(1));
			inserir.setInt(5, a.getPlacares().get(1));
			inserir.setString(6, a.getPaises().get(2));
			inserir.setInt(7, a.getPlacares().get(2));
			inserir.setString(8, a.getPaises().get(3));
			inserir.setInt(9, a.getPlacares().get(3));
			inserir.setString(10, a.getPaises().get(4));
			inserir.setInt(11, a.getPlacares().get(4));
			inserir.setString(12, a.getPaises().get(5));
			inserir.setInt(13, a.getPlacares().get(5));
			inserir.setString(14, a.getPaises().get(6));
			inserir.setInt(15, a.getPlacares().get(6));
			inserir.setString(16, a.getPaises().get(7));
			inserir.setInt(17, a.getPlacares().get(7));
			inserir.setString(18, a.getPaises().get(8));
			inserir.setInt(19, a.getPlacares().get(8));
			inserir.setString(20, a.getPaises().get(9));
			inserir.setInt(21, a.getPlacares().get(9));
			inserir.setString(22, a.getPaises().get(10));
			inserir.setInt(23, a.getPlacares().get(10));
			inserir.setString(24, a.getPaises().get(11));
			inserir.setInt(25, a.getPlacares().get(11));
			inserir.setString(26, a.getPaises().get(12));
			inserir.setInt(27, a.getPlacares().get(12));
			inserir.setString(28, a.getPaises().get(13));
			inserir.setInt(29, a.getPlacares().get(13));
			inserir.setString(30, a.getPaises().get(14));
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Bolao> listar() {
		ArrayList<Bolao> aux = new ArrayList<Bolao>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			ResultSet resultado = conexao.prepareStatement("select * from bolao").executeQuery();

			while (resultado.next()) {
				Bolao listaBolao = new Bolao();
				
				listaBolao.setNome(resultado.getString("nome"));
				listaBolao.addPaises(resultado.getString("pais1"));
				listaBolao.addPlacares(resultado.getInt("placar1"));
				listaBolao.addPaises(resultado.getString("pais2"));
				listaBolao.addPlacares(resultado.getInt("placar2"));
				listaBolao.addPaises(resultado.getString("pais3"));
				listaBolao.addPlacares(resultado.getInt("placar3"));
				listaBolao.addPaises(resultado.getString("pais4"));
				listaBolao.addPlacares(resultado.getInt("placar4"));
				listaBolao.addPaises(resultado.getString("pais5"));
				listaBolao.addPlacares(resultado.getInt("placar5"));
				listaBolao.addPaises(resultado.getString("pais6"));
				listaBolao.addPlacares(resultado.getInt("placar6"));
				listaBolao.addPaises(resultado.getString("pais7"));
				listaBolao.addPlacares(resultado.getInt("placar7"));
				listaBolao.addPaises(resultado.getString("pais8"));
				listaBolao.addPlacares(resultado.getInt("placar8"));
				listaBolao.addPaises(resultado.getString("pais9"));
				listaBolao.addPlacares(resultado.getInt("placar9"));
				listaBolao.addPaises(resultado.getString("pais10"));
				listaBolao.addPlacares(resultado.getInt("placar10"));
				listaBolao.addPaises(resultado.getString("pais11"));
				listaBolao.addPlacares(resultado.getInt("placar11"));
				listaBolao.addPaises(resultado.getString("pais12"));
				listaBolao.addPlacares(resultado.getInt("placar12"));
				listaBolao.addPaises(resultado.getString("pais13"));
				listaBolao.addPlacares(resultado.getInt("placar13"));
				listaBolao.addPaises(resultado.getString("pais14"));
				listaBolao.addPlacares(resultado.getInt("placar14"));
				listaBolao.addPaises(resultado.getString("pais15"));
				aux.add(listaBolao);
			}
			conexao.close();
		} catch (Exception e) {

		}
		return aux;
	}

}
