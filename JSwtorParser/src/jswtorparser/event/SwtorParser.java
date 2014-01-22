package jswtorparser.event;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jswtorparser.event.factory.CombatEvent;
import jswtorparser.event.factory.SwtorEventFactory;
import jswtorparser.event.factory.SwtorEventType;
import jswtorparser.event.factory.SwtorParserEvent;

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
 * <b>SwtorParser:</b> Creates an instance that allows you to parse information
 * from
 * 
 * @author Brandon Bluemner
 */
public class SwtorParser {

	private boolean isRunning;
	private String playerName;
	private Set<SwtorParserListener> listeners;
	boolean DEBUG=true;

	//
	// /*
	// *Fight
	// */
	// int DAMAGE_GIVEN;
	// int DAMAGE_RECIVED;
	// int HEALS_GIVEN;
	// int HEALS_RECIVED;
	// int HEALS_THREAT;
	// int DAMAGE_THREAT;
	// int Threat; //Heals + Damage
	// int COMPANION_DAMAGE_GIVEN;
	// int COMPANION_DAMAGE_RECIVED;
	// int COMPANION_HEALS_GIVEN;
	// int COMPANION_HEALS_RECIVED;
	// int COMPANION_Threat;
	//
	// /*
	// * Total
	// */
	// long Total_DAMAGE_GIVEN;
	// long Total_DAMAGE_RECIVED;
	// long Total_HEALS_GIVEN;
	// long Total_HEALS_RECIVED;
	// long Total_Threat;
	//

	public SwtorParser() {
		this.listeners = new HashSet<SwtorParserListener>();
	}

	/**
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Adds the specified listener
	 * 
	 * @param l
	 *            Listener to add
	 */
	public void addSwtorParserListener(SwtorParserListener l) {
		this.listeners.add(l);
	}

	/**
	 * Removes the specified listener
	 * 
	 * @param l
	 *            The Listener to be removed
	 */
	public void removeSwtorParserListener(SwtorParserListener l) {
		this.listeners.remove(l);
	}

	/**
	 * Removes all listeners
	 */
	public void clearSwtorParserListener() {
		this.listeners.clear();
	}

	/**
	 * @param isRunning
	 *            the isRunning to set
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	/*
	 * Code to fire events
	 */

