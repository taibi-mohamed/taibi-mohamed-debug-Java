package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import reader.ISymptomReader;
import reader.ReadSymptomDataFromFile;
import writer.ISymptomWriter;
import writer.WriteSymptomDataToFile;

public class Main {

	public static void main(String args[]) {

		//Instanciation des variables
		String filepath = "C:\\Users\\Taibi Mohamed\\git\\-taibi-mohamed-debug-Java\\Project02Eclipse\\src\\symptoms.txt";
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(filepath);
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile();	
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

		//Appel des méthodes		
		//1)On recupere les symptomes presents dans le fichier symptoms.txt pour les mettre dans une liste de String
		List<String> symptomsList=analyticsCounter.getSymptoms();

		//2)On comptabilise le nombre d'occurences par symptome
		Map<String, Integer> countSymptoms=analyticsCounter.countSymptoms(symptomsList);

		//3)On trie les symptomes par ordre alphabetique
		Map<String, Integer> sortSymptoms=analyticsCounter.sortSymptoms(countSymptoms);

		//4)On ecrit le resultat dans un fichier result.out
		analyticsCounter.writeSymptoms(sortSymptoms);

	}



}
