package group6;

import group8.*;

import static group8.CarCategory.NEW;

/**
 * @author Runyao Xia
 * @date: 2021/4/10
 */
public class MainTest {
    public static void main(String[] args) {
        Car bmw =  new Car("1",
                "BMW",
                "Q7",
                2022,
                9090.0,
                "Blue",
                "Bell",
                234,
                "12",
                NEW);
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
