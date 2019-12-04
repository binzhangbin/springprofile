package cn.bin.zhang.ioc;

public class MoAttack implements ActorArrangable{
    private GeLi geLi;
    public MoAttack(){}
    public MoAttack(GeLi geLi){
        this.geLi=geLi;
    }

    public void setGeLi(GeLi geLi) {//属性注入
        this.geLi = geLi;
    }

    public GeLi getGeLi() {
        return geLi;
    }

    public void cityGateAsk(){
        geLi.responseAsk("墨者隔离");
    }

    @Override
    public void injectGeli(GeLi geLi) {//接口注入
        this.geLi=geLi;
    }

    @Override
    public String toString() {
        return "MoAttack{" +
                "geLi=" + geLi +
                '}';
    }
}
