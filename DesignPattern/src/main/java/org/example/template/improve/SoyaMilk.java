package org.example.template.improve;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/8 20:30
 */
public abstract class SoyaMilk {

    final void make() {
        this.select();
        if (this.customWantCondiments()) {
            this.addCondiments();
        }
        this.soak();
        this.beat();
    }

    void select() {
        System.out.println("第一步：选择好的新鲜黄豆 ");
    }

    abstract void addCondiments();

    void soak() {
        System.out.println("第三步：黄豆和配料开始浸泡，需要3小时 ");
    }

    void beat() {
        System.out.println("第四步：黄豆和配料放到豆浆机去打碎 ");
    }

    /**
     * 钩子方法
     *
     * @return
     */
    boolean customWantCondiments() {
        return true;
    }
}
