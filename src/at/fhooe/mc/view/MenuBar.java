package at.fhooe.mc.view;

import at.fhooe.mc.controller.MMController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexandergattringer on 10/12/15.
 */
public class MenuBar extends JMenuBar implements ActionListener {

    private JMenu mFileMenu;
    private JMenuItem mNewMenuItem;
    private JMenuItem mExitMenuItem;

    public MenuBar() {
        super();
        mFileMenu = new JMenu("File");

        // "new" menu item
        mNewMenuItem = new JMenuItem("New");
        mNewMenuItem.addActionListener(this);
        mFileMenu.add(mNewMenuItem);

        // "exit" menu item
        mExitMenuItem = new JMenuItem("Exit");
        mExitMenuItem.addActionListener(this);
        mFileMenu.add(mExitMenuItem);

        add(mFileMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mNewMenuItem)) {
            SetupDialog setupDialog = new SetupDialog();
            setupDialog.setVisible(true);
            return;
        }

        if (e.getSource().equals(mExitMenuItem)) {
            //TODO: this is to test only
            MMController.getInstance().setupPlayfield(10,10);
            updateUI();
            //close
            //dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

}
