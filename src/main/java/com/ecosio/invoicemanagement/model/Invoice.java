package com.ecosio.invoicemanagement.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents invoices types, such as commercial invoice, debit note, etc.
 */
public class Invoice extends Document {

  //Supplying party
  private String supplier;

  //Buying party
  private String buyer;

  //Invoice total amounts
  private BigDecimal totalNetAmount = BigDecimal.ZERO;
  private BigDecimal totalTaxAmount = BigDecimal.ZERO;
  private BigDecimal totalGrossAmount = BigDecimal.ZERO;

  private List<InvoiceLine> invoiceLines = new ArrayList<>();


  public Invoice(String invoiceNumber, String buyer, String supplier) {
    super(invoiceNumber);
    this.buyer = buyer;
    this.supplier = supplier;
  }


  public void addInvoiceLine(InvoiceLine invoiceLine) {
    invoiceLines.add(invoiceLine);

    //Update the invoice amounts
    totalNetAmount = totalNetAmount.add(invoiceLine.getNetAmount());
    totalTaxAmount = totalTaxAmount.add(invoiceLine.getTaxAmount());
    totalGrossAmount = totalGrossAmount.add(invoiceLine.getGrossAmount());

  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public String getBuyer() {
    return buyer;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public BigDecimal getTotalNetAmount() {
    return totalNetAmount;
  }


  public BigDecimal getTotalTaxAmount() {
    return totalTaxAmount;
  }

  public BigDecimal getTotalGrossAmount() {
    return totalGrossAmount;
  }

  @Override
  public String toString() {
    return "Invoice{" +
           "supplier='" + supplier + '\'' +
           ", buyer='" + buyer + '\'' +
           ", totalNetAmount=" + totalNetAmount +
           ", totalTaxAmount=" + totalTaxAmount +
           ", totalGrossAmount=" + totalGrossAmount +
           ", invoiceLines=" + invoiceLines +
           ", documentNumber='" + documentNumber + '\'' +
           '}';
  }
}
