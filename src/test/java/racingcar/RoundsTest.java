package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RoundsTest {

    @DisplayName("Car의 수는 1이상의 정수이다.")
    @Test
    void numberOfRoundsHasToBeIntegerNotLessThanOne() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Rounds(0)).withMessageMatching("시도 회수는 1이상의 정수입니다.");
    }

}
