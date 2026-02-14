package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();

            // Load hibernate.cfg.xml
            configuration.configure();

            // Programmatic properties
            Properties properties = new Properties();

            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");

            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Product.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
