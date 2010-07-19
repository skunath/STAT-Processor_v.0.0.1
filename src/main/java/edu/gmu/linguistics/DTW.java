package edu.gmu.linguistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Stack;


public class DTW {
	
	// Create the analyzer
	Analyzer diffanalyze;
	String [] sample;
	String [] reference;
	int samplelength;
	int referencelength;
	Double[][] difference;
	transcription trans1, trans2; 	
	
    public DTW(String word1, String word2, Alphabet processalphabet) {
    		diffanalyze = new Analyzer(processalphabet);
		
    		trans1 = new transcription(word1, processalphabet);
    		//trans_alphabet = newtrans.get_alphabet();

    		trans2 = new transcription(word2, processalphabet);

    		
    		// Split signals and move into array storage...
    		sample = word1.split(" ");
    		reference = word2.split(" ");
    		
    		// Get lengths to prep matrices
    		samplelength = trans1.get_size();
    		referencelength = trans2.get_size();
    		// Setup difference matrix
    		// This is actually a similarity matrix but we will perceive the numbers 
    		// as the closer to zero the worse the match is
    		difference = new Double[samplelength + 1][referencelength + 1];
    		for (int i = 0; i < samplelength + 1; i++) {
    			Arrays.fill(difference[i],0.0);
    		}
    		
    		
	}
    

