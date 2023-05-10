package RecuperacaoTributaria;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class NotaFiscal {
	
	String caminhoXml ="C:\\Users\\01014185157\\Documents\\CCA_BR\\WorkSpaceCCA\\JavaCCA\\RecuperacaoTributaria\\nfe.xml";
    
    public static void lerXml(String caminho) throws Exception {
        DocumentBuilderFactory fabricaDocumento = DocumentBuilderFactory.newInstance();
        DocumentBuilder construtorDocumento = fabricaDocumento.newDocumentBuilder();
        Document documento = construtorDocumento.parse(caminho);
        documento.getDocumentElement().normalize();
        
        NodeList nodeList = documento.getElementsByTagName("nfeProc");
        Element element = (Element) nodeList.item(0);
        
        Element emitente = (Element) element.getElementsByTagName("emit").item(0);

        Element cnpj = (Element) emitente.getElementsByTagName("CNPJ").item(0);
        Element nome = (Element) emitente.getElementsByTagName("xNome").item(0);
        
        String cnpjValue = cnpj.getTextContent();
        System.out.println("CNPJ do emitente: " + cnpjValue);
        
        String nomeValue = nome.getTextContent();
        System.out.println("Nome do emitente: " + nomeValue);
        
        // Outras informações da nota fiscal podem ser obtidas aqui
    }
    
    //LEITURA DE PDF AINDA A SER MODIFICADO
    public static void lerPdf(String caminho) throws Exception {
        PdfReader leitorPdf = new PdfReader();
        String textoPdf = PdfTextExtractor.getTextFromPage(leitorPdf, 1);
        leitorPdf.close();
        
        System.out.println("Conteúdo do PDF:");
        System.out.println(textoPdf);
        
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
