package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		
		
		
		
		String read = "select * from contados order by nome";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo enquanto houver contatos
			while (rs.next()) {
				
				// variaveis de apoio que recebem os dados do banco 
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				//populando o ArrayList 
				contatos.add(new JavaBeans(idcon,nome,fone,email));	
			}
			
			con.close();
			return contatos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	

	/*
	 * teste de conexao public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); }
	 */
}
