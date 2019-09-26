package jose.rodriguez.everis.peru.app.models.dao;

import jose.rodriguez.everis.peru.app.models.document.Opening;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface OpeningDao extends ReactiveMongoRepository<Opening, String> {

}
