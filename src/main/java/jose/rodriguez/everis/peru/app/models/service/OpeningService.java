package jose.rodriguez.everis.peru.app.models.service;

import jose.rodriguez.everis.peru.app.models.document.Category;
import jose.rodriguez.everis.peru.app.models.document.Opening;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OpeningService {
  
  public Flux<Opening> findAll();
  public Mono<Opening> findById(String id);
  public Mono<Opening> save(Opening opening);
  public Mono<Void> delete(Opening opening);

  public Flux<Category> findAllCategory();
  public Mono<Category> findCategoryById(String id);
  public Mono<Category> saveCategory(Category category);
  public Mono<Void> deleteCategory(Category category);
}
