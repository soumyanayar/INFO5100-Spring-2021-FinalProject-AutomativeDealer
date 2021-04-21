package group2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VehicleImagePanel {
    private JLabel imageLabel;
    private JButton incButton;
    private JButton decButton;
    private List<String> imageList;
    private int index = 0;

    VehicleImagePanel(List<String> images) {
        this.imageList = images;
        incButton = getIncButton();
        decButton = getDecButton();
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(480,500));
        imageLabel.setMinimumSize(new Dimension(480,500));
        imageLabel.setMaximumSize(new Dimension(480,500));
    }

    public JPanel imagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        imageLabel.setIcon(getImageByIndex(index));
//        imageLabel.setBorder(new EmptyBorder(10, 10, 20, 10));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if (decButton != null)
            panel.add(decButton);
        panel.add(imageLabel);
        if (incButton != null)
            panel.add(incButton);
        //panel.setBackground(Color.white);
//        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(new Dimension(540, 500));
        panel.setMinimumSize(new Dimension(540, 500));
        panel.setMaximumSize(new Dimension(540, 500));
        return panel;
    }

    public JButton getDecButton() {
        if (imageList == null || imageList.size() <= 1) {
            return null;
        }
        decButton = getButton();
        decButton.setText("<");
        decButton.setBorder(new LineBorder(new Color(255,255,255)));

        decButton.setPreferredSize(new Dimension(30,500));
        decButton.setMinimumSize(new Dimension(30,500));
        decButton.setMaximumSize(new Dimension(30,500));

        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == 0)
                    return;
                index--;
                imageLabel.setIcon(getImageByIndex(index));
            }
        });
        return decButton;
    }

    public JButton getIncButton() {
        if (imageList == null || imageList.size() <= 1) {
            return null;
        }
        incButton = getButton();
        incButton.setText(">");
        incButton.setBorder(new LineBorder(new Color(255,255,255)));

        incButton.setPreferredSize(new Dimension(25,500));
        incButton.setMinimumSize(new Dimension(25,500));
        incButton.setMaximumSize(new Dimension(25,500));

        incButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index == imageList.size() - 1)
                    return;
                index++;
                imageLabel.setIcon(getImageByIndex(index));
            }
        });
        return incButton;
    }

    public JButton getButton() {
        JButton button = new JButton();
        Font newButtonFont = new Font(button.getFont().getName(), button.getFont().getStyle(), 25);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(newButtonFont);
        return button;
    }

    public ImageIcon getImageByIndex(int index) {
        if (imageList != null && imageList.size() > 0) {
            return getUpdateImage(imageList.get(index), 500, 400);
        }
        return getUpdateImage("TestImages/noImage.jpg", 500, 400);
    }

    public ImageIcon getUpdateImage(String url, int width, int height) {
        Image newImage = new ImageIcon(url).getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(newImage);
    }

}
