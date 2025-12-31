package ma.mundi.tp_2;

import ma.mundi.tp_2.entities.Product;
import ma.mundi.tp_2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product> productList = productRepository.findAll();
        productList.forEach(produit->{
            System.out.println(produit.toString());
        });
        try{
            Product product=productRepository.findById(Long.valueOf(1)).orElseThrow(()->new RuntimeException("produit no trouve"));
            System.out.println("************");
            System.out.println(product.getId());
            System.out.println(product.getNom());
            System.out.println(product.getPrix());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        List<Product> produi= productRepository.findByNomContains("n");
        produi.forEach(produit->{
            System.out.println(produit.toString());
        });
        System.out.println("list produit 2");
        List<Product> produi2= productRepository.search("%C%");
        produi2.forEach(produitr->{
            System.out.println(produitr.toString());
        });
        System.out.println("-----------price------------");
        List<Product> price= productRepository.findByPrixGreaterThan(555);
        price.forEach(pricepri->{
            System.out.println(pricepri.toString());
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }


}
