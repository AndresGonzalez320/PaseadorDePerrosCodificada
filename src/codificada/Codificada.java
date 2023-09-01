
package codificada;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Codificada extends JFrame implements ActionListener {

    JLabel L1;
    JTextField t1;

    JLabel L2;
    JTextField t2;

    JLabel L3;
    JTextField t3;

    JLabel L4;
    JTextField t4;

    JLabel L5;
    JTextField t5;

    JButton b1;

    public static void main(String[] args) {
        Codificada gato = new Codificada();
    }

   public Codificada() {
    setBounds(500, 500, 500, 500);
    setLayout(new FlowLayout());

    L1 = new JLabel("Ingrese la cantidad de Perros grandes que quiere ingresar:");
    L1.setHorizontalAlignment(JLabel.LEFT);
    t1 = new JTextField(10);
    
    L2 = new JLabel("Ingrese la cantidad de perros medianos que quiere ingresar:");
    L2.setHorizontalAlignment(JLabel.LEFT);
    t2 = new JTextField(10);
    
    L3 = new JLabel("Ingrese la cantidad de perros pequeños que quiere ingresar:");
    L3.setHorizontalAlignment(JLabel.LEFT);
    t3 = new JTextField(10);
    
    L4 = new JLabel("Ingrese cantidad de horas para el servicio:");
    L4.setHorizontalAlignment(JLabel.LEFT);
    t4 = new JTextField(10);
    
    b1 = new JButton("Calcular");
    
    L5 = new JLabel("Total");
    L5.setHorizontalAlignment(JLabel.LEFT);
    t5 = new JTextField(10);

    add(L1);
    add(t1);
    add(L2);
    add(t2);
    add(L3);
    add(t3);
    add(L4);
    add(t4);
    add(b1);
    add(L5);
    add(t5);

    b1.addActionListener(this);

    setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtiene los valores ingresados por el usuario
            int cantidadPerrosGrandes = Integer.parseInt(t1.getText());
            int cantidadPerrosMedianos = Integer.parseInt(t2.getText());
            int cantidadPerrosPequenos = Integer.parseInt(t3.getText());
            int horas = Integer.parseInt(t4.getText());

            // Calcula el costo total del servicio
            float totalCobro = 0;
            totalCobro += calcularCobroPorTipo(cantidadPerrosGrandes, 1, horas); // Grande
            totalCobro += calcularCobroPorTipo(cantidadPerrosMedianos, 2, horas); // Mediano
            totalCobro += calcularCobroPorTipo(cantidadPerrosPequenos, 3, horas); // Pequeño

            // Aplica descuento del 10% si hay más de un perro
            int totalPerros = cantidadPerrosGrandes + cantidadPerrosMedianos + cantidadPerrosPequenos;
            if (totalPerros > 1) {
                float descuento = totalCobro * 0.1f;
                totalCobro -= descuento;
            }

            // Muestra el total en el campo correspondiente
            t5.setText(Float.toString(totalCobro));
        } catch (NumberFormatException ex) {
            // Maneja el error de entrada inválida
            JOptionPane.showMessageDialog(this, "Error: Ingrese un valor numérico válido en todos los campos.");
        }
    }

    // Función para calcular el costo por tipo de perro
    private float calcularCobroPorTipo(int cantidadPerros, int tipoPerro, int horas) {
        float cobroPorTipo = 0;

        switch (tipoPerro) {
            case 1:
                if (horas < 1) {
                    cobroPorTipo = 10000;
                } else {
                    cobroPorTipo = (horas * 10000);
                }
                break;
            case 2:
                if (horas < 1) {
                    cobroPorTipo = 5000;
                } else {
                    cobroPorTipo = (horas * 5000);
                }
                break;
            case 3:
                if (horas < 1) {
                    cobroPorTipo = 3000;
                } else {
                    cobroPorTipo = horas * 3000;
                }
                break;
            default:
                System.out.println("INCORRECTO");
                break;
        }

        return cobroPorTipo * cantidadPerros;
    }
}