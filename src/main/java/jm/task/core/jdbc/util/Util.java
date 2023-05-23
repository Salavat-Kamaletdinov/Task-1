package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Property;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД
    public static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static final String username = "postgres";
    public static final String userpassword = "postgres";
    public static final String driver_class = "org.postgresql.Driver";
    private static SessionFactory sessionFactory;

    private static Properties properties = new Properties();

    //public static SessionFactory getSessionFactory;
    static {
        try {
            properties.load(Util.class.getClassLoader().getResourceAsStream("1.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static SessionFactory sessionFactory() throws SQLException {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
//            configuration.setProperty("hibernate.connection.driver_class", driver_class);
//            configuration.setProperty("hibernate.connection.url", url);
//            configuration.setProperty("hibernate.connection.username", username);
//            configuration.setProperty("hibernate.connection.password", userpassword);
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }


}
