package com.github.cloudyrock.spring.util;

import com.github.cloudyrock.mongock.runner.core.executor.DependencyContext;
import com.github.cloudyrock.mongock.runner.core.executor.DependencyNotFound;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringDependencyContext implements DependencyContext {

  private final ApplicationContext springContext;

  public SpringDependencyContext(ApplicationContext springContext) {
    this.springContext = springContext;
  }

  @Override
  public <T> T getBean(Class<T> type) {
    try {
      return springContext.getBean(type);
    } catch (BeansException ex) {
      throw new DependencyNotFound(ex);
    }
  }

  @Override
  public Object getBean(String name) {
    try {
      return springContext.getBean(name);
    } catch (BeansException ex) {
      throw new DependencyNotFound(ex);
    }
  }
}
