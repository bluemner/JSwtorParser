package jswtorparser.event.factory;



/**
 * Event For when threat is generated 
 * @author Brandon Bluemner
 *
 */
public class ThreatEvent extends SwtorParserEvent{
	
	private long value;
	private boolean isPlayer;

	/**
	 * 
	 * @param value amount of threat generated 
	 * @param isPlayer true if is player false for companion
	
	 */
	public ThreatEvent(long value, boolean isPlayer){
		
		super(SwtorEventType.THREAT);
		this.value=value;
		this.isPlayer=isPlayer;
	
	}
	
	/**
	 * @return the value
	 */
	public long getValue() {
		return value;
	}

	/**
	 * @return the isPlayer
	 */
	public boolean isPlayer() {
		return isPlayer;
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
	}
}
