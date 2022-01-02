package Day09_1;

import java.util.Scanner;

class Music{
	// 가수, 노래
	private String type;
	private String song;
	
	public Music(String type, String song) {
		this.type = type;
		this.song = song;
	}
	
	public void play() {
		System.out.printf("%s type의 %s가 실행됩니다.\n", type, song);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

}



class DanceMusic extends Music {
	private String name;
	public DanceMusic(String name, String type, String song) {
		super(type, song);
		this.name = name;
	}
	
	@Override
	public void play() {
		super.play();
		System.out.printf("가수는 %s입니다.\n", name);
	}
}



class NCSMusic extends Music {
	public NCSMusic(String type, String song) {
		super(type, song);
	}
	
	@Override
	public void play() {
		super.play();
		System.out.println("No Copyrignt Sound!");
	}
}



class MusicPlayer {
	Scanner scan = new Scanner(System.in);
	private static Music[] musicList = new Music[12];
	private static int top = 0;
	
	static {
		musicList[top++] = new Music("NCSMusic", "i");
	}
	
	public static int indexNum(Music music) {
		
		int index = -1;
		for(int i = 0; i < top; i++) {
			if(music.equals(musicList[i])) {
				index = i;
			}
		}
		return index;
	}

	public static int indexN(String song) { /////
		
		int index = -1;
		for(int i = 0; i < top; i++) {
			if(song.equals(musicList[i])) {
				index = i;
			}
		}
		return index;
	}
	
	public void appendMusic() {
		// 음악 추가
		System.out.println("추가할 음악의 정보를 입력하세요");
//		System.out.print("가수 >> ");
//		String name = scan.next();
		System.out.print("노래 >> ");
		String song = scan.next();
		System.out.print("타입 >> ");
		String type = scan.next();
		if(type.equals("DanceMusic")) {
			System.out.printf("가수를 입력하세요 >> ");
			String name = scan.next();
		}
		Music m = new Music(type, song);
		
		musicList[top++] = new Music(type, song);
		System.out.printf("%s type %s가 추가되었습니다.\n", type, song);
//		m.play();
	}
	
	public Music removeMusic() {
		// 음악 제거
		return null;
	}
	
	public Music findMusic() {
		// 음악 검색
		System.out.print("찾을 노래 제목을 입력하세요 >> ");
		String song = scan.next();
		int index = indexN(song);
		
//		int flag = 0;
		for(int i = 0; i < musicList.length; i++) {
			if(song.equals(musicList[i].getSong())) {
				System.out.println("찾으시는 노래가 있습니다.");
				System.out.println("노래를 재생합니다.");
				musicList[i].play();
				break;
//				flag++;
			} else {
				System.out.println("찾으시는 노래가 없습니다.");
				break;
			}
		}
//		if(flag == 0) {
//		} else {
//			musicList[index].play();
//		}
		return null;
	}

	public void playAllMusic() {
		// 모든 음악 실행
		System.out.println("모든 노래를 재생합니다.");
		for(Music music : musicList) {
			if(music == null) {
				break;
			}
			musicList[indexNum(music)].play();
//			System.out.println(music);
		}
	}
	
	public int menu() {
		System.out.println("1.추가 2.전체곡실행 3.선택곡실행 4.제거 5.종료");
		System.out.print("선택 >>> ");
		int no = scan.nextInt();
		
		while(true) {
			if(no < 1 || no > 5) {
				System.out.println("1~5 사이의 정수를 입력하세요");
				System.out.println("1.추가 2.전체곡실행 3.선택곡실행 4.제거 5.종료");
				System.out.print("선택 >>> ");
				no = scan.nextInt();
			} else
				break;
		}
		return no;
	}
}




public class MainCls {
//	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer();
		while(true) {
			switch (mp.menu()) {
			case 1:
//				System.out.println("1번을 선택함");
				mp.appendMusic();
				break;
			case 2:
				mp.playAllMusic();
				System.out.println();
				break;
			case 3:
				mp.findMusic();
				break;
			case 4:
				mp.removeMusic();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				break;
			}
		}
		
	}
}
















