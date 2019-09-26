package jose.rodriguez.everis.peru.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import jose.rodriguez.everis.peru.app.models.document.Category;
import jose.rodriguez.everis.peru.app.models.document.Opening;
import jose.rodriguez.everis.peru.app.models.service.implement.OpeningServiceImplement;
import reactor.core.publisher.Flux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@EnableSwagger2WebFlux
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootProyectoEverisAperturaApplication implements CommandLineRunner{

  private static final Logger log = LoggerFactory.getLogger(SpringBootProyectoEverisAperturaApplication.class);
  
  
  @Autowired
  private ReactiveMongoTemplate mongoTemplate;
  
  @Autowired
  private OpeningServiceImplement service;
  
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProyectoEverisAperturaApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    mongoTemplate.dropCollection("categories").subscribe();
    mongoTemplate.dropCollection("openings").subscribe();
      
    Category student = new Category("student");
    Category listeningFamily = new Category("listeningFamily");
    Category listeningTeacher = new Category("listeningTeacher");
    
    Flux.just(student,listeningFamily,listeningTeacher)
    .flatMap(c -> service.saveCategory(c))
    .doOnNext(c ->{
      log.info("Cantidad de curso : " + c.getTypes());

    }).thenMany(
        // String name,  String lastName,  String gender,Date date,  String typeDocument,  int document
        Flux.just(
            new Opening("Java Master",false,student),
            new Opening("Sql",false,listeningFamily),
            new Opening("Ruby",false,listeningTeacher),
            new Opening("Phyton",false,student),
            new Opening("Auditoría",false,listeningTeacher))
        .flatMap( op -> {
          return service.save(op);
        })).subscribe(op -> log.info("insert : " + op.getNameCourse()));
    
    
    
    
  }

}
