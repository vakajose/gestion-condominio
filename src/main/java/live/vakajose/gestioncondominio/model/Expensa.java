package live.vakajose.gestioncondominio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Expensa {
    @Id
    private String id;
    private Departamento departamento;
    private BigDecimal monto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEmision;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPago;
    private String periodo;
    private String estadoPago;
}
