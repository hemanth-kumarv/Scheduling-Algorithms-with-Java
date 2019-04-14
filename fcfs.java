public class fcfs {
	static void findWaitingTime(String proc[], int n, int bt[], int wt[], int at[]) {
		int service_time[] = new int[n];
		service_time[0] = 0;
		wt[0] = 0;

		for (int i = 1; i < n; i++) {
			service_time[i] = service_time[i - 1] + bt[i - 1];

			wt[i] = service_time[i] - at[i];
			if (wt[i] < 0)
				wt[i] = 0;
		}
	}

	static void findTurnAroundTime(String proc[], int n, int bt[], int wt[], int tat[]) {
		for (int i = 0; i < n; i++)
			tat[i] = bt[i] + wt[i];
	}

	float findavgTime(String proc[], int n, int bt[], int at[]) {
		int wt[] = new int[n], tat[] = new int[n];

		findWaitingTime(proc, n, bt, wt, at);
		findTurnAroundTime(proc, n, bt, wt, tat);

		System.out.print("Processes " + " Arrival Time " + " Burst Time " + " Waiting Time " + " Turn Around Time \n");
		int total_wt = 0, total_tat = 0;
		for (int i = 0; i < n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(proc[i] + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t " + tat[i]);
		}

		System.out.println("Average waiting time = " + (float) total_wt / n);
		System.out.println("Average turn around time = " + (float) total_tat / n);
		return (float) total_wt / n;
	}
}
