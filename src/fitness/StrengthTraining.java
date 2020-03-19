package fitness;

public class StrengthTraining extends Activity {

	private static int totalStrengthCalories;
	private static double totalStrengthHRInc;

	public StrengthTraining() {
		super();
	}

	public static int getTotalStrengthCalories() {
		return totalStrengthCalories;
	}

	public static double getTotalStrengthHRInc() {
		return totalStrengthHRInc;
	}

	@Override
	public void calcCaloriesBurnt(int time) {
		activityCalories = 0;
		activityCalories = activityCalories + time * 5;
		caloriesBurnt += activityCalories;
		totalStrengthCalories += activityCalories;
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
		totalStrengthHRInc += activityHeartRateInc;
	}

}