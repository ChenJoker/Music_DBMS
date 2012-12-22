import java.io.*;
import java.util.*;

public class Music_DBMS {

	/**
	 * @param args
	 */	
	//Save user's table
	public static class User{
		
		String ID;
		String PASSWORD;
		String NICKNAME;
		User next;
		
		public User(String id,String password , String nickname){
				this.ID=id;
				this.NICKNAME=nickname;
				this.PASSWORD=password;
		}
		
	}
	
	//Save music's table
	public static class Music{
		
		String NAME;
		String PRICE;
		String TIME_LENGTH;
		String ALBUM_NAME;
		String SINGER_NAME;
		String F_NUMBER;
		Music next;
		
		public Music(String name,String price,String time_length,String album_name,String singer_name,String f_number){
			this.NAME=name;
			this.PRICE=price;
			this.TIME_LENGTH=time_length;
			this.ALBUM_NAME=album_name;
			this.SINGER_NAME=singer_name;
			this.F_NUMBER=f_number;
		}
	}
	
	//Save farorite's tabel
	public static class Favorite{
		String USER_ID;
		String FAVORITE_NUMBER;
		
		public Favorite(String user_id,String favorite_number){
			this.USER_ID=user_id;
			this.FAVORITE_NUMBER=favorite_number;
		}
	}
	
	//Save Album's table
	public static class Album{
		String NAME;
		String PRICE;
		String F_NUMBER;
		
		public Album(String name,String price,String f_number){
			this.NAME=name;
			this.PRICE=price;
			this.F_NUMBER=f_number;
		}
	}
	
	//Save singer's table
	public static class Singer{
		String NAME;
		String BIRTHDAY;
		String NATION;
		String F_NUMBER;
		
		public Singer(String name,String birthday, String nation , String f_number){
			this.NAME=name;
			this.NATION=nation;
			this.F_NUMBER=f_number;
			this.BIRTHDAY=birthday;
		}
	}
	
	public class Insert_user implements Insert_interface{

		@Override
		public void insert() {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
