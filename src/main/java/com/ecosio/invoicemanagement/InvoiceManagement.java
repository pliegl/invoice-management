package com.ecosio.invoicemanagement;


import com.ecosio.invoicemanagement.model.Invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple invoice management application
 *
 * We on purpose do not use Java streams or byte code manipulation for getters and setters using Lombok
 * to allow for a better comparision to the ABAP sample
 */
public class InvoiceManagement {


  private List<Invoice> invoices = new ArrayList<>();



  public BigDecimal getInvoiceGrossTotals() {
    BigDecimal sum = BigDecimal.ZERO;

    for (Invoice invoice : invoices) {
      sum = sum.add(invoice.getTotalGrossAmount());
    }

    return sum;
  }


  public void addInvoice(Invoice invoice) {
    invoices.add(invoice);
  }


}
