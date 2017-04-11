package com.quangnguyen.hellomvp;

import dagger.Module;
import dagger.Provides;

/**
 * @author Quang Nguyen.
 */
@Module public class SayHelloPresenterModule {

  private final SayHelloContract.View view;

  private final Person person;

  public SayHelloPresenterModule(SayHelloContract.View view, Person person) {
    this.view = view;
    this.person = person;
  }

  @Provides SayHelloContract.View provideTaskDetailContractView() {
    return view;
  }

  @Provides Person providePerson() {
    return person;
  }
}
