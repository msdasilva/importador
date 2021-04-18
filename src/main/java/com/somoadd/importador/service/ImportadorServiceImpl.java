package com.somoadd.importador.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somoadd.importador.model.Importador;
import com.somoadd.importador.respository.ImportadorRespository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Service
public class ImportadorServiceImpl implements ImportadorService {

	@Autowired
	private ImportadorRespository importadorRespository;

	@Override
	public void loadImportador(String arquivoPathString) {

		System.out.println("arquivoPathString: " + arquivoPathString);

		Path path = Paths.get(arquivoPathString);
		String diretorioDoArquivo = path.toAbsolutePath().toString();

		if (Files.exists(path)) {
			Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new File(diretorioDoArquivo + "/teste-xls.xls"));
			} catch (BiffException | IOException e) {
				e.printStackTrace();
			}

			Sheet sheet = workbook.getSheet(0);
			int linhas = sheet.getRows();
			for (int i = 1; i < linhas; i++) {
				Cell a1 = sheet.getCell(0, i);

				Cell a2 = sheet.getCell(1, i);

				Cell a3 = sheet.getCell(2, i);

				String as1 = a1.getContents();

				String as2 = a2.getContents();

				String as3 = a3.getContents();

				Importador importador = new Importador(as1, as2, as3);

				importadorRespository.save(importador);

				System.out.println(": " + as1 + " - : " + as2 + " - : " + as3);
			}

			workbook.close();
		}

	}

}
