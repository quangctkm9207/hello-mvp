package com.quangnguyen.hellomvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

/**
 * @author Quang Nguyen.
 */

public class SayHelloPresenterTest {
  public static final String FIRST_NAME = "Quang";

  public static final String LAST_NAME = "Nguyen";

  @Mock private SayHelloContract.View sayHelloView;

  @Mock private Person person;

  private SayHelloContract.Presenter sayHelloPresenter;

  @Before public void setup() {
    // When use @Mock annotation, we need to trigger the creation of annotated objects by calling iniMocks() method.
    MockitoAnnotations.initMocks(this);
  }

  @Test public void loadErrorMessage() {
    sayHelloPresenter = new SayHelloPresenter(person, sayHelloView);
    sayHelloPresenter.loadMessage();
    verify(sayHelloView).showError("No person name found."); // No data in person object yet.
  }

  @Test public void loadNormalMessage() {
    person = new Person(FIRST_NAME, LAST_NAME);
    sayHelloPresenter = new SayHelloPresenter(person, sayHelloView);
    sayHelloPresenter.loadMessage();
    verify(sayHelloView).showMessage("Hi " + FIRST_NAME + " " + LAST_NAME + "!");
  }

  @Test public void saveName() {
    sayHelloPresenter = new SayHelloPresenter(person, sayHelloView);
    sayHelloPresenter.saveName(FIRST_NAME, LAST_NAME);
    InOrder inOrder = inOrder(person, sayHelloView);
    inOrder.verify(person).setFirstName(FIRST_NAME);
    inOrder.verify(person).setLastName(LAST_NAME);
  }
}
