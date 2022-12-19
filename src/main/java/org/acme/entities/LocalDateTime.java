package org.acme.entities;

import javax.persistence.*;
import org.acme.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as LocalDateTimes
 */
public class LocalDateTime extends Base {

  @Column(name = NO_TIME_ZONE, nullable = false)
  public java.time.LocalDateTime noTimeZone;

  @Column(name = WITH_TIME_ZONE, nullable = false)
  public java.time.LocalDateTime withTimeZone;

  @Column(name = WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.LocalDateTime withTimeZoneGmt2;
}
