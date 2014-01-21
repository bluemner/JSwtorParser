package jswtorparser.event.factory;



/**
 * Event For when threat is generated 
 * @author Brandon Bluemner
 *
 */

/*
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
/**
 * <b>ThreatEvent:</b> Event that stores state of Threat<br>
 * <b>Extends:</b>  {@link SwtorParserEvent}
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
	 * Amount of threat
	 * @return the value of threat
	 */
	public long getValue() {
		return value;
	}

	/**
	 * If player is active 
	 * @return the isPlayer true if player is the one generating threat
	 */
	public boolean isPlayer() {
		return isPlayer;
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
	}
}
