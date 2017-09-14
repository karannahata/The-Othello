package Process;

public class BoardOperations {
	int board[][];
	int turn,nextTurn;
	int count1,count2;
	
	public BoardOperations(){

		board=new int[8][8];
		
		board[3][3]=2;
		board[3][4]=1;
		board[4][3]=1;
		board[4][4]=2;
		
		board[2][3]=3;
		board[3][2]=3;
		board[4][5]=3;
		board[5][4]=3;
		
		count1=2;
		count2=2;
		
		turn=1;
		nextTurn=2;
	}
	
	public int[][] getBoard(){
		return board;
	}
	
	public int getTurn(){
		return turn;
	}
	
	
	public void updateBoard(int i, int j) {
		board[i][j]=turn;
		for(int k=0;k<8;k++){
			for(int l=0;l<8;l++){
				if(board[k][l]==3){
					board[k][l]=0;
				}
			}
		}
		diceChange(i,j);
		turnSwap();
		hint();
	}
	
	
	private void diceChange(int i, int j) {
		if(j<7 && board[i][j+1]==nextTurn){
			int k=j+1;
			if(LR(i,j+2)){
				while(board[i][k]!=turn){
					board[i][k]=turn;
					k++;
				}
			}
		}
		if(j>0 && board[i][j-1]==nextTurn){
			int k=j-1;
			if(RL(i,j-2)){
				while(board[i][k]!=turn){
					board[i][k]=turn;
					k--;
				}
			}
		}
		if(i<7 && board[i+1][j]==nextTurn){
			int k=i+1;
			if(TD(i+2,j)){
				while(board[k][j]!=turn){
					board[k][j]=turn;
					k++;
				}
			}
		}
		if(i>0 && board[i-1][j]==nextTurn){
			int k=i-1;
			if(DT(i-2,j)){
				while(board[k][j]!=turn){
					board[k][j]=turn;
					k--;
				}
			}
		}
		if(i<7 && j<7 && board[i+1][j+1]==nextTurn){
			int k=i+1,l=j+1;
			if(D1(i+2,j+2)){
				while(board[k][l]!=turn){
					board[k][l]=turn;
					k++;
					l++;
				}
			}
		}
		if(i>0 && j>0 && board[i-1][j-1]==nextTurn){
			int k=i-1,l=j-1;
			if(D2(i-2,j-2)){
				while(board[k][l]!=turn){
					board[k][l]=turn;
					k--;
					l--;
				}
			}
		}
		
		if(i<7 && j>0 && board[i+1][j-1]==nextTurn){
			int k=i+1,l=j-1;
			if(D3(i+2,j-2)){
				while(board[k][l]!=turn){
					board[k][l]=turn;
					k++;
					l--;
				}
			}
		}
		
		if(j<7 && i>0 && board[i-1][j+1]==nextTurn){
			int k=i-1,l=j+1;
			if(D4(i-2,j+2)){
				while(board[k][l]!=turn){
					board[k][l]=turn;
					k--;
					l++;
				}
			}
		}
	}

	public void hint(){
		int flag=0;
		count1=0;count2=0;
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(board[i][j]==1){
						count1++;
					}
					if(board[i][j]==2){
						count2++;
					}
					if(j>0 && j<7){
						if(board[i][j]==nextTurn){
							if(board[i][j-1]==0 && LR(i,j+1)){
								flag=1;
								board[i][j-1]=3;
							}
							if(board[i][j+1]==0 && RL(i,j-1)){
								flag=1;
								board[i][j+1]=3;
							}
						}
					}
					if(i>0 && i<7){
						if(board[i][j]==nextTurn){
							if(board[i-1][j]==0 && TD(i+1,j)){
								flag=1;
								board[i-1][j]=3;
							}
							if(board[i+1][j]==0 && DT(i-1,j)){
								flag=1;
								board[i+1][j]=3;
							}
						}
					}
					if(i>0 && j>0 && j<7 && i<7){
						if(board[i][j]==nextTurn){
							if(board[i-1][j-1]==0 && D1(i+1,j+1) ){
								flag=1;
								board[i-1][j-1]=3;
							}
							if(board[i+1][j+1]==0 && D2(i-1,j-1)){
								flag=1;
								board[i+1][j+1]=3;
							}
							if(board[i-1][j+1]==0 && D3(i+1,j-1)){
								flag=1;
								board[i-1][j+1]=3;
							}
							if(board[i+1][j-1]==0 && D4(i-1,j+1)){
								flag=1;
								board[i+1][j-1]=3;
							}
						}
						
					}
				}
			}
			if(flag==0){
				turnSwap();
			}
		
	}

	private void turnSwap() {
		int t= turn;
		turn=nextTurn;
		nextTurn=t;
	}

	private boolean DT(int i, int j) {
		while(i>=0){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			i--;
		}
		return false;
	}
	
	private boolean TD(int i, int j) {
		while(i<8){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			i++;
		}
		return false;
	}
	
	private boolean RL(int i, int j) {
		while(j>=0){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			j--;
		}
		return false;
	}

	private boolean LR(int i, int j) {
			while(j<8){
				if(board[i][j]==0 || board[i][j]==3)
					return false;
				if(board[i][j]==turn)
					return true;
				j++;
			}
		return false;
	}
	
	private boolean D1(int i, int j){
		while(i<8 && j<8){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			i++;
			j++;
		}
		return false;
	}
	
	private boolean D2(int i, int j){
		while(i>=0 && j>=0){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			i--;
			j--;
		}
		return false;
	}
	
	private boolean D3(int i, int j){
		while(i<8 && j>=0){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			i++;
			j--;
		}
		return false;
	}
	
	private boolean D4(int i, int j){
		while(j<8 && i>=0){
			if(board[i][j]==0 || board[i][j]==3)
				return false;
			if(board[i][j]==turn)
				return true;
			j++;
			i--;
		}
		return false;
	}
	
	
	public int countP1() {
		return count1;
	}
	
	public int countP2() {
		return count2;
	}
	
	public int winCase(){
		int sum= count1+count2;
		if(sum==64){
			return 1;
		}
		return 0;
	}
	
}
