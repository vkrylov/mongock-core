package io.changock.driver.mongo.springdata.v3.driver.decorator.operation.executable.update.impl;

import io.changock.driver.mongo.springdata.v3.driver.decorator.operation.executable.update.UpdateWithQueryDecorator;
import io.changock.driver.api.lock.guard.decorator.DecoratorBase;
import io.changock.driver.api.lock.guard.invoker.LockGuardInvoker;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation;

public class UpdateWithQueryDecoratorImpl<T>
    extends DecoratorBase<ExecutableUpdateOperation.UpdateWithQuery<T>>
    implements UpdateWithQueryDecorator<T> {

  public UpdateWithQueryDecoratorImpl(ExecutableUpdateOperation.UpdateWithQuery<T> impl, LockGuardInvoker invoker) {
    super(impl, invoker);
  }

}