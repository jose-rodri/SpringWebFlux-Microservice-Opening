package jose.rodriguez.everis.peru.app.service;

import static org.mockito.Mockito.when;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import jose.rodriguez.everis.peru.app.models.dao.OpeningDao;
import jose.rodriguez.everis.peru.app.models.document.Opening;
import jose.rodriguez.everis.peru.app.models.service.implement.OpeningServiceImplement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)

public class testService {

  


  @Mock
  private OpeningDao openingDao;

  @InjectMocks
  private OpeningServiceImplement openingService;

  


  @SuppressWarnings("unused")
  private void assertResults(Publisher<Opening> publisher, Opening... expectedOpenings) {
    StepVerifier.create(publisher).expectNext(expectedOpenings).verifyComplete();
  }


  @Test
  public void findAll() {
    Opening p = new Opening();
    
    p.setNameCourse("Java");
    p.setState(false);
   
    when(openingService.findAll()).thenReturn(Flux.just(p));
    Flux<Opening> actual = openingService.findAll();
    assertResults(actual, p);
  }


  @Test
  public void idexisting() {
    Opening p = new Opening();
    p.setNameCourse("123");
    p.setNameCourse("C#");
    p.setState(false);
    when(openingDao.findById(p.getId())).thenReturn(Mono.just(p));
    Mono<Opening> actual = openingDao.findById(p.getId());
    assertResults(actual, p);
  }


  @Test
  public void idInvalid() {
    Opening p = new Opening();
    p.setId("3554");
    p.setNameCourse("C#");
    p.setState(false);
    when(openingDao.findById(p.getId())).thenReturn(Mono.empty());
    Mono<Opening> actual = openingService.findById(p.getId());
    assertResults(actual);
  }



  @Test
  public void save() {
    Opening p = new Opening();
    p.setNameCourse("Go");
    p.setState(false);
    when(openingDao.save(p)).thenReturn(Mono.just(p));
    Mono<Opening> actual = openingService.save(p);
    assertResults(actual, p);
  }



  @Test
  public void delete() {
    Opening p = new Opening();
    p.setId("iiiiii");
    p.setNameCourse("Go");
    p.setState(false);
    when(openingDao.delete(p)).thenReturn(Mono.empty());
  }

  
  
  
  
}
