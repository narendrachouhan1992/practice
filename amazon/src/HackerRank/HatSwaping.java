package HackerRank;

public class HatSwaping {
//	void calc(vector<int> q)
//	{
//	    int ans = 0;
//	    for (int i = q.size() - 1; i >= 0; i--) {
//	        if (q[i] - (i + 1) > 2) {
//	            cout << "Too chaotic" << endl;
//	            return;
//	        }
//	        for (int j = max(0, q[i] - 2); j < i; j++)
//	            if (q[j] > q[i]) ans++;
//	    }
//	    cout << ans << endl;
//	}
	static void minimumBribes(int[] q) {
		int ans = 0;
		for (int i = q.length - 1; i >= 0; i--) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Integer.max(0, q[i] - 2); j < i; j++)
				if (q[j] > q[i])
					ans++;
		}
		System.out.println(ans);
	}

}
