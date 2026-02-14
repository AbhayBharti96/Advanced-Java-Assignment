package org.example;

public class Main {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // -------- CREATE --------
        Product product = new Product();
        product.setName("Laptop");
        product.setDescription("Gaming Laptop");
        product.setCategory("Electronics");
        product.setQuantity(5);
        product.setPrice(85000);
        product.setSku("LAP001");
        product.setActive(true);

        Long id = dao.createProduct(product);
        System.out.println("Created Product ID: " + id);

        // -------- READ --------
        Product fetched = dao.getProductById(id);
        System.out.println("Fetched Product: " + fetched.getName());

        // -------- UPDATE --------
        fetched.setPrice(80000);
        dao.updateProduct(fetched);
        System.out.println("Updated Successfully");

        // -------- DELETE --------
        dao.deleteProduct(id);
        System.out.println("Deleted Successfully");

        HibernateUtil.getSessionFactory().close();
    }
}
