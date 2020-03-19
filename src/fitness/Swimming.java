package fitness;

public class Swimming extends Activity {

	private static int totalSwimCalories;
	private static double totalSwimHRInc;

	public Swimming() {
		super();
	}

	public static int getTotalSwimCalories() {
		return totalSwimCalories;
	}

	public static double getTotalSwimHRInc() {
		return totalSwimHRInc;
	}

	@Override
	public void calcCaloriesBurnt(int time) {
		activityCalories = 0;
		activityCalories = activityCalories + time * 4;
		caloriesBurnt += activityCalories;
		totalSwimCalories += activityCalories;
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
		totalSwimHRInc += activityHeartRateInc;
	}

}