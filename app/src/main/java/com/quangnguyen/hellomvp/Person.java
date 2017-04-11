package com.quangnguyen.hellomvp;

/**
 * Created by Quang Nguyen on 3/27/17.
 *
 * Represents the Model in MVP architecture
 */

public class Person {
  private String firstName;
  private String lastName;

  public Person() {
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getName() {
    return firstName + " " + lastName;
  }
}
