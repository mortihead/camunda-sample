package ru.ibs.camunda.authorization;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotifyUser implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
      if( (Boolean) delegateExecution.getVariable("decision")){
          log.info("[{}] {}, добро пожаловать на портал!", NotifyUser.class.getName(),delegateExecution.getVariable("username"));
      } else {
          log.info("[{}] {}, Вам отказано в регистрации!", NotifyUser.class.getName(),delegateExecution.getVariable("username"));
      }
    }
}
