import java.util.*;

public class SQL {

	private String select;
	private String from;
	private String where;
	private String [] select_ary;
	private String [] from_ary;
	private String [] where_ary;
	private int attribute;
	private LinkedList table=new LinkedList();
	
	public void CreateTable(){
		Table_node table=new Table_node();
		table.insert_all_table();
	//	table.show();
	}
	
	public void run(){
		
		attribute=0;
		table.removeAll(table);
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
			String [] select_attributes=select_ary[1].split(",");
			String [] from_entity=from_ary[1].split(",");
			
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
						table.add(1);
					else if(from_entity[i].equals("MUSIC"))
						table.add(2);
					else if(from_entity[i].equals("FAVORITE"))
						table.add(3);
					else if(from_entity[i].equals("ALBUM"))
						table.add(4);
					else if(from_entity[i].equals("SINGER"))
						table.add(5);
				}
			}
			catch(Exception e){
				System.out.println("No entity in the database");
				return;
			}
			
			//test
			for(int i=0;i<select_attributes.length;i++)
				System.out.println(select_attributes[i]);
			for(int i=0;i<from_entity.length;i++)
				System.out.println(from_entity[i]);
			for(int i=1;i<where_ary.length;i++)
				System.out.println(where_ary[i]);
		}
		catch(Exception e){
			System.out.println("Please enter correct commend");
			return;
		}		
		System.out.println(select_ary[0].charAt(0));
		System.out.println(attribute);
		System.out.println(table);
	}
	
	public void analyze(){
		
	}
}
