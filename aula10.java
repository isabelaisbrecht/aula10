("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
 protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
 }
}
String paramAcao = request.getParameter("acao");

if(paramAcao.equals("ListaEmpresas")) {
    ListaEmpresas acao = new ListaEmpresas();
    acao.executa(request, response);
} else if(paramAcao.equals("RemoveEmpresa")) {
    RemoveEmpresa acao = new RemoveEmpresa();
    acao.executa(request, response);
} else if(paramAcao.equals("MostraEmpresa")) {
    MostraEmpresa acao = new MostraEmpresa();
    acao.executa(request, response);
} else if(paramAcao.equals("AlteraEmpresa")) {
    AlteraEmpresa acao = new AlteraEmpresa();
    acao.executa(request, response);
} else if(paramAcao.equals("NovaEmpresa")) {
    NovaEmpresa acao = new NovaEmpresa();
    acao.executa(request, response);
}
response.sendRedirect("entrada?acao=ListaEmpresas");

<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">edita</a>
<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">remove</a>
<c:url value="/entrada" var="linkEntradaServlet"/>

<form action="${linkEntradaServlet }" method="post">
    Nome: <input type="text" name="nome" value="${empresa.nome }" />
    Data Abertura: <input type="text" name="data" 
        value="<fmt:formatDate value="${empresa.dataAbertura }" 
        pattern="dd/MM/yyyy"/>" />
    <input type="hidden" name="id" value="${empresa.id }">
    <input type="hidden" name="acao" value="AlteraEmpresa">
    <input type="submit" />
</form>

<c:url value="/entrada" var="linkEntradaServlet"/>

<form action="${linkEntradaServlet }" method="post">
    Nome: <input type="text" name="nome"  />
    Data Abertura: <input type="text" name="data"  />
    <input type="hidden" name="acao" value="NovaEmpresa">
    <input type="submit" />
</form>
