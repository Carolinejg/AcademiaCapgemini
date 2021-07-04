package controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AnuncioDAO;
import model.Anuncio;
import model.Total;


//Servlet responsável por fazer criar a página de relatório 
//com as informações de cada anuncio 

@WebServlet(name = "ServletRelatorio", urlPatterns = {"/servletRelatorio"})
public class ServletRelatorio extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// busca todos os anuncios cadastrados
		var anuncios= AnuncioDAO.pesquisaAnuncios();
		
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		var writer = response.getWriter();
		
		String html = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"utf-8\" />\r\n"
				+ "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n"
				+ "        <meta name=\"description\" content=\"\" />\r\n"
				+ "        <meta name=\"author\" content=\"\" />\r\n"
				+ "        <title>Calendário da Turma</title>\r\n"
				+ "        <!-- Custom fonts for this template-->\r\n"
				+ "        <link href=\"resources/bootstrap/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n"
				+ "        <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\" />\r\n"
				+ "        <!-- Custom styles for this template-->\r\n"
				+ "			<link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\" />"
				+ "        <link href=\"resources/bootstrap/css/sb-admin-2.css\" rel=\"stylesheet\" />\r\n"
				
				+ "    </head>\r\n"
				+ "    <body class=\"bg-gradient-primary\">\r\n"
				+ "            <div class=\"container\">\r\n"
				+ "                <div class=\"card o-hidden border-0 shadow-lg my-5\">\r\n"
				+ "                    <div class=\"card-body\">\r\n"
				+ "                        <!-- Nested Row within Card Body -->\r\n"
				+ "                        <div class=\"page-header\">\r\n"
				+ "                            <h1 class=\"text-center font-weight-bold\"></h1>\r\n"
				+ "                            <h5>Relatório</h5>\r\n"
		        + "                            <div id=\"container1\" class=\"container\">\r\n"
				+ "  							<div class=\"row\">\r\n"
				+ "                             <div class=\"col-sm\">\r\n"
				
				+ "                               <div class=\"input-group\">\r\n"
				+ "  								<div class=\"form-outline\">\r\n"
				+ "    									<input type=\"search\" id=\"clienteFiltro\" class=\"form-control\" onblur=\"aplicaFiltro()\" onchange=\"aplicaFiltro()\" onkeyup=\"aplicaFiltro()\" />\r\n"
				+ "    										<label class=\"form-label\" for=\"form1\">Filtre por cliente</label>\r\n"
				+ " 								</div>\r\n"
				+ "								</div>\r\n"
				
				+ "                             </div>\r\n"
				+ "                             <div class=\"col-sm\">\r\n"
				
				+ "                               <div class=\"input-group\">\r\n"
				+ "  								<div class=\"form-outline\">\r\n"
				+ "    									<input type=\"date\" id=\"dataInicioFiltro\" class=\"form-control\" onblur=\"aplicaFiltro()\" onchange=\"aplicaFiltro()\" onkeyup=\"aplicaFiltro()\" />\r\n"
				+ "    										<label class=\"form-label\" for=\"form1\">Filtre por data início</label>\r\n"
				+ " 								</div>\r\n"
				+ "								</div>\r\n"
				+ "                             </div>\r\n"
				
				+ "                             <div class=\"col-sm\">\r\n"
				
				+ "                               <div class=\"input-group\">\r\n"
				+ "  								<div class=\"form-outline\">\r\n"
				+ "    									<input type=\"date\" id=\"dataFinalFiltro\" class=\"form-control\" onblur=\"aplicaFiltro()\" onChange=\"aplicaFiltro()\" onkeyUp=\"aplicaFiltro()\" />\r\n"
				+ "    										<label class=\"form-label\" for=\"form1\">Filtre por data término</label>\r\n"
				+ " 								</div>\r\n"
				+ "								</div>\r\n"
				+ "                             </div>\r\n"
				
				+ "                             </div>\r\n"
				+ "                             </div>"
				+ "                            <h5></h5>\r\n"
				+ "                        </div>\r\n"
				+ "                            <div class=\"table-responsive\">\r\n";
				
				int count = 0;
				for (Anuncio a : anuncios) {
					double totalInvesti=a.investimentoTotal(a.getInvestimentoPorDia());
					System.out.println("O valor total investido é "+ totalInvesti);
					System.out.println("O valor do investimento por dia é de : "+a.getInvestimentoPorDia());
					
					html+="<table class=\"table table-bordered\" id=\"dataTable" + count +"\" width=\"100%\" cellspacing=\"0\" style=\"background:#add8e663;\" >\r\n"
							+ "        <tr>\r\n"
							+ "            <th>\r\n"
							+ "                Nome\r\n"
							+ "            </th>\r\n"
							+ "            <th>\r\n"
							+ "                Cliente\r\n"
							+ "            </th>\r\n"
							+ "            <th>\r\n"
							+ "                Investimento por dia\r\n"
							+ "            </th>\r\n"
							+ "            <th>\r\n"
							+ "                Data de Início\r\n"
							+ "            </th>\r\n"
							+ "            <th>\r\n"
							+ "                Data de término\r\n"
							+ "            </th>\r\n"
							+ "        </tr>\r\n"
							+ "\r\n"
							+ "        <tr>\r\n"
							+ "            <td id=\"nome"+count+"\">"+ a.getNome()+ "</td>\r\n"
							+ "\r\n"
							+ "\r\n"
							+ "            <td id=\"client"+count+"\">"+ a.getCliente()+"</td>\r\n"
							+ "\r\n"
							+ "            <td>"+String.format("%.2f", a.getInvestimentoPorDia()) + " R$</td>\r\n"
							+ "\r\n"
							+ "\r\n"
							+ "            <td id=\"dti"+count+"\">" + dt1.format(a.getDataInicio())+"</td>\r\n"
							+ "\r\n"
							+ "\r\n"
							+ "            <td id=\"dtf"+count+"\">" + dt1.format(a.getDataFinal())+"</td>\r\n"
							+ "\r\n"
							+ "        </tr>\r\n"
							+ "        <tr>\r\n"
							+ "            <th>Valor total investido</th>\r\n"
							+ "            <th>Quantidade máxima de visualizações</th>\r\n"
							+ "            <th>Quantidade máxima de compartilhamentos</th>\r\n"
							+ "            <th>Quantidade máxima de cliques</th>\r\n"
							+ "\r\n"
							+ "        </tr>\r\n"
							+ "        <tr>\r\n"
							+ "            <td>" + String.format("%.2f", totalInvesti)+ " R$</td>\r\n";
							Total total = Anuncio.calcTotal(totalInvesti);
							html+= "       <td>"+String.format("%.4f", total.getTotalVizualizacao())+"</td>\r\n"
							+ "            <td>"+String.format("%.4f", total.getTotalCompartilhamento())+"</td>\r\n"
							+ "            <td>"+String.format("%.4f", total.getTotalClicks())+"</td>\r\n"
							+ "        </tr>\r\n"
							+ "       \r\n"
							+ "        \r\n"
							+ "        \r\n"
							+ "    </table>";
					count += 1;
				}
				html += "</table>";
				
				html += "\r\n"
				
				+ "                        <a class=\"btn btn-primary\" align=\"center\" href=\"dashboard\" role=\"button\">Voltar</a>\r\n"
				+ "                        \r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "            <!-- Bootstrap core JavaScript-->\r\n"
				+ "            <script src=\"resources/bootstrap/vendor/jquery/jquery.min.js\"></script>\r\n"
				+ "            <script src=\"resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "            <!-- Core plugin JavaScript-->\r\n"
				+ "            <script src=\"resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n"
				+ "            <!-- Custom scripts for all pages-->\r\n"
				+ "            <script src=\"resources/bootstrap/js/sb-admin-2.min.js\"></script>\r\n"
				+ "        \r\n"
				+ "        \r\n"
				+ "    </body>\r\n"
				+ "    \r\n"
				
				+ "<script>\r\n"
				
				+ "function filtrarClienteEData(clienteFiltro, dataInicio, dataFim) {\r\n"
				+ "	    for (i=0; i<1000; i++) {\r\n"
				+ "	        var cliente = document.getElementById(\"client\"+i);\r\n"
				+ "	        if (cliente == null) break;\r\n"
				+ "	        \r\n"
				+ "	        var mostrarCliente = false;\r\n"
				+ "	        mostrarCliente = cliente.textContent.toLowerCase().includes(clienteFiltro.toLowerCase());\r\n"
				+ "	        \r\n"
				+ "	        var dti = document.getElementById(\"dti\"+i).textContent;\r\n"
				+ "	        var dtf = document.getElementById(\"dtf\"+i).textContent;\r\n"
				+ "\r\n"
				+ "	        var mostrarI = false;\r\n"
				+ "	        var mostrarF = false;\r\n"
				+ "\r\n"
				+ "	        if (dataInicio == \"\") {\r\n"
				+ "	            mostrarI = true;\r\n"
				+ "	        } else {\r\n"
				+ "	            mostrarI = dateToEpoch(dti) >= dateToEpoch(dataInicio);\r\n"
				+ "	        }\r\n"
				+ "\r\n"
				+ "	        if (dataFim == \"\") {\r\n"
				+ "	            mostrarF = true;\r\n"
				+ "	        } else {\r\n"
				+ "	            mostrarF = dateToEpoch(dtf) <= dateToEpoch(dataFim);\r\n"
				+ "	        }\r\n"
				+ "	        \r\n"
				+ "	        if (mostrarCliente && mostrarI && mostrarF) {\r\n"
				+ "	            document.getElementById(\"dataTable\"+i).style.display = \"\";\r\n"
				+ "	        } else {\r\n"
				+ "	            document.getElementById(\"dataTable\"+i).style.display = \"none\";\r\n"
				+ "	        }\r\n"
				+ "	    }\r\n"
				+ "	}\r\n"
				
				+ "function aplicaFiltro() {\r\n"
				+ "    var cliente = document.getElementById(\"clienteFiltro\").value;\r\n"
				+ "    var dataInicio = document.getElementById(\"dataInicioFiltro\").value;\r\n"
				+ "    var dataFinal = document.getElementById(\"dataFinalFiltro\").value;\r\n"
				+ "console.log(\"aplicando filtro: \" + cliente + \", \" + dataInicio + \", \" + dataFinal);"
				+ "    filtrarClienteEData(cliente, dataInicio, dataFinal);\r\n"
				+ "}"
				
				+ "function dateToEpoch(date) {\r\n"
				+ "    var parts = date.split(\"/\");\r\n"
				+ "    if (parts.length == 3) {\r\n"
				+ "        return Date.parse(parts[1]+\"/\"+parts[0]+\"/\"+parts[2]);\r\n"
				+ "    } else {\r\n"
				+ "        parts = date.split(\"-\");\r\n"
				+ "        return Date.parse(parts[1]+\"/\"+parts[2]+\"/\"+parts[0]);\r\n"
				+ "    }\r\rn"
				+ "}\r\n"
				+ "</script>"
				
				+ "</html>\r\n"
				+ "";
				
				writer.write(html);


	}
	
}
