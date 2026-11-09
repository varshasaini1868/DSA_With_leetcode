
class MyHashMap {

    int[][] arr;

    public MyHashMap() {
        arr = new int[1000001][2];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = -1;
        }
    }

    public void put(int key, int value) {
        arr[key][0] = key;
        arr[key][1] = value;
    }

    public int get(int key) {
        return arr[key][0] == -1 ? -1 : arr[key][1];
    }

    public void remove(int key) {
        arr[key][0] = -1;
        arr[key][1] = -1;
    }
}

