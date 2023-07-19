class Solution {
    public int maxTurbulenceSize(int[] arr) {
        //创建dp表
        int n = arr.length;
        int[] f = new int[n+1];
        int[] g = new int[n+1];
        int max = 1;
        //初始化
        for(int i=0;i<=n;i++){
            f[i] = 1;
            g[i] = 1;
        }
        //填表
        for(int i=2;i<=n;i++){
            if(arr[i-1]>arr[i-2]){
                f[i] += g[i-1];
            }else if(arr[i-1]<arr[i-2]){
                g[i] += f[i-1];
            }
            //返回值
            max = Math.max(Math.max(max,f[i]),g[i]);
        }
        return max;

    }
}