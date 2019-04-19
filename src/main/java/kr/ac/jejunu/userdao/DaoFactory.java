package kr.ac.jejunu.userdao;

public class DaoFactory {

    public UserDao getUserDao() {
        return new UserDao(getConnection());
    }

    public ConnectionMaker getConnection() {
        return new JejuConnectionMaker();
    }

}
