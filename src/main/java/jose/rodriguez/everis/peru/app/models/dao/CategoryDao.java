package jose.rodriguez.everis.peru.app.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import jose.rodriguez.everis.peru.app.models.document.Category;

public interface CategoryDao extends ReactiveMongoRepository<Category, String> {

  
  
}
