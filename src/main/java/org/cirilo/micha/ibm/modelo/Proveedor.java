package org.cirilo.micha.ibm.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

	private Integer idProveedor;
	private String nombre;
	private String fechaAlta;
	private String idCliente;
}
