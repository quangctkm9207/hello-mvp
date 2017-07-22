package com.quangnguyen.hellomvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author Quang Nguyen.
 */

public class SayHelloPresenterTest {

  public static final String FIRST_NAME = "Quang";

  public static final String LAST_NAME = "Nguyen";

  @Mock
  private SayHelloContract.View sayHelloView;

  private SayHelloContract.Presenter sayHelloPresenter;

  @Before
  public void setup() {
    // When use @Mock annotation, we need to trigger the creation of annotated objects by calling initMocks() method.
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void loadMessage() {
    sayHelloPresenter = new SayHelloPresenter(sayHelloView);
    sayHelloPresenter.loadMessage();
    verify(sayHelloView).showError(
        "No person name found."); // Person Object has just created but no data.
  }

  @Test
  public void saveName() {
    sayHelloPresenter = new SayHelloPresenter(sayHelloView);
    sayHelloPresenter.saveName(FIRST_NAME, LAST_NAME);
    // Because of stupidly dependent creation of Model in Presenter, we can not test Model behavior.
    // OK, test View instead
    sayHelloPresenter.loadMessage();
    verify(sayHelloView).showMessage("Hi " + FIRST_NAME + " " + LAST_NAME + "!");
  }
}
