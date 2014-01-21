package jswtorparser.event.factory;

import jswtorparser.event.SwtorParser;

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
 * 
 * @author Brandon Bluemner
 *
 */
public class SwtorEventFactory {
		/**
		 * 
		 * @param sc State Change Provided In jwtorparser.event.SwtorParser.statChange
		 * @return Correct Event State Based on Parse information
		 */
		public static SwtorParserEvent newEvent(SwtorParser.StateChange sc){
			SwtorParserEvent ev = null;
			switch(sc.getType()){
			case HEALS: ev = new HealEvent(sc.getValue(),sc.isPlayer(),sc.isGiving(),sc.getAbility());
						break;
			case DAMAGE: ev = new DamageEvent(sc.getValue(),sc.isPlayer(),sc.isGiving(),sc.getAbility());
						break;
			case THREAT: ev = new ThreatEvent(sc.getValue(),sc.isPlayer());
						break;
			case COMBAT:
						 ev = new CombatEvent(sc.getState());
						break;
			case DEATH:
						ev= new DeathEvent(sc.isPlayer());
			case UPDATE:
						break;
			case CLEAR: 
						break;
			default:
				ev=new UnknownEvent();
			}
			
			return ev ;
		}
}
