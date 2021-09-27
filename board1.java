//only for 1 player1
import java.awt.*;
import java.applet.*;
import java.awt.event.*;  
import java.util.*;
import javax.swing.*;
/*<applet code=board1 height=1600 width=1400></applet>*/
public class board1 extends Applet implements ActionListener
{
	int cell_position[][]=new int[101][3];
	Button b1;
	int n,player1=0;
	int snake[]=new int[]{98,84,50,56,87};
	int snake_move[]=new int[]{40,58,5,8,49};
	int ladder[]=new int[]{20,57,6,52};
	int ladder_move[]=new int[]{59,96,45,72};
	int c=0;
	public void paint(Graphics g)
	{
		int m=100;
		g.setColor(Color.WHITE);
		g.fillRect(0,0,1600,1000);
		setLayout(null);
	 	b1=new Button("DICE");
		add(b1);
		b1.setBounds(1200,100,50,20);
		b1.addActionListener(this);
		for(int i=0;i<650;i+=130)
		{
			for(int k=100;k<=1000;k+=100)
			{
				if(k%200==0)
					g.setColor(Color.YELLOW);
				else
					g.setColor(Color.RED);
				g.fillRect(k-100,i,100,65);
				g.setColor(Color.BLACK);
				String j=String.valueOf(m);
				g.drawString(j,k-50,i+45);
				m--;
			}
			for(int k=1000;k>=100;k-=100)
			{
				if(k%200!=0)
					g.setColor(Color.YELLOW);
				else
					g.setColor(Color.RED);
				g.fillRect(k-100,i+65,100,65);
				g.setColor(Color.BLACK);
				String j=String.valueOf(m);
				g.drawString(j,k-50,i+65+45);
				m--;
			}
		}
		for(int i=0;i<5;i++)
		{
			g.drawLine(cell_position[snake[i]][1],cell_position[snake[i]][2],cell_position[snake_move[i]][1],cell_position[snake_move[i]][2]);
		}
		for(int i=0;i<4;i++)
		{
			g.setColor(Color.BLUE);
			g.drawLine(cell_position[ladder[i]][1]-20,cell_position[ladder[i]][2],cell_position[ladder_move[i]][1]-20,cell_position[ladder_move[i]][2]);
			g.drawLine(cell_position[ladder[i]][1]+20,cell_position[ladder[i]][2],cell_position[ladder_move[i]][1]+20,cell_position[ladder_move[i]][2]);
		}
		g.drawRect(0,0,1000,650);
		for(int i=65;i<650;i+=65)
		{
			g.drawLine(0,i,1000,i);
			
		}
		for(int i=100;i<1000;i+=100)
		{
			g.drawLine(i,0,i,650);
		}
		if(player1>0)
		g.fillOval(cell_position[player1][1],cell_position[player1][2],25,25);
		String z=String.valueOf(n);
		g.drawString(z,1210,150);
		
	}
	public void init()
	{
		int m=100;
		for(int i=0;i<650;i+=130)
		{
			for(int k=100;k<=1000;k+=100)
			{
				String j=String.valueOf(m);
				cell_position[m][0]=m;
				cell_position[m][1]=k-50;
				cell_position[m][2]=i+45;
				m--;
			}
			for(int k=1000;k>=100;k-=100)
			{
				String j=String.valueOf(m);
				cell_position[m][0]=m;
				cell_position[m][1]=k-50;
				cell_position[m][2]=i+45+65;
				m--;
			}
		}
		
		/*for(int i=0;i<100;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(" "+cell_position[i][j]);
			}
			System.out.println();
		}*/
	}
			
	public void actionPerformed(ActionEvent e)
	{
		String x1=e.getActionCommand();
		Random r= new Random();
		n=r.nextInt(7-1)+1;
		System.out.println(n);
		update();
	}
	
	public void update()
	{	
		if(player1==0&&n==6 || player1>0)
		{
			/*if(player1==0&&n==6)
			{}
			else if(n==6)
			{}*/
			if(player1<100)
			{
				
				c=0;
				for(int i=0;i<snake.length;i++)
				if(snake[i]==player1+n)
				{
					player1=snake_move[i];
					c=1;
					break;
				}
				for(int i=0;i<ladder.length;i++)
				if(ladder[i]==player1+n)
				{
					
					player1=ladder_move[i];
					c=1;
					break;
				}
				if(c==0&&player1+n<=100){
				player1=player1+n;
				}
				repaint();
			}
			else
				System.out.println("You win");
		}
	}

}