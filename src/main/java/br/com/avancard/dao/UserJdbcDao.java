package br.com.avancard.dao;

import br.com.avancard.conexaojdbc.SingleConnection;
import br.com.avancard.model.Userjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao {

    private Connection connection;

    public UserJdbcDao() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(Userjdbc userjdbc) {
        try{
            String sql = "insert into user_java_jdbc values(?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, userjdbc.getNm_user());
            stmt.setString(2, userjdbc.getEmail());
            stmt.execute();
            connection.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Userjdbc> listar(){
        List<Userjdbc> lista = new ArrayList<Userjdbc>();
        try{
            String sql = "select * from user_java_jdbc";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                Userjdbc userjdbc = new Userjdbc();
                userjdbc.setCd_user(result.getLong("cd_user"));
                userjdbc.setNm_user(result.getString("nm_user"));
                userjdbc.setEmail(result.getString("email"));
                lista.add(userjdbc);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Userjdbc> buscar(String parametro){
        List<Userjdbc> lista = new ArrayList<>();
        try{
            String sql = "select * from user_java_jdbc where nm_user like ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + parametro + "%");
            ResultSet result = stmt.executeQuery();

            while(result.next()) {
               Userjdbc userjdbc = new Userjdbc();
               userjdbc.setCd_user(result.getLong("cd_user"));
               userjdbc.setNm_user(result.getString("nm_user"));
               userjdbc.setEmail(result.getString("email"));
               lista.add(userjdbc);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
return lista;
    }

    public void atualizar(String parametro, long cd_user){
        try{
            String sql = "update user_java_jdbc set email = ? where cd_user = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, parametro );
            stmt.setLong(2, cd_user);
            stmt.execute();
            connection.commit();
            System.out.println("executei");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(long cd_user){

        try{

            String sql = "delete from user_java_jdbc where cd_user = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, cd_user);
            stmt.execute();
            connection.commit();
            System.out.println("Registro deletado com sucesso");
        }catch (Exception e) {

            e.printStackTrace();
        }
    }
}
