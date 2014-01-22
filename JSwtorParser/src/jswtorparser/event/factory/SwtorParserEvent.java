package jswtorparser.event.factory;

import jswtorparser.event.SwtorParser.StateChange;

/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
/**
 * /**
 * <b>SwtorParserEvent </b> Parent Class to all events<br>
 * 
 * @author Brandon Bluemner
 * 
 */
public abstract  class SwtorParserEvent {

	private SwtorEventType et;
	protected StateChange state;
	
	/**
	 * 
	 * @param et {@link SwtorEventType}
	 * @param state {@link StateChange} of the event
	 */
	public SwtorParserEvent(SwtorEventType et, StateChange state){
		this.et=et;
		this.state=state;
	}
	/**
	 * Code to run during event 
	 */
	protected abstract void run();
	/**
	 * @return the EventType
	 */
	public SwtorEventType getEventType() {
		return et;
	}
	/**
	 * @param et the EventType to set
	 */
	public void setEventType(SwtorEventType et) {
		this.et = et;
	}
	/**
	 * 
	 * @return <b>True</b> if the player caused the event </br> <b>False</b> if other caused ;
	 */
	public abstract boolean isPlayer();
	/**
	 * 
	 * @return <b>True</b> if the player companion caused the event </br> <b>False</b> if other caused;
	 */
	public abstract boolean isCompanion();
	/**
	 * 
	 * @return the value of the event 
	 */
	public abstract long getValue() ;
	/**
	 * 
	 * @return <b>True:</b> if the player is causing the action</br><b>False:</b> if the player is receiving the action
	 */
	public abstract boolean isGiven() ;
	
	/**
	 * 
	 * @return the abilities name
	 */
	public abstract String getAbilityName() ;
		
	
	
}
