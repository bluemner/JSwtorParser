package jswtorparser.event.factory;


public class CombatEvent extends SwtorParserEvent {

	private byte combat;
	
	public final static byte  STARTED =0;
	public final static byte  STOPED =1;
	public final static byte  PAUSED =2;
	
	public CombatEvent( byte combat) {
		super(SwtorEventType.COMBAT);
		this.combat = combat;
	}
	
	/**
	 * 
	 * @return the combat Byte 0 Started , 1 STOPED, 2 PAUSED
	 */
	public byte getCombat() {
		return combat;
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub

	}

}
