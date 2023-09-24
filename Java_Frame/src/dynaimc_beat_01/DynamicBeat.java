package dynaimc_beat_01;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	//더블 버퍼링을 위해서 전체 화면에 대한 이미지를 담는 두 인스턴스
	//자바에서 제공하는 이미지를 화면에 띄우는 방식을 이용하게 되면 버퍼링이 심함 
	//따라서 더블 버퍼링이라는 프로그램 기법을 이용
	//현제 프로그램의 크기에 맞는 이미지르 매 순간마다 생성헤서 원하는 컴포넌트만 화면에 출력하는 방식
	//버퍼의 이미지를 담아서 매 순간마다 이미지를 갱신하기 때문에 피아노 리듬게임에서는 빠질 수 없는 기술
	private Image screenImage;
	private Graphics sreenGraphic;
	
	private Image introBackground; //이미지를 담을 수 있는 하나의 객체
	
	public DynamicBeat() {
		setTitle("안녕 나는 제목이야");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); 
		setResizable(false); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//이미지 파일을 얻어온 뒤에 그것의 이미지 인스턴스를 introBackground의 이미지 변수에다가 초기화를 해주겠다는 뜻 > 초기화를 하면 사용가능해진다는 의미
		introBackground = new ImageIcon(Main.class.getResource("../images/Welcome.jpg")).getImage();
	}
	public void paint(Graphics g) {  //우리 게임창에 스크린 이미지가 그려지는 것
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//이미지를 만들어주고 그걸 screenImage에 넣는 것(프로그램 화면 크기만큼 이미지 생성)
		Graphics screenGraphic = screenImage.getGraphics();
		//스크린 이미지를 이용해서 그래픽 객체를 얻어오는 것(그 이미지에 우리가 원하는 내용이 그려지는 것)림을 그려주는 것(그 이미지에 우리가 원하는 내용이 그려지는 것)
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0,null); //(screenDraw라는 함수를 이용해서 그려지는데 
		//스크린 이미지를 (0,0)에 그려주는 것
	}
 
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		//인트로 백그라운드를 전체 이미지(스크린 이미지)에 그려줄 수 있도록 함(인트로 백그라운드를 (0,0)위치에 그려줌
		this.repaint();//페인트는 JFrame을 상속받은 GUI게임에서 가장 첫 번쩨로 화면을 그려주는 함수
		//리페인트 > 다시 페인트 함수를 불로 옴(전체 화면 이미지를 매순간마다 반복되면서 왔다갔다하면서 그려주는 것)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
