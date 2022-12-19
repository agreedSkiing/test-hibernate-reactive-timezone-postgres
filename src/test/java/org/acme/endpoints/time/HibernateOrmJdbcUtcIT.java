package org.acme.endpoints.time;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.acme.test.resources.HibernateOrmJdbcUtc;

@QuarkusIntegrationTest
@QuarkusTestResource(
  value = HibernateOrmJdbcUtc.class,
  restrictToAnnotatedClass = true
)
public class HibernateOrmJdbcUtcIT extends GmtIT {}
