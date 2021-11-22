
package lmj2.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lmj2.modelos.ConsultasVehiculos;
import lmj2.modelos.Ticket;
import lmj2.modelos.Usuarios;
import lmj2.modelos.Vehiculo;
import lmj2.vistas.VistaHome;
import lmj2.vistas.VistaIngreso;


public class ControladorHome implements ActionListener {
    
    VistaHome vistaHome = new VistaHome();
    Usuarios usuario = new Usuarios();
    Vehiculo vehiculo = new Vehiculo();
    Ticket ticket = new Ticket();

    public ControladorHome(VistaHome vistaHome, Usuarios usuario, Vehiculo vehiculo, Ticket ticket) {
        
        this.vistaHome = vistaHome;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.ticket = ticket;
        
        vistaHome.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasVehiculos consultasVehiculos = new ConsultasVehiculos();
        String placa = vistaHome.cajaPlaca.getText();
        
        if(consultasVehiculos.buscarVehiculo(placa) != null){
            
        }else{
            
            //ingresar el vehiculo al parqueadero
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistaHome.setVisible(false);
            vistaIngreso.setVisible(true);
        }
    }
    
    
}
