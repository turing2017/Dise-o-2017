package sistemapagoimpuestos.Utils;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MetodosPantalla {

    private static MetodosPantalla mp;

    public MetodosPantalla() {
    }

    public static MetodosPantalla getInstance() {
        if (mp == null)  {
            mp = new MetodosPantalla();
        }
        return mp;
    }

    public void setearPantalla(JFrame pantalla) {
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pantalla.setLocationRelativeTo(null);

    }

}
