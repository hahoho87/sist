package view;

import java.awt.Image;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class ButtonListener1 implements ActionListener {
	SeatReserve seat = new SeatReserve();
	TimeSelect time = new TimeSelect();

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(">> 1번 영화 선택 완료");
		System.out.println("-----------------------------");
//		seat.main();
		time.list1(1);
	}

}// END class ButtonListener

class ButtonListener2 implements ActionListener {
	SeatReserve seat = new SeatReserve();
	TimeSelect time = new TimeSelect();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(">> 2번 영화 선택 완료");
		System.out.println("-----------------------------");
//		seat.main();
		time.list1(2);
	}

}// END class ButtonListener

class ButtonListener3 implements ActionListener {
	SeatReserve seat = new SeatReserve();
	TimeSelect time = new TimeSelect();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(">> 3번 영화 선택 완료");
		System.out.println("-----------------------------");
//		seat.main();
		time.list1(3);
	}

}// END class ButtonListener

class MovieFrame extends JFrame {
	public MovieFrame() {
		this.setSize(1300, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("쌍용 영화관 상영작");

		this.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("영화를 선택한 후 버튼을 눌러주세요");
		label.setForeground(new Color(65, 105, 225));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("돋움", Font.BOLD, 15));
		label.setBounds(80, 10, 265, 67);
		panel.add(label);
		
		
		JButton button1 = new JButton("1번");
		JButton button2 = new JButton("2번");
		JButton button3 = new JButton("3번");
		button1.addActionListener(new ButtonListener1());
		button2.addActionListener(new ButtonListener2());
		button3.addActionListener(new ButtonListener3());
		
		ImageIcon image1 = new ImageIcon("avengersEnd.jpg");
		ImageIcon image2 = new ImageIcon("money.jpg");
		ImageIcon image3 = new ImageIcon("us.jpg");
		JLabel labelImage1 = new JLabel(image1);
		JLabel labelImage2 = new JLabel(image2);
		JLabel labelImage3 = new JLabel(image3);
		
		this.add(label, BorderLayout.NORTH);
		panel.add(labelImage1, BorderLayout.CENTER);
		panel.add(labelImage2, BorderLayout.CENTER);
		panel.add(labelImage3, BorderLayout.CENTER);
		
		this.add(button1, BorderLayout.SOUTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.SOUTH);
		
		this.add(panel);

		this.setVisible(true);
		this.setResizable(false);
	}
}

public class MovieSelect {
	public static void main() {
		System.out.println("-----------------------------");
		System.out.println("팝업창을 참고해 영화를 선택해주세요.");
		System.out.println("-----------------------------");
		MovieFrame f = new MovieFrame();
		new ButtonListener1();
		new ButtonListener2();
		new ButtonListener3();
	}
}










