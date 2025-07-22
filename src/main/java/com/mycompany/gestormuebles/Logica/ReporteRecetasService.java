package com.mycompany.gestormuebles.Logica;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteRecetasService {

    public byte[] generarReporteRecetas(List<Receta> recetas, String creadoPor) throws JRException {
        // Cargar el jrxml (plantilla XML)
        InputStream reporteStream = getClass().getResourceAsStream("/reporte_recetas.jrxml");
        if (reporteStream == null) {
            throw new RuntimeException("No se encontró reporte_recetas.jrxml");
        }

        // Compilar reporte jrxml a JasperReport
        JasperReport jasperReport = JasperCompileManager.compileReport(reporteStream);

        // Fuente de datos
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(recetas);

        // Parámetros
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("createdBy", creadoPor);

        // Llenar el reporte
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

        // Exportar a PDF bytes
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