	/*
	 * Player Code
	 */
	public void fireHealGiven(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.healGiven(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireHealRecevied(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.healRecevied(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireDamageGiven(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.damageGiven(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireDamageRecvied(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.damageRecvied(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireThreat(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.threat(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireDeath(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.death(SwtorEventFactory.newEvent(sc));
		}
	}

	/*
	 * Companion
	 */
	public void fireCompanionHealGiven(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.companionHealGiven(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCompanionHealRecevied(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.companionHealRecevied(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCompanionDamageGiven(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.companionDamageGiven(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCompanionDamageRecvied(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.companionDamageRecvied(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCompanionThreat(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.companionThreat(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCompanionDeath(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.companionDeath(SwtorEventFactory.newEvent(sc));
		}
	}

	/*
	 * Action
	 */
	public void fireClear() {
		for (SwtorParserListener l : this.listeners) {
			l.clear();
		}
	}

	public void fireCombatStarted(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.combatStarted(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCombatEnded(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.combatEnded(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireCombatPaused(StateChange sc) {
		for (SwtorParserListener l : this.listeners) {
			l.combatPaused(SwtorEventFactory.newEvent(sc));
		}
	}

	public void fireUpdate() {
		for (SwtorParserListener l : this.listeners) {
			l.update();
		}
	}

	/*
	 * End of events
	 */

	/**
	 * 
	 * @param s
	 *            String to parse
	 */
	public void parse(String s) {
		/*
		 * [23:00:17.885] [@Försäkën:Treek {3275183146139648}]
		 * [@Försäkën:Treek{3275183146139648}] [Fektur Dart {3279138811019264}]
		 * [ApplyEffect * {836045448945477}: Heal {836045448945500}] (87) <11>
		 */

		StateChange sc1 = new StateChange();
		String reg1 = "(\\[.*?\\])", ws = "\\s*", reg2 = "(\\(.*\\))?", reg3 = "(<[^>]+>)?", line = reg1
				+ ws
				+ reg1
				+ ws
				+ reg1
				+ ws
				+ reg1
				+ ws
				+ reg1
				+ ws
				+ reg2
				+ ws + reg3 + ws;

		Pattern p = Pattern.compile(line, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);
		Matcher m = p.matcher(s);
		String[] group = new String[8];
		if (m.find()) {
			for (int i = 0; i < 8; ++i) {
				group[i] = m.group(i);
				if(DEBUG)
				_(m.group(i));
			}
		} else
			System.out.println("bad :(");
		/*
		 * 1 Time stamp - Skip
		 */

		/*
		 * 2 Source
		 */
		line = "(\\[)" + "(@)?" + "([^:]*)" + "(:)?" + "([^\\{]*)?" + "(\\{)?"
				+ "(\\d+)?" + "(\\})?" + "(\\])";
		_("");
		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		m = p.matcher(group[2]);
		if (m.find()) {

			if (playerName == null) {
				playerName = m.group(3);
				sc1.isPlayer = true;
			} else if (playerName.equals(m.group(3))) {
				sc1.isGiving = true;
				if (m.group(4).contains(":")) {
					
					sc1.isPlayer = false;
					sc1.isCompanion=true;
				} else
					sc1.isPlayer = true;

			} else {
				sc1.isGiving = false;
			}

		} else
			System.out.println("bad 2:(");

		/*
		 * 3 Destination
		 */
		m = p.matcher(group[3]);
		if (m.find()) {

			if (playerName.equals(m.group(3))) {

				if (m.group(4).contains(":")) {
					sc1.isPlayer = false;
					sc1.isCompanion=true;
				} else
					sc1.isPlayer = true;
			}

		} else
			System.out.println("bad 3 :(");

		/*
		 * 4 Ability
		 */
		line = "(\\[)" + "([^\\{]*)?" + "(\\{)?" + "(\\d+)?" + "(\\})?"
				+ "(\\])";

		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		m = p.matcher(group[4]);
		if (m.find()) {
			if (m.group(2) != null && !(m.group(2).isEmpty())) {
				sc1.ability = m.group(2);
			}
		} else
			System.out.println("bad 4:(");
		/*
		 * 6 Value
		 * TODO Value
		 */
		line ="(\\()"+"(\\d+)?"+"(\\*)?"+"(\\))";
		
		
		
		
		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		m = p.matcher(group[6]);
		if (m.find()) {
			if(m.group(2)!=null){
				sc1.value=Integer.parseInt(m.group(2));
			}
		} else
			System.out.println("bad 6:(");
		/*
		 * 7 Threat
		 * TODO Threat
		 */
		if(group[7]!=null){
		line ="(\\<)?"+"(\\d+)?"+"(\\*)?"+"(\\>)?";
		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		
		m = p.matcher(group[7]);
		if (m.find()) {
			if(m.group(2)!=null){
				sc1.threat=Integer.parseInt(m.group(2));
			}
		} else
			System.out.println("bad 7:(");
		}
		/*
		 * 5 Type 
		 *last because we use this to fire event
		 */
		//_("G5\n" + group[5] + "\n");
		line = "(\\[)?" + "([^\\{]*)?" + "(\\{)?" + "(\\d+)?" + "(\\})?"
				+ "(:)?" + "([^\\{]*)?" + "(\\d)?" + "(\\])?";

		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		m = p.matcher(group[5]);
		if (m.find()) {
			// for(int i=0; i<8;++i){
			// _(m.group(i));
			// }
			// String event =m.group(2);
			String type = m.group(7);

			if (type == null) {
				return;
			} else {
				type = type.trim();
				type = type.toUpperCase();
				if (type.contains("EnterCombat")) {
					sc1.type = SwtorEventType.COMBAT;
					sc1.state = CombatEvent.STARTED;

					this.fireCombatStarted(sc1);

				} else if (type.contains("ExitCombat")) {
					sc1.type = SwtorEventType.COMBAT;
					sc1.state = CombatEvent.STOPED;

					
					this.fireCombatEnded(sc1);
				} else if (type.contains("HEAL")) {
					sc1.type = SwtorEventType.HEALS;
				
					if (sc1.isPlayer) {
						/*
						 * Is the player
						 */
						if (sc1.isGiving) {
							this.fireHealGiven(sc1);
						}

						else {
							this.fireHealRecevied(sc1);
						}

					} else {
						/*
						 * Not Player Might be companion
						 */
						if (sc1.isGiving) {
							this.fireCompanionHealGiven(sc1);
						}

						else {
							this.fireCompanionHealRecevied(sc1);
						}
					}//
				} else if (type.contains("DAMAGE")) {
					sc1.type = SwtorEventType.DAMAGE;
					// TODO Fire Event
					if (sc1.isPlayer) {
						/*
						 * Is the player
						 */
						if (sc1.isGiving) {
							this.fireDamageGiven(sc1);
						}

						else {
							this.fireDamageRecvied(sc1);
						}

					} else {
						/*
						 * Not Player Might be companion
						 */
						if (sc1.isGiving) {
							this.fireCompanionDamageGiven(sc1);
						}

						else {
							this.fireCompanionDamageRecvied(sc1);

						}
					}//
				} else if (type.contains("Threat")) {
					sc1.type = SwtorEventType.THREAT;
					// TODO Fire Event
					if (sc1.isPlayer)
						this.fireThreat(sc1);
					else
						this.fireCompanionThreat(sc1);
				} else if (type.contains("DEATH")) {
					sc1.type = SwtorEventType.DEATH;
					// TODO Fire Event
					if (sc1.isPlayer)
						this.fireDeath(sc1);
					else
						this.fireCompanionDeath(sc1);
				}
			}

		} else
			System.out.println("bad 5:(");
		
		
	}

	public static void main(String[] args) {

		String test = "[23:00:17.885] [@Försäkën:Treek {3275183146139648}] [@Försäkën:Treek {3275183146139648}] [Fektur Dart {3279138811019264}] [ApplyEffect {836045448945477}: Heal {836045448945500}] (87) <11>";
		SwtorParser p = new SwtorParser();
		p.addSwtorParserListener(new SwtorParserListener() {

			@Override
			public void healGiven(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void healRecevied(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void damageGiven(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void damageRecvied(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void threat(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void death(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void companionHealGiven(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void companionHealRecevied(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void companionDamageGiven(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void companionDamageRecvied(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void companionThreat(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void companionDeath(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub

			}

			@Override
			public void combatStarted(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void combatEnded(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void combatPaused(SwtorParserEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getEventType() + "Fired");
			}

			@Override
			public void update() {
				// TODO Auto-generated method stub

			}
		});
		p.parse(test);
		test = "[23:00:17.885] [@Försäkën:Treek {3275183146139648}] [@Försäkën:Treek {3275183146139648}] [Fektur Dart {3279138811019264}] [ApplyEffect {836045448945477}: Heal {836045448945500}] (87) ";

		p.parse(test);
		test = "[21:43:11.380] [@Freefall:Ashara Zavros {483596137660416}] [@Freefall:Ashara Zavros {483596137660416}] [Simplifaction {2531196026224640}] [ApplyEffect {836045448945477}: Hunter's Boon {2531196026224912}] ()";
		p.parse(test);
		test = "[21:43:20.067] [@Freefall] [@Freefall] [] [Spend {836045448945473}: Force {836045448938502}] (91)";
		p.parse(test);
	}

	private void _(String s) {
		System.out.println(s);
	}

	/**
	 * State Change: Helper Class to hold value of a line of parse
	 * 
	 * @author Brandon Bluemner
	 * 
	 */
	public class StateChange {
		protected int threat=0;
		protected int value=0;
		protected SwtorEventType type=SwtorEventType.UNKNOWN;
		protected boolean isPlayer =false, isGiving=false,isCompanion=false;
		protected byte state=-1;
		protected String ability="";

		/**
		 * Creates an instance of State Change
		 */
		public StateChange() {
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * @return the type
		 */
		public SwtorEventType getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(SwtorEventType type) {
			this.type = type;
		}

		/**
		 * @return the isPlayer
		 */
		public boolean isPlayer() {
			return isPlayer;
		}

		/**
		 * @param isPlayer
		 *            the isPlayer to set
		 */
		public void setPlayer(boolean isPlayer) {
			this.isPlayer = isPlayer;
		}

		/**
		 * @return the isGiving
		 */
		public boolean isGiving() {
			return isGiving;
		}

		/**
		 * @param isGiving
		 *            the isGiving to set
		 */
		public void setGiving(boolean isGiving) {
			this.isGiving = isGiving;
		}

		public byte getState() {

			return state;
		}

		public String getAbility() {
			return ability;
		}

		public boolean isCompanion() {

			return isCompanion;
		}

		public int getThreat() {
			return threat;
		}

		public void setThreat(int threat) {
			this.threat = threat;
		}

		public void setCompanion(boolean isCompanion) {
			this.isCompanion = isCompanion;
		}

		public void setState(byte state) {
			this.state = state;
		}

		public void setAbility(String ability) {
			this.ability = ability;
		}
		

	}

}
