package com.cody;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.nio.file.*;

public class App3Buffered {
  public static void main(String[] args) throws IOException {
    App3Buffered app = new App3Buffered();
    app.parse();
//    try {
//      app.watch();
//    } catch (Exception ex) {
//      System.out.println(ex);
//    }

  }

  private void watch() throws IOException, InterruptedException {
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

  private void parse() throws IOException {
    File f = new File("C:\\Users\\cody.jewell\\IdeaProjects\\invparser\\inv_draft_err.pdf");
    String parsedText;

    PDFTextStripper pdfStripper = new PDFTextStripper();
    PDDocument doc = PDDocument.load(f);
    parsedText = pdfStripper.getText(doc);

    char[] buf = new char[70];
    StringReader reader = new StringReader(parsedText);
    reader.read(buf);
    System.out.println(buf);

    //BufferedInputStream stream = new BufferedInputStream
    // (parsedText);
  }
}
