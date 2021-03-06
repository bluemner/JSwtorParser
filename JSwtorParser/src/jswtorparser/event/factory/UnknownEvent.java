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
 * <b>UnknownEvent:</b> Event of an Unknown State<br>
 * <b>Extends:</b>  {@link SwtorParserEvent}
 * @author Brandon Bluemner
 *
 */
public class UnknownEvent extends SwtorParserEvent {

		public UnknownEvent(){
			super(SwtorEventType.UNKNOWN,null);
		}

		@Override
		protected void run() {
			// TODO Auto-generated method stub
			
		}
		
		/**
		 * 
		 * @return <b>true</b> if the charter is the player false otherwise;
		 */
		@Override
		public boolean isPlayer(){
			return false;
		}
		/**
		 * @return -3
		 */
		@Override
		public long getValue() {
			return -3;
		}
		@Override
		public boolean isGiven() {
			return false;
		}
		@Override
		public String getAbilityName() {
			return "Unknown";
		}

		@Override
		public boolean isCompanion() {
			// TODO Auto-generated method stub
			return state.isCompanion();
		}

		@Override
		public int threat() {
			// TODO Auto-generated method stub
			return 0;
		}
		
}
