package com.apiwp.steps;

import com.apiwp.utils.ResponseTypes;
import com.apiwp.utils.ScenarioContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class StepsUtils {

  private final ScenarioContext scenarioContext;


  private static final Logger LOGGER = LoggerFactory.getLogger(StepsUtils.class);

  public StepsUtils(ScenarioContext scenarioContext) {
    this.scenarioContext = scenarioContext;

  }

  public Class getResponseType(String response) {
    return ResponseTypes.getEnumValueByName(response.toUpperCase());
  }
}
