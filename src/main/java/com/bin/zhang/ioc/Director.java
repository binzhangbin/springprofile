package com.bin.zhang.ioc;
//调试类-导演
public class Director {
    public void direct(){
        GeLi geLi=new LiuDeHua();
        //构造注入
        //MoAttack moAttack=new MoAttack(geLi);
        MoAttack moAttack=new MoAttack(geLi);
        //属性注入
        moAttack.setGeLi(geLi);
        //接口注入
        moAttack.injectGeli(geLi);

        moAttack.cityGateAsk();
    }

    public static void main(String[] args) {
        new Director().direct();
    }
}
