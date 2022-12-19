DROP TABLE
  IF EXISTS time;

CREATE TABLE
  IF NOT EXISTS time(
    identity INTEGER NOT NULL,
    no_time_zone TIMESTAMP NOT NULL,
    with_time_zone TIMESTAMPTZ NOT NULL,
    with_time_zone_gmt_2 TIMESTAMPTZ NOT NULL,
    PRIMARY KEY (identity)
  );

INSERT INTO
  time(
    identity,
    no_time_zone,
    with_time_zone,
    with_time_zone_gmt_2
  )
VALUES
  (
    1,
    '2022-12-18T19:39:20+0100',
    '2022-12-18T19:39:20+0100',
    '2022-12-18T19:39:20+0200'
  );
