<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Affichage de la cha�ne "message" transmise par la servlet --%>
    <p class="info">${ message }</p>
    <%-- Puis affichage des donn�es enregistr�es dans le bean "commande" transmis par la servlet --%>
    <p>Client</p>
    <%-- Les 5 expressions suivantes acc�dent aux propri�t�s du client, qui est lui-m�me une propri�t� du bean commande --%>
    <p>Nom : ${ commande.client.nom }</p>
    <p>Pr�nom : ${ commande.client.prenom }</p>
    <p>Adresse : ${ commande.client.adresse }</p>
    <p>Num�ro de t�l�phone : ${ commande.client.numTel }</p>
    <p>Email : ${ commande.client.email }</p>
    <p>Commande</p>
    <p>Date  : ${ commande.date }</p> 
    <p>Montant  : ${ commande.montant }</p> 
    <p>Mode de paiement  : ${ commande.modePaiement }</p> 
    <p>Statut du paiement  : ${ commande.statutPaiement }</p> 
    <p>Mode de livraison  : ${ commande.modeLivraison }</p> 
    <p>Statut de la livraison  : ${ commande.statutLivraison }</p>
</body>
</html>