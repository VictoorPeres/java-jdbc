package br.com.avancard.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.avancard.conexaojdbc.SingleConnection;
import br.com.avancard.model.Userjavajdbc;
import org.w3c.dom.ls.LSOutput;

public class UserJavaDao {
//Declarando o atributo connection para receber um objeto do tipo Connection
private Connection connection;

//Construtor atribuindo o SingleConnection.getConnection() ao atributo connection para realizar a conexão com o banco e as instruções SQL
public UserJavaDao() {
    connection = SingleConnection.getConnection();
}

/* Método para realizar inserts na tabela user_java_jdbc do banco de dados */
public void salvar(Userjavajdbc userjavajdbc) {/* o metodo recebe por parametro um objeto tipo Userjavajdbc que é o model da tabela user_java_jdbc  */
    try {
        String sql = "insert into user_java_jdbc (cd_user,nm_user,email) values(?,?,?)"; /* Atribuindo a instrução sql a uma variavel tipo string */
        PreparedStatement insert = connection.prepareStatement(sql); /* Instanciando um objeto tipo PreparedStatement que recebe o atributo connection seguido do metodo prepareStatement que recebe por parametro a variavel que armazena a instrução sql  */
        insert.setLong(1, userjavajdbc.getCd_user());
        insert.setString(2, userjavajdbc.getNm_user());
        insert.setString(3, userjavajdbc.getEmail());
        insert.execute();
        connection.commit();/* Confirma a instrução  que foi passada para o banco */

    } catch (SQLException e) {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
    }

}

/* Método para listar todos os users do banco */
public List<Userjavajdbc> listar() {

    List<Userjavajdbc> list = new ArrayList<>();
    try {
        String sql = "select * from user_java_jdbc";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Userjavajdbc userjavajdbc = new Userjavajdbc();
            userjavajdbc.setCd_user(resultSet.getLong("cd_user"));
            userjavajdbc.setNm_user(resultSet.getString("nm_user"));
            userjavajdbc.setEmail(resultSet.getString("email"));
            list.add(userjavajdbc);
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

/*Método de busca por aproximação usando a coluna nm_user*/
public List<Userjavajdbc> listaFiltro(String parametro) {
    List<Userjavajdbc> list = new ArrayList<>();
    try{
        String sql = "select * from user_java_jdbc where nm_user like ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + parametro + "%");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Userjavajdbc userjavajdbc = new Userjavajdbc();
            userjavajdbc.setCd_user(resultSet.getLong("cd_user"));
            userjavajdbc.setNm_user(resultSet.getString("nm_user"));
            userjavajdbc.setEmail(resultSet.getString("email"));

            list.add(userjavajdbc);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
}
