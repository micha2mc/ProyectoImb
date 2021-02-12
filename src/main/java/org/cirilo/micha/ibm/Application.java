/**
 * Proyecto del proceso de selección de la empresa IBM.
 */
package org.cirilo.micha.ibm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.cirilo.micha.ibm.modelo.Proveedor;
import org.cirilo.micha.ibm.utiles.Constantes;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Application {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/ibmprueba?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		final String USERNAME = "root";
		final String PSW = "";
		Connection myConnection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Proveedor> proveedores = new ArrayList<>();
		Proveedor proveedor;
		if (!(args.length<=0)) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				myConnection = DriverManager.getConnection(URL, USERNAME, PSW);
				ps = myConnection.prepareStatement(
						"SELECT * FROM springbatchdemo.proveedores WHERE id_cliente=?");

				ps.setString(1, args[0]);
				rs = ps.executeQuery();

				if (rs.next()) {
					do {
						proveedor = new Proveedor();
						proveedor.setIdProveedor(rs.getInt("id_proveedor"));
						proveedor.setNombre(rs.getString("nombre"));
						proveedor.setFechaAlta(rs.getString("fecha_alta"));
						proveedor.setIdCliente(rs.getString("id_cliente"));
						proveedores.add(proveedor);
					} while (rs.next());
					writeFile(proveedores);

				} else {
					System.out.println(
							"El cliente no tiene proveedores asignados");
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					rs.close();
					ps.close();
					myConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Necesario la introducción de un indice del"
					+ " cliente.\nConsulta el archivo README.md");
		}

	}

	/**
	 * Método para escribir el archivo plano.
	 */

	private static void writeFile(List<Proveedor> proveedores) {
		File ibm = new File(
				"." + File.separator + "src/main/resources/ibmData");
		ibm.mkdir();
		try (FileWriter fw = new FileWriter(
				ibm.getAbsolutePath() + "//FicheroIbm"
						+ new SimpleDateFormat("yyyyMMdd", Locale.FRANCE)
								.format(new Date()))) {
			proveedores.forEach(pr -> {
				try {
					fw.write(pr.getIdProveedor() + Constantes.ESPACIO
							+ pr.getNombre() + Constantes.ESPACIO
							+ pr.getFechaAlta() + Constantes.ESPACIO
							+ pr.getIdCliente());
					fw.write("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
