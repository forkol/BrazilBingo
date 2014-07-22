package com.brazilbingo.game;


public class BrazilBingo {

	public static void main(String[] args) {
		
//		BingoBallMachine bingoBallMachine = new BingoBallMachine();
//		
//		while (!bingoBallMachine.isEmpty())
//		{
//			System.out.println(bingoBallMachine.getBall());
//		}
		
		PlayerCardGenerator playerCardGenerator = new PlayerCardGenerator();
		
		int[][] aPlayerCard = playerCardGenerator.genFullCard();
		
		for(int row=0; row < playerCardGenerator.NUMROWS; row++)
		{
			System.out.printf("%02d %02d %02d %02d %02d %02d %02d %02d %02d\n",
					aPlayerCard[row][0],
					aPlayerCard[row][1],
					aPlayerCard[row][2],
					
					aPlayerCard[row][3],
					aPlayerCard[row][4],
					aPlayerCard[row][5],
					
					aPlayerCard[row][6],
					aPlayerCard[row][7],
					aPlayerCard[row][8]);
		}
		//System.out.println("BrazilBingo.main()");
		
	}	
}
