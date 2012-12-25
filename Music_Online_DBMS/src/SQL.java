
public class SQL {

	public void CreateTable(){
		Table_node table=new Table_node();
		table.insert_all_table();
		table.show();
		
		/*
		for(int i=0;i<5;i++)
		{
			if(table.singer!=null)
			{
				System.out.println(table.singer.BIRTHDAY);
				table.singer=table.singer.next;
			}
		}*/
	}
}
