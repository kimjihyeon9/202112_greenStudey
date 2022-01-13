package Day22_1_ch13_다른;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TimerThread extends Thread {
	JLabel timerLabel;
	boolean isPause = false;

	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		// 스레드의 실행 메소드 재정의 - start()에 의해서 실행됨
		System.out.println("나의 스레드>>> " + this.getName());
		int ssec = 0;
		int sec = 0;
		while (true) {
			try {
				if (ssec % 60 == 0)
					sec++;
				ssec %= 60;

				// 초가 찍히는지 확인
//				System.out.println("Timer >>> " + sec + ":" + ssec++);
//				System.out.print("\r");

				timerLabel.setText("Timer >>> " + sec + ":" + ssec++);
				Thread.sleep(100 / 6);
			} catch (InterruptedException e) {
			}

			// 반복문이 끝나면 쓰레드도 종료한다
			if (isPause) {
				synchronized (this) {
					try {
						System.out.println("멈춤 .... ");
						this.wait();
						System.out.println("재실행 ....");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	public void stopTimer() {
		isPause = true;
	}

	public void restart() {
		synchronized (this) {
			isPause = false;
			this.notifyAll();
		}
	}
}

public class ThreadTimerEx_2 extends JFrame {
	JPanel contentPan = new JPanel();

	public ThreadTimerEx_2() {
		contentPan.setBackground(Color.white);
		this.setContentPane(contentPan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Thread를 이용한 시계");
		setSize(300, 200);

		JLabel timerLabel = new JLabel(">>> 0초");
		contentPan.setLayout(new GridBagLayout());
		contentPan.add(timerLabel);

		JButton stopBtn = new JButton("Stop");
		JButton playBtn = new JButton("Play");
		contentPan.add(stopBtn);
		contentPan.add(playBtn);

		// Thread 생성하고 실행하기 - 업캐스팅
		TimerThread th = new TimerThread(timerLabel);

		// run()을 실행하기 위해서 start() 호출
		th.start();

		System.out.println("메인 >>> " + this.getName());

		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 타이머가 일시 중지하도록 Thread 객체에 요청 한다
				synchronized (this) {
					th.stopTimer();
				}

			}
		});

		playBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 타이머가 재실행 하도록 Thread 객체에 요청 한다
				th.restart();
			}
		});

	}

	public static void main(String[] args) {
		new ThreadTimerEx_2().setVisible(true);
	}

}
