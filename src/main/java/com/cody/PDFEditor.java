package com.cody;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PDFEditor {
  public static void main(String[] args) throws IOException {
    File file = new File("C:\\Users\\cody.jewell\\Downloads\\ShepRevisionBoxBeef_10.09.19.pdf");
    PDDocument document = PDDocument.load(file);
    System.out.println(document.getNumberOfPages());
    document.removePage(0);
    document.removePage(0);
    document.removePage(5);
    document.removePage(5);

//    document.removePage(1);
//    document.removePage(2);
//    document.removePage(3);
//    document.removePage(4);
//    document.removePage(5);
//    document.removePage(6);
//    document.removePage(7);
//    document.removePage(8);
//    document.removePage(9);
//    document.removePage(10);
//    document.removePage(11);
//    document.removePage(13);
//    document.removePage(16);
//    document.removePage(21);
//    document.removePage(22);
    document.save("C:\\Users\\cody.jewell\\Desktop\\UPDATED.pdf");
    document.close();
  }
}
