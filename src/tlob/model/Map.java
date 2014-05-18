package tlob.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
	
	private int length;
	private int width;
	private String level;
	private String roomLine;
	private String roomColumn;
	private String environment ="/Desert";
	
	//view
	/*
	Image """bigTree""" = Toolkit.getDefaultToolkit().getImage("res/LittleTree");
	Image littleTree = Toolkit.getDefaultToolkit().getImage("res/LittleTree");
	Image bg = Toolkit.getDefaultToolkit().getImage("res/BackgroundForest");
	Image jar = Toolkit.getDefaultToolkit().getImage("res/Jar.png");
	ImageAnimeDirection melee = new ImageAnimeDirection("res/MeleeRun",1);
	Image rocks = Toolkit.getDefaultToolkit().getImage("res/Rocks");
	Image rock = Toolkit.getDefaultToolkit().getImage("res/Rock");
	Image root = Toolkit.getDefaultToolkit().getImage("res/Root");
	*/
	
	
	public Map(int length, int width, String level, String roomLine, String roomColumn)
	{
		this.length = length;
		this.width = width;
		this.level = level;
		this.roomLine = roomLine;
		this.roomColumn = roomColumn;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public String getEnvironment(){
		return environment;
	}
	
	public void setEnvironment(String environment){
		this.environment = environment;
			
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public String getLevel()
	{
	return level;
	}
	
	public void setLevel(String level)
	{
	this.level = level;
	}
	
	public String getRoomLine()
	{
	return roomLine;
	}
	
	public void setRoomLine(String roomLine)
	{
	this.roomLine = roomLine;
	}
	
	public String getRoomColumn()
	{
	return roomColumn;
	}
	
	public void setRoomColumn(String roomColumn)
	{
	this.roomColumn = roomColumn;
	}
	
	public char[][] loadMap(FileInputStream fis)// pas sur qu il faille mettre try catch
	{
		char[][] map = new char[length][width];
		try{
			  byte[] buf = new byte[8];
			  int i = 0;
			  int j = 0;
			  char a = ' ';
			  
			  while (fis.read(buf) >= 0){
				  for (byte bit : buf){
					  a = ((char)bit);
					  	if (bit == 10){
					  		i++;
					  		j =0;
					  	}
					  
					  	else if (a != ' '&& a != '\n')
					  	{
							map[j][i] = a;
					  		j++;
					  	}
				  }	  
			  }
			
		  } catch(IOException e){
			  e.printStackTrace();
		  }finally{
			  try{
				  if(fis != null)
					  fis.close();
			  } catch (IOException e){
				  e.printStackTrace();
			  }
			  
		  }
		return map;		  
	  }
	
public char[][] loadRoom(){
	
	FileInputStream fis = null;
	File f =new File("res/"+level+"-"+roomLine+"-"+roomColumn+"copy.txt");
	char[][] tableau = new char[16][16];
	
	try{
		if (f.exists()){
			fis = new FileInputStream(new File("res/"+level+"-"+roomLine+"-"+roomColumn+"copy.txt"));
			tableau = loadMap(fis);
		}
		else{
			fis = new FileInputStream(new File("res/"+level+"-"+roomLine+"-"+roomColumn+".txt"));
			tableau = loadMap(fis);
			
		}
		
		} catch(FileNotFoundException e){
			e.printStackTrace();
			
		} finally{
			try{
				if(fis != null)
					fis.close();
				
				} catch (IOException e){
					e.printStackTrace();
		} 
	} 
	return tableau;
}

	
public ArrayList<Decor> mapToListDecor(char[][] map) { // changer les nulls
	ArrayList<Decor> decor = new ArrayList<Decor>();
	String obstacles[]={"res" + environment + "/Obstacle1", "res" + environment 
			+ "/Obstacle2","res" + environment + "/Obstacle3","res" + environment + "/Obstacle4"};
		
	for(int i = 0; i < map.length; i++){
		for (int j = 0; j < map[i].length;j++)
			
			switch(map[i][j]){
			case '0':				
				decor.add(new Floor(40*i,40*j,("res" + environment + "/Background")));
				break;
				
			case '1':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Wall(40*i,40*j,"res/Forest/Wall"));
				break;
				
			case '2':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Jar(40*i,40*j,"res/Jar"));
				break;
				
			case '3':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new SpawnerFireBall(40*i,40*j,"res/fireSpawner"));//SpawnerFireBall
				break;
				
			case '4':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new SpawnerMonster(40*i,40*j,"res/monsterSpawner")); //SpawnerMonster
				break;
				
			case '6':
				decor.add(new Hole(40*i,40*j,null)); //Hole
				break;
			
			case '7':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				break;
			
			case '8':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Door(40*i,40*j,"res/2",false,1,0,0)); //DoorUp
				break;
				
			case '-':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Door(40*i,40*j,"res/2",false,0,1,0)); //DoorRight
				break;
		
			case '_':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Door(40*i,40*j,"res/2",false,-1,0,0)); //DoorDown
				break;
			
			case ':':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Door(40*i,40*j,"res/2",false,0,-1,0)); //DoorLeft
				break;
			
			case '9':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				decor.add(new Door(40*i,40*j,"res/2",false,0,0,1)); //Exit
				break;

