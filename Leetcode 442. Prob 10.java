class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> resultSet = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;

            //if the number is negative, encountering twice
            if (nums[index] < 0)
            resultSet.add(index + 1);

            //if the number is positive
            nums[index] = nums[index] * -1;
        }
        return resultSet;
    }
}
        
   
