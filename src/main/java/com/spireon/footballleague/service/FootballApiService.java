package com.spireon.footballleague.service;

import com.spireon.footballleague.client.FootballApiClient;
import com.spireon.footballleague.domain.CountryDto;
import com.spireon.footballleague.domain.FootballLeagueDto;
import com.spireon.footballleague.domain.LeagueDto;
import com.spireon.footballleague.domain.StandingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FootballApiService {

    @Autowired
    FootballApiClient footballApiClient;

    public Collection<CountryDto> getCountries() {
        return footballApiClient.getCountries();
    }

    public Collection<LeagueDto> getLeagues(long countryId) {
        return footballApiClient.getLeagues(countryId);
    }

    public Collection<StandingDto> getStandings(long leagueId) {
        return footballApiClient.getStandings(leagueId);
    }

    public Set<FootballLeagueDto> getFootballLeague() {
        Set<FootballLeagueDto> footballLeagueDtos = new HashSet<>();
        Collection<CountryDto> countryDtos = getCountries();
        countryDtos.stream().forEach(countryDto -> {
            Collection<LeagueDto> leagueDtos = getLeagues(countryDto.getCountry_id());
            leagueDtos.stream().forEach(leagueDto -> {
                Collection<StandingDto> standingDtos = getStandings(leagueDto.getLeague_id());
                standingDtos.stream().forEach(standingDto -> {
                    FootballLeagueDto footballLeagueDto = new FootballLeagueDto();
                    footballLeagueDto.setLeagueDto(leagueDto);
                    footballLeagueDto.setStandingDto(standingDto);
                    footballLeagueDtos.add(footballLeagueDto);
                });
            });
        });
        return footballLeagueDtos;
    }


}
