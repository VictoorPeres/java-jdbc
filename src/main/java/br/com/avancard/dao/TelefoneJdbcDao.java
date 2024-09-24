package br.com.avancard.dao;

import br.com.avancard.conexaojdbc.SingleConnection;

import java.sql.Connection;

public class TelefoneJdbcDao {
    private Connection connection;

    public TelefoneJdbcDao() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(TelefoneJdbcDao telefoneJdbcDao) {
        String sql = "INSERT INTO telefone VALUES (?,?,?,?)";
    }

}
