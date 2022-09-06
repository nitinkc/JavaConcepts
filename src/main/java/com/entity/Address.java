package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 3:09 AM
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Address {

    public String addressLine1;
    public String addressLine2;

    public String City;
    public String State;
    public String Country;
    public int zip;

}
