/**
 * @author      S Kunath <skunath@gmail.comm>
 * @version    	1.0                   
 * @since       2010-03-31
 */

package edu.gmu.linguistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.lang.*;
import java.util.Iterator;

public class Alphabet {
	Map alphabet;
    Map salience;
    Map place;
    Map manner;
    Map back;
    Map height;
    
    // Variables that control certain processing rules
	Double cskip;
	Double csub;
	Double cexp;
	Double cvowel;
	Double epsilon;
	int debug = 0;
	
	public Alphabet(){
		//populate initial settings for weighting factors
		cskip = -10.0;
		csub = 35.0;
		cexp = 45.0;
		cvowel = 10.0;
		epsilon = 0.0;
		
		// Setup place points:
	    place = new HashMap();    // hash table
		place = new TreeMap();        // sorted map
	    
		place.put("bilabial", 1.0);
		place.put("labiodental", 0.95);
		place.put("dental", 0.9);
		place.put("labiovelar", 0.82);
		place.put("alveolar", 0.85);
		place.put("retroflex", 0.8);
		place.put("palato-alveolar", 0.75);
		place.put("palatal", 0.7);
		place.put("velar", 0.6);
		place.put("uvular", 0.5);
		place.put("pharyngeal", 0.3);
		place.put("glottal", 0.1);
		
		// Setup manner points:
	    manner = new HashMap();    // hash table
		manner = new TreeMap();        // sorted map
	    
		manner.put("stop", 1.0);
		manner.put("nasal", 0.95);
		manner.put("affricate", 0.9);
		manner.put("fricative", 0.8);
		manner.put("approximant", 0.6);
		manner.put("tap", 0.55);
		manner.put("trill", 0.5);
		manner.put("hvowel", 0.4);
		manner.put("mvowel", 0.2);
		manner.put("lvowel", 0.0);
		
		
		// Setup alphabet object we will be using...
		alphabet = new HashMap();    // hash table
		alphabet = new TreeMap();        // sorted map
	    
		
		// Create a temporary hash table. This hash table will be used and reused to 
		// input all character/phoneme specific data
	    Map map = new HashMap();    // hash table
	    map = new TreeMap();        // sorted map
	    
	    
	    // Add key/value pairs to the map
		// the initial integer in the hash value indicates what the alphabet member is
		// 1 - vowel
		// 2 - consonant
		// 3 - diacritic
		// ...
		
		//Insert vowels:
	    
	    // i - profile
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "close");
	    map.put("back", "front");
	    map.put("round", 0.0);
	    map.put("long", 0.0);
	    alphabet.put("i", map);
		// y
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "close");
	    map.put("back", "front");
	    map.put("round", 1.0);
	    map.put("long", 0.0);
	    alphabet.put("y", map);
		// e
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "closemid");
	    map.put("back", "front");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("e", map);
		// ø
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "closemid");
	    map.put("back", "front");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ø", map);
	    // ɛ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "front");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɛ", map);
	    // œ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "front");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("œ", map);
	    // œ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","lvowel");
	    map.put("high", "semiopen");
	    map.put("back", "front");
	    map.put("round", 0.0);
	    map.put("long", 0.0);			    
	    alphabet.put("æ", map);
	    // a
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","lvowel");
	    map.put("high", "open");
	    map.put("back", "front");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("a", map);
	    // œ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","lvowel");
	    map.put("high", "open");
	    map.put("back", "front");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɶ", map);
	    // ɪ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "semiclose");
	    map.put("back", "front");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɪ", map);
	    // ʏ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "semiclose");
	    map.put("back", "front");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ʏ", map);
	    // ɨ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "close");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɨ", map);
	    // ʉ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "close");
	    map.put("back", "central");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ʉ", map);
	    // ɘ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "closemid");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɘ", map);
	    // ɵ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "closemid");
	    map.put("back", "central");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɵ", map);
	    // ə
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "mid");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ə", map);
	    // ɚ -- Special Case... rhoticized schwa
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "mid");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    map.put("place", "alveolar");
	    alphabet.put("ɚ", map);
	    
	    // ɜ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɜ", map);
	    // ɝ -- Special case 
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);
	    map.put("place", "alveolar");
	    alphabet.put("ɝ", map);
	    
	    
	    // ɞ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "central");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɞ", map);
	    // ɐ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","lvowel");
	    map.put("high", "semiopen");
	    map.put("back", "central");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɐ", map);
	    // ʊ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "semiclose");
	    map.put("back", "back");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ʊ", map);
	    // ɯ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "close");
	    map.put("back", "back");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɯ", map);
	    // u
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","hvowel");
	    map.put("high", "close");
	    map.put("back", "back");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("u", map);
	    // ɤ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "closemid");
	    map.put("back", "back");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɤ", map);
	    // o
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "closemid");
	    map.put("back", "back");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("o", map);
	    // ʌ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "back");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ʌ", map);
	    // ɔ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","mvowel");
	    map.put("high", "openmid");
	    map.put("back", "back");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɔ", map);
	    // ɑ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","lvowel");
	    map.put("high", "open");
	    map.put("back", "back");
	    map.put("round", 0.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɑ", map);
	    // ɒ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 1);    // Character type...
	    map.put("manner","lvowel");
	    map.put("high", "open");
	    map.put("back", "back");
	    map.put("round", 1.0);
	    map.put("long", 0.0);		
	    alphabet.put("ɒ", map);
	    
	    //Insert consonants
	    
	    // m
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "bilabial");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("m", map);
	    // ɱ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "labiodental");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɱ", map);
	    // n
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("n", map);
	    // ɳ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɳ", map);
	    // ɲ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɲ", map);
	    // ŋ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ŋ", map);
	    // ɴ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","nasal");
	    map.put("place", "uvular");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 1.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɴ", map);
	    // p
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "bilabial");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("p", map);
	    // b
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "bilabial");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("b", map);
	    // t
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("t", map);
	    // d
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("d", map);
	    // ʈ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʈ", map);
	    // ɖ̪
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɖ̪", map);
	    // c
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("c", map);
	    // ɟ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɟ", map);
	    // k
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("k", map);
	    // ɡ̪ɡ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɡ̪", map);
	    alphabet.put("ɡ", map);
	    alphabet.put("g", map);
	    // q
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "uvular");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("q", map);
	    // ɢ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "uvular");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɢ", map);
	    // ʔ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","stop");
	    map.put("place", "glottal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʔ", map);
	    // ɸ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "bilabial");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɸ", map);
	    // β
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "bilabial");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("β", map);
	    // f
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "labiodental");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("f", map);
	    // v
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "labiodental");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("v", map);
	    // θ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "dental");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("θ", map);
	    // ð
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "dental");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ð", map);
	    // s
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("s", map);
	    // z
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("z", map);
	    // ʃ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "palato-alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʃ", map);
	    // ʒ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "palato-alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʒ", map);
	    // ʂ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʂ", map);
	    // ʐ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʐ", map);
	    // ç
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ç", map);
	    // ʝ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʝ", map);
	    // x
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("x", map);
	    // ɣ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɣ", map);
	    // χ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "uvular");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("χ", map);
	    // ʁ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "uvular");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʁ", map);
	    // ħ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "pharyngeal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ħ", map);
	    // ʕ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "pharyngeal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʕ", map);
	    // h
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "glottal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("h", map);
	    // ɦ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "glottal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɦ", map);
	    // ʋ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "labiodental");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʋ", map);
	    // ɹ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɹ", map);
	    // ɻ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɻ", map);
	    // j
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("j", map);
	    // ɰ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɰ", map);
	    // ʙ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","trill");
	    map.put("place", "bilabial");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʙ", map);
	    // r
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","trill");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("r", map);
	    // ʀ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","trill");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʀ", map);
	    // ɾ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","tap");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɾ", map);
	    // ɽ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","tap");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɽ", map);
	    // ɬ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 1.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɬ", map);
	    // ɮ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","fricative");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 1.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɮ", map);
	    // l
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 1.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("l", map);
	    // ɭ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "retroflex");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 1.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 1.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ɭ", map);
	    // ʎ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "palatal");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 1.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʎ", map);
	    // ʟ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "velar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 1.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʟ", map);
	    
	    // w
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","approximant");
	    map.put("place", "labiovelar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 1.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("w", map);
	    
	    // ʧ
	    map = new HashMap(); 
	    map = new TreeMap();
	    map.put("type", 2);    // Character type...
	    map.put("manner","affricate");
	    map.put("place", "alveolar");
	    map.put("syllabic", 0.0);
	    map.put("nasal", 0.0);
	    map.put("retroflex", 0.0);	
	    map.put("voice", 0.0);
	    map.put("lateral", 0.0);
	    map.put("aspirated", 0.0);
	    alphabet.put("ʧ", map);
	    
	    
	    // Combining Character stuff.... now the fun begins
	    
	    // aspiration
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("aspirated", 1.0);
	    alphabet.put("ʰ", map);
	    
	    // long mark
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("long", 1.0);		
	    alphabet.put("ː", map);
	    
	    // half-long mark
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("long", 0.5);		
	    alphabet.put("ˑ", map);
	    
	    // unreleased
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("aspirated", 0.0);
	    alphabet.put("˺", map);
	    alphabet.put("\u031a", map);
	    alphabet.put(" ̚", map);
	    
	    // nasal -- p̃
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("nasal", 1.0);
	    alphabet.put("\u0303", map);

	    // voiceless -- b̥
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("voice", -1.0);
	    alphabet.put("\u0325", map);
	   
	    // voiced -- p̬
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("voice", 1.0);
	    alphabet.put("\u032c", map);
	    
	    // velarized -- tˠ
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("place", "velar");
	    alphabet.put("\u02e0", map);
	    
	    // rhoticized -- ə˞
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("place", "alveolar");
	    alphabet.put("\u02de", map);
	    
	    // labialized -- tʷ
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("place", "bilabial");
	    alphabet.put("ʷ", map);
	    
	    // short -- n̆
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("long", 0.0);
	    alphabet.put("\u0306", map);
	    
	    // dentalized -- d̪
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("place", "dental");
	    alphabet.put("̪", map);
	    
	    // retracted -- s̠
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("̠", map);
	    
	    // raised -- e̝
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("̝", map);
	    
	    // lowered -- i̞
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("\u031e", map);
	    
	    
	    // syllabalized -- θ̩
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("̩", map);
	    
	    // extra short -- ĭ
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("\u0306", map);
	    
	    // advanced -- o̟
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("\u031f", map);
	    
	    // creaky voiced -- ɛ̰
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    alphabet.put("\u0330", map);
	    
	    // palatalized -- ʲ
	    map = new TreeMap();
	    map.put("type", 3);    // Character type...
	    map.put("place", "palatal");
	    alphabet.put("ʲ", map);
	    
	    
	    // Setup salience measures:
	    salience = new HashMap();    // hash table
		salience = new TreeMap();        // sorted map
	    
		salience.put("syllabic", 5.0);
		salience.put("voice", 10.0);
		salience.put("lateral", 10.0);
		salience.put("high", 5.0);
		salience.put("manner", 50.0);
		salience.put("long", 1.0);
		salience.put("place", 40.0);
		salience.put("nasal", 10.0);
		salience.put("aspirated", 5.0);
		salience.put("back", 5.0);
		salience.put("retroflex", 10.0);
		salience.put("round", 5.0);

		// Setup place points:
	    height = new HashMap();    // hash table
		height = new TreeMap();        // sorted map
	    
		height.put("close", 1.0);
		height.put("semiclose", 0.8);
		height.put("closemid", 0.65);
		height.put("mid", 0.5);
		height.put("openmid", 0.35);
		height.put("semiopen", 0.2);
		height.put("open", 1.0);

		// Setup place points:
	    back = new HashMap();    // hash table
		back = new TreeMap();        // sorted map
	    
		back.put("front", 1.0);
		back.put("central", 0.5);
		back.put("back", 0.0);
				
	}
	
	// passing an int as that is what the character code is stored as
	public int sound_type(int test_sound) {
		String temp_sound_storage;
		temp_sound_storage = Character.toString((char) test_sound);
				
		if (alphabet.containsKey(temp_sound_storage)) {
			Map character;
			character = (Map)alphabet.get(temp_sound_storage);
			return (Integer)character.get("type");
		}
		return 3;
	}
	
	// passing an int as that is what the character code is stored as
	public int sound_type(String test_sound) {				
		if (alphabet.containsKey(test_sound)) {
			Map character;
			character = (Map)alphabet.get(test_sound);
			return (Integer)character.get("type");
		}
		return 3;
	}
	
	public boolean sound_exist(String sound) {
		if (alphabet.containsKey(sound)) {
			return true;
		}
		return false;
	}
	
	// this function assumes a multi-part sound. That is a representation that contains diacritics
	public void add_new_sound(String new_sound) {
		String base_sound = Character.toString((char) new_sound.codePointAt(0));
		
		if (debug == 1) {
			System.out.println("new base sound");
			System.out.println(base_sound);
		}
		
		Map new_sound_map = new HashMap((Map)alphabet.get(base_sound));    // hash table
	    
		Map diacritic_map;
		
		if (debug == 1) {
			System.out.println("new sound being added");
			System.out.println(new_sound);
		}
		
		for (int i = 1; i < (new_sound.codePointCount(1, new_sound.length()) + 1); i++) {
			diacritic_map =  (Map)alphabet.get(Character.toString((char) new_sound.codePointAt(i)));

			// test point
			//System.out.println(Character.toString((char) new_sound.codePointAt(i)));
			 // this is the iterator used to loop through the key/value pairs
			Iterator it = diacritic_map.entrySet().iterator();
			
		    while (it.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        if (pairs.getKey() == "type") {
			        continue;
		        }
		        
		        if (new_sound_map.containsKey(pairs.getKey())) {
		        	if (pairs.getValue().getClass().getName() == "java.lang.String"){
		        		new_sound_map.put(pairs.getKey(), pairs.getValue());
		        	}
		        	else {
		        		new_sound_map.put(pairs.getKey(), (Double)pairs.getValue() + (Double)new_sound_map.get(pairs.getKey()));
		        	}
		        }
		        else {
		        	new_sound_map.put(pairs.getKey(), pairs.getValue()); 
		        }
		    }
			
		}
		
		alphabet.put(new_sound, new_sound_map);
				
	}
	
	
	public Double vowel(String check){
		// This function simply checks to see if a particular character/phoneme is a vowel
		// if it is it returns the vowel constant. Otherwise return a 0.
		if (alphabet.containsKey(check)) {
			Map character;
			character = (Map)alphabet.get(check);
			if ((Integer)character.get("type") == 1) {
				return cvowel;
			}
		}
		else {
			add_new_sound(check);
		}
		return 0.0;
	}

	private Double twoVowelCompare(String p, String q) {
		
		if (alphabet.containsKey(p)) {
			add_new_sound(p);
		}
		if (alphabet.containsKey(q)) {
			add_new_sound(q);
		}

		
		//System.out.println("Comparing two vowels...");
		//System.out.println(p + " -- " + q);
		
		// This function will return the total difference of two vowels based on a variety of comparisons
		Double diff;
		diff = 0.0;
		
		Map vowel1;
	    vowel1 = (Map)alphabet.get(p);
	    Map vowel2;
	    vowel2 = (Map)alphabet.get(q);
		
	    // begin computing vowel difference measure
		diff = 0.0;
	    
	   	// roundness comparison
		diff = diff + Math.abs( (Double)vowel1.get("round") - (Double)vowel2.get("round") ) * (Double)salience.get("round");
		//length comparison
		diff = diff + Math.abs((Double)vowel1.get("long") - (Double)vowel2.get("long") ) * (Double)salience.get("long");
		//backness comparison
		diff = diff + Math.abs((Double)back.get((String)vowel1.get("back")) - (Double)back.get((String)vowel2.get("back"))  ) * (Double)salience.get("back");		
	    // height comparison
		diff = diff + Math.abs((Double)height.get((String)vowel1.get("high")) - (Double)height.get((String)vowel2.get("high"))) * (Double)salience.get("high");		
	    // manner comparison
		diff = diff + Math.abs((Double)manner.get((String)vowel1.get("manner")) - (Double)manner.get((String)vowel2.get("manner"))) * (Double)salience.get("manner");		
		
		return diff;
		
	}
	
	private Double twoConsonantCompare(String p, String q) {
		if (alphabet.containsKey(p)) {
			add_new_sound(p);
		}
		if (alphabet.containsKey(q)) {
			add_new_sound(q);
		}
		
		// This function will return the total difference of two vowels based on a variety of comparisons
		Double diff;
		diff = 0.0;
		

		//System.out.println("Comparing two consonants...");
		//System.out.println(p + " -- " + q);

		
		Map consonant1;
		consonant1 = (Map)alphabet.get(p);
	    Map consonant2;
	    consonant2 = (Map)alphabet.get(q);
			    
	    // begin computing vowel difference measure
		diff = 0.0;
		
		// manner comparison
		diff = diff + Math.abs((Double)manner.get((String)consonant1.get("manner")) - (Double)manner.get((String)consonant2.get("manner"))) * (Double)salience.get("manner");		
		// place comparison
		
		
		//System.out.println("Comparing two consonant places...");
		//System.out.println((String)consonant1.get("place") + " -- " + (String)consonant2.get("place"));
		//System.out.println((Double)place.get((String)consonant1.get("place")) + " -- " + (Double)place.get((String)consonant2.get("place")));
		
		
		diff = diff + Math.abs((Double)place.get((String)consonant1.get("place")) - (Double)place.get((String)consonant2.get("place"))) * (Double)salience.get("place");		
		//syllabic comparison
		diff = diff + Math.abs((Double)consonant1.get("syllabic") - (Double)consonant2.get("syllabic") ) * (Double)salience.get("syllabic");
		//nasal comparison
		diff = diff + Math.abs((Double)consonant1.get("nasal") - (Double)consonant2.get("nasal") ) * (Double)salience.get("nasal");
		//retroflex comparison
		diff = diff + Math.abs((Double)consonant1.get("retroflex") - (Double)consonant2.get("retroflex") ) * (Double)salience.get("retroflex");
		//voice comparison
		diff = diff + Math.abs((Double)consonant1.get("voice") - (Double)consonant2.get("voice") ) * (Double)salience.get("voice");
		//lateral comparison
		diff = diff + Math.abs((Double)consonant1.get("lateral") - (Double)consonant2.get("lateral") ) * (Double)salience.get("lateral");
		//aspirated comparison
		diff = diff + Math.abs((Double)consonant1.get("aspirated") - (Double)consonant2.get("aspirated") ) * (Double)salience.get("aspirated");
		    
		return diff;
		
	}
    
	private Double mixedCompare(String p, String q) {
		if (alphabet.containsKey(p)) {
			add_new_sound(p);
		}
		if (alphabet.containsKey(q)) {
			add_new_sound(q);
		}
		
		//System.out.println("Comparing mixed...");
		//System.out.println(p + " -- " + q);
		
		// This function will return the total difference of two vowels based on a variety of comparisons
		Double diff;
		diff = 0.0;
		
		Map vowel;
	    Map consonant;
	    
		if (this.vowel(p) == 0.0) {
			vowel = (Map)alphabet.get(q);
		    consonant = (Map)alphabet.get(p);
		}
		else {
			vowel = (Map)alphabet.get(p);
		    consonant = (Map)alphabet.get(q);
		}
			
	    // begin computing vowel difference measure
		diff = 0.0;
	    
		//syllabic comparison
		//diff = diff + Math.abs((Double)consonant.get("syllabic") - (Double)vowel.get("syllabic") ) * (Double)salience.get("syllabic");
		//nasal comparison
		//diff = diff + Math.abs((Double)consonant.get("nasal") - (Double)vowel.get("nasal") ) * (Double)salience.get("nasal");
		//retroflex comparison
		//diff = diff + Math.abs((Double)consonant.get("retroflex") - (Double)vowel.get("retroflex") ) * (Double)salience.get("retroflex");
		// manner comparison
		diff = diff + Math.abs((Double)manner.get((String)consonant.get("manner")) - (Double)manner.get((String)vowel.get("manner"))) * (Double)salience.get("manner");		
		// place comparison
		diff = diff + Math.abs((Double)place.get((String)consonant.get("place")) - 0.0) * (Double)salience.get("place");		
		//voice comparison
		diff = diff + Math.abs((Double)consonant.get("voice") - 0.0 ) * (Double)salience.get("voice");
		//lateral comparison
		diff = diff + Math.abs((Double)consonant.get("lateral") - 0.0 ) * (Double)salience.get("lateral");
		//aspirated comparison
		diff = diff + Math.abs((Double)consonant.get("aspirated") - 0.0 ) * (Double)salience.get("aspirated");

		
	   	
		return diff;
		
	}
	

	
	public Double totalDiff(String p, String q){
		if (alphabet.containsKey(p)) {
			add_new_sound(p);
		}
		if (alphabet.containsKey(q)) {
			add_new_sound(q);
		}
		
		
		// This function determines the actual difference between two characters/phonemes
		// based on the features it knows of of the character/phoneme.
		
		//
		// Notes:
		// This should probably create an on the fly hash when the class is instantiated to memoize
		// previous diff calculations...It should speed things up.
		//System.out.println("comparing: " + p + " to: " + q);	

		int first_string_vowel = vowel(p).compareTo(0.0);
		int second_string_vowel = vowel(q).compareTo(0.0);
		
		
		//if ((first_string_vowel == 0) && (second_string_vowel == 0)) {
			
		if ((vowel(p).compareTo(0.0) == 0) && (vowel(q).compareTo(0.0) == 0)) {
			// case where both characters/phonemes are consonants

			return this.twoConsonantCompare(p, q);
		}
		else if (vowel(p) != 0.0 && vowel(q) != 0.0) {
		    // case where only vowels are passed
			return this.twoVowelCompare(p, q);
		}
		else {
		    // Mixed case with a vowel and a consonant
			return this.mixedCompare(p, q);
		}
		
	}
	
	public String core_sound(String p){
		return Character.toString((char) p.codePointAt(0));
	}
	
	public HashMap 	sound_map(String sound) {
		return (HashMap)alphabet.get(sound);
	}
	
}
