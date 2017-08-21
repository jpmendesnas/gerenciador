<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form action="novaEmpresa" method="POST">
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}
</c:if>
<br/>
Nome: <input type="text" name="nome">
<button type="submit">Enviar</button>
</form>

<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="Login">

	Email: <input type="email" name="email">
	Senha: <input type="password" name="senha">
	<input type="submit" value="enviar">
</form>

<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Deslogar">
</form>
</body>
</html>