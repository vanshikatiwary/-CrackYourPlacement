class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the last element in the initial part of nums1
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last element in nums1 (including the zeroes)

        // Merge the arrays starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are any remaining elements in nums2, copy them over
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        // No need to copy remaining elements from nums1, because they are already in place
    }
}

        
  