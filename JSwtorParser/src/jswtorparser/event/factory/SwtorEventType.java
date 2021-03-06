package jswtorparser.event.factory;

/**
 * Stores all the event types needed for the Event factory
 * @author bluemner
 *
 */
public enum SwtorEventType {
	/*
	 * Player
	 */
	PLAYER_RECEIVED_HEALS,
	PLAYER_RECEIVED_DAMAGE,
	PLAYER_GIVEN_HEALS,
	PLAYER_GIVEN_DAMAGE,
	PLAYER_THREAT,	
	PLAYER_DEATH,
	/*
	 * Companion
	 */
	COMPANION_RECEIVED_HEALS,
	COMPANION_RECEIVED_DAMAGE,
	COMPANION_GIVEN_HEALS,
	COMPANION_GIVEN_DAMAGE,
	COMPANION_THREAT,
	COMPANION_DEATH,

	
	/*
	 * COMBAT events
	 */
	COMBAT_STARTED,
	COMBAT_ENDED,
	COMBAT_PAUSE,
	
	/*
	 * Generic
	 */
	HEALS,
	DAMAGE,
	THREAT,
	DEATH,
	COMBAT,
	
	/*
	 * BASE EVENTS
	 */
	CLEAR,
	UPDATE, UNKNOWN, 
}
