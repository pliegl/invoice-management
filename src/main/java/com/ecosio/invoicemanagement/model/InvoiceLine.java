package com.ecosio.invoicemanagement.model;

import java.math.BigDecimal;

/**
 * Line item of an invoice
 */
public class InvoiceLine {

  //Positions are numbered in an ascending order
  private int positionNumber;
  //Free text description of invoiced item
  private String description;
  private BigDecimal quantity;
  private BigDecimal price;
  private BigDecimal taxRate;


  public InvoiceLine(int positionNumber, String description, BigDecimal quantity, BigDecimal price, BigDecimal taxRate) {
    this.positionNumber = positionNumber;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.taxRate = taxRate;
  }


  public BigDecimal getNetAmount() {
    return price.multiply(quantity);
  }

  public BigDecimal getGrossAmount() {
    return price.multiply(quantity).multiply(BigDecimal.ONE.add(BigDecimal.ONE.divide(taxRate)));
  }

  public BigDecimal getTaxAmount() {
    return getNetAmount().multiply(taxRate);
  }


  public int getPositionNumber() {
    return positionNumber;
  }

  public void setPositionNumber(int positionNumber) {
    this.positionNumber = positionNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  @Override
  public String toString() {
    return "InvoiceLine{" +
           "positionNumber=" + positionNumber +
           ", description='" + description + '\'' +
           ", quantity=" + quantity +
           ", price=" + price +
           ", taxRate=" + taxRate +
           '}';
  }
}
