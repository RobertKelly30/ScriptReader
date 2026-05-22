import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadScript {
	
	public static void readScript(File filepath) {
		boolean end;
		Scanner sceneScanner;
		Scanner scriptInput = new Scanner(System.in);
		String readString = scriptInput.nextLine();
		int counter = 0;
		
		do{
			try {
				sceneScanner = new Scanner(filepath);
				System.out.println("You have accessed "+filepath.getName());
				System.out.println("If you wish to see the next speaker press: SPACE");
				System.out.println("When you are ready to see the line of the speaker press:ENTER");
				System.out.println("If at anytime you wish to see the next line entirely press: ENTER");
				System.out.println();
				System.out.println("--Scene Begins--");
				
				do{
					System.out.print(sceneScanner.next());
			        if (readString.isEmpty()) {
			        	if(counter < 1) {
			        		System.out.print(sceneScanner.nextLine());
			        		counter++;
			        	}else {
			        		System.out.print(sceneScanner.nextLine());
			        		counter=0;
			        	}
			        }
	
			        if (scriptInput.hasNextLine()) {
			            readString = scriptInput.nextLine();
			        } else {
			            readString = null;
			        }
					
				}while(sceneScanner.hasNextLine()==true);
				
				sceneScanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("Could not find file.");
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("Would you like to go over this scene again? (Y/N)");
			System.out.println();
			String answer = scriptInput.nextLine();
			if(answer.equalsIgnoreCase("Y")) {
				end = false;
				System.out.println("Restarting the Scene.");
			}else {
				end = true;
				System.out.println("Returning to main menu.");
			}
		}while(end != true);
		scriptInput.close();
	}
}
