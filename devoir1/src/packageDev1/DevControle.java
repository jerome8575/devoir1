package packageDev1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DevControle implements MouseListener, ActionListener{

    DevAffichage monAffichage;
    DevModele monModel;

    public DevControle(DevAffichage x, DevModele y)
    {
        monAffichage = x;
        monModel = y;
    }



    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        e.getSource();
        monModel.ouvrirFichier("dictio");
    }
}
