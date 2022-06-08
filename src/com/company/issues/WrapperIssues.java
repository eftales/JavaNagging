package com.company.issues;

import com.company.Issues;

public class WrapperIssues  implements Issues {
    public void show(){
        // 包装类是引用类型，因此不能直接用 == 比较值是否相等，-128~127除外
        // 这里用了 new 新建了变量，所以两个的引用值不等
        Integer itr1 = new Integer(2);
        Integer itr2 = new Integer(2);
        boolean bl1 = itr1 == itr2;

        // 这里用了自动装箱的机制，所以两个的引用值相等
        Integer itr12 = 2;
        Integer itr22 = 2;
        boolean bl2 = itr12 == itr12;

        // 获得缓存的包装类的另一种写法
        Integer itr2v1 = Integer.valueOf(2);
        Integer itr2v2 = Integer.valueOf(2);
        bl2 = itr2v1 == itr2v2;

        // 大于 127 就不会自动装箱了，本质上还是 new 出来的
        Integer itr13 = 200;
        Integer itr23 = 200;
        boolean bl3 = itr13 == itr23;
        boolean bl4 = itr13.equals(itr23);

    }
}
