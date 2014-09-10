package DynamicProgramming;

public class MaxCoins {
	int[] coins;
	int[] min;
	int sum;
	
	MaxCoins(int[] cns, int sm){
		this.coins = cns;
		this.sum = sm;
		this.min = new int[sm+1];
		
		min[0] = 0;
		for(int i=1;i<this.min.length;i++)
			min[i] = this.sum + 1;
	}
	
	void calculate(){
		for(int i=0; i<this.sum+1;i++){
			for(int j=0;j<this.coins.length;j++){
				if((coins[j]<=i) && (this.min[i-coins[j]]+1 < this.min[i]) )
					   min[i] = min[i-coins[j]]+1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] coins = new int[]{1, 5,10,25,100};
		int sum = 274;
		
		MaxCoins mc = new MaxCoins(coins, sum);
		mc.calculate();
		//for(int i=0;i<=sum;i++){
		System.out.println("For "+(double)sum/100+" Dollars we atleast need "+mc.min[sum]+" coins");
//		}
	}

}
