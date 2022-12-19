package org.acme.entities;

import javax.persistence.*;
import org.acme.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as Instants
 */
public class Instant extends Base {

  @Column(name = NO_TIME_ZONE, nullable = false)
  public java.time.Instant noTimeZone;

  @Column(name = WITH_TIME_ZONE, nullable = false)
  public java.time.Instant withTimeZone;

  @Column(name = WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.Instant withTimeZoneGmt2;
}
