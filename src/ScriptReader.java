import java.util.Scanner;
import java.io.File;

public class ScriptReader {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int selection;
		boolean end;
		
		File folder = new File("Scenes/");
		File[] listOfFiles = folder.listFiles();
		
		do {
			end = false;
			int counter  = 1;
			int totalScenes = 0; 
			System.out.println("AVAILABLE SCENES");
			for (File file : listOfFiles) {
				
			    if (file.isFile()) {
			        System.out.println(counter+". "+file.getName());
			        counter++;
			    }
			    totalScenes++;
			}
			
			System.out.println("Please type in the number of the page you wish to access.");
			do {
				selection = Integer.parseInt(input.nextLine());
				if(selection > totalScenes || selection < 1) {
					System.out.println("That scene is not available.");
					System.out.println("Please type in the number of the scene you wish to access.");
				}
			}while(selection > totalScenes || selection < 1);
			
			ReadScript.readScript(listOfFiles[selection-1]);
			
			
			System.out.println();
			System.out.println("Would you like to go over another scene? (Y/N)");
			System.out.println();
			String answer = input.nextLine();
			if(answer.equalsIgnoreCase("N")) {
				end = true;
			}
			
		}while(!end);
		
		
		input.close();
	}
	
}
