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
		
		String [] select_ary=select.split(" ");
		String [] from_ary=from.split(" ");
		String [] where_ary=where.split(" ");
		for(int i=0;i<select_ary.length;i++)
			System.out.println(select_ary[i]);
		for(int i=0;i<from_ary.length;i++)
			System.out.println(from_ary[i]);
		for(int i=0;i<where_ary.length;i++)
			System.out.println(where_ary[i]);
		
		
	}
	public void SELECT(){
		
	}
}
