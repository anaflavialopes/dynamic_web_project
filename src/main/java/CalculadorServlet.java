import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class CalculadorServlet extends HttpServlet {

	private String idadePorExtenso(int dia, int mes, int ano) {
		LocalDate localDate = LocalDate.now();

		int diaAtual = localDate.getDayOfMonth();
		int mesAtual = localDate.getMonthValue();
		int anoAtual = localDate.getYear();

		int anos = anoAtual - ano;
		int meses = mesAtual - mes;
		int dias = diaAtual - dia;

		return anos + "anos, " + meses + " meses e " + dias + " dias.";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String nome = request.getParameter(getServletName());

		try {
			int dia = Integer.valueOf(request.getParameter("dia"));
			int mes = Integer.valueOf(request.getParameter("mes"));
			int ano = Integer.valueOf(request.getParameter("ano"));

			out.println("<html><body>");
			out.println("<h1><Olá, <nome>! <br/>Você tem <get.idadePorExtenso()> </h1>");
			out.println("</body></html>");

		} catch (ArithmeticException exception) {
			System.out.println("<html><body><h1>Erro na conversão de algum dos valores.</h1></body></html>");
		}
		out.close();
	}

}
