class Solution {
	public long solution(int price, long money, int count) {
		long current_price;
		for (int i=1; i<=count; i++) {
			current_price = price * i;
			money -= current_price;
		}
		if (money > 0)
			return (0);
		return (-money);
	}
}
