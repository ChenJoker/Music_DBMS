import java.util.*;

public class SQL {

	private String select;
	private String from;
	private String where;
	private String [] select_ary;
	private String [] from_ary;
	private String [] where_ary;
	private String [] select_attributes;
	private String [] from_entity;
	private int attribute;
	private LinkedList entity=new LinkedList();
	private int conditions_number;
	private String [] aggregate;
	private int special;
	
	Table_node table=new Table_node();
	
	public void CreateTable(){
		
		table.insert_all_table();
	//	table.show();
	}
	
	public void run(){
		
		special=1;
		conditions_number=1;
		attribute=0;
		entity.removeAll(entity);
		Scanner input=new Scanner(System.in);
		//Enter commend and test whether there are some errors.
		try{
			System.out.println("Enter:");
			select=input.nextLine();
			from=input.nextLine();
			where=input.nextLine();
			
			select_ary=select.split(" ");
			from_ary=from.split(" ");
			where_ary=where.split(" ");
		
			//split attributes , entity
	
			 select_attributes=select_ary[1].split(",");
			 aggregate=select_ary[1].split("\\(");
			 from_entity=from_ary[1].split(",");
			 
			//check whether user enters correct commend
			if(aggregate[0].toUpperCase().equals("MAX") || aggregate[0].toUpperCase().equals("MIN") || aggregate[0].toUpperCase().equals("AVG")
					|| aggregate[0].toUpperCase().equals("SUM") || aggregate[0].toUpperCase().equals("COUNT"))
				special=2;
			if(!select_ary[0].toUpperCase().equals("SELECT"))
				throw new Exception();
			if(!from_ary[0].toUpperCase().equals("FROM"))
				throw new Exception();
			if(!where_ary[0].toUpperCase().equals("WHERE"))
				throw new Exception();
			
			try{
				if(special==1){
					for(int j=0;j<select_attributes.length;j++){
		
							//check whether attributes which user enters are correct
							if(select_attributes[j].equals("ID") || select_attributes[j].equals("PASSWORD")|| select_attributes[j].equals("NICKNAME")
									|| select_attributes[j].equals("M_NAME") || select_attributes[j].equals("M_PRICE") || select_attributes[j].equals("TIME_LENGTH") || select_attributes[j].equals("ALBUM_NAME")
									 || select_attributes[j].equals("SINGER_NAME") || select_attributes[j].equals("F_NUMBER") || select_attributes[j].equals("*")
									 || select_attributes[j].equals("USER_ID") || select_attributes[j].equals("FAVORITE_NUMBER")
									 || select_attributes[j].equals("A_NAME") || select_attributes[j].equals("A_PRICE") || select_attributes[j].equals("F_NUMBER")
									 || select_attributes[j].equals("S_NAME") || select_attributes[j].equals("BIRTHDAY") || select_attributes[j].equals("NATION") || select_attributes[j].equals("F_NUMBER"))
								;
							else
								throw new Exception();
							
							if(select_attributes[j].equals("ID") || select_attributes[j].equals("PASSWORD")|| select_attributes[j].equals("NICKNAME"))
								attribute=1;
							else if(select_attributes[j].equals("M_NAME") || select_attributes[j].equals("M_PRICE") || select_attributes[j].equals("TIME_LENGTH") || select_attributes[j].equals("ALBUM_NAME")
									 || select_attributes[j].equals("SINGER_NAME") || select_attributes[j].equals("F_NUMBER"))
								attribute=2;
							else if(select_attributes[j].equals("USER_ID") || select_attributes[j].equals("FAVORITE_NUMBER"))
								attribute=3;
							else if(select_attributes[j].equals("A_NAME") || select_attributes[j].equals("A_PRICE") || select_attributes[j].equals("F_NUMBER"))
								attribute=4;
							else if( select_attributes[j].equals("S_NAME") || select_attributes[j].equals("BIRTHDAY") || select_attributes[j].equals("NATION") || select_attributes[j].equals("F_NUMBER"))
								attribute=5;
							else if(select_attributes[j].equals("*"))
								attribute=6;
							
					}	
				}
				else{

					if(aggregate[1].substring(0,aggregate[1].length()-1).equals("ID") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("PASSWORD")||aggregate[1].substring(0,aggregate[1].length()-1).equals("NICKNAME")
							|| aggregate[1].substring(0,aggregate[1].length()-1).equals("M_NAME") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("M_PRICE") || aggregate[1].substring(0,aggregate[1].length()-1).equals("TIME_LENGTH") || aggregate[1].substring(0,aggregate[1].length()-1).equals("ALBUM_NAME")
							 || aggregate[1].substring(0,aggregate[1].length()-1).equals("SINGER_NAME") || aggregate[1].substring(0,aggregate[1].length()-1).equals("F_NUMBER") || aggregate[1].substring(0,aggregate[1].length()-1).equals("*")
							 || aggregate[1].substring(0,aggregate[1].length()-1).equals("USER_ID") || aggregate[1].substring(0,aggregate[1].length()-1).equals("FAVORITE_NUMBER")
							 || aggregate[1].substring(0,aggregate[1].length()-1).equals("A_NAME") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("A_PRICE") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("F_NUMBER")
							 || aggregate[1].substring(0,aggregate[1].length()-1).equals("S_NAME") || aggregate[1].substring(0,aggregate[1].length()-1).equals("BIRTHDAY") || aggregate[1].substring(0,aggregate[1].length()-1).equals("NATION") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("F_NUMBER"))
						;
					else
						throw new Exception();
					
					
					if(aggregate[1].substring(0,aggregate[1].length()-1).equals("ID") || aggregate[1].substring(0,aggregate[1].length()-1).equals("PASSWORD")||aggregate[1].substring(0,aggregate[1].length()-1).equals("NICKNAME"))
						attribute=1;
					else if(aggregate[1].substring(0,aggregate[1].length()-1).equals("M_NAME") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("M_PRICE") || aggregate[1].substring(0,aggregate[1].length()-1).equals("TIME_LENGTH") || aggregate[1].substring(0,aggregate[1].length()-1).equals("ALBUM_NAME")
							 || aggregate[1].equals("SINGER_NAME") || aggregate[1].equals("F_NUMBER"))
						attribute=2;
					else if(aggregate[1].substring(0,aggregate[1].length()-1).equals("USER_ID") || aggregate[1].substring(0,aggregate[1].length()-1).equals("FAVORITE_NUMBER"))
						attribute=3;
					else if(aggregate[1].substring(0,aggregate[1].length()-1).equals("A_NAME") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("A_PRICE") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("F_NUMBER"))
						attribute=4;
					else if( aggregate[1].substring(0,aggregate[1].length()-1).equals("S_NAME") ||aggregate[1].substring(0,aggregate[1].length()-1).equals("BIRTHDAY") || aggregate[1].substring(0,aggregate[1].length()-1).equals("NATION") || aggregate[1].substring(0,aggregate[1].length()-1).equals("F_NUMBER"))
						attribute=5;
					else if(aggregate[1].substring(0,aggregate[1].length()-1).equals("*"))
						attribute=6;
				}
					
			}
			catch(Exception e){
				System.out.println("No attributes in the database");
				return;
			}
			
			try{
				//check entity
				for(int i=0;i<from_entity.length;i++){
					if(from_entity[i].equals("USER") || from_entity[i].equals("MUSIC") || from_entity[i].equals("FAVORITE") || from_entity[i].equals("ALBUM") || from_entity[i].equals("SINGER"))
						;
					else
						throw new Exception();
					
					if(from_entity[i].equals("USER"))
						entity.add(1);
					else if(from_entity[i].equals("MUSIC"))
						entity.add(2);
					else if(from_entity[i].equals("FAVORITE"))
						entity.add(3);
					else if(from_entity[i].equals("ALBUM"))
						entity.add(4);
					else if(from_entity[i].equals("SINGER"))
						entity.add(5);
				}
			}
			catch(Exception e){
				System.out.println("No entity in the database");
				return;
			}
			
			
			try{
				//check whether the attributes are in entity user enters
				for(int i=0;i<entity.size();i++){
					if(entity.get(i).equals(attribute) || attribute==6)
						break;
					else
						throw new Exception();
				}
			}
			catch(Exception e){
				System.out.println("The attributes are not in entities you enter");
				return;
			}
		}
		catch(Exception e){
			System.out.println("Please enter correct commend");
			return;
		}		
		
		analyze();
	}
	
