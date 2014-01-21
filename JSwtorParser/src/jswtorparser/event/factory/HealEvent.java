package jswtorparser.event.factory;


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
 * <b>HealEvent:</b> Event that stores state of Heals<br>
 * <b>Extends:</b>  {@link SwtorParserEvent}
 * @author Brandon Bluemner
 * 
 */
public class HealEvent extends SwtorParserEvent {
	

	long value;
	boolean isPlayer;
	boolean isGiven;
	String  abilityName;
	/**
	 * 
	 * 
	 * @param value amount of heals received
	 * @param isPlayer True if player is the one selected false for companion
	 * @param isGiven true if giving heals false is receiving 
	 * @param abilityName the ability that is being applied during this state
	 */
	public HealEvent( long value, boolean isPlayer , boolean isGiven,String abilityName){
		super(SwtorEventType.HEALS);
		this.value=value;
		this.isPlayer=isPlayer;
		this.isGiven=isGiven;
	}

	@Override
	protected void run() {
		
	}
	
}
