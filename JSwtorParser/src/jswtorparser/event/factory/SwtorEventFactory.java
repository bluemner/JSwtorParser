package jswtorparser.event.factory;

import jswtorparser.event.SwtorParser;

public class SwtorEventFactory {
		public static SwtorParserEvent newEvent(SwtorParser.stateChange sc){
			SwtorParserEvent ev = null;
			switch(sc.getType()){
			case HEALS: ev = new HealEvent(sc.getValue(),sc.isPlayer(),sc.isGiving());
						break;
			case DAMAGE: ev = new DamageEvent(sc.getValue(),sc.isPlayer(),sc.isGiving());
						break;
			case THREAT: ev = new ThreatEvent(sc.getValue(),sc.isPlayer());
						break;
			case COMBAT:
						 ev = new CombatEvent(sc.getState());
						break;
			case UPDATE:
						break;
			case CLEAR: 
						break;
			default:
				break;
			}
			
			return ev;
		}
}
