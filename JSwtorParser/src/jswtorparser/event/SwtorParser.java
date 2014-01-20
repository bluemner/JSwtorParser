package jswtorparser.event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class SwtorParser {

	private  boolean isRunning;
	private  String playerName;
	
	
	/**
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * @param isRunning the isRunning to set
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public void parse(String s) {
		/*
		 *[23:00:17.885]
		 *[@Försäkën:Treek {3275183146139648}]
		 *[@Försäkën:Treek {3275183146139648}]
		 *[Fektur Dart {3279138811019264}]
		 *[ApplyEffect {836045448945477}: Heal {836045448945500}]
		 *(87) 
		 *<11>
		 */
		
		stateChange sc1 = new stateChange();
		String reg1= "(\\[.*?\\])",
			   ws="\\s*",
			   reg2="(\\(.*\\))?",
			   reg3="(<[^>]+>)?",
			   line = reg1+ws+
			   		  reg1+ws+
			   		  reg1+ws+
			   		  reg1+ws+
			   		  reg1+ws+
			   		  reg2+ws+
			   		  reg3+ws;
		
		   Pattern p=Pattern.compile(line,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		   Matcher m = p.matcher(s);
		   String [] group = new String[8];
		   if(m.find()){
			   for(int i=0; i<8;++i){
				   group[i]=m.group(i);
			   	_(m.group(i));}
		   }else
			   System.out.println("bad :(");
		   /*
		    * Time stamp - Skip
		    */
		   
		   /*
		    * Source
		    */
		   line="(\\[)" +
		   		"(@)?" +
		   		"([^:]*)" +
		   		"(:)?" +
		   		"([^\\{]*)?" +
		   		"(\\{)?" +
		   		"(\\d+)?" +
		   		"(\\})?" +
		   		"(\\])";
		   _("");
		   p=Pattern.compile(line,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		   m=p.matcher(group[2]);
		   if(m.find()){
			   for(int i=0; i<10;++i){
				   
			//   	_(m.group(i));
		   }
			   if(playerName==null){
				   playerName =m.group(3);
				   sc1.isPlayer=true;
			   }else if(playerName.equals(m.group(3))){
				   sc1.isGiving=true;
				  if(m.group(4).contains(":")){
						  sc1.isPlayer=false;
				   }else 
					   sc1.isPlayer=true;
					  
			   }else{
				   sc1.isGiving=false;
			   }
			   
		   }else
			   System.out.println("bad 2:(");
		   
		  
			  
		   
		   /*
		    * Destination
		    */
			m=p.matcher(group[3]);	
			  if(m.find()){
				   for(int i=0; i<10;++i){
					   
				  //	_("Destinaion:"+m.group(i));
			   }
				 
				  if(playerName.equals(m.group(3))){
					   
					  if(m.group(4).contains(":")){
							  sc1.isPlayer=false;
					   }else 
						   sc1.isPlayer=true;
						  
				   }
				   
			   }else
				   System.out.println("bad 3 :(");
			  
			  /*
			   * Ability
			   */
			  line ="(\\[)" +
			  		"([^\\{]*)?" +
			  		"(\\{)?" +
			  		"(\\d+)?" +
			  		"(\\})?" +
			  		"(\\])";
			  
			  
			   p=Pattern.compile(line,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			   m=p.matcher(group[4]);
			   if(m.find()){
				   for(int i=0; i<7;++i){
					   
				  	_("ability:"+m.group(i));
			   }
			   }else
				   System.out.println("bad 4:(");
			  /*
			   * Type
			   */
			   line ="(\\[)" +
				  		"([^\\{]*)?" +
				  		"(\\{)?" +
				  		"(\\d+)?" +
				  		"(\\})?" +
				  		"(:)?" +
				  		"([^\\{]*)?" +
				  		"(\\d)" +
				  		"(\\])";
				  
				  
				   p=Pattern.compile(line,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				   m=p.matcher(group[5]);
				   if(m.find()){
					   for(int i=0; i<7;++i){
						   
					  	_("ability:"+m.group(i));
				   }
				   }else
					   System.out.println("bad 5:(");
		_("");
	}
	
	
	
	public static void main(String [] args){
		String test="[23:00:17.885] [@Försäkën:Treek {3275183146139648}] [@Försäkën:Treek {3275183146139648}] [Fektur Dart {3279138811019264}] [ApplyEffect {836045448945477}: Heal {836045448945500}] (87) <11>";
		SwtorParser  p = new SwtorParser();
		p.parse(test);
		test="[23:00:17.885] [@Försäkën:Treek {3275183146139648}] [@Försäkën:Treek {3275183146139648}] [Fektur Dart {3279138811019264}] [ApplyEffect {836045448945477}: Heal {836045448945500}] (87) ";
		
		p.parse(test);
		test="[21:43:11.380] [@Freefall:Ashara Zavros {483596137660416}] [@Freefall:Ashara Zavros {483596137660416}] [Simplifaction {2531196026224640}] [ApplyEffect {836045448945477}: Hunter's Boon {2531196026224912}] ()";
		p.parse(test);
		test="[21:43:20.067] [@Freefall] [@Freefall] [] [Spend {836045448945473}: Force {836045448938502}] (91)";
		p.parse(test);
	}
	private void _(String s){
		System.out.println(s);
	}
 public class stateChange{
		protected int value;
		protected SwtorEventType type;
		protected boolean isPlayer, isGiving;
		protected byte state;
		public stateChange(int value, SwtorEventType type, boolean isPlayer,
				boolean isGiving) {
			this.value = value;
			this.type = type;
			this.isPlayer = isPlayer;
			this.isGiving = isGiving;
		}
		public stateChange() {
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}
		/**
		 * @param value the value to set
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
		 * @param type the type to set
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
		 * @param isPlayer the isPlayer to set
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
		 * @param isGiving the isGiving to set
		 */
		public void setGiving(boolean isGiving) {
			this.isGiving = isGiving;
		}
		public byte getState() {
			
			return state;
		}
		
	}
}
