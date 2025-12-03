package adventcode.daythree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {

    @Test
    void should_return_value_of_joltage() {
        Battery battery = new Battery(9, 1);
        assertThat(battery.getJoltage()).isEqualTo(9);
        assertThat(battery.getPosition()).isEqualTo(1);
    }
}