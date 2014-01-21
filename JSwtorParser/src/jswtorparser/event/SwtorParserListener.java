package jswtorparser.event;

import jswtorparser.event.factory.DamageEvent;
import jswtorparser.event.factory.HealEvent;


/**
 * 
 * @author Brandon Bluemner
 *
 */
public interface SwtorParserListener {
	/*
	 * Player Code
	 */
	public void healGiven(HealEvent e);
	public void healRecevied(HealEvent e);
	public void damageGiven(DamageEvent e);
	public void damageRecvied(DamageEvent e);
	public void threat(SwtorParser p);
	/*
	 * Companion
	 */
	public void companionHealGiven(HealEvent e);
	public void companionHealRecevied(HealEvent e);
	public void companionHamageGiven(DamageEvent e);
	public void companionHamageRecvied(DamageEvent e);
	public void companionThreat(SwtorParser p);
	
	/*
	 * Action
	 */
	public void clear();
	public void combatStarted(SwtorParser p);
	public void combatEnded(SwtorParser p);
	public void update(SwtorParser p);
}
