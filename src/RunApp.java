

import com.enigma.controller.dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.enigma.model.Cliente;

public class RunApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // LoginPage login =new LoginPage();
        //login.setLocationRelativeTo(null);
        // login.setVisible(true);

        // ConnectionDb con = new ConnectionDb();
        //   if (con.validarLogin("vania@gmail.com", "vania")) {
        //        JOptionPane.showMessageDialog(null, "LOGIN SUCESSO");
        //    } else {
        //     JOptionPane.showMessageDialog(null, "LOGIN ERRO");
        //   }
        //
        //con.closeConnection();
        ClienteDAO cliDAO = new ClienteDAO();

        List<Cliente> lista = cliDAO.listar();

        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }
    }

}
