class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    // }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int len = a.length + b.length;
        if (len % 2 != 0){
        return findKth(a, 0, b, 0, len / 2 + 1);
        }else{
        double left  = findKth(a, 0, b, 0, len / 2);
        double right = findKth(a, 0, b, 0, len / 2 + 1);
        return (left + right) / 2;
        }
    }

  private int findKth(int[] A, int i, int[] B, int j, int k) {
    if (i >= A.length)  return B[j + k - 1];
    if (j >= B.length)  return A[i + k - 1];
    if (k == 1) return Math.min(A[i], B[j]);
    
    int Amid = k / 2 + i - 1 >= A.length ? Integer.MAX_VALUE : A[k / 2 + i - 1];
    int Bmid = k / 2 + j - 1 >= B.length ? Integer.MAX_VALUE : B[k / 2 + j - 1];

    if (Amid <= Bmid) {
      return findKth(A, k / 2 + i, B, j, k - k / 2);
    }else {
      return findKth(A, i, B, k / 2 + j, k - k / 2);
    }
  }
}
