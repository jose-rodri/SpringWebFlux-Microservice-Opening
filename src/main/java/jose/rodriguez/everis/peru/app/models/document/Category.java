package jose.rodriguez.everis.peru.app.models.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="categories")
public class Category {
  
  @Id
  private String id;
  
  private String types;
  

  public Category() {

  }

  

  public Category(String types) {
  this.types = types;
  }



  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }



  public String getTypes() {
    return types;
  }



  public void setTypes(String types) {
    this.types = types;
  }


  
  
  
  
}
