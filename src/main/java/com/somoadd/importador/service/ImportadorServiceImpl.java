package com.somoadd.importador.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.somoadd.importador.entity.DataSet;
import com.somoadd.importador.entity.EntityDatasource;
import com.somoadd.importador.entity.Hierarchy;
import com.somoadd.importador.respository.*;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somoadd.importador.entity.EntityDs;
import com.somoadd.importador.model.Importador;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Service
public class ImportadorServiceImpl implements ImportadorService {

    @Autowired
    private ImportadorRespository importadorRespository;

    @Autowired
    private DatasetRepository _datasetRepository;

    @Autowired
    private HierarchyRepository _hierarchyRepository;

    @Autowired
    private DatasourceRepository _datasourceRepository;

    @Autowired
    private EntityRepository _entityRepository;

    @Override
    public void loadImportador(String arquivoPathString) {

        System.out.println("arquivoPathString: " + arquivoPathString);

        Path path = Paths.get(arquivoPathString);
        String diretorioDoArquivo = path.toAbsolutePath().toString();
        Workbook workbook = null;
        if (Files.exists(path)) {

            try {
                workbook = Workbook.getWorkbook(new File(diretorioDoArquivo + "/cargaEntidadesFacebook.xls"));
            } catch (BiffException | IOException e) {
                e.printStackTrace();
            }

            Sheet sheet = workbook.getSheet(0);
            int linhas = sheet.getRows();
            for (int i = 1; i < linhas; i++) {
                Cell coluna1 = sheet.getCell(0, i);

                Cell coluna2 = sheet.getCell(1, i);

                Cell coluna3 = sheet.getCell(2, i);

                String valor1 = this.cleanString(coluna1.getContents());

                String valor2 = this.cleanString(coluna2.getContents());

                String valor3 = this.cleanString(coluna3.getContents());

                var dataset = _datasetRepository.findById(899L).get();
                var datasource = _datasourceRepository.getOne(1L);

                var entidade = new EntityDs();
                var listaDataset = new ArrayList<DataSet>();
                listaDataset.add(dataset);

                var hierarquia = _hierarchyRepository.getOne(908L);
                var listaHierarquia = new ArrayList<Hierarchy>();
                listaHierarquia.add(hierarquia);


                var entityDatasource = new EntityDatasource();
                entityDatasource.setEntity(entidade);
                entityDatasource.setDatasource(datasource);
                entityDatasource.setValue(valor3);

                var listaEntityDatasource = new ArrayList<EntityDatasource>();
                listaEntityDatasource.add(entityDatasource);

                entidade.setName(valor2);
                entidade.setDatasetList(listaDataset);
                entidade.setHierarchies(listaHierarquia);
                entidade.setEntityDatasource(listaEntityDatasource);

                try {
                    //var result = _entityRepository.saveAndFlush(entidade);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        workbook.close();
    }

    public String cleanString(String conteudo) {
        int limite = 50;
        return conteudo.replace("'", "").substring(0, conteudo.length() > limite ? limite : conteudo.length());
    }

}


