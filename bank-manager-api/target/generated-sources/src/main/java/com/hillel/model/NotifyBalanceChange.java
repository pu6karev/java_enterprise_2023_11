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
 * NotifyBalanceChange
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-29T23:11:17.851421400+02:00[Europe/Kiev]")
public class NotifyBalanceChange {

  private Integer accountId;

  private Integer newBalance;

  public NotifyBalanceChange accountId(Integer accountId) {
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

  public NotifyBalanceChange newBalance(Integer newBalance) {
    this.newBalance = newBalance;
    return this;
  }

  /**
   * Get newBalance
   * @return newBalance
  */
  
  @Schema(name = "newBalance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("newBalance")
  public Integer getNewBalance() {
    return newBalance;
  }

  public void setNewBalance(Integer newBalance) {
    this.newBalance = newBalance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotifyBalanceChange notifyBalanceChange = (NotifyBalanceChange) o;
    return Objects.equals(this.accountId, notifyBalanceChange.accountId) &&
        Objects.equals(this.newBalance, notifyBalanceChange.newBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, newBalance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotifyBalanceChange {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    newBalance: ").append(toIndentedString(newBalance)).append("\n");
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

