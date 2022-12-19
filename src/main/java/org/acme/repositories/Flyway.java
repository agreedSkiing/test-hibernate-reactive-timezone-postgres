package org.acme.repositories;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@ApplicationScoped
public class Flyway {

  private static final Logger LOGGER = Logger.getLogger(Flyway.class);

  @ConfigProperty(name = "quarkus.datasource.reactive.url")
  String datasourceUrl;

  @ConfigProperty(name = "quarkus.datasource.username")
  String datasourceUsername;

  @ConfigProperty(name = "quarkus.datasource.password")
  String datasourcePassword;

  public void runFlywayMigration(@Observes StartupEvent event) {
    LOGGER.info("Init Flyway ...");
    var flyway = org.flywaydb.core.Flyway
      .configure()
      .dataSource(
        "jdbc:" + datasourceUrl,
        datasourceUsername,
        datasourcePassword
      )
      .locations("db/migration")
      .load();
    flyway.migrate();
  }
}
