import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class player extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	user pTic=new user();
	ai ai= new ai();
	int currentPlayer=1, aiNum=2, score1=0, score2=0;
	boolean needAI;
	JButton [] btn = new JButton [9];
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel(new BorderLayout());
	ImageIcon Bono = new ImageIcon(this.getClass().getResource("Bono.png"));
	ImageIcon Pika = new ImageIcon(this.getClass().getResource("Pikachu.png"));
	ImageIcon White = new ImageIcon(this.getClass().getResource("Whi.png"));
	JLabel copyright = new JLabel("Copyright(c) Euncharming & Wind");
	JLabel score = new JLabel("         Pikachu: "+score1+" vs "+"Bonobono: "+score2);
	public player(JPanel panelC, boolean plymode) {
		for(int i=0; i < 9; i++){
			btn[i] = new JButton(i+"¹öÆ°");
			panelC.add(btn[i]);
			btn[i].setIcon(White);
			btn[i].addActionListener(this);	
		}
		panel1.add(copyright);
		panel2.add(score);
		panelC.add(panel1, "South");
		panelC.add(panel2, "South");
		needAI=plymode;
	}
	private void resetButton() {
		for(int i=0; i < 9; i++){
			btn[i].setIcon(White);
		}
	}
	private void toggleCurrentPlayer(int i) {
	 	if(currentPlayer==1) btn[i].setIcon(Pika);
	   	else if(currentPlayer==2) btn[i].setIcon(Bono);  
	  	if(currentPlayer==1) currentPlayer=2;
	  	else if(currentPlayer==2) currentPlayer=1;
	}	
	@Override
	public void actionPerformed(ActionEvent e){
		if(pTic.checkWinCondition()!=0) {
			if(pTic.checkWinCondition()==1) score1++;
			else if (pTic.checkWinCondition()==2) score2++;
			score.setText("         Pikachu: "+score1+" vs "+"Bonobono: "+score2);
			resetButton();
			pTic.resetindex(pTic.index);
			aiTurn();
			return;
		}
		int i;
		for(i=0; i<9; i++) {
			if(e.getSource().equals(btn[i])) 
				break;
		}
		if(pTic.userInput(currentPlayer, i)) toggleCurrentPlayer(i);	
		if(pTic.checkWinCondition()!=0) {
			pTic.showMessage(pTic.checkWinCondition());			
			return;
		}
		  aiTurn();
		  if(pTic.checkWinCondition()!=0) pTic.showMessage(pTic.checkWinCondition());	
	}
	private void aiTurn() {
		   if(!needAI) return;
		   int aiChoice=ai.isItMe(currentPlayer, pTic.index, aiNum);
			  if(aiChoice!=-1) {
				  pTic.userInput(aiNum, aiChoice);
				  toggleCurrentPlayer(aiChoice);
		      }   
	   }
}