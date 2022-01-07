package de.htwberlin.webtech.owOrganizer;

import de.htwberlin.webtech.owOrganizer.persistence.IPlayerRepository;
import de.htwberlin.webtech.owOrganizer.service.PlayerService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest implements WithAssertions {
    @Mock
    private IPlayerRepository repository;

    @InjectMocks
    private PlayerService underTest;

    @Test
    @DisplayName("should return true if delete was succesfsul")
    void should_return_true_if_delete_was_succesfsul(){
        Integer givenId = 11;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if player to delete does not exist")
    void should_return_false_if_player_to_delete_does_not_exist(){
        Integer givenId = 11;
        doReturn(false).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