    public ArrayList analyze() {
		// Perform DTW
    	Double temp_cost = 0.0;
    	Double [] temp_cost_array = new Double[3];
    	Double[][] distance = new Double[samplelength][referencelength];
    	int[][] move_matrix = new int[samplelength][referencelength];
    	
    	int wordlength1, wordlength2, wordlengthdiff;
    	ArrayList word1, word2;
    	
    	
		for (int i = 1; i < samplelength + 1; i++) {
			for (int j = 1; j < referencelength + 1; j++){
				temp_cost_array[0] = 0.0;
				temp_cost_array[1] = 0.0;
				temp_cost_array[2] = 0.0;
				
				//temp_cost = diffanalyze.alignment(reference[j-1], sample[i-1]);
				//distance[i-1][j-1] = diffanalyze.alignment(reference[j-1], sample[i-1]);
				word1 = trans1.get_word(i-1);
				word2 = trans2.get_word(j-1);
				
				wordlength1 = word1.size();
				wordlength2 = word2.size();
				wordlengthdiff = Math.abs(wordlength1 - wordlength2);
				
				
				temp_cost = diffanalyze.alignment(word2, word1);
				distance[i-1][j-1] = diffanalyze.alignment(word2, word1);
				/*
				System.out.println(reference[j-1]);
				System.out.println(sample[i-1]);
				System.out.println(temp_cost);
				System.out.println("----------------");
				*/
				
				
				// insert
				temp_cost_array[0] =  difference[i-1][j] + temp_cost;
				//delete
				temp_cost_array[1] = difference[i][j-1] + temp_cost;
				//match
				// We use a weighting factor of 2 here to give a preference for a "match" between words...
				// This is based on the fact that since we are not really giving a distance measure but a closeness measure...
				temp_cost_array[2] = (3 - wordlengthdiff) * 2.5 * difference[i-1][j-1] + temp_cost;
				
				System.out.println("--=-===-==-=-=-=-");
				System.out.println(temp_cost_array[0].toString() + " - " + temp_cost_array[1] + " - " + temp_cost_array[2]);
				System.out.println("--=-===-==-=-=-=-");
				
				
				//Arrays.sort(temp_cost_array);
				Double temp_max_cost = temp_cost_array[2];
				int max_location = 2;
				for (int search = 0; search < temp_cost_array.length; search++) {
					if (temp_cost_array[search] > temp_max_cost) {
						temp_max_cost = temp_cost_array[search];
						max_location = search;
					}
				}
				
				move_matrix[i-1][j-1] = max_location;
				difference[i][j] = temp_max_cost;
			}
		}
		
		String temp;
		for (int i = 0; i < samplelength + 1; i++) {
			temp = "";
			for (int j = 0; j < referencelength + 1; j++){
				temp = temp + "   " + difference[i][j];
			}
			//System.out.println(temp);
			
		}

		
		System.out.println("==================");
		
		temp = "";
		for (int i = samplelength -1; i >=  0; i--) {
			temp = "";
			for (int j = 0; j < referencelength; j++){
				temp = temp + "   " + distance[i][j].toString().substring(0, 3);
			}
			System.out.println(temp);
			
		}
	
		
		
		System.out.println("==================");
		temp = "";
		for (int i = samplelength -1; i >=  0; i--) {
			temp = "";
			for (int j = 0; j < referencelength; j++){
				temp = temp + "   " + move_matrix[i][j];
			}
			System.out.println(temp);
			
		}
		
		int moves;
		
		moves = samplelength;
		if (samplelength < referencelength) {
			moves = referencelength;
		}
		
		System.out.println(moves);
		
		int moveleft, movedown;
		moveleft = 0;
		movedown = 0;
		int startx, starty;
		starty = referencelength - 1;
		startx = samplelength - 1 ;
		
		ArrayList movelist = new ArrayList();
		int [] matchpoints;
		

		while (moves > 0) {
			if (move_matrix[startx][starty] == 2) {
				System.out.println("match");
				matchpoints = new int[2];
				matchpoints[0] = startx;
				matchpoints[1] = starty;
				movelist.add(0, matchpoints);
				
				startx -= 1;
				starty -= 1;
			}
			else if (move_matrix[startx][starty] == 1) {
				System.out.println("skip down");
				starty -= 1;
			}
			else if (move_matrix[startx][starty] == 0) {
				System.out.println("skip left");
				startx -= 1;
			}
			
			moves -= 1;
		}
		
		
		int prevtrans1, prevtrans2;
		prevtrans1 = 0;
		prevtrans2 = 0;
		
		int [] fmatchpoints;
		fmatchpoints = (int[])movelist.get(1);

		ArrayList finalmatch = new ArrayList();
		
		for (int i=0; i < movelist.size(); i++) {
			matchpoints = (int[])movelist.get(i);
			ArrayList row = new ArrayList();			
			ArrayList left = new ArrayList();
			ArrayList right = new ArrayList();
			row.add(left);
			row.add(right);
			
			left.add(matchpoints[0]);
			right.add(matchpoints[1]);

			/*
			 * 
			 * this is for matching and running things
			if ((matchpoints[1] - 2) == prevtrans2) {
				//System.out.println(trans1.get_word(matchpoints[0]) + " -- " + trans2.get_word(matchpoints[1] - 1) + " " + trans2.get_word(matchpoints[1]));
				((ArrayList) ((ArrayList) finalmatch.get(i-1)).get(1)).add(matchpoints[1] - 1);
			} 	else if ((matchpoints[0] - 2) == prevtrans1) {
				//System.out.println( trans1.get_word(matchpoints[0]-1) + " " + trans1.get_word(matchpoints[0]) + " -- " + trans2.get_word(matchpoints[1]));
				((ArrayList) ((ArrayList) finalmatch.get(i-1)).get(0)).add(matchpoints[0] - 1);
			} 
			 */
			
			
			/* else  {
				System.out.println(trans1.get_word(matchpoints[0]) + " -- " + trans2.get_word(matchpoints[1]));
			} */
			finalmatch.add(row);
			prevtrans1 = matchpoints[0];
			prevtrans2 = matchpoints[1];
		}
		/*
		int temp_index;
		String templine;
		for (int i=0; i < finalmatch.size();i++) {
			templine = "";
			ArrayList row = (ArrayList) finalmatch.get(i);
			ArrayList left = (ArrayList) row.get(0);
			ArrayList right = (ArrayList) row.get(1);
			for (int j=0; j < left.size(); j++) {
				//System.out.println(left.get(j));
				temp_index = ((Number) left.get(j)).intValue();
				templine +=  trans1.get_word( temp_index) + " ";
			}
			templine += " -- ";
			for (int j=0; j < right.size(); j++) {
				//System.out.println(left.get(j));
				temp_index = ((Number) right.get(j)).intValue();
				templine +=  trans2.get_word( temp_index) + " ";
			}
			System.out.println(templine);
			
		}
		
		*/
		return finalmatch;
}

    
    
    
    public void analyze2() {
    		// Perform raw difference analysis
    		for (int i = 0; i < samplelength; i++) {
    			for (int j = 0; j < referencelength; j++){
    				difference[i][j] = diffanalyze.alignment(reference[j], sample[i]);
    			}
    		}
    		
    		String temp;
    		for (int i = 0; i < samplelength; i++) {
    			temp = "";
    			for (int j = 0; j < referencelength; j++){
    				temp = temp + "   " + difference[i][j];
    			}
    			System.out.println(temp);
    			
    		}
    		
    		
    }
	
}
