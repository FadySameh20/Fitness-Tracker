package fitness;

public abstract class Activity {
	
	int activityCalories;
	double activityHeartRateInc;
	static double activityHeartRate;
	static int caloriesBurnt = 0;
	static double heartRate = 80;
	public static int caloriesArray[] = new int[4];
	public static double heartRateIncArray[] = new double[4];

	abstract void calcCaloriesBurnt(int time);

	abstract void calcHeartRate(int time, double rateIncrease);

    Activity() {
    	activityCalories = 0;
    	activityHeartRate = heartRate;
	}

	public static int getCaloriesBurnt() {
		return caloriesBurnt;
	}

	public static double getHeartRate() {
		return heartRate;
	}

	private static void swap(int i, int j) {
		int temp1;
		double temp2;
		temp1 = caloriesArray[i];
		caloriesArray[i] = caloriesArray[j];
		caloriesArray[j] = temp1;
		temp2 = heartRateIncArray[i];
		heartRateIncArray[i] = heartRateIncArray[j];
		heartRateIncArray[j] = temp2;
	}

	public static void sortActivity() {
		int i, j;
		setArrays();
		for (i = 0; i < caloriesArray.length - 1; i++) {
			for (j = i + 1; j < caloriesArray.length; j++) {
				if (caloriesArray[i] < caloriesArray[j]) {
					swap(i, j);
				} else if (caloriesArray[i] == caloriesArray[j]) {
					if (heartRateIncArray[i] < heartRateIncArray[j]) {
						swap(i, j);
					}
				}
			}
		}
	}

	private static void setArrays() {
		caloriesArray[0] = Swimming.getTotalSwimCalories();
		caloriesArray[1] = Running.getTotalRunCalories();
		caloriesArray[2] = KickBoxing.getTotalKbCalories();
		caloriesArray[3] = StrengthTraining.getTotalStrengthCalories();
		heartRateIncArray[0] = Swimming.getTotalSwimHRInc();
		heartRateIncArray[1] = Running.getTotalRunHRInc();
		heartRateIncArray[2] = KickBoxing.getTotalKbHRInc();
		heartRateIncArray[3] = StrengthTraining.getTotalStrengthHRInc();
	}

}