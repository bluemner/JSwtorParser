package jswtorparser.event.factory;

import jswtorparser.event.SwtorParser.StateChange;


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
 * <b>CombatEvent:</b> Event that stores state of combat<br>
 * 
 * <b>Extends:</b>  {@link SwtorParserEvent}
 * @author Brandon Bluemner
 * 
 */
public class CombatEvent extends SwtorParserEvent {

	
	
	public final static byte  STARTED =0;
	public final static byte  STOPED =1;
	public final static byte  PAUSED =2;
	
	/**
	 * 
	 * @param et {@link SwtorEventType}
	 * @param state {@link StateChange} of the event
	 */
	public CombatEvent( StateChange sc) {
		super(SwtorEventType.COMBAT,sc);
	
	}
	
	/**
	 * 
	 * @return the combat Byte 0 Started , 1 STOPED, 2 PAUSED
	 */
	public byte getCombat() {
		return state.getState();
	}
	/**
	 * 
	 * @return String of Combat State State
	 */
	public String getCombatString(){
		switch(state.getState()){
		case STARTED: return "Strated";
		case STOPED:  return "Stoped";
		case PAUSED:  return "PAUSED";
		
		default: return "";
		}
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPlayer() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public long getValue() {
		// TODO Auto-generated method stub
		return state.getState();
	}

	@Override
	public boolean isGiven() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAbilityName() {
		// TODO Auto-generated method stub
		return this.state.getAbility();
	}

	@Override
	public boolean isCompanion() {
		// TODO Auto-generated method stub
		return false;
	}

}
