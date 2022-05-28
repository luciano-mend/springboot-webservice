package br.luciano.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.luciano.course.entities.Category;
import br.luciano.course.entities.Order;
import br.luciano.course.entities.Product;
import br.luciano.course.entities.User;
import br.luciano.course.entities.enums.OrderStatus;
import br.luciano.course.repositories.CategoryRepository;
import br.luciano.course.repositories.OrderRepository;
import br.luciano.course.repositories.ProductRepository;
import br.luciano.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "O Senhor dos Anéis é uma trilogia cinematográfica dirigida por Peter Jackson com base na obra-prima homónima de J. R. R. Tolkien.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Toda televisão que se conecta à Internet é chamada Smart TV.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "The MacBook Pro is the top line of MacBook laptops, introduced in 2006.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "PC gamer nada mais é do que um computador voltado para jogos.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Quickly create Web sites with this powerful tool.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Joana D A Brown", "joanadarc@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Elizabeth Green", "lizag@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
