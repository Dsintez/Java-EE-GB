<%@ page import="ru.gb.entity.Product"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Ten products</title>
</head>
<body>
    <h2>Products</h2>
    <ul>
        <% for (Product product: (Product[]) request.getAttribute("products")) { %>
        <li>ID: <%=product.getId()%>; Title: <%=product.getTitle()%>; Cost: <%=product.getCost()%> </li>
        <% } %>
    </ul>
</body>
</html>