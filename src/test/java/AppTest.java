import br.com.avancard.conexaojdbc.SingleConnection;
import br.com.avancard.dao.UserJdbcDao;
import br.com.avancard.model.BeanUserFone;
import br.com.avancard.model.Telefonejdbc;
import br.com.avancard.model.Userjdbc;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest {
    @Test
    public void initInserir() {

        Userjdbc user = new Userjdbc();
        UserJdbcDao dao = new UserJdbcDao();

        user.setNm_user("Jose Mendes");
        user.setEmail("josem@gmail.com");
        dao.salvar(user);
    }
    @Test
    public void initInserirTelefone() {

        Telefonejdbc telefone = new Telefonejdbc();
        UserJdbcDao dao = new UserJdbcDao();

        telefone.setNumero("92984357215");
        telefone.setCd_usuario(1);
        dao.salvarTelefone(telefone);
    }
    @Test
    public void initListar() {

        UserJdbcDao userJdbcDao = new UserJdbcDao();

        for (Userjdbc user : userJdbcDao.listar()){
            System.out.println("###########################");
            System.out.println("Código: " + user.getCd_user());
            System.out.println("Email: " + user.getNm_user());
            System.out.println("Nome: " + user.getEmail());
        }
    }

    @Test
    public void initBuscar() {

        UserJdbcDao userJdbcDao = new UserJdbcDao();
        for (Userjdbc user : userJdbcDao.buscar("y")){
            System.out.println("Código: " + user.getCd_user());
            System.out.println("Nome: " + user.getNm_user());
            System.out.println("Email: " + user.getEmail());
        }
    }

    @Test
    public void initAtualizar() {

    UserJdbcDao userJdbcDao = new UserJdbcDao();
    long cd_user = 1;
    String email = "email@alterado.com";
    userJdbcDao.atualizar(email, cd_user);
    }

    @Test
    public void initDeletar() {

        UserJdbcDao userJdbcDao = new UserJdbcDao();
        long cd_user = 2;
        userJdbcDao.deletar(cd_user);
    }
    @Test
    public void initUserFone() {

        UserJdbcDao userJdbcDao = new UserJdbcDao();
        List<BeanUserFone> bean = userJdbcDao.listaUserFone(1);

        for (BeanUserFone beanUserFone : bean){
            System.out.println("Nome: " + beanUserFone.getNome());
            System.out.println("Número: " + beanUserFone.getNumero());
            System.out.println("Email: " + beanUserFone.getEmail());
        }
    }
}
