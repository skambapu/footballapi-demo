package com.spireon.footballleague.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {
    private long country_id;
    private String country_name;
}
