package java_32_h05;

public class MyArrayList {
	private int[] arr;
	private int size;

	public static void main(String[] args) {
		MyArrayList myArrayList = new MyArrayList();
		for (int i = 0; i < 10; i++) {
			myArrayList.add(i);
		}
		System.out.println(myArrayList);
		System.out.println(myArrayList.size());
		
		myArrayList.add(5, 2);
		System.out.println(myArrayList);
//		System.out.println(myArrayList.capacity());
		for (int i = 6; i > 0; i--) {
			myArrayList.delete(i);
			System.out.print(myArrayList.capacity() + "/");
			System.out.println(myArrayList.size());
		}
		System.out.println(myArrayList);
		System.out.println(myArrayList.get(2));
		MyArrayList myArrayList2 = myArrayList.clone();
		myArrayList.clear();
		System.out.println(myArrayList);
		System.out.println(myArrayList2);
	}
	
	public MyArrayList() {
		initialize();
	}

	public MyArrayList clone() {
		MyArrayList list = new MyArrayList();
		list.arr = new int[this.arr.length];
		System.arraycopy(this.arr, 0, list.arr, 0, this.arr.length);
		list.size = this.size;
		return list;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return arr.length;
	}

	private void initialize() {
		arr = new int[10];
		size = 0;
	}

	public void add(int i) {
		if (size == arr.length) {
			int[] newArr = new int[arr.length * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			this.arr = newArr;
		}
		arr[size] = i;
		size++;
	}

	public void add(int i, int pos) {
		if (pos < 0 || pos >= size) {
			throw new ArrayIndexOutOfBoundsException("ungültiger Index");
		}
		int[] newArr;
		if (size == arr.length) {
			newArr = new int[arr.length * 2];
		} else {
			newArr = new int[arr.length];
		}
		System.arraycopy(arr, 0, newArr, 0, pos);
		newArr[pos] = i;
		System.arraycopy(arr, pos, newArr, pos + 1, arr.length - pos);
		this.arr = newArr;
		size++;
	}

	public void delete(int pos) {
		if (pos < 0 || pos >= size) {
			throw new ArrayIndexOutOfBoundsException("ungültiger Index");
		}
		double space = (size - 1) / (double) arr.length;
		int[] newArr;
		if (space <= 1 / 3d) {
			int newCapacity = arr.length % 2 == 0 ? arr.length / 2 : (arr.length + 1) / 2;
			newArr = new int[newCapacity];
		}else {
			newArr = new int[this.arr.length];
		}
		System.arraycopy(this.arr, 0, newArr, 0, pos);
		System.arraycopy(this.arr, pos + 1, newArr, pos, newArr.length - pos - 1);
		size--;
		this.arr = newArr;
	}

	public void clear() {
		initialize();
	}

	public int get(int pos) {
		if (pos < 0 || pos >= size) {
			throw new ArrayIndexOutOfBoundsException("ungültiger Index");
		}
		return arr[pos];
	}

	public String toString() {
		String arrStr = "[";
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				arrStr += ",";
			}
			arrStr += arr[i];
		}
		arrStr += "]";
		return arrStr;
	}
}
