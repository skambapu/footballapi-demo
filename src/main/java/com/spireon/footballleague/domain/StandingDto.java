package com.spireon.footballleague.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingDto {
    private String country_name;
    private long league_id;
    private String league_name;
    private long team_id;
    private String team_name;
    private long overall_league_position;
}
