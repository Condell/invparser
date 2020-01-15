package com.cody;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find first number, get position in String,
 */
public class App1 {
  public static void main(String[] args) throws IOException {
    System.out.println("Running App...");


    File f = new File("C:\\Users\\cody.jewell\\IdeaProjects\\invparser\\inv_draft_err.pdf");
    String parsedText;
    //PDFParser parser = new PDFParser(new RandomAccessFile(f,
    //    "r"));
    //parser.parse();
    //
    //COSDocument cosDoc = parser.getDocument();
    PDFTextStripper pdfStripper = new PDFTextStripper();
    PDDocument doc = PDDocument.load(f);
    //PDDocument pdDoc = new PDDocument(cosDoc);
    parsedText = pdfStripper.getText(doc);

    Invoice invoice = new Invoice(parsedText);
    //System.out.println(invoice.getRawString());
    invoice.findInvoiceNumber();
    System.out.println(invoice.getInvoiceNumber());

    //char[] list = new char[10];
    //parsedText.getChars(0, 10, list, 0);


    String[] list = parsedText.split("\n");

    String invoiceNum = list[4];
    //System.out.println(list[4]);

    ArrayList<String> itemNumStrings = new ArrayList<>();



// vvvvvv GET INVOICE NUMBER vvvvvvvvv
//    String pattern = "^[0-9]{7}$";
//    // Create a Pattern object
//    Pattern r = Pattern.compile(pattern);
//    for (String str: list){
//      // Now create matcher object.
//      Matcher m = r.matcher(str);
//      if (m.find( )) {
//        System.out.println(str);
//      }
//    }

// vvvvvv GET STRING WITH ITEM NUMBER vvvvvvvvv
    String pattern = "[0-9]{2}[-][0-9]{5}";
    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);
    for (String str: list){
      // Now create matcher object.
      Matcher m = r.matcher(str);
      if (m.find( )) {
        System.out.println(str);
      }
    }

     //vvvvvv SEE PDF WITH ARRAY INDEX vvvvvv
//    int count = 0;
//    for (String str : list) {
//      System.out.println(count + " " + str);
//      count++;
//    };




//    try (PDDocument document = PDDocument.load(f)) {
//      PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//      stripper.setSortByPosition(true);
//      Rectangle rect = new Rectangle(10, 280, 275, 60);
//      stripper.addRegion("class1", rect);
//      PDPage firstPage = document.getPage(0);
//      stripper.extractRegions(firstPage);
//      System.out.println("Text in the area:" + rect);
//      System.out.println(stripper.getTextForRegion("class1"));
//    }


  }
}
