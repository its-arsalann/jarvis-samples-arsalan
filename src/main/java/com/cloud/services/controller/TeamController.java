package com.cloud.services.controller;

import com.cloud.services.entity.Team;
import com.cloud.services.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teams")
public class TeamController {

    @Autowired
    private Environment environment;

    @Autowired
    private TeamService teamService;

    @Profile("dev")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Team team){
        return new ResponseEntity(teamService.createTeam(team), HttpStatus.CREATED);
    }

    @Profile("dev")
    @GetMapping(path = "/{teamId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(@PathVariable Long teamId){
        return new ResponseEntity(teamService.getTeam(teamId), HttpStatus.OK);
    }

    @GetMapping
    public String get(){
        return environment.getProperty("local.server.port");
    }
}