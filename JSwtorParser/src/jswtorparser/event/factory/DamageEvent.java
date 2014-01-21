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
 * <b>DamageEvent:</b> Event that stores state of Damage<br>
 * <b>Extends:</b>  {@link SwtorParserEvent}
 * @author Brandon Bluemner
 
 */
public class DamageEvent extends SwtorParserEvent{
	
	private long value;
	private boolean isPlayer;
	private boolean isGiven;
	private String abilityName;

	public DamageEvent( long value, boolean isPlayer , boolean isGiven, String abilityName){	
		super(SwtorEventType.DAMAGE);
		this.value=value;
		this.isPlayer=isPlayer;
		this.isGiven=isGiven;
		this.abilityName=abilityName;
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
	/**
	 * @return the isGiven
	 */
	public boolean isGiven() {
		return isGiven;
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
	}
}
