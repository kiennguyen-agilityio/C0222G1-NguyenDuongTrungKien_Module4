package codegym.repository.impl;

import codegym.model.Product;
import codegym.repository.ProductRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductRepoImpl implements ProductRepo {

    @Override
    public List<Product> findAll() {

        List<Product> products = BaseRepository.entityManager.createQuery("select p from product p ", Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);//persist : them moi
        entityTransaction.commit();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.createQuery("select p from product p where id = ?1", Product.class).setParameter(1, id).getSingleResult();
        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = BaseRepository.entityManager.createQuery("select p from product p where nameMusic like ?1", Product.class).setParameter(1, "%" + name + "%").getResultList();
        return products;
    }
}
