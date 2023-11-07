class MM {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        //将t存放在哈希表中
        int[] hashT = new int[128];
        int k = 0;//记录字符种类
        for (char tmp : tt) {
            if (hashT[tmp]++ == 0) k++;
        }
        //存放s的哈希表
        int[] hashS = new int[128];
        int index1 = 0;
        int index2 = lenS;
        for (int left = 0, right = 0, count = 0; right < lenS; right++) {
            //进窗口 维护
            if (++hashS[ss[right]] == hashT[ss[right]]) count++;
            //判断
            while (count == k && left < lenS) {
                 //更新结果
                if (index2 - index1 + 1 > right - left + 1) {
                    index1 = left;
                    index2 = right;
                }
                //维护
                if (hashS[ss[left]] == hashT[ss[left]]) count--;
                //出窗口
                hashS[ss[left++]]--;
            }
        }       
        if (index2 == lenS) {
            return "";
        } else {
            return s.substring(index1, index2 + 1);
        }
    }
}


