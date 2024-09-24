package br.com.avancard.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=java_jdbc;user=sa;password=@dminti35;encrypt=true;trustServerCertificate=true";
    private static String password = "@dminti35";
    private static String user = "sa";
    private static Connection connection  = null;

    /*O bloco abaixo é usado para executar um conjunto de instruções antes de qualquer instância da classe ser criada.
     *É executado apenas uma vez,
     * quando a classe é carregada pela primeira vez.
     */
    static {
        conectar();
    }
    /* Construtor que chama o método conectar */
    public SingleConnection() {
        conectar();
    }

    private static void conectar(){
        try{
        if (connection == null){
            // Carrega a classe do driver JDBC do SQL Server na memória
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Estabelece uma conexão com o banco de dados utilizando a URL, usuário e senha fornecidos
            connection = DriverManager.getConnection(url, user, password);
            // Desativa o auto-commit para que as operações SQL sejam feitas manualmente (gerenciamento de transações)
            connection.setAutoCommit(false);
            System.out.println("Conectado com sucesso!");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Método estático que retorna a conexão com o banco de dados
    public static Connection getConnection() {
        return connection;
    }
}
