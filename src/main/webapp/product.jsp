<%@ page import="ru.gb.entity.Product"%>
<%@ page import="ru.gb.beans.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Ten products</title>
</head>
<body>
    <h2>Cart</h2>
    <ul>
        <% for (Product product: ((Cart) request.getAttribute("cart")).getProductsCarts()) { %>
        <li>ID: <%=product.getId()%>; Title: <%=product.getTitle()%>; Cost: <%=product.getCost()%> </li>
        <% } %>
    </ul>
</body>
</html>