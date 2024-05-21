package com.cloud.services.repository;

import com.cloud.services.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TeamRepositoryTests {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void testSaveAndFindTeam() {
        Team team = new Team();
        team = teamRepository.save(team);

        Team foundTeam = teamRepository.findById(team.getId()).orElse(null);
        assertThat(foundTeam).isNotNull();
    }
}
