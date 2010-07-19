package edu.gmu.linguistics;
import java.io.*;
import java.util.*;
import java.text.*;
//import java.text.normalizer;
//import com.ibm.icu.text.Normalizer;
//import com.ibm.icu.text.UCharacterIterator;



//import java.text.Normalizer;

//import java.io.IOException;

public class phono {
	
	public phono(){
	}
	
	
	
	
	public static void main(String args[]) {
		String finalproduct;
		finalproduct = "";
		String ref, sample;
		String tester = "pʰl̥iiːz kʰɑlˠ stɛlə æskɚ ɾə bɹɪ̃ŋ ðiːz θɪ̃ŋz wɪθɚ fɹʌ̃m ðə stɔɹ sɪks spũunz əv fɹɛʃ snoʊ pʰiiːz faɪːv θɪk sl̥æːbz əv bluː ʧiiːz æn meɪbi ə snæk˺ fɚ hɚ bɹʌðɚ bɑːb wii ɑlˠso niiː̃ɾə smɑlˠ pʰl̥æstɪk˺ sneɪk æ̃nə bɪːɡ tʰɔɪ fɹ̥ɑːɡ fɚ ðə kʰɪːdz ʃii kə̃n skʷuup˺ ðiiːz θɪŋ̃z ɪ̃ntə θɹ̥ii ɹɛːd˺ bæːɡz æ̃ːn wii wɪlˠ ɡoʊ miit hɚ wɛ̃nzdeɪ æt˺ ðə tʰɹ̥eɪ̃n steɪʃə̃n";
		
		String mandarin14 = "pliz̥ kɑː stɛlə ask hə˞ tŭ bɹɪ̃ŋ ðis sɪ̃ŋs wɪs̪ χə˞ fɾɔ̃m ðə stɔɹ sɪks spũːnz əf fɹɛʃ sno p̬iːz̥ fa̝ɪv̥ θɪk˺ sə̆læbz̥ ə bɾu tʃiːz ãnd mebi ə snæːk fɔɹ χə˞ bɹʌðə˞ bɑːb wi ɑlˠsŏ niːd ə smɑlˠ plæstɪk sneɪk an ə b̥ik tʰɔɪ fɹaɡ̥̚ fɔ̆ ðə kʰɪts ʃi kʰæ̃n̆ sːkuːf ðis sɪ̃ŋz ɪ̃ntʰu θɾi ɹɛd˺ bæ̝ɡz̥ æ̝̃n wiəlˠ ɡoʊ miːt χə˞ wɛ̃nzdeɪ æ̝t t̪ə tɹẽɪːn steɪʃə̃n";
		String mandarin2 = "plis kʰɑl stɛlʌ ask hɚ tʰuː bɹiŋ d̪i θiŋs wɪs̪ hɝ fɹɑm d̪ə stɔɹ siks spunz̥ ɔf fɹɛːʃ snoʊ pʰĩnz̥ faɪf θik sːlæbəz̥ ɔf blŭ ʧis æ̆nə meɪbi ə snæk foɹ hɝ bɹʌðə bɔb̥ wi ɔ̆lso nid̥ ə smɑl plæstɪk snek ænːd ʌ bik tʰɔɪ fɹɑɡ̥ foɹ hɛ˞ foɹ ðə kits ʃi kʰɛn s̩ kʰupʰ d̪iz̥ θiŋs intʰu θɹi ɹɛt bæɡ̥s ændə wɪɹ ɡo mit hɝ wɛnzdeɪ æt˺ ðɚ tɹeɪ̃n steɪʃən";
		String mandarin9 = "pʰliz̥ kɑˑl stɛlə æs xɜ tŭ bɹɪ̃ŋ ziːs sɪ̃ŋz̥ wɪθ hɜ fɹʌ̃m zə stɔʷ sɪks spũːns əfə fɹɛ̃n fɹɛʃə snoʊ pĩːs faɪ sɪ̃ŋkt snæːbz̥ əft̆˺ bɾ̆u tʃiːz ɛndə meɪbi ə snæk˺ fɔ̰̆ hɜ bɹʌzə bɑp wi ɑlso niːd ə smɑʷ pl̥æstɪx snæk˺ andə ə biɡ tɔɪ fɹɑɡ˺ fɔ ðə kiz̥ ʃi kɛ̃n skuːp zis sɪ̃ŋs ɪ̃ntu sɹi ɹɛd˺ bæɡz̥ ɛ̃nə wi wɪl̥ ɡoʊ mit hɛ wɛ̃sdeɪ ætə zə tʃɹæ̃ŋ steɪʃn̩";
		String mandarin8 = "pʰɾis kɔː stɛ̃nːə ask hɜ tʊ bɹɪ̃n̠ dɪs sɪ̃ns wɪs xɤ fɹõm n̆ə stɔː siks spũ̞ns ɔf fɹɛʃ sno pis faf θɪ̃ŋ slæb̥s ɔf blu ʧiːs ə̃nə meɪbi a snæk fɔ̆ ɾɚ bɹod̪ə bob vi vɔlso niːd ə smol plastix sneɪk æ̃n ə bik˺ tʰɔɪ fɹɔk fɔ ɾə kɪ̞d̥s ʃi kæn skup dis̪ θĩn̪s ɪ̃ntʊ θɹiː ɹed̥˺ bæks ə̃n wi wa ɡo mit hɛ wẽnsdĕɪ a də tr̥ĭn steɪʃə̃n";
		String mandarin1 = "pliːz kol stɛːlə ăsk hɜɹ tu bɹĩŋ ði θĩŋs wɪs̪ hɜɹ fɹɔ̃m ðə stɔɹ siks spũns ʔəf fɹɛʃ sno pis faɪf θik slæps əf blo ʧis ãnt meɪbi ʔə snek fɔɹ hɜɹ bɹɑðə̆ bɔb̥ wɪ̆ ɑ̆so nid ʔə smɔ plæstik snek ãnt ʔə bik tɔɹ fɹɔk fɹɔ̃m ðə keːz̥ ʃi kãn skop ði θiŋs ɪ̃ntu θɹi ɹɛt bæks æ̆nt wi wiw ɡo miːt hɜɹ wɛ̃sde æt ðə tɹĩ steʃən";
		
		String russian4 = "plis kol sːt̪ɛlːa ask xʲɛr tʊ brinːə ðizə finksə wiːf xʲɛr from̪ v̪ɛ stɔr siks spunsə ɔfə frɛʃ snoʊ pisːə ɔ̆faɪf ʌ faɪf θikʰ ʌː sleɪbə ɔf blui ʧiz̥ə̆ ɛ̝ntə̆ mebi ə snɛk fɔr xʲɛr bravɛr bɔb̥ wi ɑlsɔ nʲitə̆ e̞ smɔlːə̆ plastʲik ə snɛkʰ ɛnd e bik tɔɪ frʷɔʔ tɔɪ frɔɡə̆ for ðɛ kid̥s ə ʃiː kɛnʌ ʌsː skump˺ sːkup aɪ dɔ̃t noʊ ʌ ðiz̥ finks ɪntɔː θri rɛd bɛɡ̥s ɛnd̥ wi wil ɡoː mit xʲɛr venz̥dei æ̝tə ðɛ treɪn steɪʃən";
		String russian1 = "plˠis kɔlˠ stɛlʌ æsk hʲɪɹ tu bɹɪ̃ŋk zis θɪŋs wɪθ hʲɪɹ fɹʌm ðɛ stɔɹ sɪks spuns of fɹɛʃ sno pis faɪf θʲik sleps ov blu ʧis and mebi ə snek fɔɹ hʲɪɹ brʌðəɹ bop ʋi ɛlˠso nit ə smɔl plæstɪk snek ænd bik tɔɪ fɔ̆ɹ fɹɔk fɔɹ zə kits ʃi kæn skup˺ z̪is s̪iŋks ɪntu θri ɹɛt bæks ænd ʋi ʋɪlˠ ɡo mit hʲɪɹ wɛnde æt zə tɹen steʃən";
		String russian14 = "plis kɔlˠ stʲɛlə ask xʲɛ tŭ bɹɪ̃n d̪is θɪ̃ŋs fɹʌm xʲɛ ʔ vɪθ xʲɛ fɹʌm d̪ə stɔɹ sɪks spũs əf fɹɛʃ snaʊ ʃ̩ ʔɜ snaʊ pis faɪv̥ θɪk slæb̥s ŏv blu tʃiːz ɛ̃nd̥ meɪbi ə snæk fɔ xʲɛ bɹʌðə bob vi ɔːlso nʲid ə smolˠ plæ̝stɪk snek æ̃nd ə biɡ˺ tɔɪ fɹoɡ fo˞ ðə kid̥s ʃi kɛ̃n skup ði θɪ̃ŋs ɪ̃ntŭ θɹiː ɹɛd̥˺ baɡ̥s æ̃nd vi vɪlˠ ɡo mʲit xʲɛ wɛ̃nzde ɛt d̪ə tɹen steɪʃən";
		String russian2 = "blis kɔl stɛləɹ̆ ask hʲeɹ tŭ bɹɪŋ ðɪs θĩŋz̥ wɪθ hʲɪɹ fɹɔm ðʌ stoɹ sɪks spuːns ɔf fɹɛʃ s̬no piɹs faɪf θik slæps ɑv̥ blu ʧiiz ænd meɪbi ʌ s̬næːk fɔɹ hʲɪɹ bɹaðə bap wʊ̆ ɔlsə nid ə s̬mɔl plæstɪk s̬neɪːk ænd ə bik tɔɪ fɹaːk fɔɹ ðə kits ʃɪ kɪn skuːp˺ ðəs̪̆ θɪnk̥s intə θɹi ɹɛd bæɡ̟z̥ ænd̥ wə wɪlˠ ɡo mit hʲɪɹ wɛnzdeɪ æ̝t ðə tɹeɪn steɪʃən";
		String russian12 = "pɛlis kɔlʲ stʰilə as xʲɜ tu brɪ̃ŋ dɪs sɪ̃ŋs vɪt hʲɜ frʌ̃n dɪ stɔ sɪxs sɸũs ʌf fɪrɛʃ snoʊ piz faɪf θik slɛɸs ɔv βəlu tʃiz æ̃n mebi ɛ snɛk fɔ hə brɑðɛ bɒps no bɒb˺ vi ɛlso nʲid˺ ɛ smɔl pʰlastɪk sneɪːk æ̃nd bik tɔɪ fɹɔɡ̥ fɔ ðə kɪd̥s ʃi kæ̃n skoːp d̪ɛs sɪ̃ŋks ɪ̃ntu θri rɛd˺ bæks æ̃n vi vɪl bəɡoʊ mʲit hʲɜ vɛ̃nzdeɪ ɛd˺ də treɪ̃n steɪʃn̩";
		
		String arabic1 = "bəliːz kʰɔl stelə æsk her tu brɪ̃ŋ ðɪs θɪ̃ŋz wɪθ her frɑ̃m ðə stɔr sɪks spũn ʌf frɛʃ sno bis faɪf θɪks əslɪp ʌf blu ʧʰis ʌnd mebi ə snek fɔr her brʌðer bɑp˺ wi ɔlso nid ə smɔl blæstɪk snek ɛnd ə bɪk tɔɪ frɔɡ fɔr ðʌ kʰɪts ʃi kæn skup ðɪs θɪŋs ɪntu θri rɛt bæks ɛnd wi wɪl ɡo mit her wɛnɪzde ɛt ðə tren steʃən";
		String arabic20 = "pliz̥ kɔl stɛlɑ æsk hɚ tŭ brɪ̃ŋ d̪is θɪ̃ŋz̥ wɪθ hər fɹʌ̃m d̪ə stɔr sɪks spũns ɔf frɛʃ sno pis faɪv̥ θɪk slæb̥s ɔ̆f blu tʃiz æ̃n mebi ə snæk ɔ̆f hɚ brʌðɚ bɔp wi ɔlso nid ə smɔl plæstɪk sneɪk æ̃nd ə bɪɡ̥ tɔɪ frɔɡ̥ fɔr d̪ə kɪd̥s ʃi kæ̃n skub d̪iz̥ θɪ̃ŋz̥ ɪ̃ntu θri rɛd˺ bæɡ̥z̥ æ̃nd wil ɡo mit hər wɛ̃nz̥d̥e æt̪ d̪ə trẽɪn steɪʃə̃n";
		String arabic29 = "əblis kɑl stɛlə æsk ɛr tu bɹɪ̃ŋ ɛː ðis θɪ̃ŋs wɪθ hɛr frɔ̃mː ðɜ stɔ˞ sɪks ɪspũːns ɔf əfrɛʃ snoʊz piz̥ faɪv θɪks ɪslæps ɔɹ ɔf əbluː tʃis and meɪbiː ɛ snæks fɔ˞ əː hɛr brʌðə bop wi ɔlso nid ə smɔl plæstɪk snɛks ãnd ɛ bɪk tɔɪ frɔɡ̥ fɔr ə ðɛʔ kɪd̥s ʃi kãn skɔp ðis θɪ̃ŋs ɪ̃ntu θɾiː ɪ̃ntu ðɾi ɹɪd̥s bæ̝ɡ̥z̥ ãnd̥ wi wɪl ɡoʊ mit hɛr wɛ̃nɪzdeɪ æ̞t ðə treɪ̃n steɪʃə̃n";
		String arabic9 = "pliːz kɔl stɛla æsk hɝ tu brɪŋ d̪is θɪŋs wɪθ hɛr frʌm də stor sɪks spu̞ns ʌf frɛʃ sno p̬iːz faɪv θɪk slæb̥s ʌf blu ʧʰɪːz ænd meɪbi ə snæk for hɛr brʌðɛr bɔb wi ɔlso niːd e smɔl plæstɪk sneɪ̃kʰ æ̃nd e bɪk tɔɪ frɔɡ̥ for ðə kɪd̥s ʃɪ kæ̃n skup ðiz̥ θɪŋz ɪntu θri rɛd bæɡ̥s ænd wi wɪl ɡo mit hɛr wẽnsdeɪ æt d̪ə treɪ̃n steɪʃən";
		String arabic6 = "pʰliːz kʰɑlˠ stɛlʌ ɑsk hɛr tu bɹɪŋ ðɪs θɪŋz̥ wɪθ hɛr fɹʌm ðə stŏɹ sɪks spʊnz əf fɹɛʃ sno b̥iz faɪf θɪk slæbz̥ ʌv̥ blu ʧiz̥ æn meɪbi ə snek fŏɹ hɛr bɹʌðəɹ bɔ̆b wi ɔlso nid ə smɔl plæsɪk sneɪk ænd ə bɪɡ̥ tʰɔɪ fɹɔɡ foɹ ðə kidz̥ ʃi kæːn skʊp˺ ðɪs ʔɜ d̪is θɪŋz̥ ɪntu θri ɹɛd˺ b̩ bæ̆ɡz̥ ænd wi wɪl ɡo mit hɛr wɪʔʌ wɛnzdeɪ æ ðə tʰɹen steʃən";

		// reversed this order for a second...
		sample = tester;
		ref = arabic6;
		Alphabet trans_alphabet = new Alphabet();
		transcription newtrans = new transcription(sample, trans_alphabet);
		trans_alphabet = newtrans.get_alphabet();

		System.out.println("-----------");
		System.out.println(ref);
		System.out.println(sample);
		System.out.println("-----------");
		
		
		transcription newtrans2 = new transcription(ref, trans_alphabet);
		trans_alphabet = newtrans2.get_alphabet();
		
		Analyzer test1 = new Analyzer(trans_alphabet);
		
		/* temp delete...*/
		
		test1.alignment(newtrans.get_word(0), newtrans2.get_word(0));
		DTW test5 = new DTW(sample, ref, trans_alphabet);// ask he ta bi e hiz zins");
		ArrayList prepoutput = test5.analyze();
		
		int temp_index;
		String templine;
		
		for (int i=0; i < prepoutput.size();i++) {
			templine = "";
			ArrayList row = (ArrayList) prepoutput.get(i);
			ArrayList left = (ArrayList) row.get(0);
			ArrayList right = (ArrayList) row.get(1);
			for (int j=0; j < left.size(); j++) {
				//System.out.println(left.get(j));
				temp_index = ((Number) left.get(j)).intValue();
				templine +=  temp_index; //newtrans.get_word( temp_index) + " ";
			}
			templine += " -- ";
			for (int j=0; j < right.size(); j++) {
				//System.out.println(left.get(j));
				temp_index = ((Number) right.get(j)).intValue();
				templine +=  temp_index; //newtrans2.get_word( temp_index) + " ";
			}
			finalproduct += templine + "\n";
		}
		
		
		System.out.println("-----------");
		System.out.println("-----------");
		System.out.println("-----------");
		System.out.println("-----------");
		System.out.println("-----------");
		
		String[] matchlist = finalproduct.split("\n");
		for (int i = 0; i < matchlist.length; i++) {
			System.out.println(matchlist[i]);
		}
	
		
		// stuff to do the psp counts...
		Map map = new HashMap();    // hash table
	    map = new TreeMap();        // sorted map
	    
		
		test1.clear_psp_count();
		for (int i = 0; i < matchlist.length; i++) {
			System.out.println("***************");
			String[] tempout = matchlist[i].split("--");
			
			test1.alignment(newtrans.get_word(Integer.parseInt(tempout[0].trim())), newtrans2.get_word(Integer.parseInt(tempout[1].trim())));
			
		}
		/*temp boundary */ 
		
		System.out.println(newtrans2.get_word(4).toString() + " -- " + newtrans.get_word(4).toString());
		test1.alignment(newtrans2.get_word(3), newtrans.get_word(3));
		
		test1.print_psp_count();
		
		//return finalproduct;
		
	}
	
	
	public static void main2(String args[]) {

		//DTW trial1 = new DTW("this is a test","this also is a test");
		//trial1.analyze();
		
		
		Alphabet test2 = new Alphabet();
		String tester = "pʰl̥iiːz kʰɑlˠ stɛlə æskɚ ɾə bɹɪ̃ŋ ðiːz θɪ̃ŋz wɪθɚ fɹʌ̃m ðə stɔɹ sɪks spũunz əv fɹɛʃ snoʊ pʰiiːz faɪːv θɪk sl̥æːbz əv bluː ʧiiːz æn meɪbi ə snæk˺ fɚ hɚ bɹʌðɚ bɑːb wii ɑlˠso niiː̃ɾə smɑlˠ pʰl̥æstɪk˺ sneɪk æ̃nə bɪːɡ tʰɔɪ fɹ̥ɑːɡ fɚ ðə kʰɪːdz ʃii kə̃n skʷuup˺ ðiiːz θɪŋ̃z ɪ̃ntə θɹ̥ii ɹɛːd˺ bæːɡz æ̃ːn wii wɪlˠ ɡoʊ miit hɚ wɛ̃nzdeɪ æt˺ ðə tʰɹ̥eɪ̃n steɪʃə̃n";
		String tester2 = "pliz̥ kɑː stɛlə ask hə˞ tŭ bɹɪ̃ŋ ðis sɪ̃ŋs wɪs̪ χə˞ fɾɔ̃m ðə stɔɹ sɪks spũːnz əf fɹɛʃ sno p̬iːz̥ fa̝ɪv̥ θɪk ̚ sə̆læbz̥ ə bɾu tʃiːz ãnd mebi ə snæːk fɔɹ χə˞ bɹʌðə˞ bɑːb wi ɑlˠsŏ niːd ə smɑlˠ plæstɪk sneɪk an ə b̥ik tʰɔɪ fɹaɡ̥̚ fɔ̆ ðə kʰɪts ʃi kʰæ̃n̆ sːkuːf ðis sɪ̃ŋz ɪ̃ntʰu θɾi ɹɛd˺ bæ̝ɡz̥ æ̝̃n wiəlˠ ɡoʊ miːt χə˞ wɛ̃nzdeɪ æ̝t t̪ə tɹẽɪːn steɪʃə̃n";
		//String tester2 = "plis kaʊ̆l stɛlə ask hə ɾə bɹɪ̃ŋ diz tɪ̃ŋs wɪθ hə fɹɔ̃m ðə stɔɹ sɪks spũns ɔf fɹɛʃ ʃno piz faɪv̥ t̪ɪk slæps ɔf blu tʃiz ɛ̃n meɪbi ə snæk fɔ hə bɹʌðə bɑb̥̚ wi ɑlso nid ə smɑl plastik sneɪk æ̃n ə bɪk ʈɔɪ fɹɔɡ̥ fɔ d̪ə kɪts ʃi kə̃n skup̬ d̪iz t̪ɪ̃ŋs ɪ̃ntŭ t̪ɹi ɹɪd̚ bæːɡ̥s æ̃ wi wɪl ɡo mit hɚ wɛ̃nzdeɪ æt̚ d̪ə tɹeɪ̃n steɪʃə̃n";
		
		//String tester = "pʰl̥iiːz kʰɑlˠ stɛlə to";
		//String tester2 = "pl̥iz kɑlˠ stɛlə e to";
		
		
		Alphabet trans_alphabet = new Alphabet();
		transcription newtrans = new transcription(tester, trans_alphabet);
		trans_alphabet = newtrans.get_alphabet();

		transcription newtrans2 = new transcription(tester2, trans_alphabet);
		trans_alphabet = newtrans2.get_alphabet();
		
		Analyzer test1 = new Analyzer(trans_alphabet);
		
		System.out.println("this is where it begins");
		System.out.println("this is where it begins");
		System.out.println("this is where it begins");
		test1.alignment(newtrans.get_word(0), newtrans2.get_word(0));
		System.out.println("this is where it end");
		System.out.println("this is where it end");
		System.out.println("this is where it end");

		
		
		//DTW test5 = new DTW(tester, tester2, trans_alphabet);// ask he ta bi e hiz zins");
		//test5.analyze();
		
		
		//test1.alignment("pʰl̥iiːz", "pl̥iz");
		//String tester = "pʰlis kɔl stɛːlʌ ɑsk˺ ɜ tə bɹɪ̃ŋ ðiz θɪ̃ŋz̥ wɪf hɜ fɹʌ̃ɱ ðə stɔɹ siks spunz̥ əv̥ fɹɪʃ sn̥oʊ piːs faɪf θɪk slæb̥s əv blu ʧiːz ɛn măɪbi ɜ snæk˺ foɹ̥ hɜ bɹɑɾə̆ ʔə brʌðə bɑp wi ɔlˠsŏ nid ə smɔlˠ plæstɪk sneɪk ɛn ə bɪk tʊi fɹɔɡ̥ fɛ̆ ðə kids̥ ʃi kɛ̆n skøp ðiz θɪ̃ŋs ɪntu fɹi ɹɛd bæɡz̥ ɛn wi wɪl ɡoʊ miːd ɜ̆ wĕnz̥d̥eɪ ɛt d̪ə tɹeɪn steɪʃən";
		//String tester = "sneɪk æ̃ndə bɪk tʰɔɪ fɹɔɡ̥ fɔɹ ðə kʰjɪts ʃi kæ̃n skʰup˺ ðiz θɪ̃ŋks ɪ̃ntu ðri ɹɛd bæɡz æ̃n wi wɪlˠ ";
		String testcodecount = tester;
		
		
		String test_iter;
		int iter_length;
		int i;
		
		iter_length = testcodecount.codePointCount(0, testcodecount.length());
		i = 0;


		// test iterator...
		/*
		 * String test = "β̤sneɪk æ̃ndə tʰɔɪ fɹɔɡ̥";
		 
		String result;
		result = Normalizer.compose(test, true);
		
		
		System.out.println("**^*&^*&^*&^*^&");
		System.out.println(result);
		*/

		
		
		
		//String test = "p̬ is a test";
		//System.out.println(test);
		//System.out.println("p̬ is a test");
		
		
		//String x = "testing";
		//System.out.println(x.substring(3-1,3));
		//System.out.println("this is the next line");
		//System.out.println("e versus e " + test2.totalDiff("e", "e"));	
		//System.out.println("t versus t " + test2.totalDiff("t", "t"));	
		//System.out.println("e versus t " + test2.totalDiff("e", "t"));	
		//System.out.println("t versus e " + test2.totalDiff("t", "e"));	

		//System.out.println("String based analysis...");
		//System.out.println(test1.alignment("sabz", "sabers"));


		//System.out.println("Go DTW");
		//DTW test5 = new DTW("pʰlis kal stela", "pliz kut e kal stem e stela", trans_alphabet);// ask he ta bi e hiz zins");
		//test5.analyze();
		//System.out.println(test1.alignment("pʰlis", "pliz"));
//		System.out.println("...next word...");

		//System.out.println(test1.alignment("test", "test"));
		
		
	}
}
