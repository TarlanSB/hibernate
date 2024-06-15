package com.tarlansb;

import com.tarlansb.entity.Birthday;
import com.tarlansb.entity.Company;
import com.tarlansb.entity.PersonalInfo;
import com.tarlansb.entity.User;
import com.tarlansb.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
        Company company = Company.builder()
                .name("Google")
                .build();
        User user = User.builder()
                .username("petr@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastname("Petrov")
                        .firstname("Petr")
                        .birthDate(new Birthday(LocalDate.of(2000, 1, 2)))
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();

                User user1 = session1.get(User.class, 1L);
                Company company1 = user1.getCompany();
                String name = company1.getName();
//                session1.save(company);
//                session1.save(user);
                Object object = Hibernate.unproxy(company1);
                session1.getTransaction().commit();
            }
        }
    }
}
