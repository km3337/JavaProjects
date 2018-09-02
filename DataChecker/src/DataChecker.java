
public class DataChecker {

	public static void main(String[] args) {
		int teamName, amtWin, amtLose;
		
		

	}
	
	
	public int getTotalGames(int amtWin, int amtLose) 
	{
		return amtWin+amtLose;
	}
	
	public int getRemainingGames(int amtWin,int amtLose) 
	{
		return (25-getTotalGames(amtWin,amtLose));
	}
	
	public double getAvg(int amtWin,int amtLose) 
	{
		return (double)(amtWin)/(double)(amtLose);
	}
}
