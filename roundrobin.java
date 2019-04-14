public class roundrobin {
	public float roundRobin(String pid[], int num, int b[], int a[], int n) {
		int res = 0;
		int resc = 0;

		int res_a[] = new int[num];
		int res_b[] = new int[num];

		for (int i = 0; i < num; i++) {
			res_b[i] = b[i];
			res_a[i] = a[i];
		}

		int t = 0;
		int w[] = new int[num];
		int ttime[] = new int[num];

		while (true) {
			boolean flag = true;
			for (int i = 0; i < num; i++) {
				if (res_a[i] <= t) {
					if (res_a[i] <= n && res_b[i] > 0) {
						flag = false;
						if (res_b[i] > n) {

							t = t + n;
							res_b[i] = res_b[i] - n;
							res_a[i] = res_a[i] + n;
						}

						else {
							t = t + res_b[i];
							ttime[i] = t - a[i];

							w[i] = t - b[i] - a[i];
							res_b[i] = 0;
						}

					}

					else if (res_a[i] > n) {
						for (int j = 0; j < num; j++) {
							if (res_a[j] < res_a[i] && res_b[j] > 0) {
								flag = false;
								if (res_b[j] > n) {
									t = t + n;
									res_b[j] = res_b[j] - n;
									res_a[j] = res_a[j] + n;
								} else {
									t = t + res_b[j];
									ttime[j] = t - a[j];
									w[j] = t - b[j] - a[j];
									res_b[j] = 0;
								}

							}
						}

						if (res_b[i] > 0) {
							flag = false;

							if (res_b[i] > n) {
								t = t + n;
								res_b[i] = res_b[i] - n;
								res_a[i] = res_a[i] + n;
							}

							else {
								t = t + res_b[i];
								ttime[i] = t - a[i];
								w[i] = t - b[i] - a[i];
								res_b[i] = 0;
							}
						}
					}
				} else if (res_a[i] > t) {
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
