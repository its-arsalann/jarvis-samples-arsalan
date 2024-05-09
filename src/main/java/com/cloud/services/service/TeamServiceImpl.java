package com.cloud.services.service;

import com.cloud.services.entity.Team;
import com.cloud.services.repository.PlayerRepository;
import com.cloud.services.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Team getTeam(Long id) {
       return teamRepository.findById(id).get();
    }

    @Override
    public Team createTeam(Team team) {
        teamRepository.save(team);
        return team;
    }
}