package jswtorparser.event.factory;

import jswtorparser.event.SwtorParser.StateChange;



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
	

	/**
	 * Creates a threat event
	 * @param sc {@link StateChange}
	 */
	public ThreatEvent(StateChange sc){
		
		super(SwtorEventType.THREAT,sc);
		
	
	}
	
	


	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean isPlayer() {
		// TODO Auto-generated method stub
		return state.isPlayer();
	}




	@Override
	public long getValue() {
		// TODO Auto-generated method stub
		return state.getValue();
	}




	@Override
	public boolean isGiven() {
		// TODO Auto-generated method stub
		return state.isGiving();
	}




	@Override
	public String getAbilityName() {
		// TODO Auto-generated method stub
		return state.getAbility();
	}




	@Override
	public boolean isCompanion() {
		// TODO Auto-generated method stub
		return state.isCompanion();
	}




	@Override
	public int threat() {
		// TODO Auto-generated method stub
		return state.getThreat();
	}
	
}
