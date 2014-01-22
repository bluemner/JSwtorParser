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
 * <b>DeathEvent:</b> Event that stores state of Death<br>
 * <b>Extends:</b>  {@link SwtorParserEvent}
 * @author Brandon Bluemner
 *
 */
public class DeathEvent extends SwtorParserEvent {

	/**
	 * 
	 * @param et {@link SwtorEventType}
	 * @param state {@link StateChange} of the event
	 */
		public DeathEvent(StateChange sc){
			
			super(SwtorEventType.DEATH, sc);
			
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
			return -1;
		}

		@Override
		public boolean isGiven() {
			// TODO Auto-generated method stub
			return state.isGiving();
		}
		
		
		@Override
		public String getAbilityName() {
			// TODO Auto-generated method stub
			return "Death";
			
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
