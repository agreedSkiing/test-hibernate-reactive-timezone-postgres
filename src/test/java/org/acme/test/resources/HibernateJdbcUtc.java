package org.acme.test.resources;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;

public class HibernateJdbcUtc implements QuarkusTestResourceLifecycleManager {

  @Override
  public Map<String, String> start() {
    return Map.of("hibernate.jdbc.time_zone", "UTC");
  }

  @Override
  public void stop() {}
}
