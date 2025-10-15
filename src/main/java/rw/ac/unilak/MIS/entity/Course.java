package rw.ac.unilak.MIS.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

// Add unique title constraint
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title"}))
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  // Instance variable - table fields
  private int id;
  private String title;
  private String credits;

  public String getTitle() {
    return title;
  }

  public String getCredits() {
    return credits;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCredits(String credits) {
    this.credits = credits;
  }
}
