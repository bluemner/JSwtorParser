package jswtorparser.event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jswtorparser.event.factory.CombatEvent;
import jswtorparser.event.factory.SwtorEventType;

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
 * <b>SwtorParser:</b> Creates an instance that allows you to parse information from
 * @author Brandon Bluemner
 *
 */
public class SwtorParser {

	private boolean isRunning;
	private String playerName;
	private Set<SwtorParserListener> listeners;
	
//	
//	/*
//	 *Fight
//	 */
//	  int DAMAGE_GIVEN;
//	  int DAMAGE_RECIVED;
//	  int HEALS_GIVEN;
//	  int HEALS_RECIVED;
//	  int HEALS_THREAT;
//	  int DAMAGE_THREAT;
//	  int Threat; //Heals + Damage
//	  int COMPANION_DAMAGE_GIVEN;
//	  int COMPANION_DAMAGE_RECIVED;
//	  int COMPANION_HEALS_GIVEN;
//	  int COMPANION_HEALS_RECIVED;
//	  int COMPANION_Threat;
//	
//	/*
//	 * Total 
//	 */
//	  long Total_DAMAGE_GIVEN;
//	  long Total_DAMAGE_RECIVED;
//	  long Total_HEALS_GIVEN;
//	  long Total_HEALS_RECIVED;
//	  long Total_Threat;
//	
	
	
	public SwtorParser() {
		this.listeners= new HashSet<SwtorParserListener>();
	}
	/**
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}




	/**
	 * @param isRunning
	 *            the isRunning to set
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	/**
	 * 
	 * @param s String to parse
	 */
	public void parse(String s) {
		/*
		 * [23:00:17.885]
		 * [@Försäkën:Treek {3275183146139648}]
		 * [@Försäkën:Treek{3275183146139648}]
		 * [Fektur Dart {3279138811019264}]
		 * [ApplyEffect * {836045448945477}: Heal {836045448945500}]
		 * (87)
		 * <11>
		 */

		StateChange sc1 = new StateChange();
		String reg1 = "(\\[.*?\\])", ws = "\\s*", reg2 = "(\\(.*\\))?", reg3 = "(<[^>]+>)?", 
				line = reg1	+ ws+ reg1+ ws+ reg1+ ws+ reg1+ ws+ reg1+ ws+ reg2+ ws + reg3 + ws;

		Pattern p = Pattern.compile(line, Pattern.CASE_INSENSITIVE| Pattern.DOTALL);
		Matcher m = p.matcher(s);
		String[] group = new String[8];
		if (m.find()) {
			for (int i = 0; i < 8; ++i) {
				group[i] = m.group(i);
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
		line = "(\\[)" + "(@)?" + "([^:]*)" + "(:)?" + "([^\\{]*)?" + "(\\{)?"+ "(\\d+)?" + "(\\})?" + "(\\])";
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
				} else
					sc1.isPlayer = true;
		}

		} else
			System.out.println("bad 3 :(");

		/*
		 * 4 Ability
		 */
		line = "(\\[)" + "([^\\{]*)?" + "(\\{)?" + "(\\d+)?" + "(\\})?"+ "(\\])";

		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		m = p.matcher(group[4]);
		if (m.find()) {
			if(m.group(2)!=null && !( m.group(2).isEmpty())){
				sc1.ability=m.group(2);
			}
		} else
			System.out.println("bad 4:(");
		
		
		/*
		 * 5 Type
		 */
		
		
		line = "(\\[)" + "([^\\{]*)?" + "(\\{)?" + "(\\d+)?" + "(\\})?"	+ "(:)?" + "([^\\{]*)?" + "(\\d)" + "(\\])";
		p = Pattern.compile(line, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		m = p.matcher(group[5]);
		if (m.find()) {
			String event =m.group(2);
			String type = m.group(7);
			
			if(event==null || type ==null){
				
			}else{
				type=type.trim();
				type=type.toUpperCase();
				if(type.contains("EnterCombat")){
					sc1.type=SwtorEventType.COMBAT;
					sc1.state=CombatEvent.STARTED;
					
					//TODO Fire Event
					
				}else if(type.contains("ExitCombat")){
					sc1.type=SwtorEventType.COMBAT;
					sc1.state=CombatEvent.STOPED;
				
					//TODO Fire Event
				}
				else if(type.contains("HEALS")){
					sc1.type=SwtorEventType.HEALS;
					//TODO Fire Event
				}
				else if(type.contains("DAMAGE")){
					sc1.type=SwtorEventType.DAMAGE;
					//TODO Fire Event
				}
				else if(type.contains("Threat")){
					sc1.type=SwtorEventType.THREAT;
					//TODO Fire Event
				}else if(type.contains("DEATH")){
					sc1.type=SwtorEventType.DEATH;
					//TODO Fire Event
				}
			}
				
			
		} else
			System.out.println("bad 5:(");
		
		
		
	}

	public static void main(String[] args) {
		String test = "[23:00:17.885] [@Försäkën:Treek {3275183146139648}] [@Försäkën:Treek {3275183146139648}] [Fektur Dart {3279138811019264}] [ApplyEffect {836045448945477}: Heal {836045448945500}] (87) <11>";
		SwtorParser p = new SwtorParser();
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
	 * @author Brandon  Bluemner
	 *
	 */
	public class StateChange {
		protected int value;
		protected SwtorEventType type;
		protected boolean isPlayer, isGiving;
		protected byte state;
		protected String ability;
		
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

	}
	
	
}
