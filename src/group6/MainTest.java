package group6;

import group8.*;

/**
 * @author Runyao Xia
 * @date: 2021/4/10
 */
public class MainTest {
    public static void main(String[] args) {
        Car bmw = new Car("dsa", "330", "Sedan", 2022, 9090, true, "blue", "Seattle", 5000);
        FormActionDirectory contactUs = new FormActionDirectory(bmw);
        FormAction form = contactUs.newForm("JiaQi", "Chen", "dhasjdh@neu.com", "9900", "321");
        User user = form.getUser();
        System.out.println(user.geteMail());
        System.out.println(user.getUseType());
        user.setUseType(1);
        System.out.println(user.getUseType());
        System.out.println(user.getForm().getId());
    }
}
