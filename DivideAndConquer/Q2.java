// #169 = Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

class Solution { 
    private static int countInRange(int[]nums,intnum,intlo,inthi) {
        int count = 0;
        for(int i=lo ; i<=hi ; i++) {
            if(nums[i] ==num) {
                count++;
                }
            }
        return count;
    }
    private static int majorityElementRec(int[]nums,intlo,inthi) {
        // base case; the only element in an arrayof size 1 is the majority// element.
        if(lo==hi) {
            return nums[lo];
        }
        // recurse on left and right halves of thisslice.
        int mid = (hi-lo)/2+lo;
        int left = majorityElementRec(nums,lo,mid);
        int right = majorityElementRec(nums,mid+1,hi);
       
        // if the two halves agree on the majorityelement, return it.
        if(left==right) {
            return left;
        }
        
        // otherwise, count each element and returnthe "winner".
        int leftCount = countInRange(nums,left,lo,hi);
        int rightCount = countInRange(nums,right,lo,hi);
        return leftCount > rightCount ? left : right;
        }

        public static int majorityElement(int[]nums) {
             return majorityElementRec(nums,0,nums.length-1);
         }
        public static void main(Stringargs[]) {
            int nums[] = {2,2,1,1,1,2,2};
            System.out.println(majorityElement(nums));
            }
            }