package com.tarlansb;

import com.tarlansb.converter.BirthdayConverter;
import com.tarlansb.entity.User;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
//        BlockingDeque<Connection> pool = null;
//        Connection connection = pool.take();
//        SessionFactory

//        Connection connection = DriverManager
//                .getConnection("db.url", "db.username", "db.password");
//        Session
        Configuration configuration = new Configuration();
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAnnotatedClass(User.class);
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.registerTypeOverride(new JsonBinaryType());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

//            User user = User.builder()
//                    .username("ivan9@gmail.com")
//                    .firstname("Ivan")
//                    .lastname("Ivanov")
//                    .info("""
//                            {
//                                "name": "Ivan",
//                                "id": 25
//                            }
//                            """)
//                    .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
//                    .role(Role.ADMIN)
//                    .build();
            /**
            Если отсутствует user, то StateObjectStateException
             */
//            session.update(user)

            /**
             Если отсутствует user, то создать
             */
//            session.saveOrUpdate(user)

//            session.delete(user);

            User user = session.get(User.class, "ivan@gmail.com");

            session.getTransaction().commit();
        }
    }
}
