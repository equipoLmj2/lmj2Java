
package lmj2.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultasTickets extends ModeloDB {
    
    private PreparedStatement consultaSQL;
    private ResultSet resultadoSQL;

    public ConsultasTickets() {
    }
    
    public boolean insertarTicket(Ticket ticket){
        
        Connection conexion = conectar();
        
        String query = "INSERT INTO tickets(id, placa_vehiculo, ingreso, salida, estadia, precio) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        
        try{
            
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setInt(1, ticket.getId());
            consultaSQL.setString(2, ticket.getPlaca_vehiculo());
            consultaSQL.setString(3, ticket.getIngreso());
            consultaSQL.setString(4, ticket.getSalida());
            consultaSQL.setString(5, ticket.getEstadia());
            consultaSQL.setInt(6, ticket.getPrecio());
            
            int resultado = consultaSQL.executeUpdate();
            
            //validar el resultado
            if(resultado > 0 ){
                return true;
            }else{
                return false;
            }
        }catch(Exception err){
            
            System.out.println("Error" + err);
            return false;
        }
    }
    
    public Ticket buscarTicket (String placa_vehiculo){
        
        Ticket ticket = new Ticket();
        
        Connection conexion = conectar();
        
        String query = "SELECT * FROM tickets WHERE placa_vehiculo = ?";
        
        try{
            
            consultaSQL = conexion.prepareStatement(query);
            
            consultaSQL.setString(1, placa_vehiculo);
            
            resultadoSQL = consultaSQL.executeQuery();
            
            if(resultadoSQL.next()){
                
                ticket.setId(resultadoSQL.getInt("id"));
                ticket.setPlaca_vehiculo(resultadoSQL.getString("placa_vehiculo"));
                ticket.setIngreso(resultadoSQL.getString("ingreso"));
                ticket.setSalida(resultadoSQL.getString("salida"));
                ticket.setEstadia(resultadoSQL.getString("estadia"));
                ticket.setPrecio(resultadoSQL.getInt("precio"));
                return ticket;
                
            }else{
                
                return null;
            }
            
        }catch(Exception err){
            
            System.out.println("Error" + err);
            return null;
        }
    }
    
    
}
