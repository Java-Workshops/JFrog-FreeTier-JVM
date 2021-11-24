package io.helidon.examples.quickstart.se;

import io.helidon.common.reactive.Single;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This class extends the MicrostreamSingleThreadedExecutionContext and provides
 * data access methods using the MicrostreamSingleThreadedExecutionContext.
 */
public class GreetingServiceMicrostreamContext extends MicrostreamSingleThreadedExecutionContext {

  /**
   * Create a new GreetingServiceMicrostreamContext.
   *
   * @param storageManager the EmbeddedStorageManager used.
   */
  public GreetingServiceMicrostreamContext(EmbeddedStorageManager storageManager) {
    super(storageManager);
  }

  /**
   * Add and store a new log entry.
   *
   * @param name paramter for log text.
   * @return Void
   */
  public CompletableFuture<Void> addLogEntry(String name) {
    return execute(() -> {
      @SuppressWarnings("unchecked")
      List<LogEntry> logs = (List<LogEntry>) storageManager().root();
      logs.add(new LogEntry(name, LocalDateTime.now()));
      storageManager().store(logs);
      return null;
    });
  }

  /**
   * initialize the storage root with a new, empty List.
   *
   * @return Void
   */
  public CompletableFuture<Void> initRootElement() {
    return execute(() -> {
      if (storageManager().root() == null) {
        storageManager().setRoot(new ArrayList<LogEntry>());
        storageManager().storeRoot();
      }
      return null;
    });
  }

  /**
   * returns a List of all stored LogEntries.
   *
   * @return all LogEntries.
   */
  public Single<List<LogEntry>> getLogs() {
    @SuppressWarnings("unchecked")
    CompletableFuture<List<LogEntry>> completableFuture = CompletableFuture.supplyAsync(() -> {
      return (List<LogEntry>) storageManager().root();
    }, executor());
    return (Single<List<LogEntry>>) Single.create(completableFuture);
  }

}


