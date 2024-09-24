package br.com.avancard.pos_java_jdbc;

import br.com.avancard.conexaojdbc.SingleConnection;
import br.com.avancard.dao.UserJavaDao;
import br.com.avancard.model.Userjavajdbc;
import org.junit.Test;

public class TesteBancoJdbc {

    @Test /* Anotação de teste junit*/
    public void  initInserir(){

        UserJavaDao userJavaDao = new UserJavaDao(); /* Instanciando um objeto tipo UserJavaDao */
        Userjavajdbc userjavajdbc = new Userjavajdbc(); /* Instanciando um objeto tipo userjavajdbc */

        userjavajdbc.setCd_user(5);
        userjavajdbc.setNm_user("Joaquim Mendes");
        userjavajdbc.setEmail("joaquim@gmail.com");

        userJavaDao.salvar(userjavajdbc);


        /*for( Userjavajdbc u : userJavaDao.listar()){
            System.out.println("###################");
            System.out.println("id_user: " + u.getCd_user());
            System.out.println("Nome: " + u.getNm_user());
            System.out.println("Email: " + u.getEmail());
        }*/
    }

    @Test /* Anotação de teste junit*/
    public void  initListar(){

        UserJavaDao userJavaDao = new UserJavaDao(); /* Instanciando um objeto tipo UserJavaDao */
        Userjavajdbc userjavajdbc = new Userjavajdbc(); /* Instanciando um objeto tipo userjavajdbc */

        for( Userjavajdbc u : userJavaDao.listar()) {
            System.out.println("###################");
            System.out.println("id_user: " + u.getCd_user());
            System.out.println("Nome: " + u.getNm_user());
            System.out.println("Email: " + u.getEmail());
        }
    }

    @Test /* Anotação de teste junit*/
    public void  initBuscar(){

        UserJavaDao userJavaDao = new UserJavaDao(); /* Instanciando um objeto tipo UserJavaDao */

        for( Userjavajdbc u : userJavaDao.listaFiltro("a")){
            System.out.println(u.getEmail());
        }

    }
}
