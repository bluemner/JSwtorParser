package jswtorparser.event;

import jswtorparser.event.factory.*;


/**
 * Listener that works with {@link SwtorParser}
 * @author Brandon Bluemner
 *
 */
public interface SwtorParserListener {
	/*
	 * All events must extend SwtorParserEvent so we don't have to specify children here, despite the factory is returning them...
	 */
	/*
	 * Player Code
	 */
	
	/**
	 * Method For handling Heals received event
	 * @param e {@link HealEvent}
	 */
	public void healGiven(SwtorParserEvent e);
	/**
	 * Method For handling Heals given event
	 * @param e {@link HealEvent}
	 */
	public void healRecevied(SwtorParserEvent e);
	/**
	 * Method For handling Damage given event
	 * @param e {@link DamageEvent}
	 */
	public void damageGiven(SwtorParserEvent e);
	/**
	 * Method For handling Damage received event
	 * @param e {@link DamageEvent}
	 */
	public void damageRecvied(SwtorParserEvent e);
	/**
	 * Method For handling Threat event
	 * @param e {@link ThreatEvent}
	 */
	public void threat(SwtorParserEvent e);
	/**
	 * Method For handling death event
	 * @param e {@link DeathEvent}
	 */
	public void death(SwtorParserEvent e);
	/*
	 * Companion
	 */
	/**
	 * Method For handling Heals given event
	 * @param e {@link HealEvent}
	 */
	public void companionHealGiven(SwtorParserEvent e);
	/**
	 * Method For handling Heals received event
	 * @param e {@link HealEvent}
	 */
	public void companionHealRecevied(SwtorParserEvent e);
	/**
	 * Method For handling Damage given event
	 * @param e {@link DamageEvent}
	 */
	public void companionDamageGiven(SwtorParserEvent e);
	/**
	 * Method For handling Damage received event
	 * @param e {@link DamageEvent}
	 */
	public void companionDamageRecvied(SwtorParserEvent e);
	/**
	 * Method For handling Threat event
	 * @param e {@link ThreatEvent}
	 */
	public void companionThreat(SwtorParserEvent e);
	/**
	 * Method For handling death event
	 * @param e {@link DeathEvent}
	 */
	public void companionDeath(SwtorParserEvent e);
	/*
	 * Action
	 */
	public void clear();
	public void combatStarted(SwtorParserEvent e);
	public void combatEnded(SwtorParserEvent e);
	public void combatPaused(SwtorParserEvent e);
	public void update();
}
