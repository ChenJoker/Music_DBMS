import java.io.*;
import java.util.*;

public class Music_DBMS {

	/**
	 * @param args
	 */
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
