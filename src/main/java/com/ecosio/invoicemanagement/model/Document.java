package com.ecosio.invoicemanagement.model;

/**
 * Base logic for all document types, such as invoice, despatch advice, etc.
 */
public abstract class Document {


  protected String documentNumber;
  protected boolean processed;


  public Document() {

  }

  public Document(String documentNumber) {
    this.documentNumber = documentNumber;
    this.processed = false;
  }

  public Document(String documentNumber, boolean processed) {
    this.documentNumber = documentNumber;
    this.processed = processed;
  }


  protected String getDocumentNumber() {
    return documentNumber;
  }


  protected boolean isProcessed() {
    return processed;
  }


}
