
public class Table_node {
	
		public int Table_number=1;
		//Save user's table
		public static class User{
			
			String ID;
			String PASSWORD;
			String NICKNAME;
			User next;
			User pro;
			public User(String id,String password , String nickname){
					this.ID=id;
					this.NICKNAME=nickname;
					this.PASSWORD=password;
			}
			
		}
		
		//Save music's table
		public static class Music{
			
			String M_NAME;
			String M_PRICE;
			String TIME_LENGTH;
			String ALBUM_NAME;
			String SINGER_NAME;
			String F_NUMBER;
			Music next;
			Music pro;
			public Music(String name,String price,String time_length,String album_name,String singer_name,String f_number){
				this.M_NAME=name;
				this.M_PRICE=price;
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
			Favorite next;
			Favorite pro;
			public Favorite(String user_id,String favorite_number){
				this.USER_ID=user_id;
				this.FAVORITE_NUMBER=favorite_number;
			}
		}
		
		//Save Album's table
		public static class Album{
			String A_NAME;
			String A_PRICE;
			String F_NUMBER;
			Album next;
			Album pro;
			public Album(String name,String price,String f_number){
				this.A_NAME=name;
				this.A_PRICE=price;
				this.F_NUMBER=f_number;
			}
		}
		
		//Save singer's table
		public static class Singer{
			String S_NAME;
			String BIRTHDAY;
			String NATION;
			String F_NUMBER;
			Singer next;
			Singer pro;
			public Singer(String name,String birthday, String nation , String f_number){
				this.S_NAME=name;
				this.NATION=nation;
				this.F_NUMBER=f_number;
				this.BIRTHDAY=birthday;
			}
		}

		//Add user's content
		public void Insert_user(User user,String id, String password, String nickname){
						
			if(user.next!=null){
				Insert_user(user.next,id,password,nickname);
			}
			else{
				Table_number++;
				user.next=new User(id,password,nickname);
				user.next.pro=user;
			}
		}
		
		//Add favorite's content
		public void Insert_favorite(Favorite favorite , String user_id, String favorite_number){
			
			if(favorite.next!=null){
				Insert_favorite(favorite.next,user_id,favorite_number);
			}			
			else{
				favorite.next=new Favorite(user_id,favorite_number);
				favorite.next.pro=favorite;
			}
		}
		
		//Add music's content
		public void Insert_music(Music music , String name,String price, String time_length, String album_name, String singer_name ,String f_number){
			
			if(music.next!=null){
				Insert_music(music.next,name,price,time_length,album_name,singer_name,f_number);
			}		
			else{
				music.next=new Music(name,price,time_length,album_name,singer_name,f_number);
				music.next.pro=music;
			}
		}
		
		//Add album's content
		public void Insert_album(Album album , String name,String price, String f_number){
			
			if(album.next!=null){
				Insert_album(album.next,name,price,f_number);
			}
			else{
				album.next=new Album(name,price,f_number);
				album.next.pro=album;
			}
		}
		
		//Add singer's content
		public void Insert_singer(Singer singer,String name, String birthday,String nation ,String f_number){
			
			if(singer.next!=null){
				Insert_singer(singer.next,name,birthday,nation,f_number);
			}
			else{
				singer.next=new Singer(name,birthday,nation,f_number);
				singer.next.pro=singer;
			}
		}
		
		//initial
		static User user=new User("ABC11","1111","Jeff");
		static Favorite favorite=new Favorite("ABC11","1");
		static Music music=new Music("Birth","3","3:46","REAL_WORLD","KOKIA","1");
		static Album album=new Album("REAL_WORD","300","1");
		static Singer singer=new Singer("KOKIA","1976/7/22","JAPAN","1");
		
		//insert all table
		public void insert_all_table(){
			
			//User's table			
			Insert_user(user,"CAT","2222","Tom");
			Insert_user(user,"DOG","3333","Mary");
			Insert_user(user,"BIRD","4444","Sam");
			Insert_user(user,"TIGER","5555","Nick");
			
			//favorite's table			
			Insert_favorite(favorite,"CAT","2");
			Insert_favorite(favorite,"DOG","3");
			Insert_favorite(favorite,"BIRD","4");
			Insert_favorite(favorite,"TIGER","5");
			
			//music's table			
			Insert_music(music,"Lost_Butterfly","3","4:58","Rurutia_02","Rurutia","2");
			Insert_music(music,"Too_Young","4","3:42","C'mon","BZ","3");
			Insert_music(music,"Fighting_Soldier","4","4:53","WILL","�C�s�L��","4");
			Insert_music(music,"Cold_Wind_Blows","5","5:03","Recovery","Eminem","5");
			
			//album's table
			Insert_album(album,"Rurutia_02","400","2");
			Insert_album(album,"C'mon","350","3");
			Insert_album(album,"WILL","329","4");
			Insert_album(album,"Recovery","435","5");
			
			//singer's table			
			Insert_singer(singer,"Rurutia","?/?/?","JAPAN","2");
			Insert_singer(singer,"BZ","1988/?/?","JAPAN","3");
			Insert_singer(singer,"�C�s�L��","1987/10/27","JAPAN","4");
			Insert_singer(singer,"Eminem","1972/10/17","U.S","5");	
			
			
		}
		
		public void show(){
			showtable(user,favorite,music,album,singer);
		}
		
		public void showtable(User user,Favorite favorite,Music music,Album album,Singer singer){
			
			if(user!=null && favorite!=null && music!=null && album!=null && singer!=null){
				System.out.println(user.ID+"	"+user.PASSWORD+"	"+user.NICKNAME);
				System.out.println(favorite.USER_ID+"	"+favorite.FAVORITE_NUMBER);
				System.out.println(music.M_NAME+"	"+music.M_PRICE+"	"+music.TIME_LENGTH+"	"+music.ALBUM_NAME+"	"+music.SINGER_NAME+"	"+music.F_NUMBER);
				System.out.println(album.A_NAME+"	"+album.A_PRICE+"	"+album.F_NUMBER);
				System.out.println(singer.S_NAME+"	"+singer.BIRTHDAY+"	"+singer.NATION+"	"+singer.F_NUMBER);
				
				System.out.println();
				showtable(user.next,favorite.next,music.next,album.next,singer.next);
			}
		}
		
}
