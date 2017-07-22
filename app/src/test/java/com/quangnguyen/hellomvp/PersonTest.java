package com.quangnguyen.hellomvp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Quang Nguyen.
 */

public class PersonTest {

  @Test
  public void testCreation() {
    Person person1 = new Person();
    assertEquals("First name should be null", person1.getFirstName(), null);
    assertEquals("Last name should be null", person1.getLastName(), null);

    Person person2 = new Person("first", "last");
    assertEquals("First name should be 'fist'", person2.getFirstName(), "first");
    assertEquals("Last name should be 'last'", person2.getLastName(), "last");
  }

  @Test
  public void testUpdateName() {
    Person person = new Person("first", "last");
    person.setFirstName("FIRST");
    person.setLastName("LAST");
  }
}
