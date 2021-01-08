public class CheckSeriesNextNumber {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 2, 3 };
		int length = arr.length;
		System.out.println(getNextNumber(length, arr));
	}

	private static int getNextNumber(int length, int[] arr) {
		int nextNumber = -999;
		int nextArthmetricNum = getArthmeticNextNumber(length, arr);
		int nextGeometricNum = getGeometricNextNumber(length, arr);
		int nextFibonacciNum = getFibonacciNextNumber(length, arr);
		if (nextArthmetricNum != -999) {
			return nextArthmetricNum;
		} else if (nextGeometricNum != -999) {
			return nextGeometricNum;
		} else if (nextFibonacciNum != -999) {
			return nextFibonacciNum;
		}
		return nextNumber;
	}

	private static int getArthmeticNextNumber(int length, int[] arr) {
		int nextNum = 0;
		try {
			if (length == 1) {
				return -999;
			}
			int diff = arr[1] - arr[0];
			for (int i = 2; i < arr.length; i++) {
				if (arr[i] - arr[i - 1] == diff) {
					nextNum = arr[i] + diff;
				} else {
					return -999;
				}
			}
		} catch (Exception e) {
			nextNum = -999;
		}

		return nextNum;
	}

	private static int getGeometricNextNumber(int length, int[] arr) {
		int nextNum = 0;
		try {
			if (length == 1) {
				return -999;
			}
			int ratio = arr[1] / (arr[0]);

			for (int i = 1; i < length; i++) {
				if ((arr[i] / (arr[i - 1])) == ratio) {
					nextNum = arr[i] * ratio;
				} else {
					return -999;
				}
			}
		} catch (Exception e) {
			nextNum = -999;
		}
		return nextNum;
	}

	private static int getFibonacciNextNumber(int length, int[] arr) {
		int nextNum = 0;
		try {
			if (length == 1 || length != arr.length) {
				return -999;
			}
			if (length == 2) {
				return arr[0] + arr[1];
			}
			for (int i = 2; i < arr.length; i++) {
				if ((arr[i - 1] + arr[i - 2]) == arr[i]) {
					nextNum = arr[i - 1] + arr[i];
				} else {
					return -999;
				}
			}
		} catch (Exception e) {
			nextNum = -999;
		}
		return nextNum;
	}
}
