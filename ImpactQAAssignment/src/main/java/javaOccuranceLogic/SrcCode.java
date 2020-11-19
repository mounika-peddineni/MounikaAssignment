package javaOccuranceLogic;

import java.util.Scanner;



public class SrcCode {
	/*
	 * Searching the occurrence by CHARACTER
	 */
	public static int searchByCharacter(String sentence, char car) {
		int count = 0;
		char [] chArray = sentence.toCharArray();
		for (int i = 0; i < chArray.length; i++) {
			if(car==chArray[i])
				count++;
		}
		return count++;
	}
	
	/*
	 * Searching the occurrence by WORD
	 */
	public static int searchByWord(String sentenceByString, String searchIn) {
		int count = 0;
		String str [] = sentenceByString.split(" ");
		for (int i = 0; i < str.length; i++) {
			if(searchIn.equals(str[i]))
				count++;
		}
		return count++;
	}
	
	/*
	 * Search by sentence
	 */
	public static int searchBySentance(String sentenceBySentence, String searchIn) {
		int count = 0;
		
		for (int i = 0; i < sentenceBySentence.length(); i++) {
			if(sentenceBySentence.charAt(i)==searchIn.charAt(0)) {
				boolean found = true;
				
				for(int k = 0; k < searchIn.length(); k++) {
					try {
					if(sentenceBySentence.charAt(i+k)!=searchIn.charAt(k)) {
						found = false;
						break;
					}
					}catch(Exception e) {
						found = false;
					}
				}
				if(found) {
					count++;
					i += searchIn.length()-1;
				}
			}
		}
		return count;
	}
	
	/*
	 * Decision making
	 */
	public static int search(String sentence, String wordOrCharacterOrSentence) {		
		if (wordOrCharacterOrSentence.length()==1) {
			return searchByCharacter(sentence, wordOrCharacterOrSentence.charAt(0));
		}
		else if(wordOrCharacterOrSentence.split(" ").length==1) {
			return searchByWord(sentence, wordOrCharacterOrSentence);
		}
		else
			return searchBySentance(sentence,wordOrCharacterOrSentence);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the sentence");
		String sentence = s.nextLine();
		System.out.println("Enter the String");
		String srch = s.nextLine();
		int occurance = search(sentence.toLowerCase(), srch.toLowerCase());
		if(occurance==0)
			System.out.println("'"+srch+"' not found in a above statement");
		else
			System.out.println("Occurance of '"+srch+"' is = '"+occurance+"' by ignoring case_sensitivity");
	}
}
