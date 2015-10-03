package com.atividade.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atividade.entidades.Usuario;


public class UsuarioDAO extends BaseDAO {


	public void insere(Usuario usuario){  
		conectar();  
		try {  
			String sql = "insert into usuario (nome, login, senha,confSenha) values(?,?,?,?) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getConfSenha());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {  
			e.printStackTrace();
		} finally {  
			fechar();  
		}  
	}

	public void delete(Usuario usuario){  
		conectar();  
		try {  
			
			System.out.println("Passei no deleteDaousuario:" + usuario.getId());
			comando.executeUpdate("delete from usuario where id = "+
					usuario.getId());  
			System.out.println("Excluído!");  
		} catch (SQLException e) {  
			e.printStackTrace();
		} finally {  
			fechar();  
		}  
	}

	public List<Usuario> buscarTodos() {  
		conectar();  
		List<Usuario> resultados = new ArrayList<Usuario>();  
		ResultSet rs;  
		try {  
			rs = comando.executeQuery("select * from usuario");  
			while (rs.next()) {  
				Usuario temp = new Usuario();
				temp.setId(rs.getInt("id"));  
				temp.setNome(rs.getString("nome"));
				temp.setLogin(rs.getString("login"));
				temp.setSenha(rs.getString("senha"));
				resultados.add(temp);  
			}  
			return resultados;  
		} catch (SQLException e) {  
			e.printStackTrace();
			return null;  
		}  
	}  

	public Usuario buscarPorId(int id) {  
		conectar();   
		Usuario temp = new Usuario(); 
		ResultSet rs;  
		try {  
			rs = comando.executeQuery("");  
			while (rs.next()) {  
				temp.setId(rs.getInt("id"));  
				temp.setNome(rs.getString("nome"));   
			}  
			return temp;  
		} catch (SQLException e) {  
			e.printStackTrace();
			return null;  
		}  
	}  


	public Usuario buscarPorLogin(String login) {  
		conectar();   
		Usuario temp = new Usuario(); 
		ResultSet rs;  
		try {  
			rs = comando.executeQuery("select * from usuario where login = '"+login+"'");  
			while (rs.next()) {  
				temp.setId(rs.getInt("id"));  
				temp.setNome(rs.getString("nome"));   
				temp.setLogin(rs.getString("login"));   
				temp.setSenha(rs.getString("senha"));   
			}  
			return temp;  
		} catch (SQLException e) {  
			e.printStackTrace();
			return null;  
		}  
	}  

	public void atualizar(Usuario usuario) {  
		conectar();  
		try {  
			String sql = "update usuario set nome = ?"+
					"', login = ?"+
					"', senha = ?"+
					"', confSenha = ?"+
					"' where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getConfSenha());
			ps.setInt(5, usuario.getId());
			
			ps.execute();
			ps.close();  
		} catch (SQLException e) {  
			e.printStackTrace();  
		} finally {  
			fechar();  
		}  
	}  


}
