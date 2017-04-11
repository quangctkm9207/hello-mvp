package com.quangnguyen.hellomvp;

import javax.inject.Inject;

/**
 * @author Quang Nguyen.
 * An implementation of the Presenter
 */

public class SayHelloPresenter implements SayHelloContract.Presenter {

  private Person mPerson;
  private SayHelloContract.View mView;

  @Inject public SayHelloPresenter(Person person, SayHelloContract.View view) {
    mPerson = person;
    mView = view;
  }

  @Override public void loadMessage() {
    if (mPerson.getFirstName() == null && mPerson.getLastName() == null) {
      mView.showError("No person name found.");
      return;
    }

    String message = "Hi " + mPerson.getName() + "!";
    mView.showMessage(message);
  }

  @Override public void saveName(String firstName, String lastName) {
    mPerson.setFirstName(firstName);
    mPerson.setLastName(lastName);
  }
}
