import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayList extends Songs {
	String pathPlaylist="Playlist";
	//String pathPlaylist="/Users/roselledeleon/eclipse-workspace/MusicPlayer1/Playlist";
	File playlistFile=new File(pathPlaylist);
	Scanner scanner=new Scanner(System.in);
	public PlayList() {
		
		
		
	}
	
	public void addPlaylist(String id) throws IOException {
		
	
	playlistFile=new File(pathPlaylist);
	
	ArrayList<String> songsCollection=new ArrayList<String>();
	Scanner sc=new Scanner(songFile);
	
	String pResult="";
	
	BufferedReader br=new BufferedReader(new FileReader(path));
	String lineSong=null;
	while((lineSong=br.readLine())!=null) {
		
		if (lineSong.contains(id))
        {
            
           
       
          pResult=lineSong;
          
          try (FileWriter fw = new FileWriter(pathPlaylist,true)) {
			ArrayList<String> playList=new ArrayList<String>();
			  playList.add(pResult);
			  
			  fw.write(pResult+'\n');
		}
          
            
        }
       
	}
	
		
	System.out.println("Song Added to Playlist");
	
	
	
	
	
	
	
	
	
	
	songsCollection.add(title);
	songsCollection.add(artist);
	songsCollection.add(genre);
		
		
	}
	public void removePlayList(int id) throws IOException {
		
		
		File tempFile = new File("/Users/roselledeleon/eclipse-workspace/MusicPlayer1/tempFile");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		BufferedReader reader = new BufferedReader(new FileReader(playlistFile));
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
        tempFile.renameTo(playlistFile);
     
		
		
	}
	@Override
	public void DisplaySongs() throws IOException {
		
		System.out.print(String.format("%25s", "ID"));  
		System.out.print(String.format("%25s", "ARTIST"));
		System.out.print(String.format("%25s", "TITLE")); 
		System.out.print(String.format("%25s", "GENRE")); 
		System.out.println();
		
if(songFile.exists()) {
			
			br=new BufferedReader(new FileReader(pathPlaylist));
			String line=null;
			
			
			
			
			
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
	
	public void playSongs() throws IOException, InterruptedException {
	BufferedReader br=new BufferedReader(new FileReader(pathPlaylist));

	
	

	
	String line=null;
	String token="";
	
	int duration=5;
	int duration1=0;
	
	//System.out.println("iD,Title,Artist,Genre");
	String[]values=null;
	List<String> temps=new ArrayList<String>();
	while((line=br.readLine())!=null) {
		
		values=line.split(",");
	
		
		System.out.println(values[1]+" is playing");
		duration1=duration*1000;
		
		Thread.sleep(duration1);
		System.out.println("song Finished");
		
	}
	
	}
	
	
}
	

	
