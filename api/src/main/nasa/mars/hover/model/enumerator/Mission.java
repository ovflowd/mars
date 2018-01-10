package nasa.mars.hover.model.enumerator;

/**
 * Mission Status Enumerator
 * <p>
 * Used for the Mission Status of the Hover
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
public enum Mission {

    NOT_STARTED, // Mission not Started
    STARTED, // Mission Started
    NOT_LAUNCHED, // Hover not Launched from Earth
    IN_TRAVEL, // Hover in Travel to the Map
    LANDED, // Hover Landed
    OPERATING, // Hover Operating
    FAILURE, // Hover Failed
    ENDED // Mission Ended
}
