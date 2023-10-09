package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import reader.ISymptomReader;
import writer.ISymptomWriter;

/**
 * 
 */
public class AnalyticsCounter {

	//Variables
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;	

	//Constructeur
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		super();
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}

	//Méthodes
	/**
	 * @return List<String>
	 */
	public List<String> getSymptoms() { 
		return symptomReader.getSymptoms();
	}


	/**
	 * @param List<String> symptoms
	 * @return Map<String, Integer> symptomCounts
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		// Créez une nouvelle HashMap pour stocker les symptomes et occurrences
		Map<String, Integer> symptomCounts = new HashMap<>();

		// Parcourez la liste des symptômes
		for (String symptom : symptoms) {
			// Vérifiez si le symptôme existe déjà dans la map
			if (symptomCounts.containsKey(symptom)) {
				// S'il existe, récupérez le compteur actuel
				int currentCount = symptomCounts.get(symptom);
				// Incrémente le compteur
				symptomCounts.put(symptom, currentCount + 1);
			} else {
				// S'il n'existe pas, ajoutez-le avec un comptage initial de 1
				symptomCounts.put(symptom,1);
			}
		}


		return symptomCounts;
	}



	/**
	 * @param Map<String, Integer> symptomCounts
	 * @return TreeMap<String, Integer> sortedSymptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomCounts) {
		// Instancier une TreeMap en lui passant la Map non triée en argument
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptomCounts);

		// Le TreeMap triera automatiquement les clés (symptômes) par ordre alphabétique

		return sortedSymptoms;
	}	

	/**
	 * @param Map<String, Integer> symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		symptomWriter.writeSymptoms(symptoms);
	}



}
