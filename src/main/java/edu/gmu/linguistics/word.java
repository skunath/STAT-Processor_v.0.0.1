/**
 * @author      S Kunath <skunath@gmail.comm>
 * @version    	1.0                   
 * @since       2010-03-31
 */

package edu.gmu.linguistics;

import java.util.ArrayList;


// This class will be involved in the processing of actual words.
// The idea is that you will process a string word with this class and you will get an abstract word in return.
// The difference is that the original string will have regular and combining characters without any separation
// this will merge a single regular character with all the diacritics that are to be combined with it
public class word {
	Alphabet alphasource; 
	public word(Alphabet source_alphabet){
		alphasource = new Alphabet();
	}

	
	// This function takes a word and breaks it down to phonemic units
	public ArrayList process_word(String input_word) {
		// array used for return
		ArrayList normalized_word = new ArrayList();
		
		// Temp string to build out the product for the list
		String temp_phoneme = new String();
		int temp_phoneme_type;
		// iterate through a given word
		for (int i = 0; i < input_word.codePointCount(0, input_word.length()); i++) {
			temp_phoneme_type = alphasource.sound_type(input_word.codePointAt(i));
			if (temp_phoneme_type != 3 && temp_phoneme.length() > 0) {
				normalized_word.add(temp_phoneme);
				temp_phoneme = "";
			}

			temp_phoneme = temp_phoneme + Character.toString((char) input_word.codePointAt(i));
			
		}
		if (temp_phoneme.length() > 0) {
			normalized_word.add(temp_phoneme);
		}
		
		temp_phoneme = "";
		for (int i = 0; i < normalized_word.size(); i++) {
			temp_phoneme = (String)normalized_word.get(i);
			//System.out.println("-->" + temp_phoneme);
			if (!alphasource.sound_exist(temp_phoneme)) {
				alphasource.add_new_sound(temp_phoneme);
			}
		}
		
		return normalized_word;
		
	}
	
	
	
}
