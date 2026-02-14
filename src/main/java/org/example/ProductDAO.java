package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {

    // ========== CREATE ==========
    public Long createProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(product);

        tx.commit();
        session.close();

        return product.getId();
    }

    // ========== READ ==========
    public Product getProductById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Product product = session.get(Product.class, id);

        session.close();
        return product;
    }

    // ========== UPDATE ==========
    public void updateProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(product);

        tx.commit();
        session.close();
    }

    // ========== DELETE ==========
    public void deleteProduct(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);

        if (product != null) {
            session.remove(product);
        }

        tx.commit();
        session.close();
    }
}
