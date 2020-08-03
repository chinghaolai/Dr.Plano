import java.util.Random;

public class RandomValues {

	public RandomValues() {
		// TODO Auto-generated constructor stub
	}
	public double[] get_random_values(int rangeMin, int rangeMax, int num){
		Random r = new Random();
		double[] randomValues = new double[num];
		for (int i=0; i<randomValues.length; i++) {
			randomValues[i] = (double)rangeMin + ((double)rangeMax - (double)rangeMin) * r.nextDouble();
		}
		return randomValues;
	}
}
