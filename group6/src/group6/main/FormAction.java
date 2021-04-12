package group6.main;


/**
 * @author Runyao Xia
 * @date: 2021/4/10
 */
public class FormAction {
    private User user;
    private Integer id;

    public FormAction(User user) {
        this.user = user;
        user.setForm(this);
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "FormAction{" +
                "user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

