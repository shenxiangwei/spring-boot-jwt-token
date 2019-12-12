package com.shenxiangwei.springbootjwttoken.filter;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @time 2019/10/22 9:12 下午
 */
public enum TokenState {
    /**
     * 过期
     */
    EXPIRED("EXPIRED"),
    /**
     * 非法
     */
    INVALID("INVALID"),
    /**
     * 有效
     */
    VALID("VALID");

    private String state;

    private TokenState(String state) {
        this.state = state;
    }

    /**
     * 根据状态字符串获取token状态枚举对象
     * @param tokenState 状态字符串
     * @return 状态枚举
     */
    public static TokenState getTokenState(String tokenState){
        TokenState[] states=TokenState.values();
        TokenState ts=null;
        for (TokenState state : states) {
            if(state.toString().equals(tokenState)){
                ts=state;
                break;
            }
        }
        return ts;
    }

    @Override
    public String toString() {
        return this.state;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
