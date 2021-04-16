package group6;

import group8.Car;

import javax.swing.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static group8.CarCategory.NEW;

public class LeadFormController {

    Car car;

    public LeadFormController(Car car) {
        this.car = car;
    }

    public void showLeadForm() {
        LeadFormView formView = new LeadFormView(car);
        formView.controller = this;
        formView.setVisible(true);
        formView.setContentPane(formView.getMainPanel());
        formView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formView.pack();
    }

    public void submitLeadForm(User user) {

        System.out.println(user.toString());
        FormActionDirectory formActionDirectory = new FormActionDirectory(car);
        FormAction formAction =  formActionDirectory.newForm(user);
        formActionDirectory.submit(formAction);
        for (FormAction form: formActionDirectory.getForms()) {
            System.out.println(form.getUser());
        }
    }

    public static void main(String[] args) {
        Car car = new Car("1",
                "BMW",
                "Q7",
                2022,
                9090.0,
                "Blue",
                "Bell",
                234,
                "12",
                NEW, 5,"3746534857",
                "4.5", "Good",
                " Auto", "Auto", "Petrol", "Type");
        LeadFormController leadFormController = new LeadFormController(car);
        leadFormController.showLeadForm();

    }


    public void readCarData() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Dummy Data/NewVehicleData.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
