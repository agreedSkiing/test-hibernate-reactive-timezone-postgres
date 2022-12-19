# test-hibernate-reactive-timezone-postgres Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```bash script
bash launch.sh
```

> **_NOTE:_** Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Running the application tests

Run this applications test with the command below for a set test flow:

```bash script
bash integration-test.sh
```

## Formatting

Formatting is done by prettier and its plugins:

```bash script
npm install; npx prettier --write .
```

## Reason for project

This project was created to test the connection time to postgres database with Etc/GMT-1 time zone (GMT+1).

Utc.java test passes as expected but when GmtPlusOne.java is active none pass

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
