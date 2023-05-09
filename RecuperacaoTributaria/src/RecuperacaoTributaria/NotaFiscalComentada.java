package RecuperacaoTributaria;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Importa��es das bibliotecas necess�rias para lidar com XML
// Nesse caso, as bibliotecas utilizadas s�o as que v�m com o Java, sem necessidade de importar nada externo

public class NotaFiscalComentada {

    public static void lerXml(String caminho) throws Exception {////caminho ***EX:C:\Users\Username\Documents\XML\
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // Cria��o de uma inst�ncia da f�brica de construtores de documentos

        DocumentBuilder db = dbf.newDocumentBuilder();
        // Cria��o de uma inst�ncia do construtor de documentos a partir da f�brica

        Document doc = db.parse(caminho);
        // Cria��o de uma inst�ncia de Document a partir do construtor e faz o parse do XML

        doc.getDocumentElement().normalize();//tira espa�os em branco, quebra de linhas e etc
        // Normaliza��o do documento para garantir que o documento esteja no formato correto

        NodeList nodeList = doc.getElementsByTagName("nfeProc");
        // Obten��o da lista de n�s com a tag "nfeProc"

        Element element = (Element) nodeList.item(0);
        // Obten��o do primeiro elemento da lista de n�s

        String chave = element.getAttribute("chave");
        // Obten��o do valor do atributo "chave" do elemento "nfeProc"

        System.out.println("Chave da nota fiscal: " + chave);
        // Imprime a chave da nota fiscal no console

        // Outras informa��es da nota fiscal podem ser obtidas aqui
    }
    
    public static void lerPdf(String caminho) throws Exception {
        // Declara��o do m�todo lerPdf que recebe o caminho do arquivo PDF a ser lido como par�metro

        PdfReader reader = new PdfReader();
        // Cria��o de uma inst�ncia de PdfReader para ler o arquivo PDF

        String text = PdfTextExtractor.getTextFromPage(reader, 1);
        // Extra��o do texto da primeira p�gina do arquivo PDF

        reader.close();
        // Fechamento do PdfReader

        System.out.println("Conte�do do PDF:");
        System.out.println(text);
        // Imprime o conte�do do PDF no console

        // Informa��es da nota fiscal podem ser extra�das do texto do PDF
    }
    
    public static void main(String[] args) {
        // M�todo principal do programa

        String caminhoXml = "caminho/para/a/nota/fiscal.xml";
        String caminhoPdf = "caminho/para/a/nota/fiscal.pdf";
        // Strings que cont�m o caminho para os arquivos XML e PDF

        try {
            lerXml(caminhoXml);
            // Chama o m�todo lerXml passando como par�metro o caminho para o arquivo XML

            lerPdf(caminhoPdf);
            // Chama o m�todo lerPdf passando como par�metro o caminho para o arquivo PDF
        } catch (Exception e) {
            // Captura qualquer excess que possa ter sido lan�ada durante a execu��o do m�todo
            e.printStackTrace();
            // Imprime
        }
    }
    
}