package com.spireon.footballleague.client;


import com.spireon.footballleague.domain.CountryDto;
import com.spireon.footballleague.domain.LeagueDto;
import com.spireon.footballleague.domain.StandingDto;
import com.spireon.footballleague.setting.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@FeignClient(value = "footballLeague", url = "https://apiv2.apifootball.com/", configuration = FeignClientConfig.class)
public interface FootballApiClient {


    @RequestMapping(method = RequestMethod.GET, value = "?action=get_countries&APIkey=41aba4ffe7ad9d0776a1d2c531bc7b20d7034010ff97c3860b6b3217864c0e49")
    Collection<CountryDto> getCountries();

    @RequestMapping(method = RequestMethod.GET, value = "?action=get_leagues&country_id={country_id}&APIkey=41aba4ffe7ad9d0776a1d2c531bc7b20d7034010ff97c3860b6b3217864c0e49")
    Collection<LeagueDto> getLeagues(@RequestParam("country_id") long country_id);

    @RequestMapping(method = RequestMethod.GET, value = "?action=get_standings&league_id={league_id}&APIkey=41aba4ffe7ad9d0776a1d2c531bc7b20d7034010ff97c3860b6b3217864c0e49")
    Collection<StandingDto> getStandings(@RequestParam("league_id") long league_id);

}
