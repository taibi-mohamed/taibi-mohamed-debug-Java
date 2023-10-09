package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 *
	 */
	@Override
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<String>();
		//Si le fichier symptoms.txt est trouvé
		if (filepath != null) {
			try {
				//On instancie un objet BufferedReader afin de lire le contenu du fichier
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				//On recupere la premiere ligne du fichier, donc le premier symptome
				String symptom = reader.readLine();
				//Tant que le fichier contient des lignes de symptome
				while (symptom != null) {
					//On ajout le symptome à la liste de resultat
					result.add(symptom);
					//On recupere le symptome de la ligne suivante
					symptom = reader.readLine();
				}
				//on ferme le flux
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
