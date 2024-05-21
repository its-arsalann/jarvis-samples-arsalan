package com.cloud.services.repository;

import com.cloud.services.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PlayerRepositoryTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void testSaveAndFindPlayer() {
        Player player = new Player();
        player.setName("John Doe");
        player = playerRepository.save(player);

        Player foundPlayer = playerRepository.findById(player.getId()).orElse(null);
        assertThat(foundPlayer).isNotNull();
        assertThat(foundPlayer.getName()).isEqualTo("John Doe");
    }
}
