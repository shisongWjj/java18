package com.ss.design.watchBook.creational.factorymethod;

/**
 * NvWa
 *
 * @author shisong
 * @date 2020/4/20
 */
public class NvWa {


    public static void main(String[] args) {
        System.out.println("第一次造人行动");
        Human human = HumanFactory.createHuman(YellowHuman.class);
        human.talk();
        human.cry();
        human.laugh();

        human = HumanFactory.createHuman(WhiteHuman.class);
        human.talk();
        human.cry();
        human.laugh();

        human = HumanFactory.createHuman(BlackHuman.class);
        human.talk();
        human.cry();
        human.laugh();

        System.out.println("第二次造人行动");
        human = HumanFactory.createHuman();
        human.talk();
        human.cry();
        human.laugh();

    }

}
