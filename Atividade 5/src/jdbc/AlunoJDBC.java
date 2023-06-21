package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {
	Connection con;
	String sql;
	PreparedStatement pst;
	
	public void salvar(Aluno a) throws SQLException {
		try {
			
			con = db.getConexao();
			System.out.println("Conexao realizada com sucesso!");
			
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			pst.executeUpdate();
			System.out.println("\n Aluno foi cadastrado com sucesso!");
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
	    List<Aluno> alunos = new ArrayList<>();

	    try {
	        con = db.getConexao();
	        System.out.println("Conexão realizada com sucesso!");

	        sql = "SELECT * FROM aluno";
	        pst = con.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            Aluno aluno = new Aluno();
	            aluno.setNome(rs.getString("nome"));
	            aluno.setSexo(rs.getString("sexo"));
	            aluno.setDt_nasc(rs.getDate("dt_nasc"));
	            alunos.add(aluno);
	        }

	        System.out.println("\nLista de alunos:");
	        for (Aluno aluno : alunos) {
	            System.out.println("Nome: " + aluno.getNome());
	            System.out.println("Sexo: " + aluno.getSexo());
	            System.out.println("Data de Nascimento: " + aluno.getDt_nasc());
	            System.out.println();
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return alunos;
	}
	
	public Aluno buscarAlunoPorId(int id) throws SQLException {
	    Aluno aluno = null;

	    try {
	        con = db.getConexao();
	        System.out.println("Conexão realizada com sucesso!");

	        sql = "SELECT * FROM aluno WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            aluno = new Aluno();
	            aluno.setId(rs.getInt("id"));
	            aluno.setNome(rs.getString("nome"));
	            aluno.setSexo(rs.getString("sexo"));
	            aluno.setDt_nasc(rs.getDate("dt_nasc"));
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return aluno;
	}


	
	public void apagar(int id) throws SQLException {
	    try {
	        con = db.getConexao();
	        System.out.println("Conexão realizada com sucesso!");

	        sql = "DELETE FROM aluno WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id);
	        pst.executeUpdate();
	        System.out.println("Aluno excluído com sucesso!");

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

	
	public void alterar(Aluno aluno) throws SQLException {
	    try {
	        con = db.getConexao();
	        System.out.println("Conexão realizada com sucesso!");

	        sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ? WHERE id = ?";
	        pst = con.prepareStatement(sql);
	        pst.setString(1, aluno.getNome());
	        pst.setString(2, aluno.getSexo());
	        Date dataSql = new Date(aluno.getDt_nasc().getTime());
	        pst.setDate(3, dataSql);
	        pst.setInt(4, aluno.getId()); // Supondo que existe um atributo "id" na classe Aluno
	        pst.executeUpdate();
	        System.out.println("Aluno alterado com sucesso!");

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

}
