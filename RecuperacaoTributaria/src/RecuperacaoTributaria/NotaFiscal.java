package RecuperacaoTributaria;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class NotaFiscal {
	
	String caminho = "C:\\Users\\01014185157\\Documents\\CCA_BR\\WorkSpaceCCA\\JavaCCA\\RecuperacaoTributaria\\nfe.xml";
    
    public static void lerXml(String caminho) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(caminho);
        doc.getDocumentElement().normalize();
        
        NodeList nodeList = doc.getElementsByTagName("nfeProc");
        Element element = (Element) nodeList.item(0);
        
        String chave = element.getAttribute("chave");
        System.out.println("Chave da nota fiscal: " + chave);
        
        // Outras informações da nota fiscal podem ser obtidas aqui
    }
    
    public static void lerPdf(String caminho) throws Exception {
        PdfReader reader = new PdfReader();
        String text = PdfTextExtractor.getTextFromPage(reader, 1);
        reader.close();
        
        System.out.println("Conteúdo do PDF:");
        System.out.println(text);
        
        // Informações da nota fiscal podem ser extraídas do texto do PDF
    }
    
    public static void main(String[] args) {
    	String caminhoXml = "C:\\Users\\01014185157\\Documents\\CCA_BR\\WorkSpaceCCA\\JavaCCA\\RecuperacaoTributaria\\nfe.xml";
     //   String caminhoPdf = "caminho/para/a/nota/fiscal.pdf";
        
        try {
            lerXml(caminhoXml);
   //         lerPdf(caminhoPdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
