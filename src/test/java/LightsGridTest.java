import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LightsGridTest {

    /**
     * Behaviour for part 2:
     * - Turn On means add 1 brightness to the lights in the rectangle
     * - Turn Off means remove 1 brightness to the lights in the rectangle
     * - Toggle means add 2 brightness to the lights in the rectangle
     * - Get Lights means sum the brightness of the lights in the rectangle
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

    @Test
    void should_toggle_on_lights_in_rectangle() {
        LightsGrid lightsGrid = new LightsGrid(3, 3);

        Rectangle rectangleWithLights = new Rectangle(0, 0, 1, 1);
        lightsGrid.toggleLights(rectangleWithLights);

        assertThat(lightsGrid.getLights(new Rectangle(0, 0, 2, 2)))
                .isEqualTo(4);
    }

    @Test
    void should_toggle_off_some_lights_in_rectangle() {
        LightsGrid lightsGrid = new LightsGrid(3, 3);

        Rectangle rectangleWithLights = new Rectangle(0, 0, 1, 1);
        lightsGrid.turnOnLights(rectangleWithLights);
        Rectangle rectangleWithLights2 = new Rectangle(0, 0, 0, 0);
        lightsGrid.toggleLights(rectangleWithLights2);

        assertThat(lightsGrid.getLights(new Rectangle(0, 0, 2, 2)))
                .isEqualTo(3);
    }
}
