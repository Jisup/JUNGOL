import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Data{
	int fs;
	int se;
	Data(int fs, int se) {
		this.fs=fs;
		this.se=se;
	}
}
public class _1828_냉장고 {
	static ArrayList<Data> ref = new ArrayList<Data>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			ref.add(new Data(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(ref, (o1, o2)->o1.se!=o2.se ? o1.se-o2.se : o1.fs-o2.fs);
		int low = ref.get(0).fs;
		int high = ref.get(0).se;
		int refrigerator = 1;
		for(int i=1;i<N;i++) {
			int fs = ref.get(i).fs;
			int se = ref.get(i).se;
			//왜 첫번쨰 수부터 정렬했을까
			if (fs > high) {
				low = fs;
				high=se;
				refrigerator++;
			}		
		}
		System.out.println(refrigerator);
	}
}