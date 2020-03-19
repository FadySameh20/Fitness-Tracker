package fitness;

public class Running extends Activity {

	private static int totalRunCalories;
	private static double totalRunHRInc;

	public Running() {
		super();
	}

	public static int getTotalRunCalories() {
		return totalRunCalories;
	}

	public static double getTotalRunHRInc() {
		return totalRunHRInc;
	}

	@Override
	public void calcCaloriesBurnt(int time) {
		activityCalories = 0;
		activityCalories = activityCalories + time * 5;
		caloriesBurnt += activityCalories;
		totalRunCalories += activityCalories;
	}

	@Override
	public void calcHeartRate(int time, double rateIncrease) {
		activityHeartRate = activityHeartRate + (activityHeartRate * time * rateIncrease);
		calcHeartRateInc();
	}

	private void calcHeartRateInc() {
		activityHeartRateInc = 0;
		activityHeartRateInc = activityHeartRate - heartRate;
		heartRate += activityHeartRateInc;
		totalRunHRInc += activityHeartRateInc;
	}

}