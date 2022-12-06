package com.javaricci.FolhaSpringBootSecurity.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.javaricci.FolhaSpringBootSecurity.Entity.User;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {

	public void generate(List<User> studentList, HttpServletResponse response) throws DocumentException, IOException {

		// Criando o Objeto do Documento
		Document document = new Document(PageSize.A4);

		// Obtendo instância de PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Abrindo o documento criado para alterá-lo
		document.open();

		// Criando fonte
		// Configurando o estilo e tamanho da fonte
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Criando parágrafo
		Paragraph paragraph1 = new Paragraph("Lista de Funcionários TOTVS", fontTiltle);

		// Alinhando o parágrafo no documento
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

		// Adicionando o parágrafo criado no documento
		document.add(paragraph1);

		// Criando uma tabela das 4 colunas
		PdfPTable table = new PdfPTable(4);

		// Configurando a largura da tabela, suas colunas e espaçamento
		table.setWidthPercentage(100);
		table.setWidths(new int[] { 3, 3, 3, 3 });
		table.setSpacingBefore(5);

		// Cria células da tabela para o cabeçalho da tabela
		PdfPCell cell = new PdfPCell();

		// Configurando a cor de fundo e o preenchimento da célula da tabela
		cell.setBackgroundColor(CMYKColor.BLUE);
		cell.setPadding(5);

		// Criando fonte
		// Configurando o estilo e tamanho da fonte
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adicionando títulos na célula ou cabeçalho da tabela criada
		// Adicionando célula à tabela
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Nome Usuário", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Telefone", font));
		table.addCell(cell);

		// Iterando a lista de alunos
		for (User student : studentList) {
			table.addCell(String.valueOf(student.getId()));
			table.addCell(student.getUserName());
			table.addCell(student.getEmailId());
			table.addCell(student.getMobileNo());
		}

		// Adicionando a tabela criada ao documento
		document.add(table);

		// Fechando o documento
		document.close();

	}

}