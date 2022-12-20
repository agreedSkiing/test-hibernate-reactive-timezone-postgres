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

  public Uni<Instant> createInstants() {
    var entity = new Instant();
    entity.noTimeZone = java.time.Instant.parse("2022-12-20T20:24:00+01:00");
    entity.withTimeZone = java.time.Instant.parse("2022-12-20T20:24:00+01:00");
    entity.withTimeZoneGmt2 =
      java.time.Instant.parse("2022-12-20T20:24:00+02:00");
    return sf.withTransaction(s -> s.persist(entity)).replaceWith(entity);
  }

  public Uni<LocalDateTime> createLocalDateTimes() {
    var entity = new LocalDateTime();
    entity.noTimeZone =
      java.time.LocalDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZone =
      java.time.LocalDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZoneGmt2 =
      java.time.LocalDateTime.parse(
        "2022-12-20T20:24:00+02:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    return sf.withTransaction(s -> s.persist(entity)).replaceWith(entity);
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

  public Uni<ZonedDateTime> createZonedDateTimes() {
    var entity = new ZonedDateTime();
    entity.noTimeZone =
      java.time.ZonedDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZone =
      java.time.ZonedDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZoneGmt2 =
      java.time.ZonedDateTime.parse(
        "2022-12-20T20:24:00+02:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    return sf.withTransaction(s -> s.persist(entity)).replaceWith(entity);
  }
}
