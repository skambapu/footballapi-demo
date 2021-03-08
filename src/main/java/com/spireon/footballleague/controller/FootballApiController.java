package com.spireon.footballleague.controller;

import com.spireon.footballleague.domain.FootballLeagueDto;
import com.spireon.footballleague.service.FootballApiService;
import com.spireon.footballleague.domain.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/internal")
public class FootballApiController {

    @Autowired
    FootballApiService service;


    @GetMapping("/countries")
    public ResponseEntity<Collection<CountryDto>> getCountries() {
      return ResponseEntity.ok(service.getCountries());
    }

    @GetMapping("/standings")
    public ResponseEntity<Set<FootballLeagueDto>> getFotballLeagueStandings() {
        return ResponseEntity.ok(service.getFootballLeague());
    }

}
