<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Affichage de la chaîne "message" transmise par la servlet --%>
    <p class="info">${ message }</p>
    <%-- Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet --%>
    <p>Client</p>
    <%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une propriété du bean commande --%>
    <p>Nom : ${ commande.client.nom }</p>
    <p>Prénom : ${ commande.client.prenom }</p>
    <p>Adresse : ${ commande.client.adresse }</p>
    <p>Numéro de téléphone : ${ commande.client.numTel }</p>
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