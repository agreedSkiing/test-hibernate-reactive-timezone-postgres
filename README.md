# test-hibernate-reactive-timezone-postgres Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```bash script
bash launch.sh
```

## Running the application tests

Run this applications test with the command below for a set test flow:

```bash script
bash integration-test.sh
```

## Formatting

Formatting is done by prettier and its plugins:

```bash script
npm install \
  && npx prettier --write .
```

## Reason for project

This project was created to test the connection time to postgres database with Etc/GMT-1 time zone (GMT+1).

[UtcIT.java] and [TimeTest.java] (which uses `test.quarkus.hibernate-orm.jdbc.timezone = UTC`) test passes, but when [GmtIT.java] runs it fails because of a weird conversion error?

And then an extra test class [GmtPodUtcDbTest.java] which fails in both Hibernate Reactive and the base Hibernate Orm because of an unkown weird reason... quting my comment from my other repo

> One test fails [GmtPodUtcDbTest.java] which fails in both here with base Hibernate Orm and Hibernate Reactive because of an unkown weird conversion reason when the database connection has UTC specified and the test class uses QuarkusTestResourceLifecycleManager [GmtPlusOne.java] which assigns `user.timezone=Etc/GMT-1` through a quarkus test resource, which confuses me since it should produce the same results as [TimeTest.java] which when run throught [integration-test.sh] launches the mvn command `mvn clean package -Duser.timezone=Etc/GMT-1`.

source: https://github.com/agreedSkiing/test-hibernate-timezone-postgres/blob/master/README.md#reason-for-project

### Database looks

Database columns looks normal since no_time_zone is made without any time zone field and is stored as a plain time, other two are converted to UTC as postgres does.

```bash
podman exec -it postgres /bin/bash
c7b596f783c9:/# psql -U user quarkus
psql (13.9)
Type "help" for help.

quarkus=# \x
Expanded display is on.
quarkus=# SELECT * from time;
-[ RECORD 1 ]--------+-----------------------
identity             | 1
no_time_zone         | 2022-12-18 19:39:20
with_time_zone       | 2022-12-18 18:39:20+00
with_time_zone_gmt_2 | 2022-12-18 17:39:20+00

quarkus=# exit
c7b596f783c9:/# datae
bash: datae: command not found
c7b596f783c9:/# date
Mon Dec 19 07:33:42 UTC 2022
c7b596f783c9:/#
```

[utcit.java]: ./src/test/java/org/acme/endpoints/time/UtcIT.java
[timetest.java]: ./src/test/java/org/acme/endpoints/time/TimeTest.java
[gmtit.java]: ./src/test/java/org/acme/endpoints/time/GmtIT.java
[gmtpodutcdbtest.java]: ./src/test/java/org/acme/endpoints/time/GmtPodUtcDbTest.java
