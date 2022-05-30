import java.io.BufferedReader;
import java.io.BufferedWriter;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Songs {
	protected int id;
	protected String title;
	protected String artist;
	protected String genre;
	Scanner scanner=new Scanner(System.in);
	ArrayList<String> songs;
	
	
	String path="Songs";
	
	//String path="/Users/roselledeleon/eclipse-workspace/MusicPlayer1/Songs";
	File songFile=new File(path);
	BufferedReader br;
	
	
	public Songs() {
		this.id=0;
		this.title="";
		this.artist="";
		this.genre="";
		
			
		
	}
	public Songs(int id,String title,String artist,String genre) {
		this.id=id;
		this.title=title;
		this.artist=artist;
		this.genre=genre;
		//this.duration=duration;
		
	}
	
	public String getTitle() {
		
		return title;
		
	}
	
	public String getArtist() {
		
		return artist;
		
	}
	public String getGenre() {
		
		return genre;
		
	}
	
	
	public void setArtist(String artist) {
		
		this.artist=artist;
	}
	
	
	public void setTitle(String title) {
		
		this.title=title;
	}
	public void setGenre(String genre) {
	
	this.genre=genre;
}
	
	public void DisplaySongs() throws FileNotFoundException, IOException {
		
	//	File songFile=new File("/Users/roselledeleon/eclipse-workspace/MusicPlayer1/Songs.txt");
	clearConsole();
		
		
		//List<List<String>>records=new ArrayList<>();
		
		
		if(songFile.exists()) {
			
			br=new BufferedReader(new FileReader(path));
			String line=null;
			
		
			
			System.out.print(String.format("%25s", "ID"));  
			System.out.print(String.format("%25s", "ARTIST"));
			System.out.print(String.format("%25s", "TITLE")); 
			System.out.print(String.format("%25s", "GENRE"));
			System.out.println();
			
			while((line=br.readLine())!=null) {
				
				String[]values=line.split(",");
			
				
				
				for(String field:values) {
				
					 
					System.out.print(String.format("%25s", field));    
				}
				
				System.out.println();
		
			}
		
		
		}else {
			System.out.println("File does not exist");
		
		}
		
		
		
	}
	
	public void addSongs(String title,String artist,String genre) throws IOException {
		
		songs=new ArrayList<String>();
		
		BufferedReader reader=new BufferedReader(new FileReader(path));
		long lines=0;
		
		while(reader.readLine()!=null)
		{
			lines++;
			
			
		}
		//songs.add(String.valueOf(lines+1));
		songs.add(shuffleID());
		songs.add(title);
		songs.add(artist);
		songs.add(genre);
	
		
		String songList=songs.toString();
	
		
		songList=songList.replace("[","").replace("]","");
		System.out.println(songList);
		
		
		
		try {
			
			
			String result="";
		
			
			String line1="";
			while((line1=reader.readLine())!=null){
				result=result+line1;
				
			}
			
			FileWriter fw=new FileWriter(path,true);
			
		
			fw.write(songList+'\n');
			fw.close();
			System.out.println("Successfully added to song List");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	public void deleteSongs(int id) throws IOException {
		File tempFile = new File("/Users/roselledeleon/eclipse-workspace/MusicPlayer1/tempFile");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		BufferedReader reader = new BufferedReader(new FileReader(songFile));
		String currentLine;
		String deleteId=Integer.toString(id);
		
		

        while((currentLine = reader.readLine()) != null) {
          
            String trimmedLine = currentLine.trim();
      
            if(trimmedLine.contains(deleteId)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        System.out.println("Song removed from playlist");
        tempFile.renameTo(songFile);

		
		
	}
	
	public void PlaySong() throws IOException, InterruptedException {
		
		int songId;
		System.out.print("Enter id No of song you want to Play:");
		songId=Integer.parseInt(scanner.next());
		
		br=new BufferedReader(new FileReader(path));
		String line=null;
		String SsongId=Integer.toString(songId);
		
		
		while((line=br.readLine())!=null) {
			if (line.contains(SsongId)) {
				
				
						System.out.println(line);
				
			}
			
			
		}
		
	
		
		System.out.println("Press 1 to stop and 2 add to playlist");
		int addOrPlaylist;
		addOrPlaylist=scanner.nextInt();
		
		
		
		switch(addOrPlaylist) {
		case 1:
			System.out.println("Song Finished Playing");
			
			break;
			
		case 2:PlayList play=new PlayList();
		play.addPlaylist(SsongId);
		
		break;
		
		}
	
		
	}
	
	private String shuffleID() {
		
		String[] letters = { "1", "2", "3", "4", "5", "6","7", "8", "9", "0"};
	     // System.out.println("Initial array = "+Arrays.toString(letters));
	      List<String>list = Arrays.asList(letters);
	      int len = list.size();
	      String shuffle="";
	      //System.out.println("Shuffled array...");
	      for (int i = 0; i < 4; i++) {
	         int index = new Random().nextInt(len);
	         shuffle += list.get(index);
	       // System.out.print(shuffle);
	      }
	      return shuffle;
	
	}
	
	
	private void clearConsole() {
		for (int i = 0; i < 50; ++i) System.out.println();
		
	}
	
	
	

}
