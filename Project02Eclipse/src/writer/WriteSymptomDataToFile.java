package writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 */
public class WriteSymptomDataToFile implements ISymptomWriter{

	/**
	 * @param Map<String, Integer> symptoms
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// TODO Auto-generated method stub
		//On instancie un objet FlieWriter qui va créer le fichier result.out vide
		
		try (FileWriter writer = new FileWriter("result.out")) {
			//On boucle sur la map reçue en argument
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				//On recupere la cle (le symptome) et la valeur(l'occurence)
				String symptomName = entry.getKey();
				int count = entry.getValue();
				//on ecrit la ligne dans le fichier result.out
				writer.write(symptomName + ": " + count + "\n");
			}
			//on ferme le flux
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
