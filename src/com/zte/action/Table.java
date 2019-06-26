package com.zte.action;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Table {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static boolean hand;
	public static void main(String[] args) {
		Random r = new Random();
		int i = r.nextInt(2);
		
		if(i == 0){
			hand = true;
		}else{
			hand = false;
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}
	
	private MyJLable[][] cheesMap = 
		    {
		    {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
			};
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(700, 900);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(25, 25));
		
		
		for(int i = 0;   i< 625; i++){
			MyJLable lab = new MyJLable("+",i);
			lab.setHorizontalAlignment(JLabel.CENTER);
			lab.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 获得 选中的 棋子位置
					MyJLable my = (MyJLable)e.getSource();
					// 先验证  该位置上是否有棋子
					int pos = my.getCurrentNo();
					int y = pos / 25; // 在第几行
					int x = pos % 25; // 在第几列
					MyJLable fromMap = cheesMap[y][x];
					if(fromMap != null){
						// 该点上已经有棋子  
						return;
					}
					
					// 清空棋子位置上的内容
					my.setText("");
					// 落子
					if(hand){
						// 白子
						my.setIcon(new ImageIcon(Table.class.getResource("/").getFile()+"white.png"));
						my.setType("W");
						hand = false;
					}else{
						// 黑子
						my.setIcon(new ImageIcon(Table.class.getResource("/").getFile()+"black.png"));
						my.setType("B");
						hand = true;
					}
					// 记录棋子的位置
					cheesMap[y][x] = my;
					// 计算
					boolean back = calCheesSize(my, x, y);
					
					if(back == true){
						System.out.println("Congratulation");
					}
				}
			});	
			frame.getContentPane().add(lab);
		}		
	}
	
	private boolean calCheesSize(MyJLable chees, int col, int row){
		int count = 1;
		// 1. 先算上面 
		int i = 1;
		while(row > 0&&row>=i){
			int x = row - i;
			MyJLable ch = cheesMap[x][col];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
			
		}
		// 2. 算下面
		i = 1;
		while(row < 24&&row+i<25){
			int x = row + i;
			MyJLable ch = cheesMap[x][col];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		
		
		
		count = 1;
		// 3. 右上斜
		i = 1;
		while(row >0&&col<24&&col+i<25){
			int x = row - i;
			int y = col + i;
			MyJLable ch = cheesMap[x][y];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		// 4. 左下斜
		i = 1;
		while(row <24&&col>0&&row+i<25&&col-i>0){
			int x = row + i;
			int y = col - i;
			MyJLable ch = cheesMap[x][y];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		
		count = 1;
		// 5. 左面
		i = 1;
		while(col > 0&&col>=i){
			int y = col - i;
			MyJLable ch = cheesMap[row][y];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		// 6. 右面
		i = 1;
		while(col <24&&col+i<25){
			int y = col + i;
			MyJLable ch = cheesMap[row][y];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		count = 1;
		// 7. 右下斜
		i = 1;
		while(row <24&&col+i<25&&row+i<25&&col<24){
			int x = row + i;
			int y = col + i;
			MyJLable ch = cheesMap[x][y];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		// 8. 左上斜
		i = 1;
		while(row >0&&col>0&&row-i>0&&col-i>0){
			int x = row - i;
			int y = col - i;
			MyJLable ch = cheesMap[x][y];
			if(ch == null || ch.getType().equals(chees.getType()) == false){
				break;
			}
			count++;
			i++;
			if(count == 5){
				// 已经满足 5子条件
				System.out.println("游戏结束");
				if(chees.getType().equals("B")) {
					JOptionPane.showMessageDialog(null,"黑棋胜");
				}else {
					JOptionPane.showMessageDialog(null,"白棋胜");
				}
				return true;
			}
		}
		return false;
	}

}
