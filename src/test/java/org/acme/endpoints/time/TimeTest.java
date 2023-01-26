package org.acme.endpoints.time;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import java.net.HttpURLConnection;
import org.acme.endpoints.Time;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestHTTPEndpoint(Time.class)
public class TimeTest {

  @Test
  public void base_path_is_always_the_same() {
    RestAssured
      .get()
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body(
        "withoutTimezoneField",
        Matchers.is("2022-12-18T19:39:20"),
        "withTimezoneField",
        Matchers.is("2022-12-18T19:39:20+01:00"),
        "withTimezoneGmt2Field",
        Matchers.is("2022-12-18T17:39:20Z")
      );
  }

  @Test
  public void getting_as_instants() {
    RestAssured
      .get("/instants")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body(
        "withoutTimezoneField",
        Matchers.is("2022-12-18T19:39:20Z"),
        "withTimezoneField",
        Matchers.is("2022-12-18T18:39:20Z"),
        "withTimezoneGmt2Field",
        Matchers.is("2022-12-18T17:39:20Z")
      );
  }

  @Test
  public void getting_as_local_date_time() {
    RestAssured
      .get("/localdatetimes")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body(
        "withoutTimezoneField",
        Matchers.is("2022-12-18T20:39:20"),
        "withTimezoneField",
        Matchers.is("2022-12-18T19:39:20"),
        "withTimezoneGmt2Field",
        Matchers.is("2022-12-18T18:39:20")
      );
  }

  @Test
  public void getting_as_offset_date_time() {
    RestAssured
      .get("/offsetdatetimes")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body(
        "withoutTimezoneField",
        Matchers.is("2022-12-18T20:39:20+01:00"),
        "withTimezoneField",
        Matchers.is("2022-12-18T19:39:20+01:00"),
        "withTimezoneGmt2Field",
        Matchers.is("2022-12-18T18:39:20+01:00")
      );
  }

  @Test
  public void getting_as_zoned_date_time() {
    RestAssured
      .get("/zoneddatetimes")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body(
        "withoutTimezoneField",
        Matchers.is("2022-12-18T20:39:20+01:00[Etc/GMT-1]"),
        "withTimezoneField",
        Matchers.is("2022-12-18T19:39:20+01:00[Etc/GMT-1]"),
        "withTimezoneGmt2Field",
        Matchers.is("2022-12-18T18:39:20+01:00[Etc/GMT-1]")
      );
  }
}
