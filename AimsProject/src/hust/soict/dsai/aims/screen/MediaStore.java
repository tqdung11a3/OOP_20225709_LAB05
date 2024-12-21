package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);

        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(media.getTitle() + " has been added to the cart.");
            }
        });

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);

            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playMedia();
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void playMedia() {
        if (media instanceof Playable) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Playing: " + media.getTitle());
            playDialog.setSize(300, 150);
            playDialog.setLayout(new FlowLayout());

            JLabel message = new JLabel("Playing: " + media.getTitle());
            playDialog.add(message);

            playDialog.setVisible(true);
        } else {
            System.out.println("This media cannot be played.");
        }
    }
}
