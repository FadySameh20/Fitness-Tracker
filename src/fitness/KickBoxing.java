package fitness;

public class KickBoxing extends Activity {
	
	private static int totalKbCalories;
	private static double totalKbHRInc;

	public KickBoxing() {
		super();
	}

	public static int getTotalKbCalories() {
		return totalKbCalories;
	}

	public static double getTotalKbHRInc() {
		return totalKbHRInc;
	}

	@Override
	public void calcCaloriesBurnt(int time) {
		activityCalories = 0;
		activityCalories = activityCalories + time * 3;
		caloriesBurnt += activityCalories;
		totalKbCalories += activityCalories;
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
		totalKbHRInc += activityHeartRateInc;
	}

}