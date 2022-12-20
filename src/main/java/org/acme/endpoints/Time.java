package org.acme.endpoints;

import static org.acme.to.json.Output.Builder;

import io.smallrye.mutiny.Uni;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("time")
@ApplicationScoped
public class Time {

  @Inject
  org.acme.repositories.Time repo;

  @GET
  public Uni<Response> preset() {
    return Uni
      .createFrom()
      .item(
        Response
          .ok(
            new Builder()
              .withTimezoneField(
                ZonedDateTime
                  .parse(
                    "2022-12-18T19:39:20+01:00",
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME
                  )
                  .toString()
              )
              .withoutTimezoneField(
                LocalDateTime
                  .parse(
                    "2022-12-18T19:39:20Z",
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME
                  )
                  .toString()
              )
              .withTimezoneGmt2Field(
                Instant.parse("2022-12-18T19:39:20+02:00").toString()
              )
              .build()
          )
          .build()
      );
  }

  @GET
  @Path("offsetdatetimes")
  public Uni<Response> offsetdatetimes() {
    return repo.getAsOffsetDateTimes().map(this::mapToOutput);
  }

  @POST
  @Path("offsetdatetimes")
  public Uni<Response> createOffsetdatetimes() {
    return repo.createOffsetDateTimes().map(this::mapToOutput);
  }


  Response mapToOutput(org.acme.entities.OffsetDateTime entity) {
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }
}
