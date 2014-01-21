package jswtorparser.event;

import jswtorparser.event.factory.*;


/**
 * 
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
	public void healGiven(SwtorParserEvent e);
	public void healRecevied(SwtorParserEvent e);
	
	public void damageGiven(SwtorParserEvent e);
	public void damageRecvied(SwtorParserEvent e);
	
	public void threat(SwtorParserEvent e);
	public void death(SwtorParserEvent e);
	/*
	 * Companion
	 */
	public void companionHealGiven(SwtorParserEvent e);
	public void companionHealRecevied(SwtorParserEvent e);
	
	public void companionDamageGiven(SwtorParserEvent e);
	public void companionDamageRecvied(SwtorParserEvent e);
	
	public void companionThreat(SwtorParserEvent e);
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
