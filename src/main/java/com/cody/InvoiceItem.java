package com.cody;

import java.util.Arrays;

public class InvoiceItem {
  private int orderedCount;
  private int shippedCount;
  private String unitOfMeasure;
  private String itemNumber;
  private String weightShipped;
  private double price;
  private double extension;
  private String itemName;
  private String itemDescription;
  private String gfsItemCode;
  private double[] weights;
  private int page;

  @Override
  public String toString() {
    return "InvoiceItem{" +
            "orderedCount=" + orderedCount +
            ", shippedCount=" + shippedCount +
            ", unitOfMeasure='" + unitOfMeasure + '\'' +
            ", itemNumber='" + itemNumber + '\'' +
            ", weightShipped='" + weightShipped + '\'' +
            ", price=" + price +
            ", extension=" + extension +
            ", itemName='" + itemName + '\'' +
            ", itemDescription='" + itemDescription + '\'' +
            ", gfsItemCode='" + gfsItemCode + '\'' +
            ", weights=" + Arrays.toString(weights) +
            ", page=" + page +
            '}';
  }
}
