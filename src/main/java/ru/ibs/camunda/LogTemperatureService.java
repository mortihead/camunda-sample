package ru.ibs.camunda;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class LogTemperatureService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String json = delegateExecution.getVariable("response").toString();
        ObjectMapper jsonMapper = new ObjectMapper();
        Map<String, Object> treeMap = jsonMapper.readValue(json, new TypeReference<Map<String, Object>>() {});

        log.info("[{}] температура: {}",
                LogTemperatureService.class.getName(),
                ((Map<String, Object> )treeMap.get("main")).get("temp"));
    }
}
