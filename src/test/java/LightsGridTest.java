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
    void should_turn_on_lights_in_rectangle() {
        LightsGrid lightsGrid = new LightsGrid(3, 3);

        Rectangle rectangleWithLights = new Rectangle(0, 0, 1, 1);
        lightsGrid.turnOnLights(rectangleWithLights);

        assertThat(lightsGrid.getLights(new Rectangle(0, 0, 2, 2)))
                .isEqualTo(4);
    }

    @Test
    void should_keep_lights_on_when_turning_on_lights_in_rectangle() {
        LightsGrid lightsGrid = new LightsGrid(3, 3);

        Rectangle rectangleWithLights = new Rectangle(0, 0, 1, 1);
        lightsGrid.turnOnLights(rectangleWithLights);
        Rectangle rectangleWithLights2 = new Rectangle(1, 1, 2, 2);
        lightsGrid.turnOnLights(rectangleWithLights2);

        assertThat(lightsGrid.getLights(new Rectangle(0, 0, 2, 2)))
                .isEqualTo(7);
    }
}
