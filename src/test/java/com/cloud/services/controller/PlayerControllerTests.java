package com.cloud.services.controller;

import com.cloud.services.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PlayerControllerTests {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    public PlayerControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPlayers() {
        when(playerService.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity responseEntity = playerController.get();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
