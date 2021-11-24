package io.helidon.examples.quickstart.se;

import java.time.LocalDateTime;

/**
 *
 * simple POJO that represents a Log entry that is stored by microstream in this example.
 *
 */
public class LogEntry {
  private String name;
  private LocalDateTime dateTime;

  /**
   * The Constructor.
   *
   * @param name name to be logged.
   *
   * @param dateTime dateTime date and time to be logged
   */
  public LogEntry(String name, LocalDateTime dateTime) {
    super();
    this.name = name;
    this.dateTime = dateTime;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

}