/*case 'a':
decor.add(new Wall(40*i,40*j,null));
case 'b':
decor.add(new Wall(40*i,40*j,null));
case 'c':
decor.add(new Wall(40*i,40*j,null));*/
			case 'r':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				java.util.Random r=new java.util.Random( ) ; 
				int random = r.nextInt(4);
				String obstacle = obstacles[random];
				decor.add(new Wall(40*i,40*j,obstacle));
				break;
				
			case 'e':
				decor.add(new Wall(40*i,40*j,null)); //Escalier
				break;
				
			case 'b':
				decor.add(new Wall(40*i,40*j,null)); //ChestBombPow
				break;
				
			case 'h':
				decor.add(new Wall(40*i,40*j,null)); //ButteHaut
				break;
				
			case 'j':
				decor.add(new Wall(40*i,40*j,null)); //ButteGauche
				break;
				
			case 'k':
				decor.add(new Wall(40*i,40*j,null)); //ButteDroite
				break;
					
			case 'z':
				decor.add(new Wall(40*i,40*j,null)); //ButteBas
				break;
				
			case 'u':
				decor.add(new Wall(40*i,40*j,null)); //CoinHG
				break;
				
			case 'i':
				decor.add(new Wall(40*i,40*j,null)); //CoinHD
				break;
				
			case 'o':
				decor.add(new Wall(40*i,40*j,null)); //Coin"res/BackgroundForest"
				break;
				
			case 'p':
				decor.add(new Wall(40*i,40*j,null)); //CoinBD
				break;
//case 't':
//decor.add(new Wall(40*i,40*j,null));
			case 'q':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				break;
				
			case 's': 
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				break;
				
			case 'd':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				break;
				
			case 'f':
				decor.add(new Floor(40*i,40*j,"res" + environment + "/Background"));
				break;
				}
		}
	return decor;
}

	public ArrayList<Monster> mapToListMonster(char[][] map) { // changer les nulls
			
		ArrayList<Monster> monster = new ArrayList<Monster>();
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length;j++)
				switch(map[i][j]){
					//case 'l':
						//decor.add(new Link(3,(...)));
					case 'q':
						monster.add(new Ranged(1,40*i,40*j,1,3,"res/Monster/RangedRun")); //Ranged
						break;
					case 's':
						monster.add(new Bomber(2,40*i,40*j,1,3,"res/Monster/BomberRun")); //Bomber
						break;
					case 'd':
						monster.add(new Melee(1,40*i,40*j,1,3,"res/Monster/MeleeRun"));
						break;
					case 'f':
						monster.add(new Underground(1,40*i,40*j,4,3,"res/Monster/hidden")); //Underground
						break;
					case '7':
						monster.add(new MovingTrap(1,40*i,40*j,2,3,"res/Monster/Trap")); //Underground
						break;
						}
					}
	return monster;
}
	
public char[][] listToMap(List<Decor> decor, List<Monster> monster){
	char[][] map = new char[16][16];
	for(int k = 0;k<16;k++){
		for(int p = 0;p<16;p++)
			map[k][p] = '0';
		}
	for(int i = 0; i < decor.size();i++){
		if(decor.get(i).getClass() == Floor.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '0';
		
		else if(decor.get(i).getClass() == Wall.class && 
				(("res" + environment +"/Obstacle1").contentEquals(decor.get(i).getName()))
				|| (("res" + environment +"/Obstacle2").contentEquals(decor.get(i).getName()))
				|| (("res" + environment +"/Obstacle3").contentEquals(decor.get(i).getName()))
				|| (("res" + environment +"/Obstacle4").contentEquals(decor.get(i).getName())))
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = 'r';		
		
		else if(decor.get(i).getClass() == Wall.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '1';
		
		else if(decor.get(i).getClass() == Jar.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '2';
		
		else if(decor.get(i).getClass() == SpawnerFireBall.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '3';
		
		else if(decor.get(i).getClass() == SpawnerMonster.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '4';
		
		else if(decor.get(i).getClass() == Hole.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '6';
		/*
		else if(decor.get(i).getClass() == MovingTrap.class)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '7';
		*/
		else if(decor.get(i).getClass() == Door.class && ((Door)decor.get(i)).getLine() == 1)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '8';
		
		else if(decor.get(i).getClass() == Door.class && ((Door)decor.get(i)).getLevel() == 1)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '9';
		
		else if(decor.get(i).getClass() == Door.class && ((Door)decor.get(i)).getColumn() == 1)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '-';
		
		else if(decor.get(i).getClass() == Door.class && ((Door)decor.get(i)).getLine() == -1)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = '_';
		
		else if(decor.get(i).getClass() == Door.class && ((Door)decor.get(i)).getColumn() == -1)
			map[decor.get(i).getYPos()/40][decor.get(i).getXPos()/40] = ':';
		
		
		/*else if(decor.get(i).getClass() == Floor.class)
		 * 
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'e';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'b';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'h';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'j';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'k';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'z';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'u';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'i';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'o';
		else if(decor.get(i).getClass() == Floor.class)
		map[decor.get(i).getXPos()/40][decor.get(i).getYPos()/40] = 'p';
		*/
	}
	for(int j = 0;j < monster.size();j++){
		if(monster.get(j).getClass() == Melee.class)
			map[monster.get(j).getInitialYPos()/40][monster.get(j).getInitialXPos()/40] = 'd';		
	}
	return map;
}

	public void saveMap(char[][] map){ //oblige de mettre static sinon ca bug, pq?
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(new File("res/"+ level + "-" + roomLine + "-" + roomColumn + "copy.txt"));
			for(int i = 0; i < map.length;i ++){
				for(int j = 0; j < map[i].length ;j++){
					fos.write(map[i][j]);
					if (j<map[i].length-1)
						fos.write(' ');
				}
				fos.write('\n');
			}
				
		}
		catch (FileNotFoundException e) {
	         e.printStackTrace();
	    } catch (IOException e) {
	         e.printStackTrace();
	    } finally {
	         try {
	            if (fos != null)
	               fos.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
		
		
	}
	}
}