	public void analyze(){
		
		String [] condition = null;
		String sub;
		
		/*
		System.out.println(table.user.ID);
		
		table.user=table.user.next;
	*/
		for(int i=1;i<where_ary.length;i++){
			if(where_ary[i].toUpperCase().equals("AND"))
				conditions_number++;
		}
		
		
		for(int i=1;i<where_ary.length;i++){
			condition=where_ary[i].split("=");
			
			for(int K=0;K<entity.size();K++){
				if(entity.get(K).equals(1)){
					for(int j=0;j<table.Table_number;j++){
						if(condition[0].equals("ID") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.user.ID.equals(sub)){			
								if(special==1){
									UserPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("PASSWORD") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.user.PASSWORD.equals(sub)){
								if(special==1){
									UserPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("NICKNAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.user.NICKNAME.equals(sub)){
								if(special==1){
									UserPrint();
									System.out.println();
								}
							}	
						}
						if(table.user.next!=null)
							table.user=table.user.next;
					}
					
				}
				else if(entity.get(K).equals(2)){
					for(int j=0;j<table.Table_number;j++){
						if(condition[0].equals("M_NAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.music.M_NAME.equals(sub)){	
								if(special==1){
									MusicPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("M_PRICE") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.music.M_PRICE.equals(sub)){
								if(special==1){
									MusicPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("TIME_LENGTH") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.music.TIME_LENGTH.equals(sub)){
								if(special==1){
									MusicPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("ALBUM_NAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.music.ALBUM_NAME.equals(sub)){	
								if(special==1){
									MusicPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("SINGER_NAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.music.SINGER_NAME.equals(sub)){
								if(special==1){
									MusicPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("F_NUMBER") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.music.F_NUMBER.equals(sub)){
								if(special==1){
									MusicPrint();
									System.out.println();
								}
							}	
						}
						if(table.music.next!=null)
							table.music=table.music.next;
					}				
				}
				else if(entity.get(K).equals(3)){
					for(int j=0;j<table.Table_number;j++){
						if(condition[0].equals("USER_ID") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.favorite.USER_ID.equals(sub)){	
								if(special==1){
									FavoritePrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("FAVORITE_NUMBER") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.favorite.FAVORITE_NUMBER.equals(sub)){	
								if(special==1){
									FavoritePrint();
									System.out.println();
								}
							}	
						}
						if(table.favorite.next!=null)
							table.favorite=table.favorite.next;
					}				
				}
				else if(entity.get(K).equals(4)){
					for(int j=0;j<table.Table_number;j++){
						if(condition[0].equals("A_NAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.album.A_NAME.equals(sub)){
								if(special==1){
									AlbumPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("A_PRICE") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.album.A_PRICE.equals(sub)){
								if(special==1){
									AlbumPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("F_NUMBER") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.album.F_NUMBER.equals(sub)){	
								if(special==1){
									AlbumPrint();
									System.out.println();
								}
							}	
						}
						if(table.album.next!=null)
							table.album=table.album.next;
					}				
				}
				else if(entity.get(K).equals(5)){
					for(int j=0;j<table.Table_number;j++){
						if(condition[0].equals("S_NAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.singer.S_NAME.equals(sub)){
								if(special==1){
									SingerPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("BIRTHDAY") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.singer.BIRTHDAY.equals(sub)){	
								if(special==1){
									SingerPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("NATION") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.singer.NATION.equals(sub)){	
								if(special==1){
									SingerPrint();
									System.out.println();
								}
							}	
						}
						if(condition[0].equals("F_NUMBER") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.singer.F_NUMBER.equals(sub)){
								if(special==1){
									SingerPrint();
									System.out.println();
								}
							}	
						}
						if(table.singer.next!=null)
							table.singer=table.singer.next;
					}
					
				}
			}
			
		}
		TableInitial();
	}
	
	//let table start at root so that this system can find attribute all time.
	public void TableInitial(){
		
		while(table.user.pro!=null)
			table.user=table.user.pro;
				
		while(table.music.pro!=null)
			table.music=table.music.pro;
				
		while(table.favorite.pro!=null)
			table.favorite=table.favorite.pro;
				
		while(table.album.pro!=null)
			table.album=table.album.pro;
				
		while(table.singer.pro!=null)
			table.singer=table.singer.pro;		
	}
	
	//print user's attributes
	public void UserPrint(){
		for(int j=0;j<select_attributes.length;j++){
			if(select_attributes[j].equals("ID"))
				System.out.print(table.user.ID+" ");
			if(select_attributes[j].equals("PASSWORD"))
				System.out.print(table.user.PASSWORD+" ");
			if(select_attributes[j].equals("NICKNAME"))
				System.out.print(table.user.NICKNAME+" ");
			if(select_attributes[j].equals("*"))
				System.out.print(table.user.ID+" "+table.user.PASSWORD+" "+table.user.NICKNAME+" ");
		}
	}
	
	//print music's attributes
	public void MusicPrint(){
		for(int j=0;j<select_attributes.length;j++){
			if(select_attributes[j].equals("M_NAME"))
				System.out.print(table.music.M_NAME+" ");
			if(select_attributes[j].equals("M_PRICE"))
				System.out.print(table.music.M_PRICE+" ");
			if(select_attributes[j].equals("TIME_LENGTH"))
				System.out.print(table.music.TIME_LENGTH+" ");
			if(select_attributes[j].equals("ALBUM_NAME"))
				System.out.print(table.music.ALBUM_NAME+" ");
			if(select_attributes[j].equals("SINGER_NAME"))
				System.out.print(table.music.SINGER_NAME+" ");
			if(select_attributes[j].equals("F_NUMBER"))
				System.out.print(table.music.F_NUMBER+" ");
			if(select_attributes[j].equals("*"))
				System.out.print(table.music.M_NAME+" "+table.music.M_PRICE+" "+table.music.TIME_LENGTH+" "+table.music.ALBUM_NAME+" "+table.music.SINGER_NAME+" "+table.music.F_NUMBER+" ");
		}
	}
	
	//print favorite's attributes
	public void FavoritePrint(){
		for(int j=0;j<select_attributes.length;j++){
			if(select_attributes[j].equals("USER_ID"))
				System.out.print(table.favorite.USER_ID+" ");
			if(select_attributes[j].equals("FAVORITE_NUMBER"))
				System.out.print(table.favorite.FAVORITE_NUMBER+" ");
			if(select_attributes[j].equals("*"))
				System.out.print(table.favorite.USER_ID+" "+table.favorite.FAVORITE_NUMBER+" ");
		}
	}
	
	//print album's attributes
	public void AlbumPrint(){
		for(int j=0;j<select_attributes.length;j++){
			if(select_attributes[j].equals("A_NAME"))
				System.out.print(table.album.A_NAME+" ");
			if(select_attributes[j].equals("A_PRICE"))
				System.out.print(table.album.A_PRICE+" ");
			if(select_attributes[j].equals("F_NUMBER"))
				System.out.print(table.album.F_NUMBER+" ");
			if(select_attributes[j].equals("*"))
				System.out.print(table.album.A_NAME+" "+table.album.A_PRICE+" "+table.album.F_NUMBER+" ");
		}
	}
	
	//print singer's attributes
	public void SingerPrint(){
		for(int j=0;j<select_attributes.length;j++){
			if(select_attributes[j].equals("S_NAME"))
				System.out.print(table.singer.S_NAME+" ");
			if(select_attributes[j].equals("BIRTHDAY"))
				System.out.print(table.singer.BIRTHDAY+" ");
			if(select_attributes[j].equals("NATION"))
				System.out.print(table.singer.NATION+" ");
			if(select_attributes[j].equals("F_NUMBER"))
				System.out.print(table.singer.F_NUMBER+" ");
			if(select_attributes[j].equals("*"))
				System.out.print(table.singer.S_NAME+" "+table.singer.BIRTHDAY+" "+table.singer.NATION+" "+table.singer.F_NUMBER+" ");
		}
	}
}




