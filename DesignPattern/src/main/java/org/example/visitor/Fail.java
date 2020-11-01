package org.example.visitor;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/1 15:11
 */
public class Fail extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println(" 男性给的评价：该歌手失败 ");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女性给的评价：该歌手失败 ");
    }
}
