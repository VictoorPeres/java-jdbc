package br.com.avancard.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=java_jdbc;user=sa;password=@dminti35;encrypt=true;trustServerCertificate=true";
    private static String user = "sa";
    private static String pass = "@dminti35";
    private static Connection connection = null;

    static {
        conectar();
    }

    public SingleConnection() {
        conectar();
    }

    public static void conectar(){
        if(connection == null){
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, user, pass);
                connection.setAutoCommit(false);
                System.out.println("Conectado com sucesso!");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
