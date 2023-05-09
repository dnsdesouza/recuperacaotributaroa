package RecuperacaoTributaria;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Importações das bibliotecas necessárias para lidar com XML
// Nesse caso, as bibliotecas utilizadas são as que vêm com o Java, sem necessidade de importar nada externo

public class NotaFiscalComentada {

    public static void lerXml(String caminho) throws Exception {////caminho ***EX:C:\Users\Username\Documents\XML\
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // Criação de uma instância da fábrica de construtores de documentos

        DocumentBuilder db = dbf.newDocumentBuilder();
        // Criação de uma instância do construtor de documentos a partir da fábrica

        Document doc = db.parse(caminho);
        // Criação de uma instância de Document a partir do construtor e faz o parse do XML

        doc.getDocumentElement().normalize();//tira espaços em branco, quebra de linhas e etc
        // Normalização do documento para garantir que o documento esteja no formato correto

        NodeList nodeList = doc.getElementsByTagName("nfeProc");
        // Obtenção da lista de nós com a tag "nfeProc"

        Element element = (Element) nodeList.item(0);
        // Obtenção do primeiro elemento da lista de nós

        String chave = element.getAttribute("chave");
        // Obtenção do valor do atributo "chave" do elemento "nfeProc"

        System.out.println("Chave da nota fiscal: " + chave);
        // Imprime a chave da nota fiscal no console

        // Outras informações da nota fiscal podem ser obtidas aqui
    }
    
    public static void lerPdf(String caminho) throws Exception {
        // Declaração do método lerPdf que recebe o caminho do arquivo PDF a ser lido como parâmetro

        PdfReader reader = new PdfReader();
        // Criação de uma instância de PdfReader para ler o arquivo PDF

        String text = PdfTextExtractor.getTextFromPage(reader, 1);
        // Extração do texto da primeira página do arquivo PDF

        reader.close();
        // Fechamento do PdfReader

        System.out.println("Conteúdo do PDF:");
        System.out.println(text);
        // Imprime o conteúdo do PDF no console

        // Informações da nota fiscal podem ser extraídas do texto do PDF
    }
    
    public static void main(String[] args) {
        // Método principal do programa

        String caminhoXml = "caminho/para/a/nota/fiscal.xml";
        String caminhoPdf = "caminho/para/a/nota/fiscal.pdf";
        // Strings que contém o caminho para os arquivos XML e PDF

        try {
            lerXml(caminhoXml);
            // Chama o método lerXml passando como parâmetro o caminho para o arquivo XML

            lerPdf(caminhoPdf);
            // Chama o método lerPdf passando como parâmetro o caminho para o arquivo PDF
        } catch (Exception e) {
            // Captura qualquer excess que possa ter sido lançada durante a execução do método
            e.printStackTrace();
            // Imprime
        }
    }
    
}