package com.quangnguyen.hellomvp;

import dagger.Module;
import dagger.Provides;

/**
 * @author Quang Nguyen.
 */
@Module public class SayHelloPresenterModule {

  private final SayHelloContract.View mView;

  private final Person mPerson;

  public SayHelloPresenterModule(SayHelloContract.View view, Person person) {
    mView = view;
    mPerson = person;
  }

  @Provides SayHelloContract.View provideTaskDetailContractView() {
    return mView;
  }

  @Provides Person providePerson() {
    return mPerson;
  }
}
