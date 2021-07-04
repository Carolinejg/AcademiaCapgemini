package controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AnuncioDAO;
import model.Anuncio;

//Servlet que preenche o objeto anuncio com os paramentros passados na tela de 
//cadastro e salva a informaçâo no banco
@WebServlet(name = "Cadastro", urlPatterns = {"/cadastro"})
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Anuncio anuncio = new Anuncio();
		
		//preenchendo o objeto com as inofmrções passadas na tela de cadastro
		anuncio.setCliente(request.getParameter("cliente"));
		anuncio.setInvestimentoPorDia(Double.parseDouble(request.getParameter("investimento")));
		anuncio.setNome(request.getParameter("nome"));
		
		try {
			String adataInicio = request.getParameter("dataInicio");
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    Date inicioDate = formatter.parse(adataInicio);
		    anuncio.setDataInicio(inicioDate);
		    
		    String adataFinal = request.getParameter("dataFinal");
		    Date finalDate = formatter.parse(adataFinal);
		    anuncio.setDataFinal(finalDate);
		    
		  //salvando a informação no banco de dados
		    AnuncioDAO.addAnuncio(anuncio);
		}
		catch(ParseException p){
			p.printStackTrace();
		}
		// mostrar alertas para ações executadas pelo servlet
		String html = "<script>alert(\"Você cadastro com sucesso!\");window.location.href =\"dashboard\"</script>";
		response.getWriter().write(html);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

}
