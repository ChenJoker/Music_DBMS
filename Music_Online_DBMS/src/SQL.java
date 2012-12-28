import java.util.*;

public class SQL {

	private String [] entity={"USER","FAVORITE","MUSIC","ALBUM","SINGER"};
	
	private String select;
	private String from;
	private String where;
	private String [] select_ary;
	private String [] from_ary;
	private String [] where_ary;
	Scanner input=new Scanner(System.in);
	
	public void CreateTable(){
		Table_node table=new Table_node();
		table.insert_all_table();
	//	table.show();
	}
	
	public void run(){
		
		//Enter commend and test whether there are some errors.
		try{
			System.out.println("Enter:");
			select=input.nextLine();
			from=input.nextLine();
			where=input.nextLine();
			
			select_ary=select.split(" ");
			from_ary=from.split(" ");
			where_ary=where.split(" ");
		
			String [] select_attributes=select_ary[1].split(",");
			String [] from_entity=from_ary[1].split(",");
			
			if(!select_ary[0].toUpperCase().equals("SELECT"))
				throw new Exception();
			if(!from_ary[0].toUpperCase().equals("FROM"))
				throw new Exception();
			if(!where_ary[0].toUpperCase().equals("WHERE"))
				throw new Exception();
			
			for(int i=0;i<select_attributes.length;i++)
				System.out.println(select_attributes[i]);
			for(int i=0;i<from_entity.length;i++)
				System.out.println(from_entity[i]);
			for(int i=1;i<where_ary.length;i++)
				System.out.println(where_ary[i]);
		}
		catch(Exception e){
			System.out.println("Please enter correct commend");
		}
		
		
		
		
	}
	public void SELECT(){
		
	}
}
