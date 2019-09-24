package jose.rodriguez.everis.peru.app.models.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jose.rodriguez.everis.peru.app.models.document.Opening;
import jose.rodriguez.everis.peru.app.models.service.OpeningService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/everis/openings")
public class OpeningController {
  
  
  @Autowired
  private OpeningService service;
  
  /**
   * . Método listar coment
   */
  @GetMapping
  public Mono<ResponseEntity<Flux<Opening>>> findAll() {
    return Mono.just(
        ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(service.findAll()));
  }
  
  /**
   * . a Método crear
   */

  @PostMapping
  public Mono<ResponseEntity<Opening>> save(@RequestBody Opening opening) {
      return service.save(opening)
        .map(p -> ResponseEntity.created(URI.create("/api/everis/openings/".concat(p.getId())))
            .contentType(MediaType.APPLICATION_JSON_UTF8).body(p));

  }
  
  /**
   * . Método filtrar por codigo
   * 
   * @return
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Opening>> findById(@PathVariable String id) {
    return service.findById(id)
        .map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  /**
   * . Método actualizar
   * 
   * @return
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Opening>> update(@RequestBody Opening opening,
      @PathVariable String id) {
    return service.findById(id).flatMap(t -> {
      t.setNameCourse(opening.getNameCourse());
      t.setCatergory(opening.getCatergory());
      return service.save(t);
    }).map(
        p -> ResponseEntity.created(URI.create("/api/everis/openings/".concat(p.getId()))).body(p))
        .defaultIfEmpty(ResponseEntity.notFound().build());


  }
  
  
  /**
   * .
   * 
   * @return
   */
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    return service.findById(id).flatMap(p -> {
      return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));

    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
  }

}
