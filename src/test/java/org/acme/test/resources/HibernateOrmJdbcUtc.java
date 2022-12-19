package org.acme.test.resources;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;

public class HibernateOrmJdbcUtc
  implements QuarkusTestResourceLifecycleManager {

  @Override
  public Map<String, String> start() {
    return Map.of("quarkus.hibernate-orm.jdbc.timezone", "UTC");
  }

  @Override
  public void stop() {}
}
