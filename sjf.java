public class sjf {
	static void findWaitingTime(String pid[], int bt[], int art[], int n, int wt[]) {
		int rt[] = new int[n];

		for (int i = 0; i < n; i++)
			rt[i] = bt[i];

		int done = 0, t = 0, minm = Integer.MAX_VALUE;
		int min = 0, time;
		boolean check = false;

		while (done != n) {

			for (int j = 0; j < n; j++) {
				if ((art[j] <= t) && (rt[j] < minm) && rt[j] > 0) {
					minm = rt[j];
					min = j;
					check = true;
				}
			}

			if (check == false) {
				t++;
				continue;
			}

			rt[min]--;
			minm = rt[min];
			if (minm == 0)
				minm = Integer.MAX_VALUE;

			if (rt[min] == 0) {

				done++;
				check = false;
				time = t + 1;

				wt[min] = time - bt[min] - art[min];

				if (wt[min] < 0)
					wt[min] = 0;
			}
			t++;
		}
	}

	static void findTurnAroundTime(String pid[], int bt[], int art[], int n, int wt[], int tat[]) {
		for (int i = 0; i < n; i++)
			tat[i] = bt[i] + wt[i];
	}

	float findavgTime(String pid[], int n, int bt[], int art[]) {
		int wt[] = new int[n], tat[] = new int[n];
		int total_wt = 0, total_tat = 0;

		findWaitingTime(pid, bt, art, n, wt);
		findTurnAroundTime(pid, bt, art, n, wt, tat);

		System.out.println("Processes " + "Arrival Time " + " Burst Time " + " Waiting Time " + " Turn Around Time");

		for (int i = 0; i < n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(pid[i] + "\t\t" + art[i] + "\t\t " + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
		}

		System.out.println("Average waiting time = " + (float) total_wt / n);
		System.out.println("Average turn around time = " + (float) total_tat / n);
		return (float) total_wt / n;
	}
}
