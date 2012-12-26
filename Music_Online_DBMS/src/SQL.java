import java.util.*;

public class SQL {

	private String [] entity={"USER","FAVORITE","MUSIC","ALBUM","SINGER"};
	
	private String select;
	private String from;
	private String where;
	
	Scanner input=new Scanner(System.in);
	
	public void CreateTable(){
		Table_node table=new Table_node();
		table.insert_all_table();
	//	table.show();
	}
	
	public void run(){
		System.out.println("Enter:");
		select=input.nextLine();
		from=input.nextLine();
		where=input.nextLine();
		
		System.out.println(select+"\n"+from+"\n"+where);
	}
	public void SELECT(){
		
	}
}
