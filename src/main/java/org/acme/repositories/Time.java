package org.acme.repositories;

import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.acme.entities.*;
import org.hibernate.reactive.mutiny.Mutiny;

@ApplicationScoped
public class Time {

  @Inject
  Mutiny.SessionFactory sf;

  public Uni<Instant> getAsInstants() {
    return sf.withTransaction(s -> s.find(Instant.class, 1));
  }

  public Uni<LocalDateTime> getAsLocalDateTimes() {
    return sf.withTransaction(s -> s.find(LocalDateTime.class, 1));
  }

  public Uni<OffsetDateTime> getAsOffsetDateTimes() {
    return sf.withTransaction(s -> s.find(OffsetDateTime.class, 1));
  }

  public Uni<ZonedDateTime> getAsZonedDateTimes() {
    return sf.withTransaction(s -> s.find(ZonedDateTime.class, 1));
  }
}
