package io.changock.driver.mongo.springdata.v3.driver.decorator.operation.executable.find;

import io.changock.driver.api.lock.guard.decorator.Invokable;
import io.changock.driver.mongo.springdata.v3.driver.decorator.operation.executable.find.impl.TerminatingDistinctDecoratorImpl;
import io.changock.driver.api.lock.guard.invoker.LockGuardInvoker;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.ExecutableFindOperation.TerminatingDistinct;

public interface TerminatingDistinctDecorator<T> extends Invokable, TerminatingDistinct<T> {

  TerminatingDistinct<T> getImpl();

  LockGuardInvoker getInvoker();

  @Override
  default List<T> all() {
    return getInvoker().invoke(() -> getImpl().all());
  }

  @Override
  default TerminatingDistinct<T> matching(Query query) {
    return new TerminatingDistinctDecoratorImpl<>(getInvoker().invoke(() -> getImpl().matching(query)), getInvoker());
  }

  @Override
  default  <R> TerminatingDistinct<R> as(Class<R> resultType) {
    return new TerminatingDistinctDecoratorImpl<>(getInvoker().invoke(() -> getImpl().as(resultType)), getInvoker());
  }

  @Override
  default TerminatingDistinct<T> matching(CriteriaDefinition criteria) {
    return new TerminatingDistinctDecoratorImpl<>(getInvoker().invoke(() -> getImpl().matching(criteria)), getInvoker());
  }
}