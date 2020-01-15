package com.cody;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Invoice {
  private String rawString;
  private String invoiceNumber;
  private String date;
  private String route;
  private ArrayList<InvoiceItem> items;
  private int pages;
  private double totalWeight;
  private double invoiceTotal;

  public Invoice(String rawString) {
    this.rawString = rawString;
  }

  public String getRawString() {
    return rawString;
  }

  private void parse() {
    // turn long string into arraylist of invoice items.
  }

  public String findInvoiceNumber() {
    String pattern = "^[0-9]{7}$";
    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);
    // Now create matcher object.
    Matcher m = r.matcher(rawString);


   // TODO: NOT FINDING INVOICE NUMBER CORRECTLY



    if (m.find()) {
      return invoiceNumber = m.toString();
    }
    return "Not Found!";
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }
}

