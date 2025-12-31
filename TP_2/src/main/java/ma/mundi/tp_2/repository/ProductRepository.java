package ma.mundi.tp_2.repository;

import ma.mundi.tp_2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNomContains(String nom);
    List<Product> findByPrixGreaterThan(double price);
    @Query("SELECT p FROM Product p where p.nom LIKE :x")
    List<Product> search(@Param("x") String nom);

    List<Product> id(Long id);
}
