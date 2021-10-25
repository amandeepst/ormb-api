package com.apiwp.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {

  private Map<String, Object> context = new HashMap<>();

  public ScenarioContext() {
    super();
  }

  public ScenarioContext(Map<String, Object> context) {
    super();
    this.context = context;
  }

  public <T> T getNamedValue(String key, Class<T> type) {
    return context.containsKey(key) && context.get(key) != null ? (T) context.get(key) : null;
  }

  public void setNamedValue(String key, Object value) {
    this.context.put(key, value);
  }

  public void reset() {
    this.context = new HashMap();
  }

}
