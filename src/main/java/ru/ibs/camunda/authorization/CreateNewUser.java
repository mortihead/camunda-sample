package ru.ibs.camunda.authorization;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateNewUser implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("[{}] Пользователь {} успешно зарегистрирован!",
                CreateNewUser.class.getName(),
                delegateExecution.getVariable("username"));
    }
}
