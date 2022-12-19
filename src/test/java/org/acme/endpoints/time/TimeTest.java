package org.acme.endpoints.time;

import static org.hamcrest.Matchers.is;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import java.net.HttpURLConnection;
import org.acme.endpoints.Time;
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
      .body("withoutTimezoneField", is("2022-12-18T19:39:20"))
      .body("withTimezoneField", is("2022-12-18T19:39:20+01:00"))
      .body("withTimezoneGmt2Field", is("2022-12-18T17:39:20Z"));
  }

  @Test
  public void getting_as_instants() {
    RestAssured
      .get("/instants")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body("withoutTimezoneField", is("2022-12-18T19:39:20Z"))
      .body("withTimezoneField", is("2022-12-18T18:39:20Z"))
      .body("withTimezoneGmt2Field", is("2022-12-18T17:39:20Z"));
  }

  @Test
  public void getting_as_local_date_time() {
    RestAssured
      .get("/localdatetimes")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body("withoutTimezoneField", is("2022-12-18T20:39:20"))
      .body("withTimezoneField", is("2022-12-18T19:39:20"))
      .body("withTimezoneGmt2Field", is("2022-12-18T18:39:20"));
  }

  @Test
  public void getting_as_offset_date_time() {
    RestAssured
      .get("/offsetdatetimes")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body("withoutTimezoneField", is("2022-12-18T20:39:20+01:00"))
      .body("withTimezoneField", is("2022-12-18T19:39:20+01:00"))
      .body("withTimezoneGmt2Field", is("2022-12-18T18:39:20+01:00"));
  }

  @Test
  public void getting_as_zoned_date_time() {
    RestAssured
      .get("/zoneddatetimes")
      .then()
      .statusCode(HttpURLConnection.HTTP_OK)
      .assertThat()
      .body("withoutTimezoneField", is("2022-12-18T20:39:20+01:00[Etc/GMT-1]"))
      .body("withTimezoneField", is("2022-12-18T19:39:20+01:00[Etc/GMT-1]"))
      .body(
        "withTimezoneGmt2Field",
        is("2022-12-18T18:39:20+01:00[Etc/GMT-1]")
      );
  }
}
