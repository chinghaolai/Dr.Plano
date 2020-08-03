import java.util.Random;

public class RandomDate {
	public int[][] get_random_datetime(int[] rangeMin, int[] rangeMax, int num){
		Random r = new Random();
		int[][] random_date = new int[num][6];
		for (int i=0; i<num; i++) {
			for (int j=0; j<6; j++) {
				random_date[i][j] = (int) Math.round((double)rangeMin[j] + ((double)rangeMax[j] - (double)rangeMin[j]) * r.nextDouble());
			}
		}
		return random_date;
	}
}
