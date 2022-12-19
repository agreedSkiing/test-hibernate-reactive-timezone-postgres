package org.acme.endpoints.time;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.acme.test.resources.HibernateJdbcUtc;

@QuarkusIntegrationTest
@QuarkusTestResource(
  value = HibernateJdbcUtc.class,
  restrictToAnnotatedClass = true
)
public class HibernateJdbcUtcIT extends GmtIT {}
