package com.javaricci.FolhaSpringBootSecurity.Controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.javaricci.FolhaSpringBootSecurity.Entity.User;

@Component
public class CsvFileGenerator {

	public void writeStudentsToCsv(List<User> students, Writer writer) {

		try {

			CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL.withDelimiter(';'));

			for (User student : students) {
				printer.printRecord(student.getId(), student.getUserName(), student.getEmailId(), student.getMobileNo(),
						student.getCity(), student.getPassword(), student.getSalario(), student.getHorasBase(),
						student.getSalarioDia(), student.getSalarioHora(), student.getSalarioPagar(),
						student.getInssValor(), student.getDiasTrabalahados(), student.getHorasTrabalahadas(),
						student.getQtddepirrf(), student.getQtddepsalfam(), student.getQtdHorasExtra001(),
						student.getValorHorasExtra001(), student.getQtdHorasExtra002(), student.getValorHorasExtra002(),
						student.getValorDsr(), student.getValorsalfam(), student.getIrrfValor(),
						student.getPercPrevPrivada(), student.getValorPrevPrivada(), student.getQtdDiasFaltas(),
						student.getValorDiasFaltas(), student.getQtdHorasAtraso(), student.getValorHorasAtraso(),
						student.getValorBaseInss(), student.getValorBaseIrrf(), student.getValorBaseSalFam());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}