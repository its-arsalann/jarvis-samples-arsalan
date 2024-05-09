package com.cloud.services.service;

import com.cloud.services.entity.Team;

public interface TeamService {
    Team getTeam(Long id);
    Team createTeam(Team teamRequestDTO);
}