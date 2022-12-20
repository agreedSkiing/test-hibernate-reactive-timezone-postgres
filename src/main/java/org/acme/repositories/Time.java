package org.acme.repositories;

import io.smallrye.mutiny.Uni;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.acme.entities.*;
import org.hibernate.reactive.mutiny.Mutiny;

@ApplicationScoped
public class Time {

  @Inject
  Mutiny.SessionFactory sf;

  public Uni<OffsetDateTime> getAsOffsetDateTimes() {
    return sf.withTransaction(s -> s.find(OffsetDateTime.class, 1));
  }

  public Uni<OffsetDateTime> createOffsetDateTimes() {
    var entity = new OffsetDateTime();
    entity.noTimeZone =
      java.time.OffsetDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZone =
      java.time.OffsetDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZoneGmt2 =
      java.time.OffsetDateTime.parse(
        "2022-12-20T20:24:00+02:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    return sf.withTransaction(s -> s.persist(entity)).replaceWith(entity);
  }
}
