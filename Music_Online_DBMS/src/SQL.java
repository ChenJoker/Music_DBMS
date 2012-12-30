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
	
	Table_node table=new Table_node();
	
	public void CreateTable(){
		
		table.insert_all_table();
	//	table.show();
	}
	
	public void run(){
		
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
			 from_entity=from_ary[1].split(",");
			
			//check whether user enters correct commend
			if(!select_ary[0].toUpperCase().equals("SELECT"))
				throw new Exception();
			if(!from_ary[0].toUpperCase().equals("FROM"))
				throw new Exception();
			if(!where_ary[0].toUpperCase().equals("WHERE"))
				throw new Exception();
			
			try{
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
					do{
						if(condition[0].equals("ID") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.user.ID.equals(sub)){							
								UserPrint();
								System.out.println();
							}	
						}
						if(condition[0].equals("PASSWORD") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.user.PASSWORD.equals(sub)){							
								UserPrint();
								System.out.println();
							}	
						}
						if(condition[0].equals("NICKNAME") && condition[1].charAt(0)=='\"'){
							sub=condition[1].substring(1, condition[1].length()-1);
							if(table.user.NICKNAME.equals(sub)){							
								UserPrint();
								System.out.println();
							}	
						}
						table.user=table.user.next;
					}while(table.user.next!=null);
					
				}
			}
			
		}
		TableInitial();
	}
	
	//let table start at root so that this system can find attribute all time.
	public void TableInitial(){
		do{
			table.user=table.user.pro;
		}while(table.user.pro!=null);
		/*
		do{
			table.music=table.music.pro;
		}while(table.music.pro!=null);
		
		do{
			table.favorite=table.favorite.pro;
		}while(table.favorite.pro!=null);
		
		do{
			table.album=table.album.pro;
		}while(table.album.pro!=null);
		
		do{
			table.singer=table.singer.pro;
		}while(table.singer.pro!=null);*/
	}
	
	public void UserPrint(){
		for(int j=0;j<select_attributes.length;j++){
			if(select_attributes[j].equals("ID"))
				System.out.print(table.user.ID+" ");
			if(select_attributes[j].equals("PASSWORD"))
				System.out.print(table.user.PASSWORD+" ");
			if(select_attributes[j].equals("NICKNAME"))
				System.out.print(table.user.NICKNAME+" ");
		}
	}
}




