package org.acme.entities;

import javax.persistence.*;
import org.acme.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as OffsetDateTimes
 */
public class OffsetDateTime extends Base {

  @Column(name = NO_TIME_ZONE, nullable = false)
  public java.time.OffsetDateTime noTimeZone;

  @Column(name = WITH_TIME_ZONE, nullable = false)
  public java.time.OffsetDateTime withTimeZone;

  @Column(name = WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.OffsetDateTime withTimeZoneGmt2;
}
