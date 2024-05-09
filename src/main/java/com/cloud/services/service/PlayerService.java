package com.cloud.services.service;

import com.cloud.services.entity.Player;

public interface PlayerService {
    Iterable<Player> findAll();
}
