package rw.ac.unilak.MIS.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

// Add unique email constraint
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  // Instance variable - table fields
  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
