package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	/** Modulo de conexão **/
	// parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";
	// metodo de conexao

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/** CRUD CREATE **/
	public void InserirContatos(JavaBeans contato) {
		String create = "Insert into contados (nome,fone,email) values (?,?,?)";
		try {
			// abrir a conexao com o banco
			Connection con = conectar();
			// preparar a query para execuçao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os paramêTROS (?) pelo conteudo das variaveis JavaBeans

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// executar a query
			pst.executeUpdate();
			// encerrando a conexao com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}
	
	
	// CRUD READ // 
	

	/*
	 * teste de conexao public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); }
	 */
}
