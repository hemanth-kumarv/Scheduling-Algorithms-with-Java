public class roundrobin {
	public float roundRobin(String pid[], int num, int b[], int a[], int n) {
		int res = 0;
		int resc = 0;

		int res_x[] = new int[num];
		int res_y[] = new int[num];

		for (int i = 0; i < num; i++) {
			res_y[i] = b[i];
			res_x[i] = a[i];
		}

		int t = 0;
		int w[] = new int[num];
		int ttime[] = new int[num];

		while (true) {
			boolean flag = true;
			for (int i = 0; i < num; i++) {
				if (res_x[i] <= t) {
					if (res_x[i] <= n && res_y[i] > 0) {
						flag = false;
						if (res_y[i] > n) {

							t = t + n;
							res_y[i] = res_y[i] - n;
							res_x[i] = res_x[i] + n;
						}

						else {
							t = t + res_y[i];
							ttime[i] = t - a[i];

							w[i] = t - b[i] - a[i];
							res_y[i] = 0;
						}

					}

					else if (res_x[i] > n) {
						for (int j = 0; j < num; j++) {
							if (res_x[j] < res_x[i] && res_y[j] > 0) {
								flag = false;
								if (res_y[j] > n) {
									t = t + n;
									res_y[j] = res_y[j] - n;
									res_x[j] = res_x[j] + n;
								} else {
									t = t + res_y[j];
									ttime[j] = t - a[j];
									w[j] = t - b[j] - a[j];
									res_y[j] = 0;
								}

							}
						}

						if (res_y[i] > 0) {
							flag = false;

							if (res_y[i] > n) {
								t = t + n;
								res_y[i] = res_y[i] - n;
								res_x[i] = res_x[i] + n;
							}

							else {
								t = t + res_y[i];
								ttime[i] = t - a[i];
								w[i] = t - b[i] - a[i];
								res_y[i] = 0;
							}
						}
					}
				} else if (res_x[i] > t) {
					t++;
					i--;
				}
			}

			if (flag)
				break;
		}

		System.out.println("Processes " + " Arrival Time " + " Burst Time " + " Waiting Time " + " Turn Around Time");
		for (int i = 0; i < num; i++) {
			System.out.println(pid[i] + "\t\t" + a[i] + "\t\t" + b[i] + "\t\t" + w[i] + "\t\t" + ttime[i]);

			res = res + w[i];
			resc = resc + ttime[i];
		}

		System.out.println("Average waiting time = " + (float) res / num);
		System.out.println("Average turn around time = " + (float) resc / num);
		return (float) res / num;
	}
}
