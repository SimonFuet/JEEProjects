<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p class="info">${ message }</p>
    <%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
    <p>Nom : ${ client.nom }</p>
    <p>Prénom : ${ client.prenom }</p>
    <p>Adresse : ${ client.adresse }</p>
    <p>Numéro de téléphone : ${ client.numTel }</p>
    <p>Email : ${ client.email }</p>
</body>
</html>