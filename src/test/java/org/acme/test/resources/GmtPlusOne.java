package org.acme.test.resources;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;

public class GmtPlusOne implements QuarkusTestResourceLifecycleManager {

  @Override
  public Map<String, String> start() {
    return Map.of("user.timezone", "Etc/GMT-1");
  }

  @Override
  public void stop() {}
}
