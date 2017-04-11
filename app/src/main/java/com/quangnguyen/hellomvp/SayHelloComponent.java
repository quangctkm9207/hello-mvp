package com.quangnguyen.hellomvp;

import dagger.Component;

/**
 * @author Quang Nguyen.
 */
@Component(modules = SayHelloPresenterModule.class) public interface SayHelloComponent {

  void inject(SayHelloActivity sayHelloActivity);
}
