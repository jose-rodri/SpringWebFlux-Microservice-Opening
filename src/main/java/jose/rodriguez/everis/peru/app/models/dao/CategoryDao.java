package jose.rodriguez.everis.peru.app.models.dao;

import jose.rodriguez.everis.peru.app.models.document.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CategoryDao extends ReactiveMongoRepository<Category, String> {

  
  
}
