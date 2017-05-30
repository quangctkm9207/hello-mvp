package com.quangnguyen.hellomvp;

import javax.inject.Inject;

/**
 * An implementation of the Presenter
 *
 * @author Quang Nguyen.
 */

public class SayHelloPresenter implements SayHelloContract.Presenter {

  private Person person;
  private SayHelloContract.View view;

  @Inject
  public SayHelloPresenter(Person person, SayHelloContract.View view) {
    this.person = person;
    this.view = view;
  }

  @Override
  public void loadMessage() {
    if (person.getFirstName() == null && person.getLastName() == null) {
      view.showError("No person name found.");
      return;
    }

    String message = "Hi " + person.getName() + "!";
    view.showMessage(message);
  }

  @Override
  public void saveName(String firstName, String lastName) {
    person.setFirstName(firstName);
    person.setLastName(lastName);
  }
}
