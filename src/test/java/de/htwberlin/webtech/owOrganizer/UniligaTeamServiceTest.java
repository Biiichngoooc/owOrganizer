package de.htwberlin.webtech.owOrganizer;


import de.htwberlin.webtech.owOrganizer.persistence.IUniligaTeamRepository;
import de.htwberlin.webtech.owOrganizer.service.UniligaTeamService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UniligaTeamServiceTest implements WithAssertions {
    @Mock
    private IUniligaTeamRepository repository;

    @InjectMocks
    private UniligaTeamService underTest;

    @Test
    @DisplayName("should return false if uniliga Team to delete does not exist")
    void should_return_false_if_uniliga_team_to_delete_does_not_exist(){
        Integer givenId = 12;
        doReturn(false).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
