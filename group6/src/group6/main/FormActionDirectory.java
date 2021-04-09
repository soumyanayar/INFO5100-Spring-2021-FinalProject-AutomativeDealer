package group6.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Runyao Xia
 * @date: 2021/4/10
 */
public class FormActionDirectory {
    private List<Dealer> dealers;


    /**
     * should not be none args,
     */
    public FormActionDirectory() {
        dealers = new ArrayList<>();
    }
    public FormAction newFormAction(Dealer dealer) {
        this.dealers.add(dealer);
        FormAction form = new FormAction(dealer);
        return form;
    }

    public List<Dealer> getDealers() {
        return dealers;
    }
}
