package org.acme.test.resources;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;

public class Utc implements QuarkusTestResourceLifecycleManager {

  @Override
  public Map<String, String> start() {
    return Map.of("user.timezone", "UTC");
  }

  @Override
  public void stop() {}
}
