import javax.swing.*;
public class user {
   int index[]= {0,0,0,0,0,0,0,0,0};
   JFrame frame = new JFrame();
   public int resetindex(int index[]){
	   for(int a=0; a<9; a++) {
		   index[a] = 0;
	   }
	   return 0;
   }
   public boolean userInput(int usrNum, int buttonNum) {
	  if(index[buttonNum]!=0) {
         return false;
      }
      index[buttonNum]=usrNum;
      return true;
   }
   public int checkWinCondition() {
      if(diff3()!=0) {
         return diff3();
      }
      else if(diff1()!=0) {
         return diff1();
      }
      else if(diffOther()!=0) {
         return diffOther();
      }
      for(int i=0; i<9; i++) {
    	  if(index[i]==0) {
    		  return 0;
    	  }
      }
      return 3;
   }
   void showMessage(int num) {
	   if(num==1) JOptionPane.showMessageDialog(frame, "Pikachu Win!!!");
	   else if(num==2) JOptionPane.showMessageDialog(frame, "Bonobono Win!!!");
	   else if(num==3) JOptionPane.showMessageDialog(frame, "--- Tie ---");
   }
   private int diff3() {
      for(int i=0; i<3; i++) {
         if(index[i]!=0&&index[i]==index[i+3]&&index[i+3]==index[i+6])
            return index[i];
      }
      return 0;
   }
   private int diff1() {
      for(int i=0; i<8; i+=3) {
  	   	  if(index[i]!=0&&index[i]==index[i+1]&&index[i+1]==index[i+2])
  	   		  return index[i];
      }
      return 0;
   }
   private int diffOther() {
      if(index[0]==index[4]&&index[4]==index[8])
         return index[0];
      if(index[2]==index[4]&&index[4]==index[6])
         return index[2];
      return 0;
   }  
}