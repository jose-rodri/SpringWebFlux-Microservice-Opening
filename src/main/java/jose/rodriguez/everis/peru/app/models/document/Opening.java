package jose.rodriguez.everis.peru.app.models.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "openings")
public class Opening {


  @Id
  private String id;
  private String nameCourse;
  private boolean state;
  
  private Category catergory;

  public Opening() {

  }



  
  public Opening(String nameCourse, boolean state, Category catergory) {
    this.nameCourse = nameCourse;
    this.state = state;
    this.catergory = catergory;
  }


}
