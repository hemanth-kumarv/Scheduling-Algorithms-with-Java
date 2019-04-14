import java.util.*;
public class index {

	public static void main(String args[]) {
		int g = 0;
		float wt[] = new float[4];
		Scanner s = new Scanner(System.in);
		int f = 0;

		System.out.println("Enter the Number of Processes");
		int n = s.nextInt();
		String process[] = new String[n];
		int burst_time[] = new int[n];
		int arrival_time[] = new int[n];

		System.out.println("Enter the Burst Time of the Processes");
		for (int i = 0; i < n; i++) {
			burst_time[i] = s.nextInt();
		}

		System.out.println("Enter the Arrival Time of the Processes");
		for (int i = 0; i < n; i++) {
			int c = i + 1;
			arrival_time[i] = s.nextInt();
			process[i] = "P" + c;
		}

		while (f < 4) {
			System.out.println("\nEnter\n1.FCFS\n2.Round Robin\n3.SJF\n");
			int c = s.nextInt();
			switch (c) {
			case 1:
				fcfs obj1 = new fcfs();
				wt[c] = obj1.findavgTime(process, n, burst_time, arrival_time);
				g++;
				break;
				
			case 2:
				roundrobin obj2 = new roundrobin();
				System.out.println("Enter the quantum time");
				int q = s.nextInt();
				wt[c] = obj2.roundRobin(process, n, burst_time, arrival_time, q);
				g++;
				break;
				
			case 3:
				sjf obj3 = new sjf();
				wt[c] = obj3.findavgTime(process, n, burst_time, arrival_time);
				g++;
				break;
				
			default:
				System.out.println("Program terminated!");
				f = 4;
			}
		}

		if (g == 3) {
			System.out.println("\nWaiting time of:");
			System.out.println("FCFS: " + wt[1]);
			System.out.println("Round Robin: " + wt[2]);
			System.out.println("SJF: " + wt[3]);
			
			float min = Float.MAX_VALUE;
			int fa = 5;
			for (int i = 1; i <= 3; i++) {
				if (wt[i] < min) {
					min = wt[i];
					fa = i;
				}
			}
			
			String ip = "";
			for (int i = 1; i <= 3; i++)
				if (wt[fa] == wt[i])
					ip += i;

			if (ip.length() == 1) {
				System.out.print("\nThe best technique is ");
				Printing((int) ip.charAt(0) - 48, wt);
				System.out.println();
			} 
			
			else {
				System.out.print("\nThe best techniques are ");
				for (int i = 0; i < ip.length() - 1; i++) {
					Printing((int) ip.charAt(i) - 48, wt);
					System.out.print(", ");
				}
				System.out.print("and ");
				Printing((int) ip.charAt(ip.length() - 1) - 48, wt);
			}
		}

		else {
			System.out.println("All three methods are not executed. Execute all three to show the best technique.");
		}
		s.close();
	}

	static void Printing(int n, float wt[]) {
		switch (n) {
		case 1:
			System.out.print("FCFS ( Average waiting time: " + wt[n] + " )");
			break;
		case 2:
			System.out.print("Round Robin ( Average waiting time: " + wt[n] + " )");
			break;
		case 3:
			System.out.print("SJF ( Average waiting time: " + wt[n] + " )");
			break;
		}
	}
}
