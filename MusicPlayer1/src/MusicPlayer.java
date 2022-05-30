import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class MusicPlayer {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Songs songs=new Songs();
		PlayList playList=new PlayList();
		char answer;
		
		int choiceList=0;

		do {
			int back=0;
			DisplayMenu();
		
		Scanner scanner=new Scanner(System.in);
		
	
		int choice=Integer.parseInt(scanner.nextLine());
		switch(choice){
		case 1:
			    songs.DisplaySongs();
			    songs.PlaySong();
			    
				break;
		case 2:
			
				
			playList.DisplaySongs();
			System.out.println("[1]Remove Songs from Play List");
			System.out.println("[2]Play Playlist");
			
			  choiceList=Integer.parseInt(scanner.nextLine());
		      
			
			if(choiceList==1) {
				
				System.out.print("Enter id of song you want to remove:");
				int number=Integer.parseInt(scanner.next());
				playList.removePlayList(number);
				
			}
			if(choiceList==2) {
				
				playList.playSongs();
			}
			
				
				break;
				
		case 3:
			  
			
			System.out.println("[1]add");
			System.out.println("[2]remove");
			int addOrRemove=Integer.parseInt(scanner.nextLine());
			
			switch(addOrRemove) {
			
			case 1:
				System.out.print("input Title of Song: ");
				String title=scanner.nextLine();
				songs.setTitle(title);
				
			
				
				System.out.print("input Artist of Song: ");
				String artist=scanner.nextLine();
				songs.setArtist(artist);
			
				
				System.out.print("input Genre of Song: ");
				String genre=scanner.nextLine();
				songs.setGenre(genre);
				
				System.out.println(songs.getTitle()+songs.getArtist()+songs.getGenre());
				songs.addSongs(songs.title,songs.artist,songs.genre);
				break;
			case 2:
				songs.DisplaySongs();
				System.out.println("Enter song id you want ro delete: ");
				int songId=Integer.parseInt(scanner.nextLine());
				songs.deleteSongs(songId);
				songs.DisplaySongs();
				break;
				
			
			}
			
				
		break;
		case 4:
				System.out.println("You have exited the program. Thank you!");
				break;
				
				
			
		
				
		}
		
		
	
		System.out.print("Back to Main Menu?[y/n]");
		answer=scanner.next().charAt(0);
		
		//scanner.close();
		}while((answer=='y')||(answer=='Y')||(choiceList==3));
		
		
		System.out.println("Thank You! GoodBye");
		
		
		
		

	}
	public static void DisplayMenu() {
		System.out.println("[1]Show List of Songs");
		System.out.println("[2]Show PlayList");
		System.out.println("[3]Add/Remove Songs from Song List");
		System.out.println("[4]Exit");
		System.out.print("Enter no. of choice:");
		
	}
   
	

}

