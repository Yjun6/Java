class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ret = 1;
        for(int x:arr){
            map.put(x,map.getOrDefault(x-difference,0)+1);
            ret = Math.max(ret,map.get(x));
        }
        return ret;
    }
}