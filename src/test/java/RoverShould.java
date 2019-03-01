import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoverShould {
    @ParameterizedTest
    @CsvSource({
            "'', '0,0,N'",
            "'L', '0,0,W'",
            "'R', '0,0,E'",
            "'RR', '0,0,S'",
            "'LL', '0,0,S'",
            "'LLL', '0,0,E'",
            "'RRR', '0,0,W'",
            "'RRRR', '0,0,N'",
            "'LLLL', '0,0,N'",
    })
    void execute_commands_and_return_a_final_location(String commands, String expectedFinalLocation) {
        Rover rover = new Rover();
        assertEquals(expectedFinalLocation, rover.executeCommands(commands));
    }
}
