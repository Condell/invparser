package com.cody;

import java.io.IOException;
import java.nio.file.*;

public class App2 {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Running App...");
    WatchService watchService =
            FileSystems.getDefault().newWatchService();
    Path path = Paths.get("C:/Users/cody.jewell/AppData/Local" +
            "/Temp");
    path.register(watchService,
            StandardWatchEventKinds.ENTRY_CREATE);

    WatchKey key;
    while ((key = watchService.take()) != null) {
      for (WatchEvent<?> event : key.pollEvents()) {
        System.out.println(
                "Event kind:" + event.kind()
                        + ". File affected: " + event.context() + ".");
      }
      key.reset();
    }
  }

}

