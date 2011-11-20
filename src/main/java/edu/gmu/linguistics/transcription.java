/**
 * @author      S Kunath <skunath@gmail.comm>
 * @version    	1.0                   
 * @since       2010-03-31
 */

package edu.gmu.linguistics;

import java.util.ArrayList;

public class transcription {
	// This string will store the source transcription
	String transcription_string;
	
	// This will be the actual split transcription before it is processed by the word class
	ArrayList split_transcription = new ArrayList();
	
	// This will store the results of the word by word processed transcription.
	// So this will make use of the word class to make all the individual words have normalized phonemic units
	ArrayList processed_transcription = new ArrayList();
	
	// need to add a mechanism to map the processed_transcription to the simple split_transcription
	word word_processor;
	
	// make connection to root alphabet
	Alphabet custom_alphabet;
	
	// Constructor which takes a single string transcription
	public transcription (String transcription_string) {
		custom_alphabet = new Alphabet();
		word_processor = new word(custom_alphabet);
		this.prep_transcription(transcription_string);
		
	}

	// Constructor which takes a single string transcription
	public transcription (String transcription_string, Alphabet transcription_alphabet) {
		custom_alphabet = transcription_alphabet;
		word_processor = new word(custom_alphabet);
		this.prep_transcription(transcription_string);
		this.print_aligned_transcriptions();
	}

	public ArrayList get_word(int word_index) {
		return (ArrayList) processed_transcription.get(word_index);
	}
	
	public ArrayList get_list() {
		return (ArrayList) processed_transcription;
	}
	
	public void prep_transcription(String transcription) {
		// Set the string
		transcription_string = transcription;
		
		// Move the string into the split_transcription object
		String[] temp_string = transcription.split(" ");
		for (int i = 0; i < temp_string.length; i++) {
			split_transcription.add(temp_string[i]);
		}
	
		// Do correct word breakup
		for (int i = 0; i < split_transcription.size(); i++) {
			processed_transcription.add(word_processor.process_word((String) split_transcription.get(i)));
		}
		
	}
	
	public int get_size() {
		return split_transcription.size();
	}
	
	public Alphabet get_alphabet() {
		return custom_alphabet;
	}
	
	public void set_alphabet(Alphabet new_alphabet) {
		custom_alphabet = new_alphabet;
	}
	
	public void print_aligned_transcriptions() {
		String temp_output = new String();
		ArrayList processed_word = new ArrayList();
		for (int i = 0; i < split_transcription.size(); i++) {
			temp_output = (String)split_transcription.get(i) + " || ";
			processed_word = (ArrayList)processed_transcription.get(i);
			for (int j = 0; j < processed_word.size(); j++) {
				temp_output = temp_output + (String) processed_word.get(j) + " - ";
			}
			
		}
	}
	
}
