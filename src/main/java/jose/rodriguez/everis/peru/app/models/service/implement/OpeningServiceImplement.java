package jose.rodriguez.everis.peru.app.models.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jose.rodriguez.everis.peru.app.models.dao.CategoryDao;
import jose.rodriguez.everis.peru.app.models.dao.OpeningDao;
import jose.rodriguez.everis.peru.app.models.document.Category;
import jose.rodriguez.everis.peru.app.models.document.Opening;
import jose.rodriguez.everis.peru.app.models.service.OpeningService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OpeningServiceImplement implements OpeningService {

  @Autowired
  private OpeningDao dao;
  
  
  @Autowired
  private CategoryDao daoCat;
  
  
 
  @Override
  public Flux<Opening> findAll() {

    return dao.findAll();
  }

  @Override
  public Mono<Opening> findById(String id) {
   
    return dao.findById(id);
  }

  @Override
  public Mono<Opening> save(Opening opening) {
    
    return dao.save(opening);
  }

  @Override
  public Mono<Void> delete(Opening opening) {
  
    return dao.delete(opening);
  }

  @Override
  public Flux<Category> findAllCategory() {
   
    return daoCat.findAll();
  }

  @Override
  public Mono<Category> findCategoryById(String id) {
    // TODO Auto-generated method stub
    return daoCat.findById(id);
  }

  @Override
  public Mono<Category> saveCategory(Category category) {
    // TODO Auto-generated method stub
    return daoCat.save(category);
  }

  @Override
  public Mono<Void> deleteCategory(Category category) {
    // TODO Auto-generated method stub
    return daoCat.delete(category);
  }

 

}
