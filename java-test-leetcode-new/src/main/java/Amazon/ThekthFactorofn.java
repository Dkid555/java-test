package com.Amazon;

public class ThekthFactorofn {
    public int kthFactor(int n, int k) {
        int factor = -1;
        for(int i = 1; i <= n; ++i){
            if(k == 0)
                return factor;
            if(n % i == 0){
                factor = i;
                --k;
            }
        }
        return k == 0 ? factor : -1;
    }
}
