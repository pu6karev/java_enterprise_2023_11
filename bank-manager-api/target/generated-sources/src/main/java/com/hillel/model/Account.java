package com.hillel.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Account
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-29T23:11:17.851421400+02:00[Europe/Kiev]")
public class Account {

  private Integer accountId;

  private String iban;

  private Integer balance;

  private String currency;

  private Integer customerId;

  public Account accountId(Integer accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  */
  
  @Schema(name = "accountId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountId")
  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public Account iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  */
  
  @Schema(name = "iban", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("iban")
  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public Account balance(Integer balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  */
  
  @Schema(name = "balance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("balance")
  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  public Account currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  
  @Schema(name = "currency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Account customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.accountId, account.accountId) &&
        Objects.equals(this.iban, account.iban) &&
        Objects.equals(this.balance, account.balance) &&
        Objects.equals(this.currency, account.currency) &&
        Objects.equals(this.customerId, account.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, iban, balance, currency, customerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

