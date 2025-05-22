public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{3,2,1,5,6,4};
        int[] res = quickSort.quickSort(arr);
        for(int i:res){
            System.out.print(i+" ");
        }
    }

    public int[] quickSort(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        quick(arr, 0, arr.length-1);
        return arr;
    }

    public void quick(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int index = partition(arr, left, right);
        quick(arr, left, index-1);
        quick(arr,index+1, right);
    }

    public int partition(int[] arr, int left, int right){
        //基准
        int idx = left;
        int pv = arr[idx];

        int i = idx+1;
        int j = right;
        while(i<=j){
            //i从左往右找到第一个大于等于pv的元素
            while(i<=j && arr[i] < pv){
                i++;
            }
            //j从右往左找到第一个小于等于pv的元素
            while(i<=j && arr[j] > pv){
                j--;
            }
            if(i<=j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, idx, j);
        return j;
    }

    public void swap(int[]arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
