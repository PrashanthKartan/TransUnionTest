public class StudentMarks {

	public static void main(String[] args) {
		int students = 3;
		int marks = 5;
		int[][] arr2d = { { 75, 76, 65, 87, 87 }, { 78, 76, 68, 56, 89 }, { 67, 87, 78, 77, 65 } };
		System.out.println(getTotalMarks(students, marks, arr2d));
	}

	private static int[] getTotalMarks(int students, int marks, int[][] arr2d) {
		int[] avg = new int[marks];
		int[] totalArr = new int[students];
		int lowAvgindex = 0;
		int low = 0;
		for (int countOne = 0; countOne < arr2d.length; countOne++) {
			for (int countTwo = 0; countTwo < arr2d[countOne].length; countTwo++) {
				avg[countTwo] = avg[countTwo] + arr2d[countOne][countTwo];
			}
		}
		for (int i = 0; i < avg.length; i++) {
			avg[i] = avg[i] / students;
			if (low == 0 || low >= avg[i]) {
				low = avg[i];
				lowAvgindex = i;
			}
		}

		for (int countOne = 0; countOne < arr2d.length; countOne++) {
			for (int countTwo = 0; countTwo < arr2d[countOne].length; countTwo++) {
				if (countTwo != lowAvgindex) {
					totalArr[countOne] = totalArr[countOne] + arr2d[countOne][countTwo];
				}
			}
		}
		totalArr = sortInDecendingOrder(totalArr);
		return totalArr;
	}

	public static int[] sortInDecendingOrder(int[] input) {
		int last = input.length - 1;
		int middle = input.length / 2;
		for (int i = 0; i <= middle; i++) {
			int temp = input[i];
			input[i] = input[last - i];
			input[last - i] = temp;
		}
		return input;
	}

}
