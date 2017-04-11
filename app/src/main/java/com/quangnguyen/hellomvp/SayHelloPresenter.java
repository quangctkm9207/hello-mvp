package com.quangnguyen.hellomvp;

/**
 * Created by Quang Nguyen on 3/26/17.
 *
 * An implementation of the Presenter
 */

public class SayHelloPresenter implements SayHelloContract.Presenter {

  private Person person;
  private SayHelloContract.View view;

  public SayHelloPresenter(SayHelloContract.View view) {
    this.person = new Person();
    this.view = view;
  }

  @Override public void loadMessage() {
    if (person.getFirstName() == null && person.getLastName() == null) {
      view.showError("No person name found.");
      return;
    }

    String message = "Hi " + person.getName() + "!";
    view.showMessage(message);
  }

  @Override public void saveName(String firstName, String lastName) {
    person.setFirstName(firstName);
    person.setLastName(lastName);
  }
}
