import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LightsGridTest {

    /*
     * I would expect three things:
     * - Ability to TURN on lights in a rectangle
     * - Ability to TOGGLE a whole rectangle
     * - Ability to get the number of turned on lights in a rectangle (or whole grid)
     */
    @Test
    void fail() {
        Thing thing = new Thing();
        String value = thing.callForAction();
        assertThat(value)
                .isEqualTo("Food");
    }

    @Test
    void it_should_not_fail() {
        assertThat(42)
                .isEqualTo(42);
    }
}
