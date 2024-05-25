package com.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.processing.Generated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "uid",
        "credit_card_number",
        "credit_card_expiry_date",
        "credit_card_type"
})
@Generated("jsonschema2pojo")
public class Card {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("credit_card_number")
    public String creditCardNumber;
    @JsonProperty("credit_card_expiry_date")
    public String creditCardExpiryDate;
    @JsonProperty("credit_card_type")
    public String creditCardType;
}
