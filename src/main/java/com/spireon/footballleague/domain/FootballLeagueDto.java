package com.spireon.footballleague.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FootballLeagueDto {
    private LeagueDto leagueDto;
    private StandingDto standingDto;
}
