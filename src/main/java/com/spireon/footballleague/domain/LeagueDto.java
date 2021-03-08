package com.spireon.footballleague.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueDto {
    private long country_id;
    private String country_name;
    private long league_id;
    private String league_name;
}
