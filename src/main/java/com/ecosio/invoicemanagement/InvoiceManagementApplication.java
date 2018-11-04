package com.ecosio.invoicemanagement;

import com.ecosio.invoicemanagement.model.Invoice;
import com.ecosio.invoicemanagement.model.InvoiceLine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

/**
 * Simple invoice management app
 */
@SpringBootApplication
public class InvoiceManagementApplication implements CommandLineRunner {

  private static Logger LOG = LoggerFactory
      .getLogger(InvoiceManagementApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(InvoiceManagementApplication.class, args);
  }

  @Override
  public void run(String... args) {

    InvoiceManagement invoiceManagement = new InvoiceManagement();

    //Add two sample invoices
    Invoice invoice1 = new Invoice("Invoice 1", "Buyer A", "Supplier B");
    InvoiceLine invoiceLine1 = new InvoiceLine(1, "Apples", new BigDecimal("5"), new BigDecimal("2.54"), new BigDecimal("10"));
    InvoiceLine invoiceLine2 = new InvoiceLine(2, "Orange Juice", new BigDecimal("8"), new BigDecimal("1.87"), new BigDecimal("20"));

    invoice1.addInvoiceLine(invoiceLine1);
    invoice1.addInvoiceLine(invoiceLine2);
    invoiceManagement.addInvoice(invoice1);

    LOG.info("Added invoice {}", invoice1);

    Invoice invoice2 = new Invoice("Invoice 1", "Buyer D", "Supplier E");
    InvoiceLine invoiceLine3 = new InvoiceLine(1, "Pears", new BigDecimal("2"), new BigDecimal("1.22"), new BigDecimal("10"));
    InvoiceLine invoiceLine4 = new InvoiceLine(2, "Apple Juice", new BigDecimal("7"), new BigDecimal("3.34"), new BigDecimal("20"));
    InvoiceLine invoiceLine5 = new InvoiceLine(3, "Pineapple", new BigDecimal("3"), new BigDecimal("2.98"), new BigDecimal("10"));

    invoice2.addInvoiceLine(invoiceLine3);
    invoice2.addInvoiceLine(invoiceLine4);
    invoice2.addInvoiceLine(invoiceLine5);
    invoiceManagement.addInvoice(invoice2);

    LOG.info("Added invoice {}", invoice2);

    LOG.info("Total invoice gross amount is {}", invoiceManagement.getInvoiceGrossTotals());


  }


}

