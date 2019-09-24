package jose.rodriguez.everis.peru.app.models.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "openings")
public class Opening {


  @Id
  private String id;
  private String nameCourse;
  private boolean state;
  
  private Category catergory;

  public Opening() {

  }


  public Opening(String nameCourse, boolean state) {
    this.nameCourse = nameCourse;
    this.state = state;
  }

  
  
  
  


  public Opening(String nameCourse, boolean state, Category catergory) {
    this(nameCourse, state);
    this.catergory = catergory;
  }


  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public String getNameCourse() {
    return nameCourse;
  }


  public void setNameCourse(String nameCourse) {
    this.nameCourse = nameCourse;
  }


  public boolean isState() {
    return state;
  }


  public void setState(boolean state) {
    this.state = state;
  }


  public Category getCatergory() {
    return catergory;
  }


  public void setCatergory(Category catergory) {
    this.catergory = catergory;
  }



}
